package com.sistemclinc.sistemclinc.Domain.Repository;

import java.util.List;

import com.sistemclinc.sistemclinc.Domain.model.Security.User;

public interface UserRepository {

    User save(User user);
    User findById(Long id);
    User findByUsername(String username);
    List<User> findAll();
    void deleteById(Long id);
}
