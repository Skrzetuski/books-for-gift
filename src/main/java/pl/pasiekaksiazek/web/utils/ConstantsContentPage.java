package pl.pasiekaksiazek.web.utils;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public class ConstantsContentPage {
    private ConstantsContentPage(){}

    public static final String TITLE_CLASS = "authorAllBooks__singleTextTitle float-left";
    public static final String AUTHOR_CLASS = "authorAllBooks__singleTextAuthor authorAllBooks__singleTextAuthor--bottomMore";

    public static final String APP_X_WWW_FORM = "application/x-www-form-urlencoded; charset=UTF-8";
    public static final String URL_GET_LIBRARY_BOOK_LIST = "https://lubimyczytac.pl/profile/getLibraryBooksList";

    public static final String OWNED_BASE_URL = "page=0&listId=booksFilteredList&&shelfs[]=722911&findString=&kolejnosc=data-przeczytania&objectId=113175&own=0";
    public static final String WANTED_BASE_URL = "page=0&listId=booksFilteredList&&shelfs[]=722909&findString=&kolejnosc=data-przeczytania&objectId=113175&own=0";


    public static final HttpHeaders httpHeaders = new HttpHeaders();

    static {
        httpHeaders.setContentType(MediaType.valueOf(APP_X_WWW_FORM));
        httpHeaders.set("X-Requested-With", "XMLHttpRequest");
    }
}
