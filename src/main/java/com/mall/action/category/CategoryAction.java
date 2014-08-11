package com.mall.action.category;

import com.mall.orm.category.Category;
import com.mall.service.category.ICategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by Jayson on 2014/8/11.
 */
@Controller("CategoryAction")
@RequestMapping("/category")
public class CategoryAction {
    private static final String CATEGORY_LIST = "jsp/admin/category_list";
    private static final String CATEGORY_ADD = "jsp/admin/category_add";
    @Resource(name = "CategoryService")
    private ICategoryService categoryService;

    @RequestMapping("/add")
    public String add(@Valid @ModelAttribute Category category , BindingResult result){
        if(result.hasErrors()){
            return CATEGORY_ADD;
        }
        categoryService.save(category);
        return CATEGORY_LIST;
    }
    @RequestMapping("/addInit")
    public String addInit(){
        return CATEGORY_ADD;
    }
    @RequestMapping("/list")
    public String list(Model model){
        List<Category> categories = categoryService.list();
        model.addAttribute("categories" , categories);
        return CATEGORY_LIST;
    }
}
