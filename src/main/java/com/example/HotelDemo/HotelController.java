package com.example.HotelDemo;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HotelController {



    @GetMapping("/")
    public String index(Model m){


    }
}