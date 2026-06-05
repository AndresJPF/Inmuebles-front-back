package pca.inmuebles.DTO;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "bank_accounts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El IBAN no puede estar vacío")
    @Column(unique = true)
    private String iban;

    @NotBlank(message = "El número de cuenta no puede estar vacío")
    @Column(unique = true)
    private String accountNumber;

    private Double balance = 0.0; // saldo actual (positivo o negativo)

    @ManyToOne
    @JoinColumn(name = "bank_id", nullable = false)
    private Bank bank;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BankMovement> movements;
}
