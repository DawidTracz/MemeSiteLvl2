package pl.akademiakodu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.akademiakodu.model.Gif;
import pl.akademiakodu.repository.GifRepository;

/**
 * Created by User on 31.03.2017.
 */
@Controller
public class GifController {

    @Autowired
    private GifRepository gifRepository;

    @RequestMapping("/")
    public String listGifts(ModelMap modelMap) {
        modelMap.addAttribute("gifs", gifRepository.getAllGifs());

        return "home";
    }

    @RequestMapping("/gif/")
    public String gifDetails(@PathVariable String name, ModelMap modelMap) {
        Gif gif = gifRepository.findByName(name);
        modelMap.put("gif", gif);
        return "gif-details";
    }


    @GetMapping("/favorites")
    public String gifDetails(ModelMap modelMap) {
        modelMap.addAttribute("favorites", gifRepository.getAllGifs());


        return "favorites";
    }



}