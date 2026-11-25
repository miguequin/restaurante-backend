package com.restaurante.pedidos_backend.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.restaurante.pedidos_backend.model.Producto;
import java.util.Optional;
import com.restaurante.pedidos_backend.dto.ProductRequestDTO;
import com.restaurante.pedidos_backend.repository.ProductoRepository;
import java.math.BigDecimal;
@Service
public class ProductoService {

private final ProductoRepository productRepository;

public ProductoService(ProductoRepository productRepository) {
    this.productRepository = productRepository;
}

public Producto crearProducto(ProductRequestDTO productRequestDTO) {
    if(productRequestDTO.getDisponible() == null) {
            productRequestDTO.setDisponible(true);
        }
        
    Producto producto = new Producto();
        producto.setNombre(productRequestDTO.getNombre());
        producto.setDescripcion(productRequestDTO.getDescripcion());
        producto.setPrecio(productRequestDTO.getPrecio());
        producto.setDisponible(productRequestDTO.getDisponible());
        return productRepository.save(producto);
    }
    public List<Producto> obtenerProductosDisponibles() {
        return productRepository.findByDisponibleTrue();
    }
    public Optional<Producto> obtenerProductoPorId(Long id) {
        return productRepository.findById(id);
    }
    public Producto actualizarProducto(Long id, ProductRequestDTO productRequestDTO) {
        Optional<Producto> optionalProducto = productRepository.findById(id);
        if (optionalProducto.isPresent()) {
            Producto productoExistente = optionalProducto.get();
            productoExistente.setNombre(productRequestDTO.getNombre());
            productoExistente.setDescripcion(productRequestDTO.getDescripcion());
            productoExistente.setPrecio(productRequestDTO.getPrecio());
            productoExistente.setDisponible(productRequestDTO.getDisponible());
            return productRepository.save(productoExistente);
        } else {
            throw new IllegalArgumentException("El producto con ID " + id + " no existe.");
        }
    }
    public void eliminarProducto(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("El producto con ID " + id + " no existe.");
        }
    }
}