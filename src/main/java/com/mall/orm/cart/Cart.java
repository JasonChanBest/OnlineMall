package com.mall.orm.cart;

import com.mall.orm.item.Item;
import com.mall.orm.user.User;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Jayson on 2014/8/10.
 */
@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToMany
    @JoinTable(name = "cart_item" , joinColumns = {@JoinColumn(name = "item_id")})
    private Set<Item> items;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }
}
