package com.restaurante.pedidos_backend.model;

import jakarta.persistence.*;
@Entity
@Table(name = "mesa")
public class Mesa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private Integer numeroMesa;

    @Column(nullable = false, unique = true)
    private String codigoQR;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoMesa estado=EstadoMesa.LIBRE;

    public Mesa(){}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Integer getNumeroMesa() { return numeroMesa; }
    public void setNumeroMesa(Integer numeroMesa) { this.numeroMesa = numeroMesa; }

    public String getCodigoQr() { return codigoQR; }
    public void setCodigoQr(String codigoQr) { this.codigoQR = codigoQr; }

    public EstadoMesa getEstado() { return estado; }
    public void setEstado(EstadoMesa estado) { this.estado = estado; }
}
