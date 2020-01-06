package pl.pasiekaksiazek.web.service.model;

public abstract class BooksURL {

    Integer pageNumber = 0;

    public void reset(){
        pageNumber = 0;
    }
}
