/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import java.util.Date;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author ASUS
 */
public class GestionProductosTest {

    GestionProductos gestionProductos;

    @BeforeEach
    public void setUp() {
        gestionProductos = new GestionProductos();
    }

    @Test
    public void testAgregarProducto() {
        Producto producto = new Producto("001", "Jabon", "Para las manos", 10, 5, new Date());
        gestionProductos.agregarProducto(producto);
        assertEquals(1, gestionProductos.obtenerProductos().size());
    }
    
    @Test
    public void testModificarProducto(){
        Producto producto = new Producto("001", "Jabon", "Para las manos", 10, 5, new Date());
        gestionProductos.agregarProducto(producto);
        Producto nuevoproducto = new Producto("001", "m1", "dm1", 100, 50, new Date());
        gestionProductos.modificarProducto("001", nuevoproducto);
        Producto productoModificado = gestionProductos.buscarProducto("001");
        assertEquals("m1", productoModificado.getNombre());
    }
    
    @Test
    public void testEliminarProducto(){
        Producto producto = new Producto("001", "Jabon", "Para las manos", 10, 5, new Date());
        gestionProductos.agregarProducto(producto);
        gestionProductos.eliminarProducto("001");
        assertEquals(0, gestionProductos.obtenerProductos().size());
    }
    
    @Test
    public void testEliminarProductoXObejto(){
        Producto producto = new Producto("001", "Jabon", "Para las manos", 10, 5, new Date());
        gestionProductos.agregarProducto(producto);
        gestionProductos.eliminarProductoXObjeto(producto);
        assertEquals(0, gestionProductos.obtenerProductos().size());
    }

    @Test
    public void testModificarProductoNoExistente() {
        Producto nuevoProducto = new Producto("001", "ProductoModificado", "DescripcionModificada", 150.0, 75.0, new Date());
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> gestionProductos.modificarProducto("001", nuevoProducto));
        assertEquals("Producto no encontrado", thrown.getMessage());
    }
    
    @Test
    public void testCalcularPromedio(){
        Producto producto1 = new Producto("001", "m1", "dm1", 100, 50, new Date());
        Producto producto2 = new Producto("002", "m2", "dm2", 400, 50, new Date());
        gestionProductos.agregarProducto(producto1);
        gestionProductos.agregarProducto(producto2);
        assertEquals(250, gestionProductos.calcularPromedio());
    }
}
