package com.seanrogandev.weatherscraper.app.entities;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Entity(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id //for primary key
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column (name = "email")
    private String email;

    @Column (name = "user_name")
    private String userName;

    @Column (name = "password")
    private String password;

    @Column (name = "wind_max")
    private Integer maxWindspeed;

    @Column (name = "wind_min")
    private Integer minWindspeed;

    @Column (name = "temp_max")
    private Integer maxTemp;

    @Column (name = "temp_min")
    private Integer minTemp;

}
