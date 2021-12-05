package com.loufresh.ubigeo.model.repository;

import com.loufresh.ubigeo.model.entity.Ubigeo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UbigeoRepository extends JpaRepository<Ubigeo, Long> {

    @Query("select distinct u.departamento from Ubigeo u")
    public abstract List<String> listDepartamentos();

    @Query("select distinct u.provincia from Ubigeo u where u.departamento = :var_dep")
    public abstract List<String> listProvincias(@Param("var_dep") String departamento);

    @Query("select u from Ubigeo u where u.departamento = :var_dep and u.provincia = :var_pro")
    public abstract List<Ubigeo> listDistritos(@Param("var_dep") String departamento,
                                               @Param("var_pro") String provincia);
}
