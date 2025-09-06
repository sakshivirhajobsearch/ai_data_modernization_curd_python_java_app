package com.ai.data.modernization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ai.data.modernization.data.Data;
import com.ai.data.modernization.service.DataService;

import java.util.List;

@RestController
@RequestMapping("/api/data")
public class DataController {

	@Autowired
	private DataService dataService;

	@GetMapping
	public List<Data> getAllData() {
		return dataService.getAllData();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Data> getDataById(@PathVariable Long id) {
		Data data = dataService.getDataById(id)
				.orElseThrow(() -> new RuntimeException("Data not found with ID: " + id));
		return ResponseEntity.ok(data);
	}

	@PostMapping
	public ResponseEntity<Data> createData(@RequestBody Data data) {
		Data savedData = dataService.saveData(data);
		return ResponseEntity.ok(savedData);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Data> updateData(@PathVariable Long id, @RequestBody Data updatedData) {
		Data existingData = dataService.getDataById(id)
				.orElseThrow(() -> new RuntimeException("Data not found with ID: " + id));

		// Update the fields
		existingData.setName(updatedData.getName());
		existingData.setValue(updatedData.getValue());

		Data savedData = dataService.saveData(existingData);
		return ResponseEntity.ok(savedData);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteData(@PathVariable Long id) {
		dataService.deleteData(id);
		return ResponseEntity.noContent().build();
	}
}