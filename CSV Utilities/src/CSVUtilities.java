import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSVUtilities {
	
	static ArrayList<String>CSVData;
	int numColumns;
	
	
	public CSVUtilities(String csv) {
		// TODO Auto-generated constructor stub
		ArrayList<String>CSVData = new ArrayList<>();
		this.CSVData = CSVData;
		Path pathToFile = Paths.get(csv);
		try(BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII))
		{
			String line = br.readLine();
			String[]test = line.split(",");
			numColumns = test.length;
			
			while(line != null)
			{
				String[]attributes = line.split(",");
				//Attribute array has different length if the value is missing
				for(int i = 0; i < attributes.length; i++)
				{
					CSVData.add(attributes[i]);
				}

				line = br.readLine();
				
			}	
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}
	}
	
	//Return an ArrayList with headers for each column
	public ArrayList<String>getColumnHeaders()
	{
		ArrayList<String>header1 = new ArrayList<>();
		for(int i = 0; i < numColumns; i ++)
		{
			header1.add(CSVData.get(i));
		}
		
		return header1;
	}
	
	//Return an ArrayList with the data for a column specified
	public ArrayList<String>getDataString(int column)
	{
		ArrayList<String>data = new ArrayList<>();
		for(int i = column; i < CSVData.size(); i += numColumns)
		{
			data.add(CSVData.get(i));
		}
		return data;
	}
	
	//Return an ArrayList with the data converted to Integer
	public List<Integer>getDataInt(int column)
	{
		ArrayList<Integer>data = new ArrayList<>();
		for(int i = column; i < CSVData.size(); i += numColumns)
		{
			int n = Integer.parseInt(CSVData.get(i));
			data.add(n);
		}
		return data;
	}
	
	//Return an ArrayList with the data converted to Double
		public List<Double>getDataDouble(int column)
		{
			ArrayList<Double>data = new ArrayList<>();
			for(int i = column; i < CSVData.size(); i += numColumns)
			{
				double n = Double.parseDouble(CSVData.get(i));
				data.add(n);
			}
			return data;
		}

}
