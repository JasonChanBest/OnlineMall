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
@RequestMapping("/admin/category")
public class CategoryAction {
    private static final String CATEGORY_LIST = "jsp/category/list";
    private static final String CATEGORY_ADD = "jsp/category/add";
    private static final String CATEGORY_EDIT = "jsp/category/edit";
    @Resource(name = "CategoryService")
    private ICategoryService categoryService;

    @RequestMapping("/add")
    public String add(@Valid @ModelAttribute Category category , BindingResult result , Model model){
        if(result.hasErrors()){
            return CATEGORY_ADD;
        }

        if(category.getParent().getId() == 0){
            category.setParent(null);
        }

        categoryService.save(category);
        List<Category> categories = categoryService.list();
        model.addAttribute("categories" , categories);
        return CATEGORY_ADD;
    }
    @RequestMapping("/addInit")
    public String addInit(Model model){
        List<Category> categories = categoryService.list();
        model.addAttribute("categories" , categories);
        return CATEGORY_ADD;
    }
    @RequestMapping("/list")
    public String list(Model model){
        List<Category> categories = categoryService.list();
        model.addAttribute("categories" , categories);
        return CATEGORY_LIST;
    }
    @RequestMapping("/delete")
    public String delete(int id , Model model){
        Category category = categoryService.get(id);
        if(category == null){
            model.addAttribute("categoryErr" , "分类不存在");
            return CATEGORY_LIST;
        }
        categoryService.delete(category);
        List<Category> categories = categoryService.list();
        model.addAttribute("categories" , categories);
        return CATEGORY_LIST;
    }
    @RequestMapping("/editInit")
    public String editInit(int id , Model model){
        Category category = categoryService.get(id);
        model.addAttribute("category" , category);
        List<Category> categories = categoryService.list();
        model.addAttribute("categories" , categories);
        return CATEGORY_EDIT;
    }
    @RequestMapping("/edit")
    public String edit(@Valid @ModelAttribute Category category , BindingResult result , Model model){
        categoryService.update(category);
        return CATEGORY_EDIT;
    }
}