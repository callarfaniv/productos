/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mx.edu.uteq.productos.model.repository;

import mx.edu.uteq.productos.model.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author jvillafrancacarmo
 */
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    
}
