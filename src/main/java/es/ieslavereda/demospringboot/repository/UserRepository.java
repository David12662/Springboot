package es.ieslavereda.demospringboot.repository;

import es.ieslavereda.demospringboot.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class UserRepository {

    private List<User> users;

    public UserRepository() {
        users = new ArrayList<>();
        users.add(new User(1,"Juan","Garcia"));
        users.add(new User(2,"Alvaro","Garcia"));
        users.add(new User(3,"Carlos","Garcia"));
    }


    public List<User> getAll() {
        return users;
    }

    public User findUserById(Integer id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public User insertUser(User user) {
        users.add(user);
        return user;
    }

    public User deleteUser(Integer id) {
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getId() == id) {
                iterator.remove();
                return user;
            }
        }
        return null;
    }

    public User updateUser(User user) {
        User oldUser = findUserById(user.getId());
        if (oldUser == null) {
            return null;
        }

        oldUser.setId(user.getId());
        oldUser.setName(user.getName());
        oldUser.setSurname(user.getSurname());
        return oldUser;

    }
}
