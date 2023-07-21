package com.codelogic.MultiUserAuth.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codelogic.MultiUserAuth.Model.Admin;
import com.codelogic.MultiUserAuth.Service.AdminService;
import com.codelogic.MultiUserAuth.exception.JobAlreadyExistsException;
import com.codelogic.MultiUserAuth.exception.JobNotFoundException;

@RestController
@RequestMapping("admin")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/postJob")
	public ResponseEntity<Admin> saveUserToDB(@RequestBody Admin admin)
	{
		try
		{
			Admin saveJob = this.adminService.saveJob(admin);
			return new ResponseEntity<>(saveJob, HttpStatus.CREATED);
		}
		catch(JobAlreadyExistsException re)
		{
			return new ResponseEntity<Admin>( HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/getAllJobs")
	
	public ResponseEntity<?> getAllJobs()
	{
		try
		{
			 List allUsers = this.adminService.getAllJobs();
			 return new ResponseEntity<>(allUsers, HttpStatus.OK);

		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getJob/{jobid}")
	public ResponseEntity<?> getJobById(@PathVariable("jobid") Long id)
	{
		try
		{
			Admin admin = this.adminService.getJobById(id);
			return new ResponseEntity<>(admin, HttpStatus.OK);
		
		}
		catch(Exception e)
		{
			return new ResponseEntity<>("job not found with id :"+id, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/deleteJob/{jobid}")
	public ResponseEntity<Admin> deleteUserFromDB(@PathVariable("jobid") long id)
	{
		try
		{
			boolean deleteUser = this.adminService.deleteJob(id);
			if(deleteUser)
			{
				return new ResponseEntity<Admin>(HttpStatus.OK);

			}
			else
			{
				return null;
			}
		}
		catch(Exception e)
		{
			return new ResponseEntity<Admin>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
		
	}
	
	
@PutMapping("/updateJob/{Id}")
	
	public ResponseEntity<?> updateJobByIdToDB(@PathVariable("Id") long jobId,@RequestBody Admin admin)
	{
		
		try
		{
			Admin updateStudentById = this.adminService.updateJobById(jobId, admin);
			return new ResponseEntity<>(updateStudentById, HttpStatus.CREATED);
		}
		catch(JobNotFoundException snfe)
		{
			return new ResponseEntity<>("Error While updating data", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


}
