package pca.inmuebles.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pca.inmuebles.DAO.DetalleReciboRepository;
import pca.inmuebles.models.DetalleRecibo;
import java.util.List;
import java.util.Optional;

@Service
public class DetalleReciboService {

    @Autowired
    private DetalleReciboRepository detalleRepository;

    // Obtener todos los detalles
    public List<DetalleRecibo> obtenerTodos() {
        return detalleRepository.findAll();
    }

    // Obtener un detalle por ID
    public Optional<DetalleRecibo> obtenerPorId(Long id) {
        return detalleRepository.findById(id);
    }

    // Obtener detalles de un recibo
    public List<DetalleRecibo> obtenerPorRecibo(Long idRecibo) {
        return detalleRepository.findByReciboIdRecibo(idRecibo);
    }

    // Obtener detalles de un concepto
    public List<DetalleRecibo> obtenerPorConcepto(Long idConcepto) {
        return detalleRepository.findByConceptoIdConcepto(idConcepto);
    }

    // Obtener detalles con importe mayor a cero
    public List<DetalleRecibo> obtenerConImporte(Double importe) {
        return detalleRepository.findByImporteGreaterThan(importe);
    }

    // Guardar detalle
    public DetalleRecibo guardar(DetalleRecibo detalle) {
        return detalleRepository.save(detalle);
    }

    // Eliminar detalle
    public void eliminar(Long id) {
        detalleRepository.deleteById(id);
    }

    // Verificar si existe
    public Boolean existe(Long id) {
        return detalleRepository.existsById(id);
    }

    // Contar total de detalles
    public Long contar() {
        return detalleRepository.count();
    }
}
