package com.example.jwtdemo.repositories;

import com.example.jwtdemo.entities.User;
import org.springframework.data.repository.CrudRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Integer> {
    Optional<User> findByEmail(String email);
}
