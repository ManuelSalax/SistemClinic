package com.sistemclinc.sistemclinc.Infrastructure.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemclinc.sistemclinc.Application.UseCase.User.CreateUserUseCase;
import com.sistemclinc.sistemclinc.Application.UseCase.User.DeleteUserUseCase;
import com.sistemclinc.sistemclinc.Application.UseCase.User.GetAllUsersUseCase;
import com.sistemclinc.sistemclinc.Application.UseCase.User.GetUserByIdUseCase;
import com.sistemclinc.sistemclinc.Application.UseCase.User.GetUserByUsernameUseCase;
import com.sistemclinc.sistemclinc.Domain.model.Security.User;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final CreateUserUseCase createUser;
    private final GetUserByIdUseCase getUserById;
    private final GetUserByUsernameUseCase getUserByUsername;
    private final GetAllUsersUseCase getAllUsers;
    private final DeleteUserUseCase deleteUser;

    public UserController(
            CreateUserUseCase createUser,
            GetUserByIdUseCase getUserById,
            GetUserByUsernameUseCase getUserByUsername,
            GetAllUsersUseCase getAllUsers,
            DeleteUserUseCase deleteUser
    ) {
        this.createUser = createUser;
        this.getUserById = getUserById;
        this.getUserByUsername = getUserByUsername;
        this.getAllUsers = getAllUsers;
        this.deleteUser = deleteUser;
    }

    @PostMapping
    public User register(@RequestBody User user) {
        return createUser.execute(user);
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        return getUserById.execute(id);
    }

    @GetMapping("/username/{username}")
    public User findByUsername(@PathVariable String username) {
        return getUserByUsername.execute(username);
    }

    @GetMapping
    public List<User> findAll() {
        return getAllUsers.execute();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        deleteUser.execute(id);
    }
}
