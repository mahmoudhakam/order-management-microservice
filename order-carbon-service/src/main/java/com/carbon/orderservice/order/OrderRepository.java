package com.carbon.orderservice.order;

import com.carbon.orderservice.order.domain.Order;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

interface OrderRepository extends ReactiveMongoRepository<Order, String> {

}
