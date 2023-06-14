package com.bootcamp.robotikka.robotikkaapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
@Entity(name = "payment_table")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    @Id
    @Column(name = "property_id")
    private String propertyId;
    @Column(name = "payment_date")
    private Date paymentDate;
    private double amount;
    private String bank;
    @OneToOne
    @JoinColumn(name = "order_property_id",unique= true)
    private Orders ordersPropertyId;
}
