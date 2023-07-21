package com.codelogic.MultiUserAuth.Service;

import java.util.List;

import com.codelogic.MultiUserAuth.Model.Admin;
import com.codelogic.MultiUserAuth.exception.JobAlreadyExistsException;
import com.codelogic.MultiUserAuth.exception.JobNotFoundException;

public interface AdminService {
	Admin saveJob(Admin admin) throws JobAlreadyExistsException;
	Admin getJob(long id);
	List getAllJobs();
	Admin getJobById(long id) throws Exception;
	boolean deleteJob(long id) throws Exception;

	Admin updateJobById(long id, Admin admin) throws JobNotFoundException;
	
}
