package com.example.gastos.gastos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class GastoDTO {
    private Long id;
    private String categoria;
    private String descripcion;
    private BigDecimal monto;
    private LocalDate fecha;
    private LocalTime hora;

    public GastoDTO() {
    }

    public GastoDTO(Long id, String categoria, String descripcion, BigDecimal monto, LocalDate fecha, LocalTime hora) {
        this.id = id;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.monto = monto;
        this.fecha = fecha;
        this.hora = hora;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

}
