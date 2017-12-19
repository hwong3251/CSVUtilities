import java.util.ArrayList;

public class Runner {

	public static void main(String[] args)
	{
		CSVUtilities test1 = new CSVUtilities("Bus_Breakdown_and_Delays.csv");
		ArrayList<String>header = test1.getColumnHeaders();
		for (String x : header)
		{
			System.out.println(x);
		}
	}
}
