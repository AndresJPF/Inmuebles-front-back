package pca.inmuebles.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pca.inmuebles.DAO.TipoMovimientoRepository;
import pca.inmuebles.models.TipoMovimiento;
import java.util.List;
import java.util.Optional;

@Service
public class TipoMovimientoService {

    @Autowired
    private TipoMovimientoRepository tipoRepository;

    // Obtener todos los tipos
    public List<TipoMovimiento> obtenerTodos() {
        return tipoRepository.findAll();
    }

    // Obtener un tipo por ID
    public Optional<TipoMovimiento> obtenerPorId(Long id) {
        return tipoRepository.findById(id);
    }

    // Buscar tipo por nombre
    public Optional<TipoMovimiento> obtenerPorNombre(String nombre) {
        return tipoRepository.findByNombre(nombre);
    }

    // Obtener tipos por clasificación (GASTO o INGRESO)
    public List<TipoMovimiento> obtenerPorClasificacion(String clasificacion) {
        return tipoRepository.findByClasificacion(clasificacion);
    }

    // Obtener tipos activos
    public List<TipoMovimiento> obtenerActivos() {
        return tipoRepository.findByActivo(true);
    }

    // Obtener tipos por clasificación y activos
    public List<TipoMovimiento> obtenerPorClasificacionYActivos(String clasificacion) {
        return tipoRepository.findByClasificacionAndActivo(clasificacion, true);
    }

    // Obtener gastos activos
    public List<TipoMovimiento> obtenerGastosActivos() {
        return tipoRepository.findByClasificacionAndActivo("GASTO", true);
    }

    // Obtener ingresos activos
    public List<TipoMovimiento> obtenerIngresosActivos() {
        return tipoRepository.findByClasificacionAndActivo("INGRESO", true);
    }

    // Guardar tipo
    public TipoMovimiento guardar(TipoMovimiento tipo) {
        return tipoRepository.save(tipo);
    }

    // Eliminar tipo
    public void eliminar(Long id) {
        tipoRepository.deleteById(id);
    }

    // Verificar si existe
    public Boolean existe(Long id) {
        return tipoRepository.existsById(id);
    }

    // Contar total de tipos
    public Long contar() {
        return tipoRepository.count();
    }
}
