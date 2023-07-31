package es.fmm.ejerc007.Servicios;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;

import es.fmm.ejerc007.Peliculas;
import es.fmm.ejerc007.Sesion;
import es.fmm.ejerc007.Ventas;
import es.fmm.ejerc007.Repos.VentasRepository;

public class VentaService {
          private final VentasRepository ventasRepository;
          private final int Descuento = 10;
          private final int numEntradaDescuento = 5;
          private final Double Precio = 5.00;

    @Autowired
    public VentaService(VentasRepository ventasRepository) {
        this.ventasRepository = ventasRepository;
    }
    
    public Ventas getVentasId(Long id)
    {
        return ventasRepository.findById(id).orElse(null);
    }
    public List<Ventas> getAllVentas()
    {
        return ventasRepository.findAll();
    }

    public Ventas createVenta(Ventas venta)
    {
        int disponibilidad = comprobarAsientosDisponibles(venta);
        if(disponibilidad > 0)
        {
            Ventas ventafinal = calcularVenta(venta);
            return ventasRepository.save(ventafinal);
        }
        else
        {
            throw new RuntimeErrorException(null, "no hay disponilidad");
        }
    }

    public Ventas updateVenta(Ventas venta)
    {
        return ventasRepository.save(venta);
    }

    public void deleteVentas(Long id)
    {
        ventasRepository.deleteById(id);
    }

    public int comprobarAsientosDisponibles(Ventas venta)
    {
        LocalDate hoy = LocalDate.now();
        
        int vendidos = (int)getAllVentas().stream().filter(miventa -> miventa.getSession() == venta.getSession() && 
                                miventa.getPelicula() == venta.getPelicula() && miventa.getFechaVenta() == hoy)
                                    .count();

        vendidos = venta.getPelicula().getSala().getButacas() - (vendidos + venta.getCantidad());

        return vendidos;
    }

    public Ventas calcularVenta(Ventas venta)
    {
        Double total = Precio * venta.getCantidad();
        venta.setPrecio(Precio);
        venta.setDescuento(0.00);
        if(venta.getCantidad() >= numEntradaDescuento)
        {
            venta.setDescuento(calcularDescuento(venta.getCantidad()));
            total = total - calcularDescuento(venta.getCantidad());
        }
        venta.setTotal(total);
        venta.setFechaVenta(LocalDate.now());
        return venta;
        

    }

    private Double calcularDescuento(int Cantidad)
    {
        return (Precio * Cantidad) % Descuento;
    }

}
