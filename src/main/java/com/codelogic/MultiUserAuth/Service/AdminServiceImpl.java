package com.codelogic.MultiUserAuth.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codelogic.MultiUserAuth.Model.Admin;
import com.codelogic.MultiUserAuth.Repository.AdminRepository;
import com.codelogic.MultiUserAuth.exception.JobAlreadyExistsException;
import com.codelogic.MultiUserAuth.exception.JobNotFoundException;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminRepository adminRepository;
	@Override
	public Admin saveJob(Admin job) throws JobAlreadyExistsException {
		Optional<Admin> findById = this.adminRepository.findById(job.getId());
		if(findById.isPresent())
		{
			throw new JobAlreadyExistsException();
		}
		else
		{
			return this.adminRepository.save(job);
		}
		
	}

	@Override
	public Admin getJob(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getAllJobs() {
		
		return this.adminRepository.findAll();
	}

	@Override
	public Admin getJobById(long id) throws Exception {
		Optional<Admin> findById = this.adminRepository.findById(id);
		if(findById.isPresent())
		{
			return findById.get();
		}
		else
		{
			throw new Exception();
		}
	}

	@Override
	public boolean deleteJob(long id) throws Exception {
Optional<Admin> findById = this.adminRepository.findById(id);
		
		boolean status = false;
		if(findById.isPresent())
		{
			this.adminRepository.deleteById(id);
			status = true;
			
		}
		else
		{
			throw new Exception();
		}
		return status;
	}

	@Override
	public Admin updateJobById(long id, Admin admin) throws JobNotFoundException {
		Optional<Admin> existingJob = this.adminRepository.findById(id);
		//System.out.println(existingJob);
		Admin jobObj=null;
		Admin updateJobObj=null;
		
		if(existingJob.isPresent())
		{
			//System.out.println(jobObj);
			jobObj = existingJob.get();
			//System.out.println(jobObj);

			//jobObj.setId(admin.getId());
			//System.out.println(jobObj);
			jobObj.setName(admin.getName());
			jobObj.setEmail(admin.getEmail());
			jobObj.setJob(admin.getJob());
			
			updateJobObj = this.adminRepository.save(jobObj);
			return updateJobObj;
		}	
		else
		{
			throw new JobNotFoundException();
		}
	}
}
