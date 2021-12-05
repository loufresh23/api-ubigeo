package com.loufresh.ubigeo.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "TBL_UBIGEO")
public class Ubigeo {

    @Id
    @Column(name = "NUBIGEO_COD")
    private Long id;

    @Column(name = "VUBIGEO_DEP")
    private String departamento;

    @Column(name = "VUBIGEO_PRO")
    private String provincia;

    @Column(name = "VUBIGEO_DIS")
    private String distrito;

    @Column(name = "CUBIGEO_UBI")
    private String ubigeo;

}
