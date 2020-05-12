package com.test.navent.controller;

import com.test.navent.model.Pedido;
import com.test.navent.service.PedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/pedidos")
public class PedidosController {

    private PedidosService pedidosService;

    @Autowired
    public void setPedidosService(PedidosService pedidosService) {
        this.pedidosService = pedidosService;
    }

    @PostMapping(path = "/guardar")
    public ResponseEntity<String> guardarPedido(@Validated @RequestBody Pedido pedido) {
        try {
            return ResponseEntity.ok(pedidosService.crearPedido(pedido));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Object> buscarPedido(@PathParam("id") final Integer idPedido) {
        try {
            return ResponseEntity.ok(pedidosService.buscarPedidoPorId(idPedido));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/modificiar")
    public ResponseEntity<String> modificarPedido(@Valid @RequestBody Pedido pedido) {
        try {
            return ResponseEntity.ok(pedidosService.modificarPedido(pedido));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/borrar/{id}")
    public ResponseEntity<String> borrarPedido(@PathParam("id") final Integer idPedido) {
        try {
            return ResponseEntity.ok(pedidosService.borrarPedido(idPedido));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
