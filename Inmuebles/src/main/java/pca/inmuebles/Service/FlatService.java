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
import pca.inmuebles.DAO.FlatRepository;
import pca.inmuebles.DTO.Flat;
import java.util.List;
import java.util.Optional;

@Service
public class FlatService {
    @Autowired private FlatRepository flatRepository;
    
    public List<Flat> findAll() { return flatRepository.findAll(); }
    public Optional<Flat> findById(Long id) { return flatRepository.findById(id); }
    public Flat save(Flat flat) { return flatRepository.save(flat); }
    public void deleteById(Long id) { flatRepository.deleteById(id); }
    public List<Flat> findByBuildingId(Long buildingId) { return flatRepository.findByBuildingId(buildingId); }
    public List<Flat> findByRented(boolean rented) { return flatRepository.findByRented(rented); }
    public boolean existsById(Long id) { return flatRepository.existsById(id); }
    public long count() { return flatRepository.count(); }
}
