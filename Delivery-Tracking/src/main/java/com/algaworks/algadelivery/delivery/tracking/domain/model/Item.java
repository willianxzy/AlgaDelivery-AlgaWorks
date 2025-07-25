package com.algaworks.algadelivery.delivery.tracking.domain.model;

import java.util.UUID;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Setter(AccessLevel.PACKAGE)
@Getter
public class Item {
    
    @EqualsAndHashCode.Include
    private UUID id;
    
    private String name;
    private Integer quantity;

    static Item brandNew(String name, Integer quantity) {
        Item item = new Item();
        item.setId(UUID.randomUUID());
        item.setName(name);
        item.setQuantity(quantity);
        return item;
    }
}
