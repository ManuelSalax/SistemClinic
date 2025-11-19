package com.sistemclinc.sistemclinc.Application.UseCase.User;

import org.springframework.stereotype.Service;

import com.sistemclinc.sistemclinc.Domain.Repository.UserRepository;
import com.sistemclinc.sistemclinc.Domain.model.Security.User;

@Service
public class GetUserByUsernameUseCase {

    private final UserRepository repository;

    public GetUserByUsernameUseCase(UserRepository repository) {
        this.repository = repository;
    }

    public User execute(String username) {
        return repository.findByUsername(username);
    }
}