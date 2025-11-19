package com.sistemclinc.sistemclinc.Application.UseCase.User;

import org.springframework.stereotype.Service;

import com.sistemclinc.sistemclinc.Domain.Repository.UserRepository;
import com.sistemclinc.sistemclinc.Domain.model.Security.User;
@Service
public class GetUserByIdUseCase {

    private final UserRepository repository;

    public GetUserByIdUseCase(UserRepository repository) {
        this.repository = repository;
    }

    public User execute(Long id) {
        return repository.findById(id);
    }
}
