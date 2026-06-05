package pca.inmuebles.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pca.inmuebles.DTO.Building;
import java.util.List;
import java.util.Optional;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Long> {

    /**
     * Busca edificios por dirección exacta
     */
    List<Building> findByAddress(String address);

    /**
     * Busca edificios por código postal
     */
    List<Building> findByPostalCode(String postalCode);

    /**
     * Busca edificios por ciudad
     */
    List<Building> findByCity(String city);

    /**
     * Busca edificios por provincia
     */
    List<Building> findByProvince(String province);

    /**
     * Busca edificios que contengan una dirección
     */
    List<Building> findByAddressContainingIgnoreCase(String address);
}
