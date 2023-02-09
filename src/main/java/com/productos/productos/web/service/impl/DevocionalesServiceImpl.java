package com.productos.productos.web.service.impl;


import com.productos.productos.web.model.Devocionales;
import com.productos.productos.web.model.Usuario;
import com.productos.productos.web.repo.IDevocionalesRepo;
import com.productos.productos.web.repo.IGenericRepo;
import com.productos.productos.web.repo.IUsuarioRepo;
import com.productos.productos.web.service.IDevocionalesService;
import com.productos.productos.web.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DevocionalesServiceImpl extends CRUDImpl<Devocionales, Integer> implements IDevocionalesService {

	@Autowired
	private IDevocionalesRepo repo;
	
	@Override
	protected IGenericRepo<Devocionales, Integer> getRepo() {
		return repo;
	}
	
	

}
