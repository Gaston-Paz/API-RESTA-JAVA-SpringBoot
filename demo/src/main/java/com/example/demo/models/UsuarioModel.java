package com.example.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "Usuarios")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long Id;
    @Column(nullable = false,length = 30)
    private String Nombre;
    @Column(nullable = false,length = 30)
    private String Apellido;
    @Column(nullable = false,length = 15)
    private String Dni;
    @Column(nullable = false,length = 150)
    private String Email;

    public String getApellido() {
        return Apellido;
    }

    public String getDni() {
        return Dni;
    }

    public String getEmail() {
        return Email;
    }

    public Long getId() {
        return Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public void setDni(String dni) {
        Dni = dni;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setId(Long id) {
        Id = id;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

}
