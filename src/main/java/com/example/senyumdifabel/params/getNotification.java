package com.example.senyumdifabel.params;

import com.example.senyumdifabel.notification.Notification;

public class getNotification extends Notification {
    public Long forward_id ;
    public String notif_name ;
    public String notif_photo ;
    public Long status ;
    public String notif_detail ;

    public getNotification() {
    }

    public getNotification(Long forward_id, String notif_name, String notif_photo, Long status, String notif_detail) {
        this.forward_id = forward_id;
        this.notif_name = notif_name;
        this.notif_photo = notif_photo;
        this.status = status;
        this.notif_detail = notif_detail;
    }

    public getNotification(Long user_id, Long type, Boolean enable, Long data_id, Long data_id2, Long forward_id, String notif_name, String notif_photo, Long status, String notif_detail) {
        super(user_id, type, enable, data_id, data_id2);
        this.forward_id = forward_id;
        this.notif_name = notif_name;
        this.notif_photo = notif_photo;
        this.status = status;
        this.notif_detail = notif_detail;
    }

    public Long getForward_id() {
        return forward_id;
    }

    public void setForward_id(Long forward_id) {
        this.forward_id = forward_id;
    }

    public String getNotif_name() {
        return notif_name;
    }

    public void setNotif_name(String notif_name) {
        this.notif_name = notif_name;
    }

    public String getNotif_photo() {
        return notif_photo;
    }

    public void setNotif_photo(String notif_photo) {
        this.notif_photo = notif_photo;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public String getNotif_detail() {
        return notif_detail;
    }

    public void setNotif_detail(String notif_detail) {
        this.notif_detail = notif_detail;
    }
}
