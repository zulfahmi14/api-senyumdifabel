package com.example.senyumdifabel.notification;

import javax.persistence.*;
import java.security.ProtectionDomain;

@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id ;

    @Column(nullable = false)
    protected Long user_id ;

    protected Long type ;

    protected Boolean enable ; // false = belum dilihat, true = sudah dilihat

    @Column(nullable = false)
    protected Long data_id ; // proposal_id/user_id

    @Column(nullable = false) // timeline_id --> yang dilike/comment
    protected Long data_id2 ;

    public Notification() {
    }

    public Notification(Long user_id, Long type, Boolean enable, Long data_id, Long data_id2) {
        this.user_id = user_id;
        this.type = type;
        this.enable = enable;
        this.data_id = data_id;
        this.data_id2 = data_id2;
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

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Long getData_id() {
        return data_id;
    }

    public void setData_id(Long data_id) {
        this.data_id = data_id;
    }

    public Long getData_id2() {
        return data_id2;
    }

    public void setData_id2(Long data_id2) {
        this.data_id2 = data_id2;
    }
}
