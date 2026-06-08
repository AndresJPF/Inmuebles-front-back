package pca.inmuebles.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pca.inmuebles.DAO.EmpresaRepository;
import pca.inmuebles.models.Empresa;
import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    // Obtener todas las empresas
    public List<Empresa> obtenerTodas() {
        return empresaRepository.findAll();
    }

    // Obtener una empresa por ID
    public Optional<Empresa> obtenerPorId(Long id) {
        return empresaRepository.findById(id);
    }

    // Obtener empresas activas
    public List<Empresa> obtenerActivas() {
        return empresaRepository.findByActiva(true);
    }

    // Buscar empresa por CIF
    public Empresa obtenerPorCif(String cif) {
        return empresaRepository.findByCif(cif);
    }

    // Buscar por nombre
    public List<Empresa> buscarPorNombre(String nombre) {
        return empresaRepository.findByNombreContainingIgnoreCase(nombre);
    }

    // Guardar empresa (crear o actualizar)
    public Empresa guardar(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    // Eliminar empresa
    public void eliminar(Long id) {
        empresaRepository.deleteById(id);
    }

    // Verificar si existe
    public Boolean existe(Long id) {
        return empresaRepository.existsById(id);
    }

    // Contar total de empresas
    public Long contar() {
        return empresaRepository.count();
    }
}
