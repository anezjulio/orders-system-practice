package com.test.navent.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

//@Entity
public class Pedido {


    // descomentar para poder usar con base de datos
    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idPedido;

    @NotNull
    @NotEmpty
    @Size(max = 100)
    private String nombre;

    @Min(1)
    private int monto;

    private int descuento;

    public Pedido() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return idPedido == pedido.idPedido &&
                monto == pedido.monto &&
                descuento == pedido.descuento &&
                Objects.equals(nombre, pedido.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPedido, nombre, monto, descuento);
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }
}

