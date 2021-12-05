package com.loufresh.ubigeo.service;

import com.loufresh.ubigeo.model.entity.Ubigeo;

import java.util.List;

public interface UbigeoService {

    public List<String> listDepartamentos();
    public List<String> listProvincias(String departamento);
    public List<Ubigeo> listDistritos(String departamento, String provincia);

}
