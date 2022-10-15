package jpdr.apps.bankdemo.forms;
 
import java.util.TreeMap;

public class SettingsForm {
	
	private String language;
	//private TreeMap<String, String> possibleLanguages;
	
	public SettingsForm() {	
//		this.possibleLanguages = new TreeMap<String, String>();
//		this.possibleLanguages.put("esp", "Español");		
//		this.possibleLanguages.put("eng", "English");
	}

	public SettingsForm(String language) {		
		this.language = language;
//		this.possibleLanguages = new TreeMap<String, String>();
//		this.possibleLanguages.put("esp", "Español");		
//		this.possibleLanguages.put("eng", "English");
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Override
	public String toString() {
		return "SettingsForm [language=" + language + "]";
	}

	
 
}
