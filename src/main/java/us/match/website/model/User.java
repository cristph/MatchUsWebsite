package us.match.website.model;

import jdk.nashorn.internal.ir.annotations.Ignore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by apple on 2015/7/8.
 */
@Entity
public class User {
        private String username="";
        private String password="";
        private String nickname="";
        private String instruction="";
        private String realname="";
        private String sex="";
        private String birthday="";
        private byte[] face;
        private String email="";
        private String mobilephone="";
        private String telephone="";
        private String qq="";
        private String address="";
        private String university="";
        private String major="";
        private String proinstruction="";
        private String goodat="";
        private String friends="";
        private HashMap<String,Integer> friendsmap=new HashMap<String, Integer>();
    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }


    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @Id
    public String getUsername() {
        return username;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }



    public String getGoodat() {
        return goodat;
    }

    public void setGoodat(String goodat) {
        this.goodat = goodat;
    }

    public byte[] getFace() {
        return face;
    }

    public void setFace(byte[] face) {
        this.face = face;
    }

    public String getProinstruction() {
        return proinstruction;
    }

    public void setProinstruction(String proinstruction) {
        this.proinstruction = proinstruction;
    }


    public String getFriends() {
        return friends;
    }

    public void setFriends(String friends) {
        this.friends = friends;
    }

    public void generatemap(String uname,Integer Intimacy){
        this.friendsmap.put(uname,Intimacy);
    }

    public void MaptoString(){
        friends = "{";
        for (Iterator it = friendsmap.entrySet().iterator(); it.hasNext();) {
            Map.Entry e = (Map.Entry) it.next();
            friends += "'" + e.getKey() + "':";
            friends += "'" + e.getValue() + "',";
        }
        friends = friends.substring(0, friends.lastIndexOf(","));
        friends += "}";
    }
}
