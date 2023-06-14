package com.bootcamp.robotikka.robotikkaapi.entity;

import com.bootcamp.robotikka.robotikkaapi.entity.share.FileResource;
import com.bootcamp.robotikka.robotikkaapi.entity.share.UserNameResource;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity(name = "user_table")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @Column(name = "property_id")
    private String propertyId;
    @Column(name = "contact_number")
    private String contactNumber;
    @Embedded
    private UserNameResource name;
    private String email;
    private String password;
    @Column(name = "is_account_non_expired")
    private boolean isAccountNonExpired;
    @Column(name = "is_account_non_locked")
    private boolean isAccountNonLocked;
    @Column(name = "is_credentials_non_expired")
    private boolean isCredentialsNonExpired;
    @Column(name = "is_enabled")
    private boolean isEnabled;
    @Column(name = "prefix")
    private String prefix;
    @Embedded
    private FileResource avatar;
    @OneToMany(mappedBy = "userPropertyId",cascade = CascadeType.ALL)
    private List<Orders> ordersList;
}
