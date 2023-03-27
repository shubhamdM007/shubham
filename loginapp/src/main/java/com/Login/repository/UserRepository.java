package com.Login.repository;


import com.Login.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {




    Optional<User> findByUserName(String username);


    Boolean existsByUserName(String username);



}
