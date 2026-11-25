package com.restaurante.pedidos_backend.dto;
import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
public class ProductRequestDTO {
@NotBlank (message = "El nombre del producto es obligatorio")
private String nombre;
private String descripcion;
@NotNull (message = "El precio del producto es obligatorio")
@Positive (message = "El precio del producto debe ser un valor positivo")
private BigDecimal precio;
private Boolean disponible;

public String getNombre() {
    return nombre;
}
public void setNombre(String nombre) {
    this.nombre = nombre;
}
public String getDescripcion() {
    return descripcion;
}
public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
}
public BigDecimal getPrecio() {
    return precio;
}
public void setPrecio(BigDecimal precio) {
    this.precio = precio;
}
public Boolean getDisponible() {
    return disponible;
}
public void setDisponible(Boolean disponible) {
    this.disponible = disponible;
}

}
