package com.example.due_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.due_app.model.dues;
import com.example.due_app.repository.dueRepository;

@Service
public class dueServiceImpl implements dueService{
	
	@Autowired
	private dueRepository DueRepository;
	
	@Override
	public List<dues> getAllDues() {
		return DueRepository.findAll();
	}

	@Override
	public void saveDue(dues Due) {
		this.DueRepository.save(Due);		
	}

	@Override
	public dues getDueById(long id) {
		Optional<dues> optional = DueRepository.findById(id);
		dues Due = null;
		if(optional.isPresent()) {
			Due = optional.get();
		} else {
			throw new RuntimeException("Bill not found for id :: " + id);
		}
		return Due;
	}

	@Override
	public void deleteDueById(long id) {
		this.DueRepository.deleteById(id);
	}

	@Override
	public List<dues> getAllDuesByUsername(String username) {
		return DueRepository.findByUsername(username);
	}

	@Override
	public List<dues> getAllDuesByLibraryDues(String status) {
		return DueRepository.findByLibraryStatus(status);
	}
	
	@Override
	public List<dues> getAllDuesByAccountDues(String status) {
		return DueRepository.findByAccountsStatus(status);
	}

	@Override
	public List<dues> getAllDuesNotRejected(String username) {
		return DueRepository.findByUsernameAndCertifiedNot(username, "Rejected");
	}

	@Override
	public List<dues> getAllDuesRejected(String username) {
		return DueRepository.findByUsernameAndCertified(username, "Rejected");
	}
	
}
