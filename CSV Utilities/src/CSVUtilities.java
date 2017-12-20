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
			
			while(line != null)
			{
				String[]attributes = line.split(",");
				for(int i = 0; i < attributes.length; i++)
				{
					CSVData.add(attributes[i]);
				}

				line = br.readLine();
				numColumns = attributes.length;
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

}
