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
public class ZadanieDomowe1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         double[][] d = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9} };
          double[][] b = { { 1, 2, 3 }, { 4, 5, 6 }};
         Matrix D = new Matrix(d);
         D.show();
         System.out.println();
         Matrix C = D.add(D);
         C.show();
         System.out.println();
         Matrix B = C.sub(D);
         B.show();
         System.out.println();
         Matrix A = D.mul(C);
         A.show();
          System.out.println();
         Matrix E = new Matrix(b);
         Matrix Mul = E.mul(D);
         Mul.show();
    }
    
}
