package jpdr.apps.bankdemo.forms;

public class SettingsFormLanguage {
	
	private String languageValue;
	private String languageLabel;
	
	public SettingsFormLanguage() {
	
	}

	public SettingsFormLanguage(String languageValue, String languageLabel) {
		 
		this.languageValue = languageValue;
		this.languageLabel = languageLabel;
	}

	public String getLanguageValue() {
		return languageValue;
	}

	public void setLanguageValue(String languageValue) {
		this.languageValue = languageValue;
	}

	public String getLanguageLabel() {
		return languageLabel;
	}

	public void setLanguageLabel(String languageLabel) {
		this.languageLabel = languageLabel;
	}

	@Override
	public String toString() {
		return "SettingsFormLanguage [languageValue=" + languageValue + ", languageLabel=" + languageLabel + "]";
	}
	
	

}
