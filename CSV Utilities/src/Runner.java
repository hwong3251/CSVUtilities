import java.util.ArrayList;

public class Runner {

	public static void main(String[] args)
	{
		CSVUtilities test1 = new CSVUtilities("NYC_Social_Media_Usage.csv");

		ArrayList<String>header = test1.getColumnHeaders();
		ArrayList<String>data = test1.getDataString(1);
		ArrayList<Integer>data2 = test1.getDataInt(1);
		ArrayList<Double>data3 = test1.getDataDouble(1);
		
		/*
		for(String n : test1.CSVData)
		{
			System.out.println(n);
		}
		
		for (String x : header)
		{
			System.out.println(x);
		}
		
		*/
		for (String y : data)
		{
			System.out.println(y);
		}
		for (Integer q : data2)
		{
			System.out.println(q);
		}
		for (Double w : data3)
		{
			System.out.println(w);
		}
		
	}
}
