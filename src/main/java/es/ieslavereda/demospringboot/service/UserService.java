package es.ieslavereda.demospringboot.service;

import es.ieslavereda.demospringboot.model.User;
import es.ieslavereda.demospringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUSers() {
        return userRepository.getAll();
    }

    public User getUserByID(Integer id) {
        return userRepository.findUserById(id);
    }

    public User createUser(User user) {
        return userRepository.insertUser(user);
    }

    public User deleteUser(Integer id) {
        return userRepository.deleteUser(id);
    }

    public User updateUSer(User user) {
        return userRepository.updateUser(user);
    }
}
