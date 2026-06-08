package pca.inmuebles.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pca.inmuebles.models.CatalogoConcepto;
import java.util.List;
import java.util.Optional;

@Repository
public interface CatalogoConceptoRepository extends JpaRepository<CatalogoConcepto, Long> {
    
    // Buscar por nombre
    Optional<CatalogoConcepto> findByNombre(String nombre);
    
    // Buscar conceptos obligatorios
    List<CatalogoConcepto> findByObligatorio(Boolean obligatorio);
    
    // Buscar conceptos activos
    List<CatalogoConcepto> findByActivo(Boolean activo);
    
    // Buscar conceptos que aplican IVA
    List<CatalogoConcepto> findByAplicaIva(Boolean aplicaIva);
}
