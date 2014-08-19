package com.mall.action.item;

import com.mall.orm.category.Category;
import com.mall.orm.item.Item;
import com.mall.orm.picture.Picture;
import com.mall.service.category.ICategoryService;
import com.mall.service.item.IItemService;
import com.mall.service.picture.IPictureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by jayson on 2014/8/12.
 */
@Controller("ItemAction")
@RequestMapping("/admin/item")
public class ItemAction {

    private static final Logger LOGGER = LoggerFactory.getLogger(ItemAction.class);

    private static final String ITEM_LIST = "jsp/item/list";
    private static final String ITEM_ADD = "jsp/item/add";
    private static final String ITEM_EDIT = "jsp/item/edit";

    @Resource(name = "ItemService")
    private IItemService itemService;

    @Resource(name = "CategoryService")
    private ICategoryService categoryService;

    @Resource(name = "PictureService")
    private IPictureService pictureService;

    @RequestMapping("/list")
    public String list(Model model){
        List<Item> items = itemService.list();
        for(Item item : items){
            LOGGER.debug(item.getId()+"");
            LOGGER.debug(item.getName());
            LOGGER.debug(item.getPrice()+"");
            LOGGER.debug(item.getCategory().getName());
        }
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
    public String add(@Valid @ModelAttribute Item item , BindingResult result , int categoryId , String[] pictureNames , Model model){

        if(result.hasErrors()){
            return ITEM_ADD;
        }

        if(categoryId == 0){
            model.addAttribute("item_category_id_error" , "商品分类为必填项");
        }

        Category category = categoryService.get(categoryId);

        item.setCategory(category);

        itemService.save(item);

        for(String pictureName : pictureNames){
            Picture picture = new Picture();
            picture.setPath(pictureName);
            picture.setItem(item);
            pictureService.save(picture);
        }

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

    @RequestMapping("/test")
    @ResponseBody
    public String test(String[] strings){
        for(String s : strings){
            LOGGER.debug(s);
        }
        return "success";
    }
}
