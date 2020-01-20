package pl.pasiekaksiazek.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.pasiekaksiazek.web.service.BooksService;
import pl.pasiekaksiazek.web.service.CacheService;

import java.net.URISyntaxException;

@Log4j2
@Controller
@RequestMapping(value = "/api/books")
public class BookListController {

    @Autowired
    CacheService cacheService;

    @Autowired
    BooksService booksService;

    @CrossOrigin(value = "*", methods = RequestMethod.GET)
    @ResponseBody
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAllBooks() throws URISyntaxException, JsonProcessingException{
        if (cacheService.getJson() == null){

            log.info("Empty cache - it's time to prepare");
            cacheService.setJson(booksService.prepareJsonAndListCache());

            log.info("Run automatically period list update ");
            cacheService.updateCache();
        }
        return cacheService.getJson();
    }
}
