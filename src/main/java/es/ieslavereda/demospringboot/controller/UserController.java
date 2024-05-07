package es.ieslavereda.demospringboot.controller;

import es.ieslavereda.demospringboot.model.User;
import es.ieslavereda.demospringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


@RestController
public class UserController extends BaseController {

    private final Logger LOG = Logger.getLogger(getClass().getCanonicalName());

    @Autowired
    private  UserService userService;

    @GetMapping("users")
    public ResponseEntity<?> getUsers() {
        LOG.log(Level.INFO, "Obteniendo todos los usuarios");
        try {
            List<User> users = userService.getAllUSers();
            return new ResponseEntity<>(users, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Error al obtener los usuarios", HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUser(@PathVariable Integer id) {
        try {
            User user=userService.getUserByID(id);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }catch (Exception e) {
            return getResposeError(e);
        }
    }

    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        try {
            User createdUser = userService.createUser(user);
            return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
        }catch (Exception e) {
            return getResposeError(e);
        }
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUser(@RequestBody Integer id) {
        LOG.log(Level.INFO, "Eliminando el usuario" + id);
        try {
             User user= userService.deleteUser(id);
             return new ResponseEntity<>(user, HttpStatus.OK);
        }catch (Exception e) {
            return getResposeError(e);
        }
    }

    @PutMapping("/user")
    public User updateUser(@RequestBody User user) {
        return userService.updateUSer(user);
    }
}
