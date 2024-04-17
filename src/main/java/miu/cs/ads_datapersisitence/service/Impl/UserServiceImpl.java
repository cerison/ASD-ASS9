package miu.cs.ads_datapersisitence.service.Impl;

import miu.cs.ads_datapersisitence.model.User;
import miu.cs.ads_datapersisitence.repository.UserRepository;
import miu.cs.ads_datapersisitence.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findUserByUsername(username)
                .orElse(null);
    }

    @Override
    public User registerNewUser(User user) {
        return null;
    }
}
