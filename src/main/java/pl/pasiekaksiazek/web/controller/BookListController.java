package pl.pasiekaksiazek.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.pasiekaksiazek.web.service.BooksService;
import pl.pasiekaksiazek.web.service.CacheService;

import java.net.URISyntaxException;

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
    public String getAllBooks() throws URISyntaxException, JsonProcessingException {
        if (cacheService.getJson() == null){
            cacheService.setJson(booksService.prepareJsonAndListCache());
        }
        return cacheService.getJson();
    }
}
