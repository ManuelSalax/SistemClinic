package com.sistemclinc.sistemclinc.Domain.model.Seguridad;

public class Usuario {

    private Long id;
    private String username;
    private String password;
    private String rol;

    public Usuario(Long id, String username, String password, String rol) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.rol = rol;
    }

    public boolean esAdministrador() {
        return "ADMIN".equalsIgnoreCase(this.rol);
    }
}
