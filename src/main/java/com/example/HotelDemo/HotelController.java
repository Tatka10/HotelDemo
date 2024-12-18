package com.example.HotelDemo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;

@Controller
public class HotelController {
    @Autowired
    HotelService hotelService;

    @GetMapping("/")
    public String index(Model m) {
        System.out.println("загружается контроллер");
        System.out.println(hotelService.getHotels());
        m.addAttribute("tab_hotels", hotelService.getHotels());
        m.addAttribute("categories", hotelService.getCategories());
        return "hotels";
    }

    @GetMapping("/hotels")
    public String index1(Model m) {
        System.out.println(hotelService.getHotels());
        m.addAttribute("tab_hotels", hotelService.getHotels());
        m.addAttribute("categories", hotelService.getCategories());
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
        model.addAttribute("name", hotelname);

        if (category.contains("stars")) {
            hotelService.addHotel(hotelname, category);
        } else {
            String cat = category + " stars";
            hotelService.addHotel(hotelname, cat);
        }
        model.addAttribute("tab_hotels", hotelService.getHotels());
        return "redirect:/";
    }

    @GetMapping("/hotelinfoid")
    public String hotelInfoId(String id, Model m) {
        int i = Integer.parseInt(id);
        Hotel hotel = hotelService.getHotelById(i);
        if (hotel != null) {
            m.addAttribute("hotel", hotel);
        }
        return "hotelinfoId";
    }

    @GetMapping("/category/{category}")
    public String getTypeProducts(@PathVariable String category,
                                  Model model) {
        System.out.println("category = " + category);
        model.addAttribute("tab_hotels", hotelService.getHotelsByCategory(category));
        model.addAttribute("categories", hotelService.getCategories());
        return "hotels";  // название HTML-шаблона
    }

    @GetMapping("/findhotel")
    public String findhotel(String name, Model model) {
        hotelService.saveSearchHotels(name);
        System.out.println("получено name = " + name);
        Hotel h = hotelService.getHotelByName(name);
        System.out.println(h);
        if (h != null) {
            model.addAttribute("nameFindHotel", h.name);
            model.addAttribute("categoryFindHOtel", h.category);
            return "hotels";
        } else {
            model.addAttribute("nameFindHotel", "Отеля нет в списке");

            return "hotels";
        }
    }

    @GetMapping("/adminka")
    public String adminka(Model model) {

        model.addAttribute("tab_lines", hotelService.listSearches);
        return "adminka";
    }

    @PostMapping("/change")
    public String changeInfoOfHotel(String name, String categoy, String id, Model model) {
        Hotel h = hotelService.changeInfoHotel(name, categoy, Integer.parseInt(id));
        model.addAttribute("hotel", h);
        return "/change";
    }

    @PostMapping("/upload")
    public String doUpLOad(MultipartFile xfile, Model model) throws IOException {
        if (xfile == null || xfile.isEmpty()) {
            System.out.println("нет файла");
            model.addAttribute("message", "нет файла");
        } else {
            System.out.println("файл загружен" + xfile.getOriginalFilename());
            System.out.println("размер файла " + xfile.getSize());
            model.addAttribute("message", "Файл загружен" + xfile.getOriginalFilename());
            Path path = Path.of("filesForHotelDemo" + "/" + xfile.getOriginalFilename());
            try {
                xfile.transferTo(path);
            } catch (IOException e) {
                System.out.println("файл не сохранен " + xfile.getOriginalFilename());
                model.addAttribute("messageError", "Ошибка сохранения файла " + xfile.getOriginalFilename());
            }
        }
        return "hotels";
    }
}

