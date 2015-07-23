package us.match.website.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by apple on 2015/7/23.
 */
@Entity
public class Information {
    private int infoid;
    private String context;
    private List<InfoRelation> users;

    @Id
    @GeneratedValue
    public int getInfoid() {
        return infoid;
    }

    public void setInfoid(int infoid) {
        this.infoid = infoid;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    @OneToMany(mappedBy = "info",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    public List<InfoRelation> getUsers() {
        return users;
    }

    public void setUsers(List<InfoRelation> users) {
        this.users = users;
    }
}
