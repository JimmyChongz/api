package ccp.repository.api.repositories;

import ccp.repository.api.entities.StockOut;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockOutRepository extends JpaRepository<StockOut, Long> {
}