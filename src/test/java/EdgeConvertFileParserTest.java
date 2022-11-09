import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.io.*;
import java.lang.ProcessHandle.Info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EdgeConvertFileParserTest {
    EdgeConvertFileParser testObj;
    EdgeConvertFileParser testObj2;
    File inFile = new File("Courses.edg");
    //File inFile2 = new File("Courses.edg.sav");
    int random = Integer.MAX_VALUE;
    public static Logger logger = LogManager.getLogger(EdgeConvertFileParserTest.class.getName());

    @Before
    public void setUp() throws Exception{
        testObj = new EdgeConvertFileParser(inFile);
        //testObj2 = new EdgeConvertFileParser(inFile2);
    }

    @Test
	public void testEntity(){
		assertEquals("isEntity should be initalized to true",true, testObj.isEntity);
	}

@Test
	public void testAttribute(){
        try{
		    assertEquals("isAttribute should be set to true", false, testObj.isAttribute);
        }catch(Exception e){
            logger.info("Entity and Attribute test Failed " + e.getMessage());
        }
    }
@Test
	public void testEntityAndAttribute(){
        try {
            assertEquals("Both values need to be set to true", true, (testObj.isAttribute && testObj.isEntity));

        } catch (Exception e ){ 
            logger.info("Entity and Attribute test Failed " + e.getMessage());
        }
	}

@Test
	public void testIsUnderline(){
		assertEquals("isUnderlined should be set to true",true, testObj.isUnderlined);
	}
@Test 
	public void testIsEntityReset(){
		assertEquals("isEntity shoudl be set back to false", false, testObj.isEntity);
	}

@Test 
	public void testIsAttributeReset(){
		assertEquals("isAttribute should be set to false", false, testObj.isAttribute);
	}
@Test 
	public void testIsUnderlinedReset(){
		assertEquals("isUnderlined should be set to false", false, testObj.isUnderlined);
	}

@Test 
	public void testNumConnector(){
		assertEquals("numConnectore should be an integer value",true, testObj.numConnector < random);
	}
@Test 
	public void testEndPoint1(){
		assertEquals("endPoint1 should be an integer value", true, testObj.endPoint1 < random);
	}

@Test
	public void testEndPoint2(){
		assertEquals( true, testObj.endPoint2 < random);
	}

@Test 
	public void testEndStyle1(){
		assertEquals("endStyle1 should be a string",true, testObj.endStyle1 != "");
	}

@Test 
	public void testEndStyle2(){
		assertEquals("endStyle2 should be a string", true, testObj.endStyle2 !="");
	}

//testing the parseSaveFile method

// @Test
// 	public void testNumFigure(){
// 		assertEquals(true, testObj2.numFigure < random);
// 	}


// @Test 
// 	public void testTableName(){
// 		assertEquals(true, testObj2.tableName != "");
// 	}


}
