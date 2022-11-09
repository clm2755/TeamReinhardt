import static org.junit.Assert.*;
import java.io.File;
import org.junit.Before;
import org.junit.Test;

public class EdgeConvertCreateDDLTest {
	File file;
	MyEdgeConvertCreateDDL myEdgeConvertCreateDDL;
	MyEdgeConvertCreateDDL myEdgeConvertCreateDDLNull;
	EdgeTable[] tablesArray;
	EdgeField[] fieldsArray;
	EdgeConvertFileParser edgeConvertFileParser;

	//Create print stream to display test output through prints
	private final String fieldName = "Name";
	private final String fieldCourseName = "CourseName";
	private final String fieldStudentSSN = "StudentSSN";
	private final String fieldAssociativeSSN = "FacSSN";
	private final String fieldCourseNumber = "Number";
	private final String fieldGrade = "Grade";
	private final int fieldStudentNameNum = 8;
	private final int fieldAssociativeNameNum = 11;
	private final int fieldCourseNameNum = 4;
	private final int fieldStudentSSNNum = 7;
	private final int fieldAssociativeSNNum = 6;
	private final int fieldCourseNumberNum = 5;
	private final int fieldGradeNum = 3;
	private final String tableStudent = "STUDENT";
	private final String tableAssociative = "FACULTY";
	private final String tableCourse = "COURSES";
	private final int tableStudentNum = 1;
	private final int tableAssociativeNum = 2;
	private final int tableCoursesNum = 13;
	private final String fileName = "Courses.edg";


    @Before
    public void setUp() throws Exception {
		file = new File(fileName);
		edgeConvertFileParser = new EdgeConvertFileParser(file);
		tablesArray = edgeConvertFileParser.getEdgeTables();
		fieldsArray = edgeConvertFileParser.getEdgeFields();
		
		for(int i = 0; i < tablesArray.length; i++){
			tablesArray[i].makeArrays();
		}
		myEdgeConvertCreateDDL = new MyEdgeConvertCreateDDL(tablesArray, fieldsArray);
		myEdgeConvertCreateDDLNull = new MyEdgeConvertCreateDDL();
    }

	@Test
	public void testGetFieldForCourseName(){
		assertEquals("Field Course Name", fieldCourseName,  myEdgeConvertCreateDDL.getField(fieldCourseNameNum).getName());
	}

	@Test
	public void testGetFieldForStaffName(){
		assertEquals("Field Staff Name", fieldName, myEdgeConvertCreateDDL.getField(fieldAssociativeNameNum).getName());
	}

	@Test
	public void testGetFieldForStudentName(){
		assertEquals("Field Student Name", fieldName, myEdgeConvertCreateDDL.getField(fieldStudentNameNum).getName());
	}

	@Test
	public void testGetFieldForStudentSSN(){
		assertEquals("Field Student SSN", fieldStudentSSN, myEdgeConvertCreateDDL.getField(fieldStudentSSNNum).getName());
	}

	@Test
    public void testGetFieldForStaffSSN() {
        assertEquals("Field Staff SSN", fieldAssociativeSSN, myEdgeConvertCreateDDL.getField(fieldAssociativeSNNum).getName());
    }
		
	@Test
    public void testGetFieldForCourseNumber() {
        assertEquals("Course Number", fieldCourseNumber, myEdgeConvertCreateDDL.getField(fieldCourseNumberNum).getName());
    }

	@Test
	public void testGetFieldForGrade(){
		assertEquals("Grade", fieldGrade, myEdgeConvertCreateDDL.getField(fieldGradeNum).getName());
	}

	@Test
	public void testGetTableForCourses(){
		assertEquals("Table Course", tableCourse, myEdgeConvertCreateDDL.getTable(tableCoursesNum).getName());
	}

	@Test
	public void testGetTableForStaff(){
		assertEquals("Table Staff", tableAssociative, myEdgeConvertCreateDDL.getTable(tableAssociativeNum).getName());
	}

	@Test
	public void testGetTableForStudent(){
		assertEquals("Table Student", tableStudent, myEdgeConvertCreateDDL.getTable(tableStudentNum).getName());
	}

	@Test
	public void testGetSQLString(){
		assertEquals("SQL String is null", null, myEdgeConvertCreateDDLNull.getSQLString());
	}

	@Test
	public void testGetProductName(){
		assertEquals("Product is null", null, myEdgeConvertCreateDDLNull.getProductName());
	}

	@Test
	public void testGetDatabaseName(){
		assertEquals("Database name is null", null, myEdgeConvertCreateDDLNull.getDatabaseName());
	}


	class MyEdgeConvertCreateDDL extends EdgeConvertCreateDDL {

		public MyEdgeConvertCreateDDL(){

		}

		public MyEdgeConvertCreateDDL(EdgeTable[] tables, EdgeField[] fields) {
			super(tables, fields);
		}
	
		
		@Override
		public String getDatabaseName() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getProductName() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getSQLString() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void createDDL() {
			// TODO Auto-generated method stub
			
		}
	
	}

}
