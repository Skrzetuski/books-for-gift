package pl.pasiekaksiazek.web.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pasiekaksiazek.web.book.Book;

import java.net.URISyntaxException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Data
@Service
public class CacheService {

    @Autowired
    BooksService booksService;

    String json = null;

    List<Book> giftBooksList = new ArrayList<>();

    public void updateCache(){
        Thread worker = new Thread(()->{
            try {
                json = booksService.prepareJsonAndListCache();
                System.out.println("Update: " + LocalTime.now().toString());
            } catch (URISyntaxException | JsonProcessingException e) {
                e.printStackTrace();
            }
        });

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        executorService.scheduleAtFixedRate(worker, 15, 60, TimeUnit.MINUTES);
    }
}
