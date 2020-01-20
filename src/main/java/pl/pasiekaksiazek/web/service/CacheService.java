package pl.pasiekaksiazek.web.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
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

@Log4j2
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
                log.info("Updating cache...");
                json = booksService.prepareJsonAndListCache();
                log.info("Updated at " + LocalTime.now().toString());
            } catch (URISyntaxException | JsonProcessingException e) {
                log.error(e.getMessage());
                e.printStackTrace();
            }
        }, "UpdateBooksListWorker");

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        executorService.scheduleAtFixedRate(worker, 15, 60, TimeUnit.MINUTES);
    }
}
