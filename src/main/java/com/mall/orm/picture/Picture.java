package com.mall.orm.picture;

import com.mall.orm.item.Item;

import javax.persistence.*;

/**
 * Created by Jayson on 2014/8/10.
 */
@Entity
@Table(name = "picture")
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "small_path")
    private String smallPath;
    @Column(name = "big_path")
    private String bigPath;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id")
    private Item item;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSmallPath() {
        return smallPath;
    }

    public void setSmallPath(String smallPath) {
        this.smallPath = smallPath;
    }

    public String getBigPath() {
        return bigPath;
    }

    public void setBigPath(String bigPath) {
        this.bigPath = bigPath;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
