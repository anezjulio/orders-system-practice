package com.test.navent.service;

import com.test.navent.dao.PedidosDAO;
import com.test.navent.model.Pedido;
import org.springframework.stereotype.Service;

@Service
public class PedidosService implements IPedidosService{

    @Override
    public String crearPedido(Pedido pedido) throws Exception {
        try {
            // Insertar en base de datos
            PedidosDAO.insertOrUpdate(pedido);
            // Añadir al cache
            BumexMemcached.getInstance().set(pedido.getIdPedido().toString(), pedido);
        }catch (Exception e){
            throw new Exception("Error al crear el pedido",e);
        }
        return "Pedido creado exitosamente";
    }

    @Override
    public String modificarPedido(Pedido pedido) throws Exception {
        try {
            // Si  existe el pedido en el cache
            if(BumexMemcached.getInstance().get(pedido.getIdPedido().toString()) != null){
                // Modificar pedido en base de datos
                PedidosDAO.insertOrUpdate(pedido);
                // Cargar pedido en cache
                BumexMemcached.getInstance().set(pedido.getIdPedido().toString(), pedido);
            }else{
                return "El pedido no existe";
            }
        }catch (Exception e){
            throw new Exception("Error al modificar el pedido",e);
        }
        return "Pedido actualizado exitosamente";
    }

    @Override
    public Pedido buscarPedidoPorId(Integer id) throws Exception  {
        Pedido pedidoConseguido;

        try {
            // Buscar en cache
            pedidoConseguido = (Pedido)BumexMemcached.getInstance().get(id.toString());
            // Si no existe en cache,
            if(pedidoConseguido == null){
                // Buscar en base de datos
                pedidoConseguido = PedidosDAO.select(id);
            }
        }catch (Exception e){
            throw new Exception("Error al buscar pedido por ID: " + id ,e);
        }

        if(pedidoConseguido != null){
            return pedidoConseguido;
        }else{
            throw new Exception("No existe el pedido ID: " + id);
        }
    }

    @Override
    public String borrarPedido(Integer id) throws Exception  {
        try {
            Pedido pedido = (Pedido) BumexMemcached.getInstance().get(id.toString());
            if(pedido != null) {
                // Borrar pedido en base de datos
                PedidosDAO.delete(pedido);
                // Borrar pedido en cache
                BumexMemcached.getInstance().delete(id.toString());
            }else{
                return "El pedido no existe";
            }
        } catch (Exception e){
            throw new Exception("Error al intentar borrar el pedido",e);
        }
        return "Pedido borrado exitosamente";
    }
}

