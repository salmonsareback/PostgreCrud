package com.adeo.postgreCrud.controllers;

import com.adeo.postgreCrud.exceptions.ResourceNotFoundException;
import com.adeo.postgreCrud.models.Supplier;
import com.adeo.postgreCrud.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class SupplierController {
	@Autowired
	private SupplierRepository supplierRepository;

	// get all suppliers
	@GetMapping("/suppliers")
	public List<Supplier> getAllSuppliers() {
		return supplierRepository.findAll();
	}

	// create supplier rest api
	@PostMapping("/suppliers")
	public Supplier createSupplier(@RequestBody Supplier supplier) {
		return supplierRepository.save(supplier);
	}

	// get supplier by id rest api
	@GetMapping("/suppliers/{id}")
	public ResponseEntity<Supplier> getSupplierById(@PathVariable Long id) {
		Supplier supplier = supplierRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Supplier not exist with id :" + id));
		return ResponseEntity.ok(supplier);
	}

// update supplier rest api

//	@PutMapping("/suppliers/{id}")
//	public ResponseEntity<Supplier> updateSupplier(@PathVariable Long id, @RequestBody Supplier supplierDetails){
//		Supplier supplier = supplierRepository.findById(id)
//				.orElseThrow(() -> new ResourceNotFoundException("Supplier not exist with id :" + id));
//
//		supplier.setFirstName(supplierDetails.getFirstName());
//		supplier.setLastName(supplierDetails.getLastName());
//		supplier.setEmailId(supplierDetails.getEmailId());
//
//		Supplier updatedSupplier = supplierRepository.save(supplier);
//		return ResponseEntity.ok(updatedSupplier);
//	}

	// delete supplier rest api
	@DeleteMapping("/suppliers/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteSupplier(@PathVariable Long id) {
		Supplier supplier = supplierRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Supplier not exist with id :" + id));

		supplierRepository.delete(supplier);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
