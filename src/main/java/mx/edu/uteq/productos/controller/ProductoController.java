/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.uteq.productos.controller;

import java.util.List;
import mx.edu.uteq.productos.model.entity.Producto;
import mx.edu.uteq.productos.model.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author jvillafrancacarmo
 */
@Controller
public class ProductoController {

    @Autowired
    private ProductoRepository repo;

    @RequestMapping("/")
    public String page(Model model) {
        List<Producto> productos = repo.findAll();

        model.addAttribute("productos", productos);
        return "index";
    }

    @GetMapping("/agregar-producto")
    public String agregar(Model model, Producto p) {
        model.addAttribute("operacion", "agregar");
        model.addAttribute("p", p);
        return "views/newProduct";
    }

    @GetMapping("/editar-producto/{id}")
    public String editar(Model model, Producto p) {
        p = repo.findById(p.getId()).orElse(null);
        model.addAttribute("operacion", "editar");
        model.addAttribute("p", p);
        return "views/editProduct";
    }

    @PostMapping("/guardar-producto")
    public String guardar(Producto p) {
        repo.save(p);
        return "redirect:/";
    }

    @GetMapping("/borrar-producto/{id}")
    public String borrarUsuario2(@PathVariable String id) {
        repo.deleteById(Integer.valueOf(id));
        return "redirect:/";
    }
}
