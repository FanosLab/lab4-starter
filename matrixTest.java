//package Matrix;

import static org.junit.Assert.*;

import org.junit.Test;


public class matrixTest {

	@Test
	public void testMatrixIntInt() {
		
		int invalid_row1 = -1, invalid_col1 = -2;
		System.out.println("*** Test Class Matrix - 40' for this part ***" );
        System.out.println("*** The mark for each test case is indicated after the case number ***" );
        // test constructor1; invalid inputs
        Matrix a = new Matrix(invalid_row1,invalid_col1);
        String expected="0  0  0  \n"+"0  0  0  \n"+"0  0  0  \n";
        assertEquals(expected,a.toString());    
		
	}

}
