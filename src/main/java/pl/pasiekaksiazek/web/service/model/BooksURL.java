package pl.pasiekaksiazek.web.service.model;

import lombok.extern.log4j.Log4j2;

@Log4j2
public abstract class BooksURL {

    Integer pageNumber = 0;

    public void reset(){
        log.info("Zeroing pageNumber");
        pageNumber = 0;
    }
}
