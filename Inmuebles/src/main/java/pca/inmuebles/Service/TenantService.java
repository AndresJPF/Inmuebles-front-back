/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pca.inmuebles.Service;

/**
 *
 * @author aandr
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pca.inmuebles.DAO.TenantRepository;
import pca.inmuebles.DTO.Tenant;
import java.util.List;
import java.util.Optional;

@Service
public class TenantService {
    @Autowired private TenantRepository tenantRepository;
    
    public List<Tenant> findAll() { return tenantRepository.findAll(); }
    public Optional<Tenant> findById(Long id) { return tenantRepository.findById(id); }
    public Optional<Tenant> findByDni(String dni) { return tenantRepository.findByDni(dni); }
    public Tenant save(Tenant tenant) { return tenantRepository.save(tenant); }
    public void deleteById(Long id) { tenantRepository.deleteById(id); }
    public List<Tenant> findByActive(boolean active) { return tenantRepository.findByActive(active); }
}
