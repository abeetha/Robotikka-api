package com.bootcamp.robotikka.robotikkaapi.entity;

import com.bootcamp.robotikka.robotikkaapi.entity.share.FileResource;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity(name = "product_table")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @Column(name = "property_id")
    private String propertyId;
    @Column(name = "display_name")
    private String displayName;
    private String description;
    @Column(name = "unit_price")
    private double unitPrice;
    private int qty;
    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private List<ProductImages> images;
    @Column(name = "selling_price")
    private double sellingPrice;
    @OneToMany(mappedBy = "productPropertyId",cascade = CascadeType.ALL)
    private List<Orders> orderList;

    @OneToMany(mappedBy = "productPropertyId",cascade = CascadeType.ALL)
    private List<LovedProperty> lovedProperties;
}
