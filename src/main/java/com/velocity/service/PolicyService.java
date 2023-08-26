package com.velocity.service;

import java.util.List;

import com.velocity.model.Policy;

public interface PolicyService {

	List<Policy> getAll();

	void create(Policy policy);

	void update(Long id, Policy policy);

	void delete(Long id);

	Policy getPolicyData(Integer age, String name);
}
