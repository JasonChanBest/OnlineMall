package com.mall.orm.item;

import com.mall.orm.category.Category;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Created by Jayson on 2014/8/10.
 */
@Entity
@Table(name = "Item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull(message = "商品名称不能为空")
    @NotEmpty(message = "商品名称不能为空")
    @Column(name = "name")
    private String name;

    @Pattern(regexp = "[\\d]+(.[\\d]+)*" , message = "价格填写不规范")
    @Column(name = "price")
    private float price;

    @NotNull(message = "商品详情不能为空")
    @NotEmpty(message = "商品详情不能为空")
    @Column(name = "detail")
    private String detail;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
