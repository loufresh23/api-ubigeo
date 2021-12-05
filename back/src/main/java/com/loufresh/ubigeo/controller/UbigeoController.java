package com.loufresh.ubigeo.controller;

import com.loufresh.ubigeo.model.entity.Ubigeo;
import com.loufresh.ubigeo.service.UbigeoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UbigeoController {

    private final UbigeoService service;

    public UbigeoController(UbigeoService service) {
        this.service = service;
    }

    @GetMapping("/departamentos")
    public ResponseEntity<Response> listDepartamento() {
        List<String> departamentos = service.listDepartamentos();
        Response response = Response.builder().mensaje("OK")
                .date(new Date())
                .data(departamentos)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/provincias")
    public ResponseEntity<Response> listProvincias(@RequestParam String departamento) {
        List<String> provincias = service.listProvincias(departamento);
        Response response = Response.builder().mensaje("OK")
                .date(new Date())
                .data(provincias)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/distritos")
    public ResponseEntity<Response> listDistritos(@RequestParam String departamento,
                                        @RequestParam String provincia) {
        List<Ubigeo> distritos = service.listDistritos(departamento, provincia);
        Response response = Response.builder().mensaje("OK")
                .date(new Date())
                .data(distritos)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
