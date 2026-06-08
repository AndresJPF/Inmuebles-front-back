package pca.inmuebles.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pca.inmuebles.DAO.MovimientoBancarioRepository;
import pca.inmuebles.models.MovimientoBancario;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MovimientoBancarioService {

    @Autowired
    private MovimientoBancarioRepository movimientoRepository;

    // Obtener todos los movimientos
    public List<MovimientoBancario> obtenerTodos() {
        return movimientoRepository.findAll();
    }

    // Obtener un movimiento por ID
    public Optional<MovimientoBancario> obtenerPorId(Long id) {
        return movimientoRepository.findById(id);
    }

    // Obtener movimientos de una cuenta
    public List<MovimientoBancario> obtenerPorCuenta(Long idCuenta) {
        return movimientoRepository.findByCuentaIdCuenta(idCuenta);
    }

    // Obtener movimientos de un inmueble
    public List<MovimientoBancario> obtenerPorInmueble(Long idInmueble) {
        return movimientoRepository.findByInmuebleIdInmueble(idInmueble);
    }

    // Obtener movimientos de un tipo
    public List<MovimientoBancario> obtenerPorTipo(Long idTipo) {
        return movimientoRepository.findByTipoIdTipo(idTipo);
    }

    // Obtener movimientos por clasificación
    public List<MovimientoBancario> obtenerPorClasificacion(String clasificacion) {
        return movimientoRepository.findByClasificacion(clasificacion);
    }

    // Obtener movimientos en un rango de fechas
    public List<MovimientoBancario> obtenerPorFechas(LocalDate fechaInicio, LocalDate fechaFin) {
        return movimientoRepository.findByFechaBetween(fechaInicio, fechaFin);
    }

    // Obtener movimientos de una cuenta en un rango de fechas
    public List<MovimientoBancario> obtenerPorCuentaYFechas(Long idCuenta, LocalDate fechaInicio, LocalDate fechaFin) {
        return movimientoRepository.findByCuentaIdCuentaAndFechaBetween(idCuenta, fechaInicio, fechaFin);
    }

    // Obtener gastos
    public List<MovimientoBancario> obtenerGastos() {
        return movimientoRepository.findByClasificacion("GASTO");
    }

    // Obtener ingresos
    public List<MovimientoBancario> obtenerIngresos() {
        return movimientoRepository.findByClasificacion("INGRESO");
    }

    // Obtener gastos de un inmueble
    public List<MovimientoBancario> obtenerGastosPorInmueble(Long idInmueble) {
        return movimientoRepository.findByInmuebleIdInmuebleAndClasificacion(idInmueble, "GASTO");
    }

    // Obtener ingresos de un inmueble
    public List<MovimientoBancario> obtenerIngresosPorInmueble(Long idInmueble) {
        return movimientoRepository.findByInmuebleIdInmuebleAndClasificacion(idInmueble, "INGRESO");
    }

    // Guardar movimiento
    public MovimientoBancario guardar(MovimientoBancario movimiento) {
        return movimientoRepository.save(movimiento);
    }

    // Eliminar movimiento
    public void eliminar(Long id) {
        movimientoRepository.deleteById(id);
    }

    // Verificar si existe
    public Boolean existe(Long id) {
        return movimientoRepository.existsById(id);
    }

    // Contar total de movimientos
    public Long contar() {
        return movimientoRepository.count();
    }
}
