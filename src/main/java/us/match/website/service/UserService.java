package us.match.website.service;

import us.match.website.model.User;

/**
 * Created by WH on 2015/7/10.
 */
public interface UserService {
    public User login(String username,String password);
    public User logout(String username);
}
