package com.example.erp_management_system.service;
import com.example.erp_management_system.entity.Inventory;
import com.example.erp_management_system.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class InventoryService {
    @Autowired
    private InventoryRepository repository;
    public Inventory saveInventory(Inventory inventory){
        return repository.save(inventory);
    }
    public List<Inventory> getAllInventory(){
        return repository.findAll();
    }
    public void deleteInventory(Long id){
        repository.deleteById(id);
    }
    public long getInventoryCount() {
    return repository.count();
}
}
