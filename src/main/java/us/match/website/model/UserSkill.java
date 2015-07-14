package us.match.website.model;


import org.hibernate.annotations.Table;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by apple on 2015/7/14.
 */
@Entity
public class UserSkill {
        private String skillname;
        private int level;
        private User user;
        @Id
        public String getSkillname() {
                return skillname;
        }

        public void setSkillname(String skillname) {
                this.skillname = skillname;
        }

        public int getLevel() {
                return level;
        }

        public void setLevel(int level) {
                this.level = level;
        }
        @ManyToOne
        @JoinColumn(name="uid")
        public User getUser() {
                return user;
        }

        public void setUser(User user) {
                this.user = user;
        }
}
