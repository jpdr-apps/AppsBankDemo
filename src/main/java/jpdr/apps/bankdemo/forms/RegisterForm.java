package jpdr.apps.bankdemo.forms;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import jpdr.apps.bankdemo.forms.validation.ValidateClassEqualToStringsFields;
import jpdr.apps.bankdemo.forms.validation.ValidateUsernameNotExists;
import jpdr.apps.bankdemo.forms.validation.groups.RegisterFormFirst;
import jpdr.apps.bankdemo.forms.validation.groups.RegisterFormSecond;



@ValidateClassEqualToStringsFields.List({
	@ValidateClassEqualToStringsFields(
			fieldBase =  "passwordRepeat", 
			fieldMatch = "password",groups = RegisterFormFirst.class)
})

public class RegisterForm {

	@NotBlank
	private String firstName;
	@NotBlank
	private String lastName;
	@NotBlank
	private String documentId;
	@Size(min=6, max=20)
	@ValidateUsernameNotExists(groups = RegisterFormSecond.class)
	private String username;
	@Size(min=6, max=20)
	private String password;	
	private String passwordRepeat;	
	
	public RegisterForm() {
	
	}

 
	public RegisterForm(String firstName, String lastName, String documentId, String username, String password,
			String passwordRepeat) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.documentId = documentId;
		this.username = username;
		this.password = password;
		this.passwordRepeat = passwordRepeat;
	}






	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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






	public String getPasswordRepeat() {
		return passwordRepeat;
	}






	public void setPasswordRepeat(String passwordRepeat) {
		this.passwordRepeat = passwordRepeat;
	}






	@Override
	public String toString() {
		return "LoginForm [firstName=" + firstName + ", lastName=" + lastName + ", documentId=" + documentId
				+ ", username=" + username + ", password=" + password + ", passwordRepeat=" + passwordRepeat + "]";
	}


}
