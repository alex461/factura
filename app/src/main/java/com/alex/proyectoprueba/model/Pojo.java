package com.alex.proyectoprueba.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Pojo implements Serializable {

    private String edicodigoProducto, ediCantidad, ediPrecio,ediDescripcion;

    public Pojo() {
    }

    public Pojo(String edicodigoProducto, String ediCantidad, String ediPrecio, String ediDescripcion) {
        this.edicodigoProducto = edicodigoProducto;
        this.ediCantidad = ediCantidad;
        this.ediPrecio = ediPrecio;
        this.ediDescripcion = ediDescripcion;
    }

    public String getEdicodigoProducto() {
        return edicodigoProducto;
    }

    public void setEdicodigoProducto(String edicodigoProducto) {
        this.edicodigoProducto = edicodigoProducto;
    }

    public String getEdiCantidad() {
        return ediCantidad;
    }

    public void setEdiCantidad(String ediCantidad) {
        this.ediCantidad = ediCantidad;
    }

    public String getEdiPrecio() {
        return ediPrecio;
    }

    public void setEdiPrecio(String ediPrecio) {
        this.ediPrecio = ediPrecio;
    }

    public String getEdiDescripcion() {
        return ediDescripcion;
    }

    public void setEdiDescripcion(String ediDescripcion) {
        this.ediDescripcion = ediDescripcion;
    }
}