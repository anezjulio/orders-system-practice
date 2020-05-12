package com.test.navent.service;

import com.test.navent.model.Pedido;

public interface IPedidosService {
    String crearPedido(Pedido pedido) throws Exception;
    String modificarPedido(Pedido pedido) throws Exception;
    Pedido buscarPedidoPorId(Integer id) throws Exception;
    String borrarPedido(Integer id) throws Exception;

}
