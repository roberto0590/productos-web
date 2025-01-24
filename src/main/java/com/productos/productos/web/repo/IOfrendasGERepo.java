package com.productos.productos.web.repo;


import com.productos.productos.web.model.DetallePuntosGE;
import com.productos.productos.web.model.OfrendasGE;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface IOfrendasGERepo extends IGenericRepo<OfrendasGE, Integer>{

    @Query("SELECT sum(ofr.monto) FROM OfrendasGE ofr WHERE ofr.tipo in ('Ingreso')")
    public BigDecimal totalIngreso();
    @Query("SELECT sum(ofr.monto) FROM OfrendasGE ofr WHERE ofr.tipo in ('Egreso')")
    public BigDecimal totalEgreso();

}
