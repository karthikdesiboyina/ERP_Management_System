package com.example.erp_management_system.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "inventory")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inventoryId;
    private String productName;
    private Integer quantity;
    private String warehouseLocation;
    public Long getInventoryId() {
        return inventoryId;
    }
    public void setInventoryId(Long inventoryId) {
        this.inventoryId = inventoryId;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
    this.quantity = quantity;
}
    public String getWarehouseLocation() {
        return warehouseLocation;
    }
    public void setWarehouseLocation(String warehouseLocation) {
        this.warehouseLocation = warehouseLocation;
    }
}
