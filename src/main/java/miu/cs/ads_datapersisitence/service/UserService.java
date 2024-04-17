package miu.cs.ads_datapersisitence.service;

import miu.cs.ads_datapersisitence.model.User;

public interface UserService {

    User getUserByUsername(String username);

    User registerNewUser(User user);
}
