package jpdr.apps.bankdemo.entities.keys;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

@Embeddable
public class LoanPaymentsId implements Serializable{
	
	/**
	 *
	 */
	@Transient
	private static final long serialVersionUID = 3448368323750201846L;
	
	@Column(name = "loan_id")
	private int loanId;
	@Column(name = "payment_id")
	private int paymentId;
	
	public LoanPaymentsId() {	
	}
	
	public LoanPaymentsId(int loanId, int paymentId) {
	
		this.loanId = loanId;
		this.paymentId = paymentId;
	}
	public int getLoanId() {
		return loanId;
	}
	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	@Override
	public String toString() {
		return "LoanPaymentsId [loanId=" + loanId + ", paymentId=" + paymentId + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(loanId, paymentId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoanPaymentsId other = (LoanPaymentsId) obj;
		return loanId == other.loanId && paymentId == other.paymentId;
	}
	

}
