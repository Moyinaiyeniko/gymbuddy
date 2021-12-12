package management.gymbuddy.service;



import management.gymbuddy.entity.User;

import java.util.List;

public interface GenericService {
    User findByUsername(String email);

    List<User> findAllUsers();
}
