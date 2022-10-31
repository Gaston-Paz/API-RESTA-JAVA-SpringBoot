package com.example.demo.services;

import java.io.Console;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.UsuarioModel;
import com.example.demo.repositories.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository _usuarioRepository;

    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return (ArrayList<UsuarioModel>)_usuarioRepository.findAll();
    }

    public UsuarioModel guardarUsuario(UsuarioModel usuario){
        return _usuarioRepository.save(usuario);
    }

    public Optional<UsuarioModel> obtenerPorId(Long id){
        return _usuarioRepository.findById(id);
    } 

    public ArrayList<UsuarioModel> obtenerPorNombre(String nombre){
        System.out.println("Service");
        System.out.println(nombre);
        ArrayList<UsuarioModel> lista = (ArrayList<UsuarioModel>)_usuarioRepository.findAll();
        ArrayList<UsuarioModel> listaPorNombre = new ArrayList<UsuarioModel>();  
        System.out.println("Listado con usuario: " + listaPorNombre.size());
        for (UsuarioModel usuario : lista) {
            System.out.println("Itera");
            System.out.println(usuario.getNombre());
            if(usuario.getNombre().toUpperCase().trim().equals(nombre.toUpperCase().trim())){
                listaPorNombre.add(usuario);
                System.out.println("Agrega");
            }
        }
        System.out.println("Listado con usuario: " + listaPorNombre.size());
        return listaPorNombre;
    }

    public boolean eliminarUsuario(Long id){
        try {
            _usuarioRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
