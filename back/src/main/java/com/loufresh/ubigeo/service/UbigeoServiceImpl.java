package com.loufresh.ubigeo.service;

import com.loufresh.ubigeo.model.entity.Ubigeo;
import com.loufresh.ubigeo.model.repository.UbigeoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UbigeoServiceImpl implements UbigeoService{

    private final UbigeoRepository repository;

    public UbigeoServiceImpl(UbigeoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<String> listDepartamentos() {
        return repository.listDepartamentos();
    }

    @Override
    public List<String> listProvincias(String departamento) {
        return repository.listProvincias(departamento);
    }

    @Override
    public List<Ubigeo> listDistritos(String departamento, String provincia) {
        return repository.listDistritos(departamento, provincia);
    }
}
