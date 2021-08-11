package com.ttt.hellospringboot.entity;

import com.fasterxml.jackson.annotation.JsonTypeId;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "User")
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Column(name =  "name")
    private String name;

    @Column(name ="email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name="avatar")
    private String avatar;

    @Column(name = "password")
    private String password;
}
