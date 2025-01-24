package com.productos.productos.web.service.impl;


import com.productos.productos.web.model.OfrendasGE;
import com.productos.productos.web.repo.IGenericRepo;
import com.productos.productos.web.repo.IOfrendasGERepo;
import com.productos.productos.web.service.IOfrendasGEService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OfrendasGEServiceImpl extends CRUDImpl<OfrendasGE, Integer> implements IOfrendasGEService {

	@Autowired
	private IOfrendasGERepo repo;
	
	@Override
	protected IGenericRepo<OfrendasGE, Integer> getRepo() {
		return repo;
	}

	public BigDecimal totalIngreso(){
		try {
			return repo.totalIngreso();
		}catch (Exception e){
			return new BigDecimal("0");
		}
	}

	public BigDecimal totalEgreso(){
		try {
			return repo.totalEgreso();
		}catch (Exception e){
			return new BigDecimal("0");
		}
	}

}
