import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CourseDBManager_STUDENT_Test {

	private CourseDBManagerInterface dataMgr = new CourseDBManager();

	/**
	 * Create an instance of CourseDBManager
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		dataMgr = new CourseDBManager();
	}

	/**
	 * Set dataMgr reference to null
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		dataMgr = null;
	}
	@Test
	public void testAddToDB() {
		try {
			dataMgr.add("CMSC203",30504,4,"SC450","Joey Bag-O-Donuts");
			dataMgr.add("CMSC204",31421,4,"SW350","Nobody");
		}
		catch(Exception e) {
			fail("This should not have caused an Exception");
		}
	}
	
	@Test
	public void testGetFromDB()
	
	{
		try {
			dataMgr.add("CMSC203",30504,4,"SC450","Joey Bag-O-Donuts");
			dataMgr.add("CMSC204",31421,4,"SW350","Nobody");
		}
		catch(Exception e) {
			fail("This should not have caused an Exception");
		}
		assertEquals(31421,dataMgr.get(31421).getCRN());
	}
}
