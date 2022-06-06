package com.seanrogandev.weatherscraper.app.entities;
import lombok.*;

import javax.persistence.*;

@Entity(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id //for primary key
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(mappedBy = "user" ,
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private UserProfile profile;


    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column (name = "email")
    private String email;

    @Column (name = "user_name")
    private String userName;

    //TODO IMPLEMENT ENCRYPTION/SECURITY
    // need to convert passwords to its hash
    // on registration and store that in the DB, along with a salt for each user
    // not their actual password. Then on Login hash their password input and compare the two

    @Column (name = "password")
    private String passwordHash;

    @Column (name = "wind_max")
    private Integer maxWindspeed;

    @Column (name = "wind_min")
    private Integer minWindspeed;

    @Column (name = "temp_max")
    private Integer maxTemp;

    @Column (name = "temp_min")
    private Integer minTemp;





}
