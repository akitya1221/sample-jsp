package model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class OutputDto {
	private double bmi;
	private BigDecimal bd_bmi;
	
	public void setBmi(Double bmi) {
		bd_bmi = BigDecimal.valueOf(bmi).setScale(-1, RoundingMode.HALF_UP);
		bmi = bd_bmi.doubleValue();
	    this.bmi = bmi;
	  }

	  public double getBmi() {
	    return this.bmi;
	  }
}
