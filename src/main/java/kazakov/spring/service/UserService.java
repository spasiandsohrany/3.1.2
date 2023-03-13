package kazakov.spring.service;

import kazakov.spring.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public void createUser(User user);

    public void updateUser(Long id , User user);

    public void deleteUser(Long id);

    public List<User> getAllUsers();

    public User getUserById(Long id) ;
}
