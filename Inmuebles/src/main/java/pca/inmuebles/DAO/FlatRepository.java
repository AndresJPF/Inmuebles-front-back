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
import pca.inmuebles.DTO.Flat;
import java.util.List;

@Repository
public interface FlatRepository extends JpaRepository<Flat, Long> {
    List<Flat> findByBuildingId(Long buildingId);
    List<Flat> findByRented(boolean rented);
    List<Flat> findByLetter(String letter);
}
