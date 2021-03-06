package us.match.website.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.annotation.Generated;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

/**
 * Created by apple on 2015/7/9.
 */
@Entity
@JsonIgnoreProperties(value = { "workers","publisher"})
public class Project {
    public static String[] states={"past","now","will"};
    private int pid;
    private String pinstruction;
    private String pname;
    private String picture;
    private String state;
    private String subject;
    private String moduel;
    private String skill;
    private String reward;
    private User publisher;
    private Timestamp updatetime;
    private Timestamp starttime;
    private String location;
    private String email;
    private String phonenumber;
    private String qq;
    private String telephone;
    private String fax;
    public String userName;/*Add by wh*/
    /*
            Lists
     */
    private List<User> workers;
    private List<Post> posts;

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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String isState() {
        return state;
    }

    public void setState(String state) {
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
    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="uid")
    public User getPublisher() {
        return publisher;
    }

    public void setPublisher(User publisher) {
        this.publisher = publisher;
    }
    @ManyToMany(mappedBy = "workingprojects",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    public List<User> getWorkers() {
        return workers;
    }

    public void setWorkers(List<User> workers) {
        this.workers = workers;
    }

    @PrePersist
    @PreUpdate
    public Timestamp getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Timestamp updatetime) {
        this.updatetime = updatetime;
    }

    @PrePersist
    public Timestamp getStarttime() {
        return starttime;
    }

    public void setStarttime(Timestamp starttime) {
        this.starttime = starttime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    @OneToMany(mappedBy = "post_match",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
