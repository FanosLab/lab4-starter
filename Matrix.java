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
		if (row<=0){ 
                    this.rowsNum=3;
                }
                else 
                    this.rowsNum=row;
                if (col<=0){ 
                    this.colsNum=3;
                }
                else 
                    this.colsNum=col;
               int[][] matrix= new int[this.rowsNum][this.colsNum];
               this.matrixData=matrix;		

	}

	public Matrix( int[][] table) 
	{	

		rowsNum = table.length;
		colsNum = table[0].length;
                
		matrixData = new int[rowsNum][colsNum]; 

		for (int i=0; i<rowsNum; i++)
			for(int j=0; j<colsNum; j++)
				matrixData[i][j] = table[i][j];
	}
	
	public int getElement(int i, int j) throws IndexOutOfBoundsException
	{ 	
		if  ( i <= this.rowsNum-1 && j <= this.colsNum-1 && i>=0 && j>=0 ) {
			return this.matrixData[i][j];
		}
		else {
			throw new IndexOutOfBoundsException("Invalid indexes.");
		}  
	}
        
        public boolean setElement(int x, int i, int j){ 
            
            if  ( i <= this.rowsNum-1 && j <= this.colsNum-1 && i>=0 && j>=0 ){
                this.matrixData[i][j]=x;
                return true;
            }
            else 
                return false;
        } 

        public Matrix copy(){ 
            Matrix copy= new Matrix(this.rowsNum,this.colsNum ); 

            for (int i=0; i < this.rowsNum; i++){
                for (int j=0; j < this.colsNum ;j++){
                    copy.matrixData[i][j]=this.matrixData[i][j];
                }
            }
            return  copy; 
        }    
                
	public void addTo( Matrix m ) throws ArithmeticException
	{
		if ( m.rowsNum== this.rowsNum && m.colsNum==this.colsNum ){
                    for (int i=0; i<this.rowsNum;i++){
                        for (int j=0; j<this.colsNum;j++){
                            this.matrixData[i][j]=m.matrixData[i][j]+ this.matrixData[i][j];
                        }
                    }
		}
		else {
			throw new ArithmeticException("Invalid operation");
		}

	}
	
        public Matrix subMatrix(int i, int j) throws ArithmeticException{ 
            if  ( i <= this.rowsNum-1 && j <= this.colsNum-1 && i>=0 && j>=0){
                Matrix m1= new Matrix(i,j); 
                for (int k=0; k<i;k++){ 
                        for (int r=0; r<j;r++){
                            m1.matrixData[k][r]=this.matrixData[k][r];
                        }
                }
                return m1; 
            }
            else { 
                throw new ArithmeticException("Submatrix not defined");
            }
        }
        
        public int getsizeofrows(){ 
            return this.rowsNum; 
        }
        
        public int getsizeofcols(){
            return this.colsNum; 
        }
        
        public boolean isUpperTr(){
            
            if (this.rowsNum== this.colsNum){
                for (int i=0, j=0; i<this.rowsNum && j<this.colsNum;i++,j++){
                    int q=j;
                    while (q !=0){ 
                        q--; 
                        if (this.matrixData[i][q]!= 0){ 
                            return false;
                        }
                    }
                }
            }

            if (this.rowsNum < this.colsNum){
                for (int i=0, j=0; i<this.rowsNum && j<this.rowsNum;i++,j++){
                    int q=j;
                    while (q !=0){
                        q--;
                        if (this.matrixData[i][q]!= 0){
                            return false;
                        }
                    }
                }
            }
            
            if (this.rowsNum > this.colsNum){
                for (int i=0, j=0; i<this.colsNum && j<this.rowsNum;i++,j++){
                    int q=j;
                    while (q !=0){
                        q--;
                        if (this.matrixData[i][q]!= 0){
                            return false;
                        }
                    }
                }
                
                for (int i=this.colsNum;i<this.rowsNum;i++){ 
                    for (int j=0; j<this.colsNum;j++){ 
                        if (this.matrixData[i][j]!=0){
                            return false;}
                    }
                    
                }
            }
            return true;  
        }
        
        public static Matrix sum(Matrix[] matArray) throws ArithmeticException{
            int length= matArray.length; 
            
            for (int i= 0; i<length; i++){ 
                if (matArray[i].rowsNum!= matArray[0].rowsNum && matArray[i].colsNum!= matArray[0].colsNum )
                    throw new ArithmeticException("Matrices do not have the same deminsions");
            }
            
            Matrix superMatrix= new Matrix(matArray[0].rowsNum,matArray[0].colsNum); 
            for (int i=0; i<length; i++){
                superMatrix.addTo(matArray[i]); 
            }
            
            
            return superMatrix; 
        }
        
	public String toString(  )
	{
		String output = new String(); 
        	for(int i = 0; i < rowsNum; i++){
        		for(int j = 0; j < colsNum; j++){
        			output += matrixData[i][j] + "  ";
        		}
                        output += "\n";
        	}
       		 return output;
	}
    
}