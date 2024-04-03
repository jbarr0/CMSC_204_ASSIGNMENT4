
public class CourseDBElement implements Comparable{

	private String courseID, roomNum, instructor;
	private int crn, numOfCredits;
	
	@Override
	public int compareTo(Object o) {
		CourseDBElement temp = (CourseDBElement)o;
		
		return this.crn - temp.crn;
	}
	
	public CourseDBElement(String courseID, int crn, int numOfCredits, String roomNum, String instructor)
	{
		this.courseID = courseID;
		this.roomNum = roomNum;
		this.instructor = instructor;
		this.crn = crn;
		this.numOfCredits = numOfCredits;
	}
	public int getCRN()
	{
		return this.crn;
	}
	public String getID()
	{
		return this.courseID;
	}
	
	public String getRoomNum()
	{
		return roomNum;
	}
	
	public String toString()
	{
		return "\nCourse:" + this.courseID + " CRN:" + this.crn +" Credits:" + this.numOfCredits + " Instructor:" + this.instructor + " Room:" + this.roomNum;
	}
	@Override
	public boolean equals (Object o)
	{
		CourseDBElement temp = (CourseDBElement)o;
		return this.crn==temp.getCRN();
	}
	@Override
	public int hashCode()
	{
		String hash="";
		hash+= this.crn;
		return hash.hashCode();
	}

}
