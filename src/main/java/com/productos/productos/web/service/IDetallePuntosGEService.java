package com.productos.productos.web.service;

import com.productos.productos.web.model.DetallePuntosGE;
import com.productos.productos.web.model.Usuario;

import java.util.List;

public interface IDetallePuntosGEService extends ICRUD<DetallePuntosGE, Integer> {
    public List<DetallePuntosGE> findByUser_name(String user_name) throws Exception;
    public int findByUser_nameBySuma(String user_name) throws Exception;
}
