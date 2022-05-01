package com.carbon.orderservice.order.clients;

import com.carbon.orderservice.order.domain.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import static com.carbon.orderservice.common.configs.KafkaConfig.FINANCE_PAYMENT_PROCESS_TOPIC;

@Slf4j
@Component
@RequiredArgsConstructor
public class FinanceServiceClient {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendPaymentProcessingEvent(Order order) {

        log.info("processing payment for order {} by customer {}", order.getId(), order.getCustomerId());
        var key = String.format("%s-payment-processing", order.getId());
        kafkaTemplate.send(FINANCE_PAYMENT_PROCESS_TOPIC, key, order);
    }

}
