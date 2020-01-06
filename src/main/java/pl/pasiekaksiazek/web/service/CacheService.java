package pl.pasiekaksiazek.web.service;

import lombok.Data;
import org.springframework.stereotype.Service;
import pl.pasiekaksiazek.web.book.Book;

import java.util.ArrayList;
import java.util.List;

@Data
@Service
public class CacheService {

    String json = null;

    List<Book> giftBooksList = new ArrayList<>();
}
