package com.loufresh.ubigeo.controller;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class Response {
    private String mensaje;
    private Date date;
    private Object data;
}
