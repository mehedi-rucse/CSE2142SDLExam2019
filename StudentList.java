import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList 
{
	public static void main(String[] args) 
	{

//		Check arguments
		if(args.length == 0 || args.length > 1)
		{
			System.out.println("Program terminated.\nPlease Enter a valid argument");
			return;
		}

		else if(args[0].equals("a"))
		{
			System.out.println("Loading data ...");			
			try
			{
				BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt"))); 
				String reader = file.readLine();
				String input[] = reader.split(",");			
				for(String output : input) 
				{ 
					System.out.println(output);
				}
			}

			catch (Exception e)
			{

			} 

			System.out.println("Data Loaded.");
		}

		else if(args[0].equals("r")) 
		{
			System.out.println("Loading data ...");

			try 
			{
				BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt"))); 
				String reader = file.readLine();
				String input[] = reader.split(",");	
				Random random = new Random();
				int output = random.nextInt(input.length);
				System.out.println(input[output]);
			}

			catch (Exception e)
			{

			} 

			System.out.println("Data Loaded.");			
		}

		else if(args[0].contains("+"))
		{
			System.out.println("Loading data ...");	

			try
			{
				BufferedWriter file = new BufferedWriter(new FileWriter("students.txt", true));
				String text = args[0].substring(1);
	        	Date date = new Date();
	        	String dateform = "dd/mm/yyyy-hh:mm:ss a";
	        	DateFormat dateFormat = new SimpleDateFormat(dateform);
	        	String formateOfDate= dateFormat.format(date);
				file.write(", "+text+"\nList last updated on "+formateOfDate);
				file.close();
			}

			catch (Exception e)
			{

			}
							
			System.out.println("Data Loaded.");	
		}

		else if(args[0].contains("?")) 
		{
			System.out.println("Loading data ...");	

			try 
			{
				BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt"))); 
				String reader = file.readLine();
				String input[] = reader.split(",");	
				boolean done = false;
				String text = args[0].substring(1);
				for(int index = 0; index<input.length && !done; index++) 
				{
					if(input[index].equals(text))
					{
						System.out.println("We found it!");
						done=true;
					}
				}
			}

			catch (Exception e)
			{

			}

			System.out.println("Data Loaded.");				
		}

		else if(args[0].contains("c")) 
		{
			System.out.println("Loading data ...");

			try
			 {
				BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt"))); 
				String reader = file.readLine();
				char array[] = reader.toCharArray();			
				boolean in_word = false;
				int count=0;
				for(char Character:array)
				{
					if(Character ==' ') 
					{
						if (!in_word) 
						{	
							count++; in_word =true;
						}
						else 
						{ 
							in_word=false;
						}			
					}
				}

				System.out.println(count +" word(s) found ");
			} 

			catch (Exception e)
			{

			} 

			System.out.println("Data Loaded.");				
		}
	}
}