package com.productos.productos.web.service;

import com.productos.productos.web.model.Usuario;

public interface IUsuarioService extends ICRUD<Usuario, Integer> {
    public Usuario findByUser_name(String user_name) throws Exception;
}
