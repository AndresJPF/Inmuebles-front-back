package pca.inmuebles.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pca.inmuebles.DAO.CatalogoConceptoRepository;
import pca.inmuebles.models.CatalogoConcepto;
import java.util.List;
import java.util.Optional;

@Service
public class CatalogoConceptoService {

    @Autowired
    private CatalogoConceptoRepository conceptoRepository;

    // Obtener todos los conceptos
    public List<CatalogoConcepto> obtenerTodos() {
        return conceptoRepository.findAll();
    }

    // Obtener un concepto por ID
    public Optional<CatalogoConcepto> obtenerPorId(Long id) {
        return conceptoRepository.findById(id);
    }

    // Buscar concepto por nombre
    public Optional<CatalogoConcepto> obtenerPorNombre(String nombre) {
        return conceptoRepository.findByNombre(nombre);
    }

    // Obtener conceptos obligatorios
    public List<CatalogoConcepto> obtenerObligatorios() {
        return conceptoRepository.findByObligatorio(true);
    }

    // Obtener conceptos activos
    public List<CatalogoConcepto> obtenerActivos() {
        return conceptoRepository.findByActivo(true);
    }

    // Obtener conceptos que aplican IVA
    public List<CatalogoConcepto> obtenerConIva() {
        return conceptoRepository.findByAplicaIva(true);
    }

    // Guardar concepto
    public CatalogoConcepto guardar(CatalogoConcepto concepto) {
        return conceptoRepository.save(concepto);
    }

    // Eliminar concepto
    public void eliminar(Long id) {
        conceptoRepository.deleteById(id);
    }

    // Verificar si existe
    public Boolean existe(Long id) {
        return conceptoRepository.existsById(id);
    }

    // Contar total de conceptos
    public Long contar() {
        return conceptoRepository.count();
    }
}
