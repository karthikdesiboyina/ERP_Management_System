package com.example.erp_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.erp_management_system.entity.Inventory;
import com.example.erp_management_system.service.InventoryService;
@RestController
@RequestMapping("/api/inventory")
@CrossOrigin("*")
public class InventoryController {
    @Autowired
    private InventoryService service;
    @PostMapping
    public Inventory createInventory(
            @RequestBody Inventory inventory){
        return service.saveInventory(inventory);
    }
    @GetMapping
    public List<Inventory> getInventory(){
        return service.getAllInventory();
    }
    @GetMapping("/count")
public long getInventoryCount() {
    return service.getInventoryCount();
}
    @PutMapping("/{id}")
    public Inventory updateInventory(
            @PathVariable Long id,
            @RequestBody Inventory inventory){
        inventory.setInventoryId(id);
        return service.saveInventory(inventory);
    }
    @DeleteMapping("/{id}")
    public String deleteInventory(@PathVariable Long id){
        service.deleteInventory(id);
        return "Inventory Deleted";
    }
}
