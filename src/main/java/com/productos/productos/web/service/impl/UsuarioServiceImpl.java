package com.productos.productos.web.service.impl;


import com.productos.productos.web.model.Usuario;
import com.productos.productos.web.repo.IGenericRepo;
import com.productos.productos.web.repo.IUsuarioRepo;
import com.productos.productos.web.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl extends CRUDImpl<Usuario, Integer> implements IUsuarioService {

	@Autowired
	private IUsuarioRepo repo;
	
	@Override
	protected IGenericRepo<Usuario, Integer> getRepo() {
		return repo;
	}

	public Usuario findByUser_name(String user_name) throws Exception {
		Usuario usuario = repo.findByUser_name(user_name);
		return usuario;
	}

}
