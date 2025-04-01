
public class CourseDBElement implements Comparable<CourseDBElement> 
{
	
	private String CourseID;
	private int CRN;
	private int Credit;
	private String roomNumber;
	private String instructorName;
	
	
	public CourseDBElement (String courseId, int crn, int credit, String roomNum, String instructor)
	{
		this.CourseID=courseId;
		this.CRN=crn;
		this.Credit=credit;
		this.roomNumber=roomNum;
		this.instructorName=instructor;
		
	}
	
	public CourseDBElement()
	{
		CourseID = "";
		CRN = 0;
		Credit = 0;
		roomNumber = "";
		instructorName = "";
	}
	
	public int getCRN()
	{
		return CRN;
	}
	
	public int getCredit()
	{
		return Credit;
	}
	
	public String getID()
	{
		return CourseID;
	}

	public String getRoomNum()
	{
		return  roomNumber;
	}
	
	public String getInstructorName()
	{
		return instructorName;
	}




	@Override
	public int compareTo(CourseDBElement o) {
		
		return Integer.compare(CRN, o.CRN);
	}
	
	public String toString() {
        return ("\nCourse:" +  getID() + " CRN:" + CRN + " Credits:" + Credit + " Instructor:" + getInstructorName() + " Room:" + getRoomNum());
    }


}
