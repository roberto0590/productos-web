package com.productos.productos.web.repo;


import com.productos.productos.web.model.DetallePuntosGE;
import com.productos.productos.web.model.Usuario;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//@Repository
public interface IDetallePuntosGERepo extends IGenericRepo<DetallePuntosGE, Integer>{
    @Query("SELECT u FROM DetallePuntosGE u WHERE u.usuario.user_name = ?1")
    public List<DetallePuntosGE> findByUser_name(String user_name);
}
