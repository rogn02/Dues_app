package com.example.due_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.due_app.model.dues;

import com.example.due_app.service.dueService;

@Controller
public class dueController {
	
	@Autowired
	private dueService DueService;
	
	// Display list of dues for an id
	@GetMapping("/UserData/{username}")
	public String viewDataPage(@PathVariable ( value = "username") String username, Model model) {
		//model.addAttribute("listDues", DueService.getAllDuesByUsername(username));
		model.addAttribute("listDues", DueService.getAllDuesNotRejected(username));
		model.addAttribute("listDuesRejected", DueService.getAllDuesRejected(username));
		return "data";
	}
	
	@GetMapping("/showNewDueForm")
	public String showNewDueForm(Model model) {
		// Create model attribute to bind form data
		 dues Due = new dues();
		 model.addAttribute("dues", Due);
		 return "new_due";
	} 
	
	@PostMapping("/saveDue")
	public String saveDue(@ModelAttribute("dues") dues Due){
		// Save due to database
		Due.setAccountsStatus("Pending");
		Due.setLibraryStatus("Pending");
		Due.setCertified("No");
		
		DueService.saveDue(Due);
		return "redirect:/";
		
	}
	
	@GetMapping("/LibraryVerification")
	public String LibraryVerification(Model model) {
		model.addAttribute("listLibraryDues", DueService.getAllDuesByLibraryDues("pending"));
		return "verification_library";
	}
	
	@GetMapping("/libraryApprove/{id}")
	public String libraryApprove(@PathVariable ( value = "id") long id, Model model) {
		dues Due = DueService.getDueById(id);
		Due.setLibraryStatus("Approved");
		if(Due.getAccountsStatus().equals("Approved")) {
			Due.setCertified("Yes");
		}
		DueService.saveDue(Due);
		return "redirect:/LibraryVerification";
	}
	
	@GetMapping("/libraryReject/{id}")
	public String libraryReject(@PathVariable ( value = "id") long id, Model model) {
		dues Due = DueService.getDueById(id);
		Due.setLibraryStatus("Rejected");
		Due.setCertified("Rejected");
		DueService.saveDue(Due);
		return "redirect:/LibraryVerification";
	}
	
	@GetMapping("/AccountsVerification")
	public String AccountsVerification(Model model) {
		model.addAttribute("listAccountsDues", DueService.getAllDuesByAccountDues("pending"));
		return "verification_accounts";
	}
	
	@GetMapping("/accountsApprove/{id}")
	public String accountsApprove(@PathVariable ( value = "id") long id, Model model) {
		dues Due = DueService.getDueById(id);
		Due.setAccountsStatus("Approved");
		if(Due.getLibraryStatus().equals("Approved")) {
			Due.setCertified("Yes");
		}
		DueService.saveDue(Due);
		return "redirect:/AccountsVerification";
	}
	
	@GetMapping("/accountsReject/{id}")
	public String accountsReject(@PathVariable ( value = "id") long id, Model model) {
		dues Due = DueService.getDueById(id);
		Due.setAccountsStatus("Rejected");
		Due.setCertified("Rejected");
		DueService.saveDue(Due);
		return "redirect:/AccountsVerification";
	}
	
	
	
//	@GetMapping("/showFormForUpdate/{id}")
//	public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
//		dues Due = DueService.getDueById(id);
//		
//		//set data as model attribute to pre poppulate form
//		model.addAttribute("dues", Due);
//		return "update_employee";
//	}
	
	@GetMapping("/deleteDue/{id}")
	public String deleteDue(@PathVariable ( value = "id") long id) {
		
		//call deleter due method
		this.DueService.deleteDueById(id);
		return "redirect:/";
	}
}
