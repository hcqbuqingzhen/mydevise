package strategy.controller;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import strategy.service.EventDispatch;

@Controller
@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private EventDispatch eventDispatch;

    @GetMapping("/event/{event}")
    public String handleEvent(@PathVariable String event) {
        return eventDispatch.getEventHandle(event).handle(event);
    }
}
