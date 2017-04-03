package pl.akademiakodu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.akademiakodu.model.Category;
import pl.akademiakodu.repository.CategoryRepository;
import pl.akademiakodu.repository.GifRepository;

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


    @RequestMapping("/category/{categoryId}")
    public String category(@PathVariable int categoryId, ModelMap modelMap){
        Category category= categoryRepository.findBy(categoryId);
        modelMap.addAttribute("category", category);
        modelMap.addAttribute("gifs", gifRepository.findById(categoryId));
        return "category";
    }

}
