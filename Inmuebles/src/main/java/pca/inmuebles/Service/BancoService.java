package pca.inmuebles.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pca.inmuebles.DAO.BancoRepository;
import pca.inmuebles.models.Banco;
import java.util.List;
import java.util.Optional;

@Service
public class BancoService {

    @Autowired
    private BancoRepository bancoRepository;

    // Obtener todos los bancos
    public List<Banco> obtenerTodos() {
        return bancoRepository.findAll();
    }

    // Obtener un banco por ID
    public Optional<Banco> obtenerPorId(Long id) {
        return bancoRepository.findById(id);
    }

    // Buscar banco por nombre
    public Optional<Banco> obtenerPorNombre(String nombre) {
        return bancoRepository.findByNombre(nombre);
    }

    // Obtener bancos activos
    public List<Banco> obtenerActivos() {
        return bancoRepository.findByActivo(true);
    }

    // Buscar banco por código BIC
    public Optional<Banco> obtenerPorBic(String codigoBic) {
        return bancoRepository.findByCodigoBic(codigoBic);
    }

    // Guardar banco
    public Banco guardar(Banco banco) {
        return bancoRepository.save(banco);
    }

    // Eliminar banco
    public void eliminar(Long id) {
        bancoRepository.deleteById(id);
    }

    // Verificar si existe
    public Boolean existe(Long id) {
        return bancoRepository.existsById(id);
    }

    // Contar total de bancos
    public Long contar() {
        return bancoRepository.count();
    }
}
