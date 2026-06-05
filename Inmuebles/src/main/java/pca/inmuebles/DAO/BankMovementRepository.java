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
import pca.inmuebles.DTO.BankMovement;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BankMovementRepository extends JpaRepository<BankMovement, Long> {
    List<BankMovement> findByMovementDateBetween(LocalDate start, LocalDate end);
    List<BankMovement> findByType(BankMovement.MovementType type);
    List<BankMovement> findByBuildingId(Long buildingId);
    List<BankMovement> findByFlatId(Long flatId);
}