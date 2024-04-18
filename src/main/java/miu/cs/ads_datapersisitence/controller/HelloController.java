package miu.cs.ads_datapersisitence.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ads/public")
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }
}
