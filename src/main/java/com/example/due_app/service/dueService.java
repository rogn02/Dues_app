package com.example.due_app.service;

import java.util.List;

import com.example.due_app.model.dues;

public interface dueService {
	List<dues> getAllDues();
	void saveDue(dues due);
	dues getDueById(long id);
	void deleteDueById(long id);
	List<dues> getAllDuesByUsername(String username);
	List<dues> getAllDuesByLibraryDues(String status);
	List<dues> getAllDuesByAccountDues(String status);
	List<dues> getAllDuesNotRejected(String username);
	List<dues> getAllDuesRejected(String username);
}
