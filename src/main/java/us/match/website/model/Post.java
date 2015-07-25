package us.match.website.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by apple on 2015/7/25.
 */
@Entity
public class Post {
    private int post_id;
    private String post_title;
    private Project post_match;
    private User poster;
    private Timestamp post_createtime;
    private Timestamp post_updatetime;
    private String post_content;
    private int post_ispay ;
    private boolean is_stick;
    /*
        Lists
     */
    private List<Reply> Replylists ;

    @Id
    @GeneratedValue
    public int getPost_id() {
        return post_id;
    }

    public String getPost_title() {
        return post_title;
    }



    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="uid")
    public User getPoster() {
        return poster;
    }

    @PrePersist
    public Timestamp getPost_createtime() {
        return post_createtime;
    }

    @PrePersist
    @PreUpdate
    public Timestamp getPost_updatetime() {
        return post_updatetime;
    }

    public String getPost_content() {
        return post_content;
    }



    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public void setPost_title(String post_title) {
        this.post_title = post_title;
    }



    public void setPoster(User poster) {
        this.poster = poster;
    }

    public void setPost_createtime(Timestamp post_createtime) {
        this.post_createtime = post_createtime;
    }

    public void setPost_updatetime(Timestamp post_updatetime) {
        this.post_updatetime = post_updatetime;
    }

    public void setPost_content(String post_content) {
        this.post_content = post_content;
    }


    public int getPost_ispay() {
        return post_ispay;
    }

    public void setPost_ispay(int post_ispay) {
        this.post_ispay = post_ispay;
    }

    @OneToMany(mappedBy = "reply_post",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    public List<Reply> getReplylists() {
        return Replylists;
    }

    public void setReplylists(List<Reply> replylists) {
        Replylists = replylists;
    }

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="pid")
    public Project getPost_match() {
        return post_match;
    }

    public void setPost_match(Project post_match) {
        this.post_match = post_match;
    }

    public boolean getIs_stick() {
        return is_stick;
    }

    public void setIs_stick(boolean is_stick) {
        this.is_stick = is_stick;
    }
}
