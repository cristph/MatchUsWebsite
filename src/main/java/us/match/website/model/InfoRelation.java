package us.match.website.model;

import javax.persistence.*;

/**
 * Created by apple on 2015/7/23.
 */
@Entity
public class InfoRelation {
    private int rid;
    private Information info;
    private User sender;
    private User receiver;
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

    @Id
    @GeneratedValue
    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="senderid")
    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="receiverid")
    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }
}
