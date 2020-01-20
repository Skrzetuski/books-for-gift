package pl.pasiekaksiazek.web.book;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@Service
public class BookFilter {

    public List<Book> newListBooksForGift(List<Book> listBooksWanted, List<Book> listBooksOwned) {

        log.info("Start filtering out books");

        List<Book> newList = new ArrayList<>();

        Boolean flag = false;

        log.info("Size bookWanted: " + listBooksWanted.size());
        log.info("Size booksOwned: " + listBooksOwned.size());

        for (Book bookWanted : listBooksWanted) {

            for (Book bookOwned : listBooksOwned) {

                if (bookOwned.getTitle().equals(bookWanted.getTitle())) {
                    flag = true;
                }
            }

            if (!flag) {
                newList.add(bookWanted);
            }

            flag = false;
        }

        log.info("Size returned list: " + newList.size());
        return newList;
    }
}
