import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseDBManager implements CourseDBManagerInterface {
	
	CourseDBStructure hashTable = new CourseDBStructure(500);

	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		CourseDBElement data = new CourseDBElement(id,crn,credits,roomNum,instructor);
		//CourseDBStructure hashtable = new CourseDBStructure(12);
		hashTable.add(data);
			
	}

	@Override
	public CourseDBElement get(int crn) {
		String look ="";
		look+=crn;
		int hash = look.hashCode();
		int index = hash % hashTable.sizeOfTable;
		if(hashTable.table[index] == null )
		{
			//throw new IOException("This cell is empty");
		}
		else
		{
			for(int i =0; i<hashTable.table[index].size();i++) {
				
				if (hashTable.table[index].get(i).getCRN() == crn)
				{
					return hashTable.table[index].get(i);
				}
					
			}
			//throw new IOException("We did not find this course");
		}
		return null;
	}

	@Override
	public void readFile(File input) throws FileNotFoundException {
		
		 String courseID, roomNum, instructor;
		 int crn, numOfCredits;
		try {
			Scanner scan = new Scanner(input);
			while(scan.hasNextLine())
			{
				courseID =scan.next();
				crn = scan.nextInt();
				numOfCredits = scan.nextInt();
				roomNum = scan.next();
				instructor = scan.nextLine();
				add(courseID,crn,numOfCredits,roomNum,instructor);
			}
			scan.close();
			
		}
		catch ( FileNotFoundException e)
		{
			System.out.println("File not found");
		}
		
		
	}

	@Override
	public ArrayList<String> showAll() {
		ArrayList<String> stringList = new ArrayList<>();
		for (int i =0;i < hashTable.sizeOfTable;i++)
		{
			if (hashTable.table[i] != null)
			{
				for (int j  = 0 ; j < hashTable.table[i].size();j++)
				{
					stringList.add(hashTable.table[i].get(j).toString());
				}
			}
		}
		
		return stringList;
	}

}
