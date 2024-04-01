package model;

public class TestProc {
	public OutputDto  TestProcess(InputDto data) {
	    // BMIを算出して設定
	    double weight = data.getWeight();
	    double height = data.getHeight();
	    double bmi = weight / (height / 100.0 * height / 100.0);
	    
	    OutputDto output_data = new OutputDto();
	    output_data.setBmi(bmi);
	    
	    return output_data;
	}
}
