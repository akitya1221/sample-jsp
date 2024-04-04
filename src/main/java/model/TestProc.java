package model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TestProc {
	public OutputDto  TestProcess(InputDto data) {
		BigDecimal bd_bmi;
		int bmi;
	    // BMIを算出して設定
	    double weight = data.getWeight();
	    double height = data.getHeight();
	    bd_bmi = BigDecimal.valueOf(weight / (height / 100.0 * height / 100.0));
	    bd_bmi = bd_bmi.setScale(-1, RoundingMode.HALF_UP);
	    OutputDto output_data = new OutputDto();
	    bmi = bd_bmi.intValue();
	    output_data.setBmi(bmi);
	    
	    return output_data;
	}
}
