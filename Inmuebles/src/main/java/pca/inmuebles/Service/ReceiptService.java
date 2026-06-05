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
import pca.inmuebles.DAO.ReceiptRepository;
import pca.inmuebles.DTO.Receipt;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ReceiptService {
    @Autowired private ReceiptRepository receiptRepository;
    
    public List<Receipt> findAll() { return receiptRepository.findAll(); }
    public Optional<Receipt> findById(Long id) { return receiptRepository.findById(id); }
    public Receipt save(Receipt receipt) { return receiptRepository.save(receipt); }
    public void deleteById(Long id) { receiptRepository.deleteById(id); }
    public List<Receipt> findByPaid(boolean paid) { return receiptRepository.findByPaid(paid); }
    public List<Receipt> findByDateRange(LocalDate start, LocalDate end) { 
        return receiptRepository.findByIssueDateBetween(start, end); 
    }
    public Optional<Receipt> findByReceiptNumber(String number) { 
        return receiptRepository.findByReceiptNumber(number); 
    }
    
    public Receipt generateFromPrevious(Receipt previous) {
        Receipt newReceipt = new Receipt();
        newReceipt.setReceiptNumber(previous.getReceiptNumber());
        newReceipt.setRent(previous.getRent());
        newReceipt.setWater(previous.getWater());
        newReceipt.setElectricity(previous.getElectricity());
        newReceipt.setPorterage(previous.getPorterage());
        newReceipt.setIpc(previous.getIpc());
        newReceipt.setVat(previous.getVat());
        newReceipt.setOtherConcepts(previous.getOtherConcepts());
        newReceipt.setIssueDate(LocalDate.now());
        newReceipt.setDueDate(LocalDate.now().plusMonths(1));
        newReceipt.setPaid(false);
        return receiptRepository.save(newReceipt);
    }
}