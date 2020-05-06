package com.henry.spring.ioc.overview.domain;

public class UserHolder {
    private User user;

    public UserHolder(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override public String toString() {
        return "UserHolder{" + "user=" + user + '}';
    }
}
