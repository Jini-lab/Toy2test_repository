package com.fineapple;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class homecontrooler {

    @GetMapping("/")
    public String testhome(){
        return "hello";
    }
}
