package pl.akademiakodu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.akademiakodu.model.Gif;
import pl.akademiakodu.repository.CategoryRepository;
import pl.akademiakodu.repository.GifRepository;

import java.util.List;

/**
 * Created by User on 03.04.2017.
 */
@Controller
public class CategoryController {

    @Autowired
    private GifRepository gifRepository;
    @Autowired
    private CategoryRepository categoryRepository;

   @GetMapping("/categories")
    public String listCategories(ModelMap modelMap){
       modelMap.addAttribute("categories", categoryRepository.getAllCategories());
        return "categories";
    }


    @RequestMapping("/category/{id}")
    public String category(@PathVariable int id, ModelMap modelMap){
        modelMap.addAttribute("categories", categoryRepository.getAllCategories());
        List<Gif> gifs = gifRepository.findByCategoryId(id);
        modelMap.put("gifs",gifs);
        return "category";
    }

}
