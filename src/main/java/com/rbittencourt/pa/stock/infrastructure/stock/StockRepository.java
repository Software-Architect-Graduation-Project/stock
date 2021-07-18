package com.rbittencourt.pa.stock.infrastructure.logistics;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<StockRecord, Long> {

}
