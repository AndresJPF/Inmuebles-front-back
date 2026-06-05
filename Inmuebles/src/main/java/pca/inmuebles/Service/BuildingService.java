package pca.inmuebles.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pca.inmuebles.DAO.BuildingRepository;
import pca.inmuebles.DTO.Building;
import java.util.List;
import java.util.Optional;

@Service
public class BuildingService {

    @Autowired
    private BuildingRepository buildingRepository;

    /**
     * Obtiene todos los edificios
     */
    public List<Building> findAll() {
        return buildingRepository.findAll();
    }

    /**
     * Obtiene un edificio por ID
     */
    public Optional<Building> findById(Long id) {
        return buildingRepository.findById(id);
    }

    /**
     * Busca edificios por dirección
     */
    public List<Building> findByAddress(String address) {
        return buildingRepository.findByAddress(address);
    }

    /**
     * Busca edificios por código postal
     */
    public List<Building> findByPostalCode(String postalCode) {
        return buildingRepository.findByPostalCode(postalCode);
    }

    /**
     * Busca edificios por ciudad
     */
    public List<Building> findByCity(String city) {
        return buildingRepository.findByCity(city);
    }

    /**
     * Guarda o actualiza un edificio
     */
    public Building save(Building building) {
        return buildingRepository.save(building);
    }

    /**
     * Elimina un edificio por ID
     */
    public void deleteById(Long id) {
        buildingRepository.deleteById(id);
    }

    /**
     * Elimina un edificio
     */
    public void delete(Building building) {
        buildingRepository.delete(building);
    }

    /**
     * Verifica si existe un edificio por ID
     */
    public boolean existsById(Long id) {
        return buildingRepository.existsById(id);
    }

    /**
     * Obtiene el total de edificios
     */
    public long count() {
        return buildingRepository.count();
    }
}
