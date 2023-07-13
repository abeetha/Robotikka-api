package com.bootcamp.robotikka.robotikkaapi.dto.response;

import com.bootcamp.robotikka.robotikkaapi.entity.LovedProperty;
import com.bootcamp.robotikka.robotikkaapi.entity.Orders;
import com.bootcamp.robotikka.robotikkaapi.entity.ProductImages;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseProductDTO {
    private String propertyId;
    private String displayName;
    private String description;
    private double unitPrice;
    private int qty;
    private double sellingPrice;
}
