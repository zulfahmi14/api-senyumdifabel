package com.example.senyumdifabel.flagChat;

import javax.persistence.*;

@Entity
public class FlagChat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id ;

    @Column(nullable = false)
    protected Long id_prev ;

    @Column(nullable = false)
    protected Long user_id ;

    @Column(nullable = false)
    protected Boolean flag ; // false = unread, true = read

    protected Long type ; // 1 = personal chat, 2 = group chat

    public FlagChat(){}

    public FlagChat(Long id_prev, Long user_id, Boolean flag, Long type) {
        this.id_prev = id_prev;
        this.user_id = user_id;
        this.flag = flag;
        this.type = type;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_prev() {
        return id_prev;
    }

    public void setId_prev(Long id_prev) {
        this.id_prev = id_prev;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }
}
