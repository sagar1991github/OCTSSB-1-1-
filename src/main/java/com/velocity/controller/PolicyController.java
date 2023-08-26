package com.velocity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.velocity.model.Policy;
import com.velocity.service.PolicyService;

@RestController
@RequestMapping("/policy")
public class PolicyController {

	@Autowired
	private PolicyService policyService;

	@GetMapping("/getAll")
	public ResponseEntity<List<Policy>> getAllPolicy() {
		return new ResponseEntity<List<Policy>>(policyService.getAll(), HttpStatus.OK);
	}

	@PostMapping("/create-policy")
	public ResponseEntity<Void> createPolicy(@RequestBody Policy policy) {
		policyService.create(policy);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@PutMapping("/update-policy/{id}")
	public ResponseEntity<Void> updatePolicy(@PathVariable("id") Long id, @RequestBody Policy policy) {
		policyService.update(id, policy);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@DeleteMapping("/delete-policy/{id}")
	public ResponseEntity<Void> deletePolicy(@PathVariable Long id) {
		policyService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/get")
	public ResponseEntity<Policy> getPolicyAsPerData(@RequestParam Integer age, @RequestParam String name) {
		return new ResponseEntity<Policy>(policyService.getPolicyData(age, name), HttpStatus.OK);
	}

}
