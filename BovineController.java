package com.poc.aim.controller;

import com.poc.aim.exception.ResourceNotFoundException;
import com.poc.aim.model.Bovine;
import com.poc.aim.repository.BovineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/bovine")
public class BovineController {

	@Autowired
	private BovineRepository bovineRepository;

	@GetMapping
	public ResponseEntity<List<Bovine>> getAllBovine() {
		return ResponseEntity.ok(bovineRepository.findAll());
	}

	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Bovine> getBovineById(@PathVariable(value = "id") Long bovineId)
			throws ResourceNotFoundException {
		Bovine bovine = bovineRepository.findById(bovineId)
				.orElseThrow(() -> new ResourceNotFoundException("Bovine not found for this id :: " + bovineId));
		return ResponseEntity.ok().body(bovine);
	}

	@PostMapping
	public Bovine createBovine(@Valid @RequestBody Bovine bovine) {
		return bovineRepository.save(bovine);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Bovine> updateBovine(@PathVariable(value = "id") Long bovineId,
                                               @Valid @RequestBody Bovine bovineDetails) throws ResourceNotFoundException {
		Bovine bovine = bovineRepository.findById(bovineId)
				.orElseThrow(() -> new ResourceNotFoundException("Bovine not found for this id :: " + bovineId));

		bovine.setThirdParty(bovineDetails.getThirdParty());
		bovine.setMovedTo(bovineDetails.getMovedTo());
		bovine.setMovedFrom(bovineDetails.getMovedFrom());
		final Bovine updatedBovine = bovineRepository.save(bovine);
		return ResponseEntity.ok(updatedBovine);
	}

	@DeleteMapping("/{id}")
	public Map<String, Boolean> deleteBovine(@PathVariable(value = "id") Long bovineId)
			throws ResourceNotFoundException {
		Bovine bovine = bovineRepository.findById(bovineId)
				.orElseThrow(() -> new ResourceNotFoundException("Bovine not found for this id :: " + bovineId));

		bovineRepository.delete(bovine);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
