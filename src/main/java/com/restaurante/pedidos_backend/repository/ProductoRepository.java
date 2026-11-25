package com.restaurante.pedidos_backend.repository;
import com.restaurante.pedidos_backend.model.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto> findByDisponibleTrue();
}
