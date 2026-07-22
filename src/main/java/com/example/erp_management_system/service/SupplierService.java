package com.example.erp_management_system.service;
import com.example.erp_management_system.entity.Supplier;
import com.example.erp_management_system.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;
    public Supplier saveSupplier(Supplier supplier){
        return supplierRepository.save(supplier);
    }
    public List<Supplier> getAllSuppliers(){
        return supplierRepository.findAll();
    }
    public void deleteSupplier(Long id){
        supplierRepository.deleteById(id);
    }
    public long getSupplierCount(){
        return supplierRepository.count();
    }
}
