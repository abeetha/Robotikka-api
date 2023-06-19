package com.bootcamp.robotikka.robotikkaapi.dto.request;

import com.bootcamp.robotikka.robotikkaapi.entity.LovedProperty;
import com.bootcamp.robotikka.robotikkaapi.entity.Orders;
import com.bootcamp.robotikka.robotikkaapi.entity.ProductImages;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestProductDTO {
    private String displayName;
    private String description;
    private double unitPrice;
    private int qty;
    private double sellingPrice;
}
