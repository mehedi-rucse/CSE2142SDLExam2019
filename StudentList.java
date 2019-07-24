import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList 
{
	public static void main(String[] args) 
	{

		Constants constant = new Constants();

//		Check arguments
		if(args.length == 0 || args.length > 1)
		{
			System.out.println("Program terminated.\nPlease Enter a valid argument");
			return;
		}

		else if(args[0].equals(constant.showAll))
		{
			System.out.println(constant.dLoading);			
			try
			{
				String reader = loadData(constant.studentList);
				String input[] = reader.split(constant.StudentEntryDelimite);			
				for(String output : input) 
				{ 
					System.out.println(output);
				}
			}

			catch (Exception e)
			{

			} 

			System.out.println(constant.dLoaded);
		}

		else if(args[0].equals(constant.showRandom)) 
		{
			System.out.println(constant.dLoading);

			try 
			{
				String reader = loadData(constant.studentList);
				String input[] = reader.split(constant.StudentEntryDelimite);
				Random random = new Random();
				int output = random.nextInt(input.length);
				System.out.println(input[output]);
			}

			catch (Exception e)
			{

			} 

			System.out.println(constant.dLoaded);			
		}

		else if(args[0].contains(constant.addEntry))
		{
			System.out.println(constant.dLoading);	

			try
			{
				BufferedWriter file = new BufferedWriter(new FileWriter(constant.studentList, true));
				String text = args[0].substring(1);
	        	Date date = new Date();
	        	DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy-hh:mm:ss a");
	        	String formateOfDate= dateFormat.format(date);
				file.write(", "+text+"\nList last updated on "+formateOfDate);
				file.close();
			}

			catch (Exception e)
			{

			}
							
			System.out.println(constant.dLoaded);	
		}

		else if(args[0].contains(constant.findEntry)) 
		{
			System.out.println(constant.dLoading);	

			try 
			{
				String reader = loadData(constant.studentList);
				String input[] = reader.split(constant.StudentEntryDelimite);	
				String text = args[0].substring(1);
				int index1=-1;
				for(int index = 0; index<input.length; index++) 
				{
					if(input[index].equals(text))
					{
						index1 = index ;
						break;
					}
				}
				if(index1 >= 0)
				{
					System.out.println("Entry " + text +" found in index " + index1);
				}
				else
				{
					System.out.println("Entry " + text +" does not exist ");
				}
			}

			catch (Exception e)
			{

			}

			System.out.println(constant.dLoaded);				
		}

		else if(args[0].contains(constant.showCount)) 
		{
			System.out.println(constant.dLoading);

			try
			 {
				String reader = loadData(constant.studentList);
				String input[] = reader.split(constant.StudentEntryDelimite);
				System.out.println(input.length +" word(s) found " );
			} 

			catch (Exception e)
			{

			} 

			System.out.println(constant.dLoaded);				
		}
		
		else
		{
			try
			{
				System.out.println("Invalid Arguments");
				return;
			}
			catch (Exception e)
			{

			}
		}
	}


	

	public static String loadData(String filename)
	{
		try
		{
			BufferedReader fileStream = new BufferedReader(new InputStreamReader(new FileInputStream(filename))); 
			String line = fileStream.readLine();
			return line;
		}
		catch(Exception e)
		{

		}
		return "";
	}

}