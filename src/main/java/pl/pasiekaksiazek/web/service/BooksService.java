package pl.pasiekaksiazek.web.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.pasiekaksiazek.web.book.Book;
import pl.pasiekaksiazek.web.book.BookFilter;
import pl.pasiekaksiazek.web.model.SiteResponseJson;
import pl.pasiekaksiazek.web.service.model.OwnedBooksURL;
import pl.pasiekaksiazek.web.service.model.WantedBooksURL;
import pl.pasiekaksiazek.web.utils.ConstantsContentPage;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Getter
@Service
public class BooksService {

    @Autowired
    WantedBooksURL wantedBooksURL;

    @Autowired
    OwnedBooksURL ownedBooksURL;

    @Autowired
    BookFilter bookFilter;

    @Autowired
    CacheService cacheService;

    Integer left = null;

    public List<Book> getBooksFromShelf(String bodyForm, HttpHeaders httpHeaders) throws URISyntaxException, JsonProcessingException {

        URI uri = new URI(ConstantsContentPage.URL_GET_LIBRARY_BOOK_LIST);

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> request = new HttpEntity<>(bodyForm, httpHeaders);
        ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);


        ObjectMapper objectMapper = new ObjectMapper();

        SiteResponseJson siteResponseJson = objectMapper.readValue(Objects.requireNonNull(result.getBody()), SiteResponseJson.class);

        left = siteResponseJson.getData().getLeft();

        Document tmp = Jsoup.parse(siteResponseJson.getData().getContent());
        Elements titles = tmp.getElementsByClass(ConstantsContentPage.TITLE_CLASS);
        Elements authors = tmp.getElementsByClass(ConstantsContentPage.AUTHOR_CLASS);

        List<Book> books = new ArrayList<>();

        for (int i = 0; i < titles.size(); i++) {
            Book book = new Book();
            book.setTitle(titles.eachText().get(i).trim());
            book.setAuthor(Arrays.asList(authors.eachText().get(i).split(",")));
            books.add(book);
        }

        return books;
    }

    public String prepareJsonAndListCache() throws URISyntaxException, JsonProcessingException {

        wantedBooksURL.reset();
        ownedBooksURL.reset();

        List<Book> ownedBooks = new ArrayList<>();

        do {
            ownedBooks.addAll(getBooksFromShelf(ownedBooksURL.nextPage(), ConstantsContentPage.httpHeaders));
        } while (getLeft() > 0);


        List<Book> wantedBooks = new ArrayList<>();

        do {
            wantedBooks.addAll(getBooksFromShelf(wantedBooksURL.nextPage(), ConstantsContentPage.httpHeaders));
        } while (getLeft() > 0);

        ObjectMapper mapper = new ObjectMapper();
        List<Book> tmp = bookFilter.newListBooksForGift(wantedBooks, ownedBooks);
        String json = mapper.writeValueAsString(tmp);

        cacheService.setGiftBooksList(tmp);

        return json;
    }
}
