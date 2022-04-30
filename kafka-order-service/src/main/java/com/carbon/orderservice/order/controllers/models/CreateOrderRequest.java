package com.carbon.orderservice.order.controllers.models;

import com.carbon.orderservice.order.domain.*;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.List;

@Value
@Builder
@RequiredArgsConstructor
public class CreateOrderRequest {

    @NotEmpty
    private final String customerId;

    @NotEmpty
    @Valid
    private final List<OrderLine> orderLines;

    @NotNull
    @Valid
    private final Address shippingAddress;

    @NotNull
    @Valid
    private final Address billingAddress;

    @NotNull
    @Valid
    private final PaymentDetails paymentDetails;


    public Order toOrder() {

        return Order.builder()
                .billingAddress(billingAddress)
                .shippingAddress(shippingAddress)
                .orderLines(orderLines)
                .customerId(customerId)
                .dateCreated(Instant.now())
                .status(OrderStatus.INITIATED_RESERVING_STOCK)
                .build();
    }

}
