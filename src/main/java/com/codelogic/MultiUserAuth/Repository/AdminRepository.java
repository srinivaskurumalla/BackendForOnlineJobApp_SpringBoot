package com.codelogic.MultiUserAuth.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codelogic.MultiUserAuth.Model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long>{

}
