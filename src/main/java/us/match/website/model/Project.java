package us.match.website.model;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by apple on 2015/7/9.
 */
@Entity
public class Project {
    private String id="";
    private String pinstruction="";
    private String pname="";
    private String publisherid="";
    private byte[] picture;
    private boolean state;
    @Id
    @GeneratedValue
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getPublisherid() {
        return publisherid;
    }

    public void setPublisherid(String publisherid) {
        this.publisherid = publisherid;
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
}
