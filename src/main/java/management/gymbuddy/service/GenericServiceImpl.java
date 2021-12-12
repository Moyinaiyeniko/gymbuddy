package management.gymbuddy.service;


import management.gymbuddy.entity.User;
import management.gymbuddy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GenericServiceImpl implements GenericService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByUsername(String email) {
        return userRepository.findUserByEmail(email);
    }


    @Override
    public List<User> findAllUsers() {
        return (List<User>)userRepository.findAll();
    }

}
