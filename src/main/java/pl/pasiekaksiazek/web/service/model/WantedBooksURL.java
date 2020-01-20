package pl.pasiekaksiazek.web.service.model;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pl.pasiekaksiazek.web.service.model.inferface.rollPages;

@Log4j2
@Component
@Scope(value = "prototype")
public class WantedBooksURL extends BooksURL implements rollPages {

    @Override
    public String nextPage() {

        pageNumber++;
        log.info("pageNumber value: " + pageNumber);

        String url = "page=" + pageNumber + "&listId=booksFilteredList&&shelfs[]=722909&findString=&kolejnosc=data-przeczytania&objectId=113175&own=0";
        log.info("Url value: " + url);

        return url;
    }
}
