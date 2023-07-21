package com.codelogic.MultiUserAuth.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codelogic.MultiUserAuth.Model.AppliedJobs;

public interface AppliedJobsRepository extends JpaRepository<AppliedJobs, Long>{

	//AppliedJobs save(AppliedJobs appliedJobs);

}
