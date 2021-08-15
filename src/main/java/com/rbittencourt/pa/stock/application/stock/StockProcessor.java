package com.rbittencourt.pa.stock.application.stock;

import com.rbittencourt.pa.stock.infrastructure.ecommerceorder.EcommerceOrder;
import com.rbittencourt.pa.stock.infrastructure.stock.StockRecord;
import com.rbittencourt.pa.stock.infrastructure.stock.StockRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class StockProcessor {

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private KafkaTemplate<String, EcommerceOrder> kafkaTemplate;

    private final Logger logger = LoggerFactory.getLogger(StockProcessor.class);

    @KafkaListener(topics = "payment_processed", containerFactory = "ecommerceOrderKafkaListenerContainerFactory")
    public void process(EcommerceOrder ecommerceOrder) {
        kafkaTemplate.send("separating_stock_started", ecommerceOrder);

        StockRecord stockRecord = new StockRecord(ecommerceOrder.getId(), ecommerceOrder.getProducts());
        stockRepository.save(stockRecord);

        kafkaTemplate.send("stock_separated", ecommerceOrder);

        logger.info("Stock from order " + ecommerceOrder.getId() + " was processed");
    }

}
