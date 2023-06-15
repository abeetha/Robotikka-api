package com.bootcamp.robotikka.robotikkaapi.entity;

import com.bootcamp.robotikka.robotikkaapi.enums.OrderState;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
@Entity(name = "order_table")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
    @Id
    @Column(name = "property_id")
    private String propertyId;
    private Date date;
    @Column(name ="total_cost")
    private double totalCost;
    @Column(name ="shipping_address")
    private String shippingAddress;
    @Column(name = "order_state")
    @Enumerated(EnumType.STRING)
    private OrderState orderState;
    @Column(name = "order_qty")
    private int orderQty;
    @ManyToOne
    @JoinColumn(name = "user_property_id")
    private User userPropertyId;
    @ManyToOne()
    @JoinColumn(name = "product_property_name")
    private Product productPropertyId;

    @OneToOne(mappedBy = "ordersPropertyId")
    private Payment payment;
}
