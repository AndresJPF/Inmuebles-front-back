/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pca.inmuebles.DAO;

/**
 *
 * @author aandr
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pca.inmuebles.DTO.Tenant;
import java.util.List;
import java.util.Optional;

@Repository
public interface TenantRepository extends JpaRepository<Tenant, Long> {
    Optional<Tenant> findByDni(String dni);
    List<Tenant> findByActive(boolean active);
    List<Tenant> findByGuaranteeType(String guaranteeType);
}