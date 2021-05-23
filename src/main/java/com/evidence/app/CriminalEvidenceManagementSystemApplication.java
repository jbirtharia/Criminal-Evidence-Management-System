package com.evidence.app;

import com.evidence.app.contants.Constants;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author JayendraB
 * @createdOn 5/13/2021
 */
@SpringBootApplication
public class CriminalEvidenceManagementSystemApplication {

	/**
	 * The entry point of application.
	 *
	 * @param args the input arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(CriminalEvidenceManagementSystemApplication.class, args);
	}

}
