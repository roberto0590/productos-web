package com.productos.productos.web.service.impl;


import com.productos.productos.web.model.DetallePuntosGE;
import com.productos.productos.web.model.Usuario;
import com.productos.productos.web.repo.IDetallePuntosGERepo;
import com.productos.productos.web.repo.IGenericRepo;
import com.productos.productos.web.repo.IUsuarioRepo;
import com.productos.productos.web.service.IDetallePuntosGEService;
import com.productos.productos.web.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetallePuntosGEServiceImpl extends CRUDImpl<DetallePuntosGE, Integer> implements IDetallePuntosGEService {

	@Autowired
	private IDetallePuntosGERepo repo;
	
	@Override
	protected IGenericRepo<DetallePuntosGE, Integer> getRepo() {
		return repo;
	}

	public List<DetallePuntosGE> findByUser_name(String user_name) throws Exception {
		List<DetallePuntosGE> detallePuntosGE = repo.findByUser_name(user_name);
		return detallePuntosGE;
	}

}
