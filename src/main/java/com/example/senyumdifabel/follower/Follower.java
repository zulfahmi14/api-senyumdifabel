//package com.example.senyumdifabel.follower;
//
//import com.example.senyumdifabel.following.Following;
//
//import javax.persistence.*;
//
//@Entity
//public class Follower {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    protected Long Id;
//
//    @Column(nullable = false)
//    protected String user_id1 ;
//
//    @Column(nullable = false)
//    protected String user_id2 ;
//
//    public Follower(){}
//
//    public Follower(String user_id1, String user_id2) {
//        this.user_id1 = user_id1;
//        this.user_id2 = user_id2;
//    }
//
//    public Long getId() {
//        return Id;
//    }
//
//    public void setId(Long id) {
//        Id = id;
//    }
//
//    public String getUser_id1() {
//        return user_id1;
//    }
//
//    public void setUser_id1(String user_id1) {
//        this.user_id1 = user_id1;
//    }
//
//    public String getUser_id2() {
//        return user_id2;
//    }
//
//    public void setUser_id2(String user_id2) {
//        this.user_id2 = user_id2;
//    }
//}
