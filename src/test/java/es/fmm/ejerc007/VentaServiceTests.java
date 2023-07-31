package es.fmm.ejerc007;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import es.fmm.ejerc007.Repos.VentasRepository;
import es.fmm.ejerc007.Servicios.VentaService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class VentaServiceTests {

    @Mock
    private VentasRepository ventasRepository;

    @InjectMocks
    private VentaService ventaService;

    private Peliculas pelicula;
    private Sesion session;
    private Ventas venta;
    private Sala sala;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        //datos de prueba
        sala = new Sala("sala1", 100);

        pelicula = new Peliculas("Una peli", LocalDate.now(), LocalDate.now().plusDays(10), sala);

        session = new Sesion(LocalTime.now(), LocalTime.now().plusHours(3), pelicula);

        venta = new Ventas(null, 0, 5.00, pelicula, session, LocalDate.now());
    }

    @Test
    public void testCrearVentaConDisponibilidad() {
       
        when(ventasRepository.findAll()).thenReturn(new ArrayList<>());

        Ventas ventaFinal = ventaService.createVenta(venta);

        
        verify(ventasRepository, times(1)).save(ventaFinal);

        // Verificar que el total es correcto
        assertEquals(10.0, ventaFinal.getTotal());

        // Verificar que no hay descuento
        assertEquals(0.0, ventaFinal.getDescuento());
    }

    @Test
    public void testCrearVentaSinDisponibilidad() {
        
        List<Ventas> ventas = new ArrayList<>();
        ventas.add(venta);
        when(ventasRepository.findAll()).thenReturn(ventas);
        venta.setCantidad(101);

        // verifica que se lance la excp
        assertThrows(RuntimeErrorException.class, () -> ventaService.createVenta(venta));
    }

    @Test
    public void testCalcularVentaConDescuento() {
        venta.setCantidad(5);

        Ventas ventaFinal = ventaService.calcularVenta(venta);

        assertEquals(5.0, ventaFinal.getDescuento());
        assertEquals(20.0, ventaFinal.getTotal());
    }

    @Test
    public void testCalcularVentaSinDescuento() {
        venta.setCantidad(3);

        Ventas ventaFinal = ventaService.calcularVenta(venta);

        assertEquals(0.0, ventaFinal.getDescuento());
        assertEquals(15.0, ventaFinal.getTotal());
    }
}