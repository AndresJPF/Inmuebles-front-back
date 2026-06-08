package pca.inmuebles.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pca.inmuebles.DAO.GarantiaInquilinoRepository;
import pca.inmuebles.models.GarantiaInquilino;
import java.util.List;
import java.util.Optional;

@Service
public class GarantiaInquilinoService {

    @Autowired
    private GarantiaInquilinoRepository garantiaRepository;

    // Obtener todas las garantías
    public List<GarantiaInquilino> obtenerTodas() {
        return garantiaRepository.findAll();
    }

    // Obtener una garantía por ID
    public Optional<GarantiaInquilino> obtenerPorId(Long id) {
        return garantiaRepository.findById(id);
    }

    // Obtener garantías de un inquilino
    public List<GarantiaInquilino> obtenerPorInquilino(Long idInquilino) {
        return garantiaRepository.findByInquilinoIdInquilino(idInquilino);
    }

    // Obtener garantías por tipo
    public List<GarantiaInquilino> obtenerPorTipo(String tipoGarantia) {
        return garantiaRepository.findByTipoGarantia(tipoGarantia);
    }

    // Obtener garantías activas
    public List<GarantiaInquilino> obtenerActivas() {
        return garantiaRepository.findByActiva(true);
    }

    // Guardar garantía
    public GarantiaInquilino guardar(GarantiaInquilino garantia) {
        return garantiaRepository.save(garantia);
    }

    // Eliminar garantía
    public void eliminar(Long id) {
        garantiaRepository.deleteById(id);
    }

    // Verificar si existe
    public Boolean existe(Long id) {
        return garantiaRepository.existsById(id);
    }

    // Contar total de garantías
    public Long contar() {
        return garantiaRepository.count();
    }
}
