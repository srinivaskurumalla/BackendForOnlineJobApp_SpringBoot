package com.codelogic.MultiUserAuth.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codelogic.MultiUserAuth.Model.AppliedJobs;
import com.codelogic.MultiUserAuth.Repository.AppliedJobsRepository;
import com.codelogic.MultiUserAuth.exception.CannotApplyJob;
import com.codelogic.MultiUserAuth.exception.JobAlreadyExistsException;
@Service
public class AppliedJobsServiceImpl implements AppliedJobsService{

	@Autowired
	private AppliedJobsRepository appliedJobsRepository;
	
	@Override
	public List getAllAppliedJobs() {
		return appliedJobsRepository.findAll();
	}

	@Override
	public AppliedJobs saveJob(AppliedJobs appliedJob) throws CannotApplyJob {
		Optional<AppliedJobs> findById = this.appliedJobsRepository.findById(appliedJob.getId());
		if(findById.isPresent())
		{
			throw new CannotApplyJob();
		}
		else
		{
			return this.appliedJobsRepository.save(appliedJob);
		}
	}

}
