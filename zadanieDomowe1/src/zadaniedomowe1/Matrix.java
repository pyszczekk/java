/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadaniedomowe1;

/**
 *
 * @author pyszczekk
 */
public class Matrix {
    Integer n,m;
    double[][]matrix;
    public Matrix(Integer _n, Integer _m){
        this.n=_n;
        this.m=_m;
        matrix = new double[_n][_m];
    }
     public Matrix(double[][] data) {
        this.n = data.length;
        this.m = data[0].length;
        this.matrix = new double[this.n][this.m];
        for (int i = 0; i < this.n; i++)
            for (int j = 0; j < this.m; j++)
                    this.matrix[i][j] = data[i][j];
    }
      
    private Matrix(Matrix A) { this(A.matrix); } //copy-c;
    public Matrix add(Matrix M2){
        if (n==M2.n && m==M2.m){
            Matrix Wynik = new Matrix(n,m);
            for (int i = 0; i < this.n; i++)
                for (int j = 0; j < this.m; j++)
                    Wynik.matrix[i][j] = this.matrix[i][j]+M2.matrix[i][j];
            return Wynik; 
        }else{
            throw new RuntimeException("Illegal matrix dimensions.");
        }

    }
    public Matrix sub(Matrix M2){
         if (n==M2.n && m==M2.m){
            Matrix Wynik = new Matrix(n,m);
            for (int i = 0; i < this.n; i++)
                for (int j = 0; j < this.m; j++)
                    Wynik.matrix[i][j] = this.matrix[i][j]-M2.matrix[i][j];
            return Wynik; 
        }else{
            throw new RuntimeException("Illegal matrix dimensions.");
        }
    }
    
    public Matrix mul(Matrix M2){
        if(this.m==M2.n){
            Matrix Wynik= new Matrix(this.n,M2.m);
            for(int i=0;i<Wynik.n;++i){
                for(int j=0;j<Wynik.m;++j){
                    Wynik.matrix[i][j]=0;
                    for(int p=0;p<m;++p){
                        Wynik.matrix[i][j]+=(this.matrix[i][p]*M2.matrix[p][j]);
                    }
                }
            }
            return Wynik;
        }else{
            throw new RuntimeException("Illegal matrix dimensions.");
        }
    }
    
    public void show(){
         for (int i = 0; i < this.n; i++){
                for (int j = 0; j < this.m; j++){
                    System.out.print(this.matrix[i][j]+ " ");
                }
                System.out.println();
         }
    }
}
