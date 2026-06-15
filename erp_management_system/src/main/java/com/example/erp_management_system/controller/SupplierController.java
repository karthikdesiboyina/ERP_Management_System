package com.example.erp_management_system.controller;
import com.example.erp_management_system.entity.Supplier;
import com.example.erp_management_system.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/suppliers")
@CrossOrigin("*")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;
    @PostMapping
    public Supplier createSupplier(
            @RequestBody Supplier supplier){
        return supplierService.saveSupplier(supplier);
    }
    @GetMapping
    public List<Supplier> getSuppliers(){
        return supplierService.getAllSuppliers();
    }
    @PutMapping("/{id}")
    public Supplier updateSupplier(
            @PathVariable Long id,
            @RequestBody Supplier supplier){
        supplier.setSupplierId(id);
        return supplierService.saveSupplier(supplier);
    }
    @DeleteMapping("/{id}")
    public String deleteSupplier(
            @PathVariable Long id){
        supplierService.deleteSupplier(id);
        return "Supplier Deleted";
    }
    @GetMapping("/count")
    public long getSupplierCount(){
        return supplierService.getSupplierCount();
    }
}
