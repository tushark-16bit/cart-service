package com.tk16.microservices.cart_service.infrastructure.out.messaging;

import com.tk16.microservices.cart_service.application.ports.out.SendPurchaseOrderPort;
import com.tk16.microservices.cart_service.domain.Cart;
import com.tk16.microservices.cart_service.domain.CartItem;
import com.tk16.microservices.common.KafkaComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;

@KafkaComponent
public class SendPurchaseOrderAdapter implements SendPurchaseOrderPort {

    Logger logger = LoggerFactory.getLogger(SendPurchaseOrderPort.class);

    private final KafkaTemplate<String, PurchaseMessage> kafkaTemplate;

    public SendPurchaseOrderAdapter(
            KafkaTemplate<String, PurchaseMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override public boolean sendPurchaseOrder(Cart cart) {
        var purchaseMessage =
                CartToPurchaseOrderMapper.mapCartToPurchaseMessage(cart);
        kafkaTemplate.send("purchase", purchaseMessage)
                .whenComplete((res, ex) -> {
                    if (ex==null) {
                        logger.info("Message sent: {}, with offset: {}",
                                purchaseMessage, res.getRecordMetadata().offset());
                    } else {
                        logger.error("Message not sent: {} due to: {}",
                                purchaseMessage, ex.getMessage());
                        throw new RuntimeException(ex);
                    }
                });
        return true;
    }
}

class CartToPurchaseOrderMapper {
    static PurchaseMessage mapCartToPurchaseMessage(Cart cart) {
        return new PurchaseMessage(
                  cart.getId(),
                cart.getTotal(),
                cart.getUserDetails().getUserId(),
                cart.getUserDetails().getEmail(),
                cart.getItems().stream()
                        .map(CartItem::getBookDetails)
                        .map(CartItem.BookDetails::toString)
                        .toList()
        );
    }
}

