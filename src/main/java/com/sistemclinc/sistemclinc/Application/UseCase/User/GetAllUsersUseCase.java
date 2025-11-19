package com.sistemclinc.sistemclinc.Application.UseCase.User;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sistemclinc.sistemclinc.Domain.Repository.UserRepository;
import com.sistemclinc.sistemclinc.Domain.model.Security.User;
@Service
public class GetAllUsersUseCase {

    private final UserRepository repository;

    public GetAllUsersUseCase(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> execute() {
        return repository.findAll();
    }
}
