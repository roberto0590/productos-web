package com.productos.productos.web.repo;


import com.productos.productos.web.model.Devocionales;
import com.productos.productos.web.model.Usuario;
import org.springframework.data.jpa.repository.Query;

//@Repository
public interface IDevocionalesRepo extends IGenericRepo<Devocionales, Integer>{
    @Query("SELECT u FROM Devocionales u WHERE u.nombre = ?1")
    public Usuario findByDevocionales_nombre(String user_name);
}
