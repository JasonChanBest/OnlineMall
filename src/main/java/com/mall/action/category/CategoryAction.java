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
    private static final String CATEGORY_DELETE = "jsp/admin/category_delete";
    @Resource(name = "CategoryService")
    private ICategoryService categoryService;

    @RequestMapping("/add")
    public String add(@Valid @ModelAttribute Category category , BindingResult result , int parentId){
        if(result.hasErrors()){
            return CATEGORY_ADD;
        }
        Category parent;
        if(parentId == 0){
            parent = null;
        }else{
            parent = categoryService.get(parentId);
        }
        category.setParent(parent);
        categoryService.save(category);
        return CATEGORY_ADD;
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
    @RequestMapping("/delete")
    public String delete(int id , Model model){
        Category category = categoryService.get(id);
        if(category == null){
            //TODO
        }
        categoryService.delete(category);
        List<Category> categories = categoryService.list();
        model.addAttribute("categories" , categories);
        return CATEGORY_LIST;
    }
}
