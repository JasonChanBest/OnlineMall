package com.mall.form.item;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import java.util.List;

/**
 * @author 陈嘉展
 * @date 2014-12-29 15:24
 * @copyright 版权所有 © 2014 广州合贷投资管理有限公司 www.hedaiwang.cn
 * @since v2.2.0
 */
public class AddItemForm {
    @NotBlank(message = "商品名称不能为空")
    private String name;

    @DecimalMin(value = "0.1" , message = "价格应大于0.1")
    private float price;

    @NotBlank(message = "商品详情不能为空")
    private String detail;

    @Min(value = 1 , message = "商品分类Id必须大于等于1")
    private int categoryId;

    @NotEmpty(message = "必须有商品图片")
    private List<String> pictures;

    /**getter、setter方法**/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public List<String> getPictures() {
        return pictures;
    }

    public void setPictures(List<String> pictures) {
        this.pictures = pictures;
    }
}
