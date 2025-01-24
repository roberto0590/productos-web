package com.productos.productos.web.service;

import com.productos.productos.web.model.OfrendasGE;

import java.math.BigDecimal;

public interface IOfrendasGEService extends ICRUD<OfrendasGE, Integer> {
    public BigDecimal totalIngreso();
    public BigDecimal totalEgreso();
}
