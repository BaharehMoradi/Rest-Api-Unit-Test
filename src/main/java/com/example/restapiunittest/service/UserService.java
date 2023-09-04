package com.example.restapiunittest.service;

import com.example.restapiunittest.entity.User;
import com.example.restapiunittest.exception.UserNotFoundException;
import com.example.restapiunittest.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    UserRepository repo;

    public User addUser(User user) {
        return repo.save(user);
    }

    public User updateUser(User user) throws UserNotFoundException {
        if (!repo.existsById(user.getId())) {
            throw new UserNotFoundException();
        }
        return repo.save(user);
    }

    public User getUser(Long id) throws UserNotFoundException {
        Optional<User> resultUser = repo.findById(id);
        if (resultUser.isPresent()) {
            return resultUser.get();
        }
        else {
            throw new UserNotFoundException();
        }
    }

    public List<User> listAllUsers(){
        return (List<User>) repo.findAll();
    }

    public void deleteUser(Long id) throws UserNotFoundException {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        }
        else {
            throw new UserNotFoundException();
        }
    }
}
