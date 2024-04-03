import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class CourseDBStructure implements CourseDBStructureInterface{
	
	LinkedList<CourseDBElement>[] table;
	int sizeOfTable;	
	
	
	public CourseDBStructure(int numOfCourses) {
		boolean primeFound = false;
		sizeOfTable = (int) (numOfCourses / 1.5);

		while (primeFound == false) {
			if ((sizeOfTable - 3) % 4 == 0) {
				if (sizeOfTable % 3 != 0 && sizeOfTable % 5 !=0 && sizeOfTable % 7 !=0) {
					if (sizeOfTable % 2 != 0)
						primeFound = true;
				}
			}
			sizeOfTable++;
		}
		sizeOfTable--;
		table = new LinkedList[sizeOfTable];

	}
	
	public CourseDBStructure(String testing, int n)
	{
		sizeOfTable=n;
		table = new LinkedList[n];
	}
	
	
	
	
	
	@Override
	public void add(CourseDBElement element) {
//		String hash="";
//		int index;
//		hash+=element.getCRN();
		int hash = element.hashCode();
		int index = hash % sizeOfTable;
		if ( table[index]== null)
		{
			LinkedList<CourseDBElement> data = new LinkedList<CourseDBElement>();
			data.add(element);
			table[index] = data;
		}
//		else if (table[index].get(0).equals(element))
//		{
//			table[index].set(0, element);
//		}
		else
		{
			for ( int i =0; i < table[index].size();i++)
			{
				if (table[index].get(i).equals(element))
				{
					table[index].set(i, element);
					return;
				}
			}
			table[index].add(element);
		}
		
	}

	@Override
	public CourseDBElement get(int crn) throws IOException {
		String look ="";
		look+=crn;
		int hash = look.hashCode();
		int index = hash % sizeOfTable;
		if(table[index] == null )
		{
			throw new IOException("This cell is empty");
		}
		else
		{
			for(int i =0; i<table[index].size();i++) {
				
				if (table[index].get(i).getCRN() == crn)
				{
					return table[index].get(i);
				}
					
			}
			throw new IOException("We did not find this course");
		}
		
	}

	@Override
	public ArrayList<String> showAll() {
		ArrayList<String> stringList = new ArrayList<>();
		for (int i =0;i < sizeOfTable;i++)
		{
			if (table[i] != null)
			{
				for (int j  = 0 ; j < table[i].size();j++)
				{
					stringList.add(table[i].get(j).toString());
				}
				
			}
		}
		
		return stringList;
	}

	@Override
	public int getTableSize() {
		
		return this.sizeOfTable;
	}

}
