package io.techup.android.friedlychatapp.pojo;

import java.util.Date;

/**
 * Created by PaoRendor on 01/08/16.
 */
public class Chat {

    private int id;

    private String message;

    private String senderName;

    private Date time;

    private String senderPhotoUrl;

    public Chat(int id, String message, String senderName, Date time, String senderPhotoUrl) {
        this.id = id;
        this.message = message;
        this.senderName = senderName;
        this.time = time;
        this.senderPhotoUrl = senderPhotoUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getSenderPhotoUrl() {
        return senderPhotoUrl;
    }

    public void setSenderPhotoUrl(String senderPhotoUrl) {
        this.senderPhotoUrl = senderPhotoUrl;
    }
}
