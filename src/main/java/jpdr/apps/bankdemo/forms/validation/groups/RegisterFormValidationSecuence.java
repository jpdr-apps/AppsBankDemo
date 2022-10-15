package jpdr.apps.bankdemo.forms.validation.groups;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

@GroupSequence({Default.class, RegisterFormFirst.class, RegisterFormSecond.class})
public interface RegisterFormValidationSecuence {

}
