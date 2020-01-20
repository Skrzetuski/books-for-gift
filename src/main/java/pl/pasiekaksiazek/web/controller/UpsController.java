package pl.pasiekaksiazek.web.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Log4j2
@Controller
public class UpsController implements ErrorController {

    @ResponseBody
    @RequestMapping("/error")
    public String handleError(){
        log.info("==========================");
        log.info(" Someone tried get access ");
        log.info("==========================");
        return "aHR0cHM6Ly93d3cueW91dHViZS5jb20vd2F0Y2g/dj1kUXc0dzlXZ1hjUQ==";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
