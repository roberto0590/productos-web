package com.productos.productos.web.service.impl;


import com.productos.productos.web.model.DetalleCampaQR;
import com.productos.productos.web.model.DetallePuntosGE;
import com.productos.productos.web.repo.IDetalleCampaQRRepo;
import com.productos.productos.web.repo.IDetallePuntosGERepo;
import com.productos.productos.web.repo.IGenericRepo;
import com.productos.productos.web.service.IDetalleCampaQRService;
import com.productos.productos.web.service.IDetallePuntosGEService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleCampaQRServiceImpl extends CRUDImpl<DetalleCampaQR, Integer> implements IDetalleCampaQRService {

	@Autowired
	private IDetalleCampaQRRepo repo;
	
	@Override
	protected IGenericRepo<DetalleCampaQR, Integer> getRepo() {
		return repo;
	}


}
