import java.util.Scanner;
import java.io.File;
	

public class Schoolsearch {
	
	public static void main(String[] args) {
	
	String option, arg;
	int argint;
	long time;
	Scanner sc = null;
	Scanner input = new Scanner(System.in);
	//Load file
	java.util.LinkedList<Students> list = new java.util.LinkedList<Students>();
		try
		{
		sc = new Scanner(new File("students.txt"));
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			input.close();
			return;
		}
		
		//File parsing
		sc.useDelimiter(",|\\n");
	  while(sc.hasNext())
		{
			list.addLast(new Students(sc.next(), sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.next(), sc.next()));
		}
		sc.close();
		
		do {
		//Option selection
		System.out.println("Search by:\n[B[us]]\n-S[tudent]:\t<lastname>\n-T[eacher]:\t<lastname>\n-C[lassroom]:\t<number>\n-B[us]:\t<number>\n-Q[uit]");
		input.reset();
		option = input.next();
		time = System.currentTimeMillis();		
		switch(option.charAt(0))
		{
			case 'B':
				if(!input.hasNextInt() && input.next().charAt(0) == 'S')
				{
				 //Student bus search
				 arg = input.next();
				 System.out.println(String.format("%-" + 30 + "s%-" + 15 + "s", "Student", "Bus"));
				 for(Students entry : list)
				 {
				 	if(entry.StLastName.equalsIgnoreCase(arg))
				 	{
					System.out.println(String.format("%-" + 15 + "s%-" + 15 + "s%-" + 15 + "d", entry.StFirstName, entry.StLastName, entry.Bus));
				 	}
				 }
				} else {
				//Bus search
				 argint = input.nextInt();
				System.out.println(String.format("%-" + 30 + "s%-" + 15 + "s", "Student", "Classroom"));
				 for(Students entry : list)
				 {
				 	if(entry.Bus == argint)
				 	{
				 	System.out.println(String.format("%-" + 15 + "s%-" + 15 + "s%-" + 15 + "d", entry.StFirstName, entry.StLastName, entry.Classroom));
				 	}
				 }
				}
				break;
			case 'S':
				//Student search
				arg = input.next();
				System.out.println(String.format("%-" + 30 + "s%-" + 15 + "s%-" + 15 + "s%-" + 30 + "s", "Student", "Classroom", "Grade", "Teacher"));
				 for(Students entry : list)
				 {
				 	if(entry.StLastName.equalsIgnoreCase(arg))
				 	{
				 	System.out.println(String.format("%-" + 15 + "s%-" + 15 + "s%-" + 15 + "d%-" + 15 + "d%-" + 15 + "s%-" + 15 + "s", entry.StFirstName, entry.StLastName, entry.Classroom, entry.Grade, entry.TFirstName.trim(), entry.TLastName));
				 	}
				 }
				break;
			case 'T':
				//Teacher search
				arg = input.next();
				System.out.println(String.format("%-" + 30 + "s", "Student"));
				 for(Students entry : list)
				 {
				 	if(entry.TLastName.equalsIgnoreCase(arg))
				 	{
				 	System.out.println(String.format("%-" + 15 + "s%-" + 15 + "s", entry.StFirstName, entry.StLastName));
				 	}
				 }
				break;
			case 'C':
				//Classroom search
				argint = input.nextInt();
				System.out.println(String.format("%-" + 30 + "s", "Student"));
				 for(Students entry : list)
				 {
				 	if(entry.Classroom == argint)
				 	{
				 	System.out.println(String.format("%-" + 15 + "s%-" + 15 + "s", entry.StFirstName, entry.StLastName));
				 	}
				 }
				break;
			case 'Q':
			//Exit
				input.close();
				return;
			default:
				System.out.println("Invalid input!");
				break;				
			}
			//Calculation time
			System.out.println("Computation time: " + (double)(System.currentTimeMillis() - time)/1000 + "s\n");
		} while(option.charAt(0) != 'Q');		
		input.close();
	}
	
}

//data structure
class Students {
	
	String StLastName;
	String StFirstName;
	int Grade;
	int Classroom;
	int Bus;
	String TLastName;
	String TFirstName;
	
	Students(String StLastName,	String StFirstName,	int Grade, int Classroom, int Bus, String TLastName, String TFirstName)
	{
	this.StLastName = StLastName;
	this.StFirstName = StFirstName;
	this.Grade = Grade;
	this.Classroom = Classroom;
	this.Bus = Bus;
	this.TLastName = TLastName;
	this.TFirstName = TFirstName;
	}
	
	} 