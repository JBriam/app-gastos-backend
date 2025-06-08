package com.example.gastos.gastos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "GASTOS")
public class Gasto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GASTOS_id_gen")
    @SequenceGenerator(name = "GASTOS_id_gen", sequenceName = "gastos_seq", allocationSize = 1)
    @Column(name = "ID_GASTO", nullable = false)
    private Long id;

    @Column(name = "CATEGORIA", nullable = false)
    private String categoria;

    @Lob
    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "MONTO", nullable = false)
    private BigDecimal monto;

    @Column(name = "FECHA")
    private LocalDate fecha;

    @Column(name = "HORA")
    private LocalTime hora;

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
