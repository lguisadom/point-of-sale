package com.cosodi.pos.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
public class PurchaseDetailPK implements Serializable {
    @ManyToOne
    @JoinColumn(name = "purchase_id", nullable = false, foreignKey = @ForeignKey(name = "FK_PURCHASE_DETAIL_PURCHASE"))
    private Purchase purchase;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false, foreignKey = @ForeignKey(name = "FK_PURCHASE_DETAIL_PRODUCT"))
    private Product product;
}
