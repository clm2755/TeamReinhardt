import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class EdgeTableTest {
    EdgeTable testObj;
	EdgeTable associativeObj;

	//Create print stream to display test output through prints

	private final String tableInput = "1|STUDENT";
	private final String associativeInput = "3|STAFF";
	private final String tableName = "STUDENT";
	private final int tableNum = 1;
	


    @Before
    public void setUp() throws Exception {
        testObj = new EdgeTable(tableInput);
		associativeObj = new EdgeTable(associativeInput);
    }

    @Test
    public void testGetName() {
        assertEquals("testObj was created as STUDENT ",tableName,testObj.getName());
    }

	@Test
    public void testGetNumFigure() {
        assertEquals("testObj was with a numFigure of 1",tableNum,testObj.getNumFigure() );
    }


	@Test
	public void testGetRelatedTables2() {
		testObj.addRelatedTable(3);
		testObj.makeArrays();
	assertEquals("Related Table 3 was added and arrays were made",3,testObj.getRelatedTablesArray()[0]);
	}


	@Test
	public void testGetRelatedTables3() {
		testObj.addRelatedTable(0);
		testObj.addRelatedTable(-20);
		testObj.makeArrays();
		assertEquals("Related Table 0 was added and arrays were made",0,testObj.getRelatedTablesArray()[0]);
		assertEquals("Related Table -20 was added and arrays were made",-20,testObj.getRelatedTablesArray()[1]);
	}


	@Test
	public void testGetNativeFields2() {
		testObj.addNativeField(1);
		testObj.makeArrays();
		assertEquals("Native Field 1 was added",1,testObj.getNativeFieldsArray()[0]);
	}

	@Test
	public void testGetNativeFields3() {
		testObj.addNativeField(0);
		testObj.addNativeField(-20);
		testObj.makeArrays();
		assertEquals("Native Field 0 was added",0,testObj.getNativeFieldsArray()[0]);
		assertEquals("Native Field 0 was added",-20,testObj.getNativeFieldsArray()[1]);
	}

	@Test
	public void testMoveFieldUp1() {
		testObj.addNativeField(1);
		testObj.addNativeField(2);
		testObj.addNativeField(3);
		testObj.makeArrays();
		testObj.moveFieldUp(2);
		assertEquals("Native Fields 1,2,3 were added, 3 was moved up",3,testObj.getNativeFieldsArray()[1]);
	}

	@Test
	public void testMoveFieldUp2() {
		testObj.addNativeField(1);
		testObj.addNativeField(2);
		testObj.addNativeField(3);
		testObj.makeArrays();
		testObj.moveFieldUp(2);
		testObj.moveFieldUp(1);
		assertEquals("Native Fields 1,2,3 were added, 3 was moved up twice",3,testObj.getNativeFieldsArray()[0]);
	}

	@Test
	public void testMoveFieldDown1() {
		testObj.addNativeField(1);
		testObj.addNativeField(2);
		testObj.addNativeField(3);
		testObj.makeArrays();
		testObj.moveFieldDown(0);
		assertEquals("Native Fields 1,2,3 were added, 1 was moved down",1,testObj.getNativeFieldsArray()[1]);
	}

	@Test
	public void testMoveFieldDown2() {
		testObj.addNativeField(1);
		testObj.addNativeField(2);
		testObj.addNativeField(3);
		testObj.makeArrays();
		testObj.moveFieldDown(0);
		testObj.moveFieldDown(1);
		assertEquals("Native Fields 1,2,3 were added, 1 was moved down",1,testObj.getNativeFieldsArray()[2]);
	}

	@Test
	public void testGetRelatedFields1() {
		testObj.addNativeField(1);
		testObj.makeArrays();
		assertEquals("Native Field 1 was added",1,testObj.getNativeFieldsArray()[0]);
		assertEquals("Related Field 1 was added as 0",0,testObj.getRelatedFieldsArray()[0]);
	}

	@Test
	public void testGetRelatedFields2() {
		testObj.addNativeField(1);
		testObj.addNativeField(2);
		testObj.addNativeField(3);
		testObj.makeArrays();
		assertEquals("Native Field 1,2, and 3 were added",1,testObj.getNativeFieldsArray()[0]);
		assertEquals("Related Field 1 was added as 0",0,testObj.getRelatedFieldsArray()[0]);
		assertEquals("Related Field 3 was added as 0",0,testObj.getRelatedFieldsArray()[2]);
	}

}
