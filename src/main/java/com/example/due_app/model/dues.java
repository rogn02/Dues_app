package com.example.due_app.model;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;



//import java.text.SimpleDateFormat;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.text.DateFormat;
//import java.text.ParseException;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "dues")
public class dues {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String username;
	private String name;
	private String SRN;
	private String accountsStatus; // Denied Approved Pending
	private String libraryStatus; // Denied Approved Pending
	private String certified; //Yes No
	private Date DateSubmitted;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSRN() {
		return SRN;
	}
	public void setSRN(String sRN) {
		SRN = sRN;
	}
	public String getAccountsStatus() {
		return accountsStatus;
	}
	public void setAccountsStatus(String accountsStatus) {
		this.accountsStatus = accountsStatus;
	}
	public String getLibraryStatus() {
		return libraryStatus;
	}
	public void setLibraryStatus(String libraryStatus) {
		this.libraryStatus = libraryStatus;
	}
	public String getCertified() {
		return certified;
	}
	public void setCertified(String certified) {
		this.certified = certified;
	}
	public String getDateSubmitted() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
		LocalDateTime now = LocalDateTime.now();
		String formattedDate = dtf.format(now);
		try {
			formattedDate = new SimpleDateFormat("dd/mm/YYYY").format(this.DateSubmitted);
		} catch (Exception e) {
		
		}
		return formattedDate;
	}
	public void setDateSubmitted(Date dateSubmitted) {
		DateSubmitted = dateSubmitted;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	private long id;
//	private String bill_id;
//	private String domain;
//	private String description;
//	private float amount;
//	private Date dueDate;
//	private String status;
//	
//	public long getId() {
//		return id;
//	}
//	public void setId(long id) {
//		this.id = id;
//	}
//	public String getBill_id() { 
//		return bill_id;
//	}
//	public void setBill_id(String bill_id) {
//		this.bill_id = bill_id;
//	}
//	public String getDomain() {
//		return domain;
//	}
//	public void setDomain(String domain) {
//		this.domain = domain;
//	}
//	public String getDescription() {
//		return description;
//	}
//	public void setDescription(String description) {
//		this.description = description;
//	}
//	public float getAmount() {
//		return amount;
//	}
//	public void setAmount(float amount) {
//		this.amount = amount;
//	}
//
//	public void setDueDate(String dueDate) {
//		DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
//		Date dueDateF = null;
//		try {
//			dueDateF = formatter.parse(dueDate);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		this.dueDate = dueDateF	;
////	    String date = formatter.format(new Date());
////		if(dueDate.compareTo(date) <= 0) {
////			this.status = "Pending";
////		} else {
////			this.status = "Late";
////		}
//	}
//	
//	// TODO Get current data and convert to string 
//	public String getDueDate() {
//		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
//		LocalDateTime now = LocalDateTime.now();
//		String formattedDate = dtf.format(now);
//		try {
//			formattedDate = new SimpleDateFormat("yyyy-mm-dd").format(this.dueDate);
//		} catch (Exception e) {
//		
//		}
//		return formattedDate;
//	}
//	public String getStatus() {
//		return status;
//	}
//	
//	
//	public void setStatus(String status) {
//		this.status = status;
////		Date cur = new Date();
////		System.out.println(this.dueDate);
////		if(this.dueDate.compareTo(cur) < 0) {x
////			this.status = "Late";
////		} else {
////			this.status = "Pending";
////		}
//	}
}
