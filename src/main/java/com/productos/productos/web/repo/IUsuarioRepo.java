package com.productos.productos.web.repo;


import com.productos.productos.web.model.Usuario;
import org.springframework.data.jpa.repository.Query;

//@Repository
public interface IUsuarioRepo extends IGenericRepo<Usuario, Integer>{
    @Query("SELECT u FROM Usuario u WHERE u.user_name = ?1")
    public Usuario findByUser_name(String user_name);
}
