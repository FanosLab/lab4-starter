/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author jianfeng
 */
public class Matrix {
    
	private int[][]  matrixData;
	private int    rowsNum;	
	private int    colsNum;	
	
	public Matrix( int row, int col ) 
	{   
		/*
		* constructs a row-by-col matrix with
		* all elements equal to 0; if row ≤ 0, the number of rows of the matrix is set to
		* 3; likewise, if col ≤ 0 the number of columns of the matrix is set to 3.		
		*/
	}

	public Matrix( int[][] table) 
	{	

		/*
		* constructs a matrix out of the two dimensional array table, with the same number of rows, columns, and the same
		* element in each position as array table.
		*/ 
	}
	
	public int getElement(int i, int j) throws IndexOutOfBoundsException
	{ 	
		/*
		* returns the element on row i and column j of this matrix; 
		* it throws an exception (IndexOutOfBoundsException) if any of indexes i and j is not in the required range 
		* (rows and columns indexing starts with 0)
		*  the detail message of the exception should read: "Invalid indexes".
		*/
		
		return -1;
	}
        
    public boolean setElement(int x, int i, int j){ 
            
        /* the detail message of the exception should read: "Invalid indexes" */
    	
    	return false;
    } 

    public Matrix copy(){ 
        
    	/* fix the code and write your implementation below */
		Matrix copy = new Matrix (0,0);
		
		
		
		
        return  copy; 
    }    
                
	public void addTo( Matrix m ) throws ArithmeticException
	{
		
		/* the detail message of the exception should read: "Invalid operation". */
		
	
	}
	
    public Matrix subMatrix(int i, int j) throws ArithmeticException{ 
        
		/* The exception detail message should read: "Submatrix not defined"*/
    	
    	/* fix the code and write your implementation below */
		Matrix subM = new Matrix (0,0);
		
		
		
		
        return  subM; 
        
    }
        
    public int getsizeofrows(){ 
           
		/* update below return */
		return -1;
    }
        
    public int getsizeofcols(){
		
		/* update below return */
        return -1; 
    }
        
    public boolean isUpperTr(){
            
		/* write your implementation here and update return accordingly */
        return true;  
	}
        
    public static Matrix sum(Matrix[] matArray) throws ArithmeticException{
            
            
        Matrix superMatrix = new Matrix (1,1); 
            
            
        return superMatrix; 
    }
        
	public String toString(  )
	{
		String output = new String(); 
        	
		return output;
	}
    
}