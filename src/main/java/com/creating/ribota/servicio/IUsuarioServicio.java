package com.creating.ribota.servicio;

import com.creating.ribota.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUsuarioServicio extends JpaRepository<Usuario, Long> {
    //public List<Usuario> findAll();
    //public void save(Usuario usuario);
}
