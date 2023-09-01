package org.cavila.apiservlet.webapp.headers.services;

import org.cavila.apiservlet.webapp.headers.models.Producto;

import java.util.List;

public interface ProductoService {
    List<Producto> listar();
}
