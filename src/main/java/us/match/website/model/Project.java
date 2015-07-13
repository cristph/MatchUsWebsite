package us.match.website.model;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.Set;

/**
 * Created by apple on 2015/7/9.
 */
@Entity
public class Project {
    private String pid;
    private String pinstruction;
    private String pname;
    private byte[] picture;
    private boolean state;
    private String subject;
    private String moduel;
    private String skill;
    private String reward;
    private User publisher;
    private Set<User> workers;


    public String getPinstruction() {
        return pinstruction;
    }

    public void setPinstruction(String pinstruction) {
        this.pinstruction = pinstruction;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }


    public String getModuel() {
        return moduel;
    }

    public void setModuel(String moduel) {
        this.moduel = moduel;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getReward() {
        return reward;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }

    @Id
    @GeneratedValue
    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    @ManyToOne
    @JoinColumn(name="uid")
    public User getPublisher() {
        return publisher;
    }

    public void setPublisher(User publisher) {
        this.publisher = publisher;
    }
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="u_p",
            joinColumns= @JoinColumn(name="project_id"),
            inverseJoinColumns=@JoinColumn(name="user_id")
    )
    public Set<User> getWorkers() {
        return workers;
    }

    public void setWorkers(Set<User> workers) {
        this.workers = workers;
    }
}
