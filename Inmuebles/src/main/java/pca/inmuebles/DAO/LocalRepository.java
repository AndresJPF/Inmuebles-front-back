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
import pca.inmuebles.DTO.Local;
import java.util.List;

@Repository
public interface LocalRepository extends JpaRepository<Local, Long> {
    List<Local> findByBuildingId(Long buildingId);
    List<Local> findByRented(boolean rented);
    List<Local> findByType(String type);
}