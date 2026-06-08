package pca.inmuebles.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pca.inmuebles.models.TipoMovimiento;
import java.util.List;
import java.util.Optional;

@Repository
public interface TipoMovimientoRepository extends JpaRepository<TipoMovimiento, Long> {
    
    // Buscar por nombre
    Optional<TipoMovimiento> findByNombre(String nombre);
    
    // Buscar por clasificación (GASTO o INGRESO)
    List<TipoMovimiento> findByClasificacion(String clasificacion);
    
    // Buscar tipos activos
    List<TipoMovimiento> findByActivo(Boolean activo);
    
    // Buscar por clasificación y activos
    List<TipoMovimiento> findByClasificacionAndActivo(String clasificacion, Boolean activo);
}
