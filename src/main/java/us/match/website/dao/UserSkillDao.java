package us.match.website.dao;

import us.match.website.model.UserSkill;

import java.util.List;

/**
 * Created by apple on 2015/7/14.
 */
public interface UserSkillDao {
    public boolean AddSkill(UserSkill userskill);
    public List<String> getSkills(String userid);
}
