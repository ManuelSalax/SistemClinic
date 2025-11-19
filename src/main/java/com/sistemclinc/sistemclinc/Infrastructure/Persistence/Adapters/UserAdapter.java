package com.sistemclinc.sistemclinc.Infrastructure.Persistence.Adapters;

import com.sistemclinc.sistemclinc.Domain.Repository.UserRepository;
import com.sistemclinc.sistemclinc.Domain.model.Security.User;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Entity.UserEntity;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Mappers.UserMapper;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Repository.UserRepositoryJpa;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserAdapter implements UserRepository {

    private final UserRepositoryJpa jpa;

    public UserAdapter(UserRepositoryJpa jpa) {
        this.jpa = jpa;
    }

    @Override
    public User save(User user) {
        UserEntity entity = UserMapper.toPersistence(user);
        UserEntity saved = jpa.save(entity);
        return UserMapper.toDomain(saved);
    }

    @Override
    public User findById(Long id) {
        return jpa.findById(id)
                .map(UserMapper::toDomain)
                .orElse(null);
    }

    @Override
    public User findByUsername(String username) {
        return jpa.findByUsername(username)
                .map(UserMapper::toDomain)
                .orElse(null);
    }

    @Override
    public List<User> findAll() {
        return jpa.findAll().stream()
                .map(UserMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        jpa.deleteById(id);
    }
}
