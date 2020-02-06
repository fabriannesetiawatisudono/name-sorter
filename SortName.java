import java.io.File;
import java.util.Scanner;
import java.io.FileWriter;
import java.util.Comparator;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.util.Collections;
import java.io.IOException;
import java.io.FileNotFoundException;


public class SortName {
	public ArrayList<String> sortLastName(ArrayList<String> name_x) 
	{
		Collections.sort(name_x, new Comparator<String>() 
		{
			@Override
			public int compare(String name1, String name2) 
			{
				String[] splitName1 = name1.split(" ");
				String[] splitName2 = name2.split(" ");
				String last_name1 = splitName1[1];
				String last_name2 = splitName2[1];
				if (last_name1.compareTo(last_name2) > 0) 
				{
					return 1;
				} 
				else 
				{
					return -1;
				}
			}
		});
		return name_x;
	}

	
  public static void writeFile(ArrayList<String> name_x) throws IOException
	{
		String path = System.getProperty("user.dir");
		String SEPARATOR = System.getProperty("file.separator");
		FileWriter fileWriter = new FileWriter(path + SEPARATOR + "sorted-names-list.txt");
		PrintWriter printWriter = new PrintWriter(fileWriter);
		for (String str: name_x) 
		{
			printWriter.println(str);
		}
		printWriter.close();
	}

	public ArrayList<String> readFile(String args)
	{
		ArrayList<String> nameList = new ArrayList<String>();
		try 
		{
			String path = System.getProperty("user.dir");
			String SEPARATOR = System.getProperty("file.separator");
			Scanner scanner = new Scanner(new File(path + SEPARATOR + args));
			while (scanner.hasNextLine()) 
			{
         			nameList.add(scanner.nextLine());
			}
			scanner.close();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		return nameList;
	}

	public static void main(String[] args) 
	{
		ArrayList<String> unsorted-names;
		ArrayList<String> sorted-names;
		SortName obj = new SortName();
		unsorted-names = obj.readFile(args[0]);
		sorted-names = obj.sortLastName(unsorted-names);

	    try 
	    {
			SortName.writeFile(sorted-names);
	    }
	    
	    catch (IOException e) 
	    {
			e.printStackTrace();
	    }
	    for (int a = 0; a < sorted-names.size(); a++) 
	    {
			System.out.println(sorted-names.get(a));
	    }
	}
}
