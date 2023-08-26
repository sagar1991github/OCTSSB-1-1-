package com.velocity.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.velocity.exception.ErrorCodes;
import com.velocity.exception.ResourceNotFoundException;
import com.velocity.model.Policy;
import com.velocity.repo.PolicyRepository;

@Service
public class PolicyServiceImpl implements PolicyService {

	@Autowired
	private PolicyRepository policyRepository;

	@Override
	public List<Policy> getAll() {
		// TODO Auto-generated method stub
		return (List<Policy>) policyRepository.findAll();
	}

	@Override
	public void create(Policy policy) {
		policyRepository.save(policy);
	}

	@Override
	public void update(Long id, Policy policy) {

		Optional<Policy> policyData = policyRepository.findById(id);
		if (policyData.isPresent()) {
			Policy existingPolicy = policyData.get();
			existingPolicy.setPolicyName(policy.getPolicyName());
			existingPolicy.setPolicyAge(policy.getPolicyAge());
			existingPolicy.setPolicyDesc(policy.getPolicyDesc());
			policyRepository.save(existingPolicy);
		} else {
			throw new ResourceNotFoundException(ErrorCodes.DATA_NOT_FOUND.getCode(),
					ErrorCodes.DATA_NOT_FOUND.getMessage());
		}
	}

	@Override
	public void delete(Long id) {
		policyRepository.deleteById(id);
	}

	@Override
	public Policy getPolicyData(Integer age, String name) {
		return policyRepository.getPolicyByAgeAndName(age, name);

	}

}
