package com.sistemclinc.sistemclinc.Application.UseCase.User;

import org.springframework.stereotype.Service;

import com.sistemclinc.sistemclinc.Domain.Repository.UserRepository;
import  com.sistemclinc.sistemclinc.Domain.model.Security.User;
@Service
public class CreateUserUseCase {

    private final UserRepository repository;

    public CreateUserUseCase(UserRepository repository) {
        this.repository = repository;
    }

    public User execute(User user) {
        return repository.save(user);
    }
}
