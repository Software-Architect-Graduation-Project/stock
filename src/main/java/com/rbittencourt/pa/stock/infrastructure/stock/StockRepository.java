package com.rbittencourt.pa.stock.infrastructure.stock;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<StockRecord, Long> {

}
