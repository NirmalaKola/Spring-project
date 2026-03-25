package com.sathya.rest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailResponse {
	
		private String receiverMail;
		private String senderMail;
		private String status;
		private String message;
		
		
	
}
