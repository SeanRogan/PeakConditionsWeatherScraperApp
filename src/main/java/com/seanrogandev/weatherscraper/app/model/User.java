package com.seanrogandev.weatherscraper.app.model;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Users")
@NoArgsConstructor
public class User {
    @Id //for primary key
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column (name = "email")
    private String email;

    @Column (name = "userName")
    private String userName;

    @Column (name = "password")
    private String password;

}
