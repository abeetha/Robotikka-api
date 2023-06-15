package com.bootcamp.robotikka.robotikkaapi.entity;

import com.bootcamp.robotikka.robotikkaapi.entity.share.FileResource;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "product_image")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductImages {
    @Id
    @Column(name = "property_id")
    private String property_id;
    @Embedded
    private FileResource resource;
    @ManyToOne
    private Product product;
}
