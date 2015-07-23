package us.match.website.model;

import javax.persistence.*;

/**
 * Created by apple on 2015/7/23.
 */
@Entity
public class InfoRelation {
    private int rid;
    private Information info;
    private User user;
    private int state;//1代表未读，0代表已读

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="infoid")
    public Information getInfo() {
        return info;
    }

    public void setInfo(Information info) {
        this.info = info;
    }

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="uid")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Id
    @GeneratedValue
    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }
}
