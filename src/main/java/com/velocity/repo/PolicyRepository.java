package com.velocity.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.velocity.model.Policy;

//@Repository
public interface PolicyRepository extends JpaRepository<Policy, Long> {

	@Query(value = "select * from policy where policy_age =?1 and policy_name =?2", nativeQuery = true)
	Policy getPolicyByAgeAndName(Integer age, String name);

}
