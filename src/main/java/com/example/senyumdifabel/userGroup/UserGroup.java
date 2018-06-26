package com.example.senyumdifabel.userGroup;

import javax.persistence.*;

@Entity
@Table(name = "user_group")
public class UserGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    private Long user_id ;
    private Long id_prev ;

    public UserGroup() {
    }

    public UserGroup(Long user_id, Long id_prev) {
        this.user_id = user_id;
        this.id_prev = id_prev;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getId_prev() {
        return id_prev;
    }

    public void setId_prev(Long id_prev) {
        this.id_prev = id_prev;
    }
}
