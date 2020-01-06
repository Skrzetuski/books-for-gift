package pl.pasiekaksiazek.web.service.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pl.pasiekaksiazek.web.service.model.inferface.rollPages;

@Component
@Scope(value = "prototype")
public class OwnedBooksURL extends BooksURL implements rollPages {

    @Override
    public String nextPage() {
        pageNumber++;
        return "page=" + pageNumber + "&listId=booksFilteredList&&shelfs[]=722911&findString=&kolejnosc=data-przeczytania&objectId=113175&own=0";
    }
}
