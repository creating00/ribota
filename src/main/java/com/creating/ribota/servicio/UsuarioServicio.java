package com.creating.ribota.servicio;

import com.creating.ribota.modelo.Usuario;
import com.creating.ribota.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicio {
    //@PersistenceContext
    //private EntityManager eM;
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    public List<Usuario> getUsers() {

        //return eM.createQuery("from Usuario").getResultList();//Se comunica con la clase Usuario
        return usuarioRepositorio.findAll();
    }

    public Optional<Usuario> getUser(Long id) {

        //return eM.createQuery("from Usuario").getResultList();//Se comunica con la clase Usuario
        return usuarioRepositorio.findById(id);
    }

    public void saveOrUpdate(Usuario usuario){
        usuarioRepositorio.save(usuario);
    }

    public void delete (Long id){
        usuarioRepositorio.deleteById(id);
    }

    /* @Override
    @Transactional
    public void save(Usuario usuario) {
        eM.persist(usuario);
    }*/
}
