package com.sistemclinc.sistemclinc.Infrastructure.Persistence.Mappers;

import com.sistemclinc.sistemclinc.Domain.model.Security.User;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Entity.UserEntity;

public class UserMapper {
    public static UserEntity toPersistence(User user) {
        if (user == null) return null;
        UserEntity entity = new UserEntity();
        entity.setUsername(user.getUsername());
        entity.setPassword(user.getPassword());
        entity.setRole(user.getRole());
        return entity;
    }

    public static User toDomain(UserEntity entity) {
        if (entity == null) return null;
        return new User(
            entity.getId(),
            entity.getUsername(),
            entity.getPassword(),
            entity.getRole()
        );
    }
}
