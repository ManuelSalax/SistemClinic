package com.sistemclinc.sistemclinc.Application.UseCase.User;

import org.springframework.stereotype.Service;

import com.sistemclinc.sistemclinc.Domain.Repository.UserRepository;
@Service
public class DeleteUserUseCase {

    private final UserRepository repository;

    public DeleteUserUseCase(UserRepository repository) {
        this.repository = repository;
    }

    public void execute(Long id) {
        repository.deleteById(id);
    }
}