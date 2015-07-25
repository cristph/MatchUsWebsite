package us.match.website.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by apple on 2015/7/25.
 */
@Entity
public class Reply {
    private int reply_id ;
    private User reply_user;
    private Post reply_post ;
    private String reply_content ;
    private Timestamp reply_createtime ;



    @Id
    @GeneratedValue
    public int getReply_id() {
        return reply_id;
    }

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="uid")
    public User getReply_user() {
        return reply_user;
    }

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="post_id")
    public Post getReply_post() {
        return reply_post;
    }

    public String getReply_content() {
        return reply_content;
    }

    @PrePersist
    public Timestamp getReply_createtime() {
        return reply_createtime;
    }

    public void setReply_id(int reply_id) {
        this.reply_id = reply_id;
    }

    public void setReply_user(User reply_user) {
        this.reply_user = reply_user;
    }

    public void setReply_post(Post reply_post) {
        this.reply_post = reply_post;
    }

    public void setReply_content(String reply_content) {
        this.reply_content = reply_content;
    }

    public void setReply_createtime(Timestamp reply_createtime) {
        this.reply_createtime = reply_createtime;
    }
}
