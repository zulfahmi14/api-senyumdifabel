package com.example.senyumdifabel.params;

public class CountFollow {
    protected Long follower;
    protected Long following;

    public CountFollow(){}

    public CountFollow(Long follower, Long following) {
        this.follower = follower;
        this.following = following;
    }

    public Long getFollower() {
        return follower;
    }

    public void setFollower(Long follower) {
        this.follower = follower;
    }

    public Long getFollowing() {
        return following;
    }

    public void setFollowing(Long following) {
        this.following = following;
    }
}
