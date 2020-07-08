/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author jianfeng
 */
public class UpperTriangularMatrix {
    private int n;
    private int[] array;
    
    public UpperTriangularMatrix(int n){
        if (n<=0){
            
            this.n=1;
            array= new int[this.n];
        }
        else {
            this.n=n;}
        
        this.array = new int[this.n*(this.n+1)/2];
        
    }
    
    public UpperTriangularMatrix(Matrix upTriM) throws IllegalArgumentException{
        
        if (upTriM.isUpperTr()==true && upTriM.getsizeofrows()== upTriM.getsizeofcols() ){ 
            this.n= upTriM.getsizeofrows();
            this.array = new int[this.n*(this.n+1)/2];
            int q=0;
            for (int i=0; i<this.n ;i++){ 
                for (int j=i; j<this.n; j++){
                    this.array[q++]=upTriM.getElement(i, j); 
                }
            }
        }
        
        else
            throw new IllegalArgumentException ("Not an upper triangular Matrix"); 
    }    
        
    public int getDim(){
        
        return this.n; 
    }
    
    public int getElement(int i, int j) throws IndexOutOfBoundsException{
        if (i < this.n && i>=0 && j <this.n && j>=0 ){ 
            Matrix m= fullMatrix();
            return m.getElement(i, j);
        }
        
        else {
            throw new IndexOutOfBoundsException("invalid index");
        }
    }
    
    public void setElement(int x, int i, int j) throws IndexOutOfBoundsException,IllegalArgumentException{
        if (i < this.n && i>=0 && j <this.n && j>=0 ){ 
            
            if (j >= i){ 
                Matrix mm= fullMatrix();
                mm.setElement(x, i, j);
                int q=0;
                for (int k=0; k<this.n ;k++){
                    for (int r=k; r<this.n; r++){
                        
                        if (k==i && r==j)
                            this.array[q]=mm.getElement(i, j);
                        q++; 
                    }
                }
            }
            else
                throw new IllegalArgumentException ("Incorrect argument"); 
            
        }
        
        else
            throw new IndexOutOfBoundsException("Invalid indexes"); 
    }
    
    public Matrix fullMatrix(){

        Matrix full= new Matrix(n,n); 
        int q=0;
        for (int i=0; i<full.getsizeofrows() ;i++){
            for ( int j=i; j<this.n; j++){
                full.setElement(this.array[q++], i, j);
            }
        }
        return full; 
    }
    
    public void print1DArray(){
        
        
        for (int i = 0; i < this.n*(this.n+1)/2; i++){
            System.out.printf("%d  ",this.array[i]);
        		}
        
        
    }
      
    public String toString(){
       String output= "";
       Matrix full= this.fullMatrix();
       for (int i=0; i< this.n;i++){
           for (int j=0; j<this.n; j++){
               output+= full.getElement(i, j)+ " ";
               
           }
           output+= "\n";
       }
       
       return output;
    }
    
    public int getDet(){
        int det= 1;
        int i;
        for (i= 0; i< this.n;i++){
            det = det * getElement(i,i);
        }
        
       return det; 
    }

    
    public double[] effSolve(double[] b) throws IllegalArgumentException{
        if (this.getDet()==0)
            throw new IllegalArgumentException("The determinant of the matrix is 0.");
        if (b.length != this.n)
            throw new IllegalArgumentException("The dimension of the matrix is not defined for operation");
        
        int row = this.n-1; 
            
        double[] sol = new double[this.n];

        for (int i =row; i>0; i--){
            double sum = 0;
            double rest=0;
            int a =row-i;
            
            if (a==0){
                sol[i]=b[i]/getElement(i,i);
            }
            else{
                for (int j= a;j>0;j--){
                    
                    sum = sum+ getElement(i,i+j)*sol[i+j];
                }               
                rest= b[i]-sum;
                sol[i] = rest/getElement(i,i);
            }
            
        }
        return sol;  
    }   
}