package com.codelogic.MultiUserAuth.Service;

import java.util.List;

import com.codelogic.MultiUserAuth.Model.AppliedJobs;
import com.codelogic.MultiUserAuth.exception.CannotApplyJob;
import com.codelogic.MultiUserAuth.exception.JobAlreadyExistsException;

public interface AppliedJobsService {
	List getAllAppliedJobs();
	AppliedJobs saveJob(AppliedJobs appliedJob) throws CannotApplyJob;
}
