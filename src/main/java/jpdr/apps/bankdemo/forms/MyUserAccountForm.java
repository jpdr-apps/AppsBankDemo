package jpdr.apps.bankdemo.forms;

import javax.validation.constraints.Size;

import jpdr.apps.bankdemo.forms.validation.ValidateClassEqualToStringsFields;
import jpdr.apps.bankdemo.forms.validation.ValidateCurrentPassword;
import jpdr.apps.bankdemo.forms.validation.ValidateUsernameNotExists;
import jpdr.apps.bankdemo.forms.validation.groups.RegisterFormFirst;
import jpdr.apps.bankdemo.forms.validation.groups.RegisterFormSecond;

@ValidateClassEqualToStringsFields.List({
	@ValidateClassEqualToStringsFields(
			fieldBase =  "newPasswordRepeat", 
			fieldMatch = "newPassword",groups = RegisterFormFirst.class)
})
public class MyUserAccountForm{
	
	@Size(min=6, max=20)
	@ValidateUsernameNotExists(groups = RegisterFormSecond.class)
	private String username;
	
	@ValidateCurrentPassword
	private String currentPassword;
	
	@Size(min=6, max=20)
	private String newPassword;
	
	private String newPasswordRepeat;
	
	public MyUserAccountForm() {
	
	}

	public MyUserAccountForm(@Size(min = 6, max = 20) String username, String currentPassword,
			@Size(min = 6, max = 20) String newPassword, String newPasswordRepeat) {
		super();
		this.username = username;
		this.currentPassword = currentPassword;
		this.newPassword = newPassword;
		this.newPasswordRepeat = newPasswordRepeat;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCurrentPassword() {
		return currentPassword;
	}

	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getNewPasswordRepeat() {
		return newPasswordRepeat;
	}

	public void setNewPasswordRepeat(String newPasswordRepeat) {
		this.newPasswordRepeat = newPasswordRepeat;
	}

	@Override
	public String toString() {
		return "MyUserAccountForm [username=" + username + ", currentPassword=" + currentPassword + ", newPassword="
				+ newPassword + ", newPasswordRepeat=" + newPasswordRepeat + "]";
	}
	
	

}
