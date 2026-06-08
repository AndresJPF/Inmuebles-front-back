package pca.inmuebles.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pca.inmuebles.models.DetalleRecibo;
import java.util.List;

@Repository
public interface DetalleReciboRepository extends JpaRepository<DetalleRecibo, Long> {
    
    // Buscar detalles de un recibo
    List<DetalleRecibo> findByReciboIdRecibo(Long idRecibo);
    
    // Buscar detalles de un concepto
    List<DetalleRecibo> findByConceptoIdConcepto(Long idConcepto);
    
    // Buscar detalles con importe mayor a cero
    List<DetalleRecibo> findByImporteGreaterThan(Double importe);
}
