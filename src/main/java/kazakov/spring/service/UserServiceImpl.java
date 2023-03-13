package kazakov.spring.service;

import jakarta.persistence.TypedQuery;
import kazakov.spring.repository.UserRepository;
import kazakov.spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public void createUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(Long id , User user) {
        user.setId(id);
        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        Optional<User> foundUser = userRepository.findById(id);
        return foundUser.orElse(null);
    }
}
