package com.codelogic.MultiUserAuth.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codelogic.MultiUserAuth.Model.AppliedJobs;
import com.codelogic.MultiUserAuth.Service.AppliedJobsService;
import com.codelogic.MultiUserAuth.exception.CannotApplyJob;

@RestController
@RequestMapping("appliedJobs")
@CrossOrigin(origins = "http://localhost:4200")
public class AppliedJobsController {

	@Autowired
	private AppliedJobsService appliedJobsService;
	
	@PostMapping("/appliedJob")
	public ResponseEntity<AppliedJobs> savejobToDB(@RequestBody AppliedJobs appliedJobs) 
	{
		try
		{
			AppliedJobs appliedJob = this.appliedJobsService.saveJob(appliedJobs);
			return new ResponseEntity<AppliedJobs>(appliedJob, HttpStatus.CREATED);
		}
		catch(Exception re)
		{
			return new ResponseEntity<AppliedJobs>( HttpStatus.BAD_GATEWAY);
		}
		
	}
	
@GetMapping("/getAllAppliedJobs")
	
	public ResponseEntity<?> getAllAppliedJobs()
	{
		try
		{
			 List allAppliedJobs = this.appliedJobsService.getAllAppliedJobs();
			 return new ResponseEntity<>(allAppliedJobs, HttpStatus.OK);

		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
