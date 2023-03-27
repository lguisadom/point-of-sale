package com.cosodi.pos.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
public class SaleDetailPK implements Serializable {
    @ManyToOne
    @JoinColumn(name = "sale_id", nullable = false, foreignKey = @ForeignKey(name = "FK_SALE_DETAIL_SALE"))
    private Sale sale;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false, foreignKey = @ForeignKey(name = "FK_SALE_DETAIL_PRODUCT"))
    private Product product;
}
