package com.mall.action.item;

import com.mall.orm.category.Category;
import com.mall.orm.item.Item;
import com.mall.service.category.ICategoryService;
import com.mall.service.item.IItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by jayson on 2014/8/12.
 */
@Controller("ItemAction")
@RequestMapping("/admin/item")
public class ItemAction {
    private static final String ITEM_LIST = "jsp/item/list";
    private static final String ITEM_ADD = "jsp/item/add";
    private static final String ITEM_EDIT = "jsp/item/edit";

    @Resource(name = "ItemService")
    private IItemService itemService;

    @Resource(name = "CategoryService")
    private ICategoryService categoryService;

    @RequestMapping("/list")
    public String list(Model model){
        List<Item> items = itemService.list();
        model.addAttribute("items" , items);
        return ITEM_LIST;
    }

    @RequestMapping("/addInit")
    public String addInit(Model model){
        List<Category> categories = categoryService.list();
        model.addAttribute("categories" , categories);

        return ITEM_ADD;
    }

    @RequestMapping("/add")
    public String add(@Valid @ModelAttribute Item item , BindingResult result , Model model){

        if(result.hasErrors()){
            return ITEM_ADD;
        }

        itemService.save(item);

        return ITEM_ADD;
    }

    @RequestMapping("/editInit")
    public String editInit(Model model){
        List<Category> categories = categoryService.list();
        model.addAttribute("categories" , categories);

        return ITEM_EDIT;
    }

    @RequestMapping("/edit")
    public String edit(@Valid @ModelAttribute Item item , BindingResult result , Model model){
        if(result.hasErrors()){
            return ITEM_EDIT;
        }

        itemService.update(item);

        List<Category> categories = categoryService.list();
        model.addAttribute("categories" , categories);

        return ITEM_EDIT;
    }

    @RequestMapping("/delete")
    public String delete(int id , Model model){
        Item item = itemService.get(id);
        if(item == null){
            model.addAttribute("itemErr" , "商品不存在");
            return ITEM_LIST;
        }
        itemService.delete(item);
        model.addAttribute("itemErr" , "删除成功");
        return ITEM_LIST;
    }

}
