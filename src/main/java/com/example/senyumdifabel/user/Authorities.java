package com.example.senyumdifabel.user;

import com.example.senyumdifabel.people.People;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Authorities {
    @Id
//    @NotNull
    private String username;

//    @NotNull
    private String authority = "ROLE_USER";

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "people_id", nullable = false)
    private People people;

    public Authorities() {
    }

    public Authorities(String username, People people) {
        this.username = username;
        this.people = people;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }
}
