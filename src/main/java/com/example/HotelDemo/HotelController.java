package com.example.HotelDemo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
//    @GetMapping("addhotel")
//    public String add(String hotelname, String category, Model model) {
//        hotelService.add(prodname,price);
//        model.addAttribute("name", prodname);
//        model.addAttribute("price",price);
//        model.addAttribute("tab_lines", op.products);
//        return "redirect:/";
}
