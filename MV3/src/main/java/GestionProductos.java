
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ASUS
 */
public class GestionProductos {

    List<Producto> productos;

    public GestionProductos() {
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        if (producto == null || producto.getPrecio() < 0 || producto.getCosto() > producto.getPrecio() || producto.getCodigo().isEmpty()) {
            throw new IllegalArgumentException("Producto no válido!");
        }
        for (Producto p : productos) {
            if (p.getCodigo().equals(producto.getCodigo())) {
                throw new IllegalArgumentException("Producto repetido");
            }
        }
        productos.add(producto);
    }
    
    public void modificarProducto(String codigo, Producto nuevoProducto){
        Producto producto = buscarProducto(codigo);
        if (producto == null) {
            throw new IllegalArgumentException("Producto no encontrado");
        }
        producto.setNombre(nuevoProducto.getNombre());
        producto.setDescripcion(nuevoProducto.getDescripcion());
        producto.setCosto(nuevoProducto.getCosto());
        producto.setPrecio(nuevoProducto.getPrecio());
        producto.setFechaCompra(nuevoProducto.getFechaCompra());
    }
    
    public void eliminarProducto(String codigo){
        Producto producto = buscarProducto(codigo);
        if (producto == null) {
            throw new IllegalArgumentException("Producto no encontrado");
        }
        productos.remove(producto);
    }
    
    public void eliminarProductoXObjeto(Producto producto){
        if (producto == null) {
            throw new IllegalArgumentException("Producto no encontrado");
        }
        productos.remove(producto);
    }
    
    public double calcularPromedio(){
        if (productos.isEmpty()) {
            throw new IllegalArgumentException("Lista vacia");
        }
        double suma = 0;
        for (Producto p : productos){
            suma += p.getPrecio();
        }
        return suma / productos.size();
    }
    
    public Producto buscarProducto(String codigo){
        for (Producto producto : productos){
            if (producto.getCodigo().equals(codigo)) {
                return producto;
            }
        }
        return null;
    }

    public List<Producto> obtenerProductos() {
        return new ArrayList<>(productos);
    }
}
