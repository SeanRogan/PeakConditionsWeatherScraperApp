package com.seanrogandev.weatherscraper.app.entities;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "users")
public class User {

    @Id //for primary key
    @Getter
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Getter
    @Setter
    @Column(name = "first_name")
    private String firstName;
    @Getter
    @Setter
    @Column(name = "last_name")
    private String lastName;
    @Getter
    @Setter
    @Column (name = "email")
    private String email;
    @Getter
    @Setter
    @Column (name = "user_name")
    private String userName;
    @Getter
    @Setter
    @Column (name = "password")
    private String password;

}
