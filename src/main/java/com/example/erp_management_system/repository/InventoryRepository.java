package com.example.erp_management_system.repository;
import com.example.erp_management_system.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
public interface InventoryRepository
        extends JpaRepository<Inventory, Long> {
}
