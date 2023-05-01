package com.example.due_app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.due_app.model.dues;

@Repository
public interface dueRepository extends JpaRepository<dues, Long>{
	List<dues> findByUsername(@Param("username") String username);
	List<dues> findByLibraryStatus(@Param("libraryStatus") String status);
	List<dues> findByAccountsStatus(@Param("AccountsStatus") String status);
	List<dues> findByUsernameAndCertifiedNot(String username,String status);
	List<dues> findByUsernameAndCertified(String username, String status);
}
