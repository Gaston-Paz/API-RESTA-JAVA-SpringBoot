package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.models.UsuarioModel;
import com.example.demo.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService _usuarioService;

    @GetMapping
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return _usuarioService.obtenerUsuarios();
    }

    //Enviando el Id sirve como PUT sino es POST
    @PostMapping
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario){
        return _usuarioService.guardarUsuario(usuario);
    }

    @GetMapping(path = "/{id}")
    public Optional<UsuarioModel> obtenerPorId(@PathVariable("id") Long id){
        return _usuarioService.obtenerPorId(id);
    }

    @GetMapping("/query")
    public ArrayList<UsuarioModel> obtenerPorNombre(@RequestParam("Nombre") String Nombre){
        return _usuarioService.obtenerPorNombre(Nombre);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarUsuario(@PathVariable("id") Long id){
        boolean ok = _usuarioService.eliminarUsuario(id);
        if(ok) return "Se eliminó el usuario con Id: " + id;
        else return "No se pudo eliminar el usuario con Id: " + id;
    }
}
