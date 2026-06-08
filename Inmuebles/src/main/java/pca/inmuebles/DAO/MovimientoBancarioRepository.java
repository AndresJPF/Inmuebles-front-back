package pca.inmuebles.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pca.inmuebles.models.MovimientoBancario;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface MovimientoBancarioRepository extends JpaRepository<MovimientoBancario, Long> {
    
    // Buscar movimientos de una cuenta
    List<MovimientoBancario> findByCuentaIdCuenta(Long idCuenta);
    
    // Buscar movimientos de un inmueble
    List<MovimientoBancario> findByInmuebleIdInmueble(Long idInmueble);
    
    // Buscar movimientos de un tipo
    List<MovimientoBancario> findByTipoIdTipo(Long idTipo);
    
    // Buscar movimientos por clasificación (GASTO o INGRESO)
    List<MovimientoBancario> findByClasificacion(String clasificacion);
    
    // Buscar movimientos en un rango de fechas
    List<MovimientoBancario> findByFechaBetween(LocalDate fechaInicio, LocalDate fechaFin);
    
    // Buscar movimientos de una cuenta en un rango de fechas
    List<MovimientoBancario> findByCuentaIdCuentaAndFechaBetween(Long idCuenta, LocalDate fechaInicio, LocalDate fechaFin);
    
    // Buscar movimientos de un inmueble por clasificación
    List<MovimientoBancario> findByInmuebleIdInmuebleAndClasificacion(Long idInmueble, String clasificacion);
}
