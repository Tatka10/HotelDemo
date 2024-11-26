package com.example.HotelDemo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HotelController {
    @Autowired
    HotelService hotelService;

    @GetMapping("/")
    public String index(Model m) {
        System.out.println("загружается контроллер");
        System.out.println(hotelService.getHotels());
        m.addAttribute("tab_hotels", hotelService.getHotels());
        return "hotels";
    }

    @GetMapping("/hotels")
    public String index1(Model m) {
        System.out.println(hotelService.getHotels());
        m.addAttribute("tab_hotels", hotelService.getHotels());
        return "hotels";
    }

    @GetMapping("/deletehotel")
    public String deleteHotel(String id, Model m) {
        try {
            int y = Integer.parseInt(id);
            hotelService.removeById(y);
            m.addAttribute("tab_hotels", hotelService.getHotels());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "hotels";
    }

    @GetMapping("addhotel")
    public String addHotel(String hotelname, String category, Model model) {
        hotelService.addHotel(hotelname, category);
        model.addAttribute("name", hotelname);
        model.addAttribute("category", category);
        model.addAttribute("tab_hotels", hotelService.hotels);
        return "redirect:/";
    }

    @GetMapping("/hotelinfo")
    public String hotelInfo(String name, Model m) {

        Hotel hotel = hotelService.getHotelByName(name);
        if (hotel != null) {
            m.addAttribute("hotel", hotel);
        }
        return "hotelinfo";
    }
    @GetMapping("/type/{type}")
    public String getTypeProducts(@PathVariable String category,
                                  Model model) {
        System.out.println("category = " + category);
        model.addAttribute("category", hotelService.getHotelsByCategory(category));
        model.addAttribute("category", hotelService.getCategory(category));
        return "index";  // название HTML-шаблона
    }
}