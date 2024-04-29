package ccp.repository.api.repositories;

import ccp.repository.api.entities.StockIn;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockInRepository extends JpaRepository<StockIn, Long> {
}
