package cl.prestabanco.users_server.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "incomes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IncomesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer idIncome;
    @Column(nullable = false)
    private Float amountIncome;
    @Column(nullable = false)
    private Date dateIncome;

    // Foreign Key
    @ManyToOne
    @JoinColumn(name = "id_job")
    private JobsEntity jobIncome;
}
