package com.productos.productos.web.service.impl;


import com.productos.productos.web.model.Usuario;
import com.productos.productos.web.repo.IGenericRepo;
import com.productos.productos.web.repo.IUsuarioRepo;
import com.productos.productos.web.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl extends CRUDImpl<Usuario, Integer> implements IUsuarioService {

	@Autowired
	private IUsuarioRepo repo;
	
	@Override
	protected IGenericRepo<Usuario, Integer> getRepo() {
		return repo;
	}
	
	

}
