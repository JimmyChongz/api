package ccp.repository.api.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "stock_out")
public class StockOut {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @Column(name = "stock_date")
    private LocalDate stockDate;

    @Column(name = "demand_person")
    private String demandPerson;

    @Column(name = "department")
    private String department;

    @Column(name = "quantity")
    private Integer quantity;
    }
