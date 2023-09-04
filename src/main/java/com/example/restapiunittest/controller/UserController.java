package com.example.restapiunittest.controller;

import com.example.restapiunittest.dto.UserDTO;
import com.example.restapiunittest.entity.User;
import com.example.restapiunittest.exception.UserNotFoundException;
import com.example.restapiunittest.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<?> add(@RequestBody @Valid User user) {
        User persistedUser = userService.addUser(user);
        UserDTO userDto = entity2Dto(persistedUser);
        URI uri = URI.create("/api/users/" + userDto.getId());
        return ResponseEntity.created(uri).body(userDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Long id) {
        try {
            User fetchedUser = userService.getUser(id);
            return ResponseEntity.ok(entity2Dto(fetchedUser));
        } catch (UserNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<?> list() {
        List<User> listUsers = userService.listAllUsers();
        if (listUsers.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(list2Dto(listUsers));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody @Valid User user) {
        try {
            user.setId(id);
            User updatedUser = userService.updateUser(user);
            return ResponseEntity.ok(entity2Dto(updatedUser));
        } catch (UserNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        try {
            userService.deleteUser(id);
            return ResponseEntity.noContent().build();
        } catch (UserNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    private UserDTO entity2Dto(User userEntity) {

        return modelMapper.map(userEntity, UserDTO.class);
    }

    private List<UserDTO> list2Dto(List<User> listUsers) {
        return listUsers.stream().map(entity -> entity2Dto(entity))
                .collect(Collectors.toList());
    }

}
