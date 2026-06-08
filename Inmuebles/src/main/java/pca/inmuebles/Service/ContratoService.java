package pca.inmuebles.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pca.inmuebles.DAO.ContratoRepository;
import pca.inmuebles.models.Contrato;
import java.util.List;
import java.util.Optional;

@Service
public class ContratoService {

    @Autowired
    private ContratoRepository contratoRepository;

    // Obtener todos los contratos
    public List<Contrato> obtenerTodos() {
        return contratoRepository.findAll();
    }

    // Obtener un contrato por ID
    public Optional<Contrato> obtenerPorId(Long id) {
        return contratoRepository.findById(id);
    }

    // Obtener contratos de un inquilino
    public List<Contrato> obtenerPorInquilino(Long idInquilino) {
        return contratoRepository.findByInquilinoIdInquilino(idInquilino);
    }

    // Obtener contratos de un inmueble
    public List<Contrato> obtenerPorInmueble(Long idInmueble) {
        return contratoRepository.findByInmuebleIdInmueble(idInmueble);
    }

    // Obtener contratos activos
    public List<Contrato> obtenerActivos() {
        return contratoRepository.findByActivo(true);
    }

    // Obtener contratos activos de un inquilino
    public List<Contrato> obtenerActivosPorInquilino(Long idInquilino) {
        return contratoRepository.findByInquilinoIdInquilinoAndActivo(idInquilino, true);
    }

    // Guardar contrato
    public Contrato guardar(Contrato contrato) {
        return contratoRepository.save(contrato);
    }

    // Eliminar contrato
    public void eliminar(Long id) {
        contratoRepository.deleteById(id);
    }

    // Verificar si existe
    public Boolean existe(Long id) {
        return contratoRepository.existsById(id);
    }

    // Contar total de contratos
    public Long contar() {
        return contratoRepository.count();
    }
}
