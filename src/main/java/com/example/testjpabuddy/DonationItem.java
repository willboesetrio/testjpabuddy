package com.example.testjpabuddy;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "DONATION_ITEM", indexes = {
        @Index(name = "FK_DONATION_ITEM_DONATION_INDEX_4", columnList = "DONATION_ID"),
        @Index(name = "FK_DONATION_ITEM_ITEM_TYPE_INDEX_4", columnList = "ITEM_TYPE_ID")
})
public class DonationItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DONATION_ID", nullable = false)
    private Donation donation;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ITEM_TYPE_ID", nullable = false)
    private ItemType itemType;

    @Column(name = "DESC")
    private String desc;

    @Column(name = "DOLLAR_VALUE", precision = 15, scale = 2)
    private BigDecimal dollarValue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Donation getDonation() {
        return donation;
    }

    public void setDonation(Donation donation) {
        this.donation = donation;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public BigDecimal getDollarValue() {
        return dollarValue;
    }

    public void setDollarValue(BigDecimal dollarValue) {
        this.dollarValue = dollarValue;
    }

}