package jpdr.apps.bankdemo.forms;

import javax.validation.constraints.NotBlank;

public class MyDataForm {
	
	@NotBlank
	private String firstName;
	@NotBlank
	private String lastName;
	@NotBlank
	private String documentId;
		
	public MyDataForm() {
	
	}

	public MyDataForm(@NotBlank String firstName, @NotBlank String lastName, @NotBlank String documentId) {
		 
		this.firstName = firstName;
		this.lastName = lastName;
		this.documentId = documentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDocumentId() {
		return documentId;
	}

	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}

	@Override
	public String toString() {
		return "MyDataForm [firstName=" + firstName + ", lastName=" + lastName + ", documentId=" + documentId + "]";
	}
	

}
