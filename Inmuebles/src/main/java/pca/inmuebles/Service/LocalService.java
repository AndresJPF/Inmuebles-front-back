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
import pca.inmuebles.DAO.LocalRepository;
import pca.inmuebles.DTO.Local;
import java.util.List;
import java.util.Optional;

@Service
public class LocalService {
    @Autowired private LocalRepository localRepository;
    
    public List<Local> findAll() { return localRepository.findAll(); }
    public Optional<Local> findById(Long id) { return localRepository.findById(id); }
    public Local save(Local local) { return localRepository.save(local); }
    public void deleteById(Long id) { localRepository.deleteById(id); }
    public List<Local> findByBuildingId(Long buildingId) { return localRepository.findByBuildingId(buildingId); }
    public List<Local> findByRented(boolean rented) { return localRepository.findByRented(rented); }
    public boolean existsById(Long id) { return localRepository.existsById(id); }
}
