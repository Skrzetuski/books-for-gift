package pl.pasiekaksiazek.web.book;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Book {

    private String title = "";

    private List<String> author = new ArrayList<>();

    @Override
    public String toString() {
        return title + " - " + author;
    }
}
