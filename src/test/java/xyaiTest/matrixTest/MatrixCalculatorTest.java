package xyaiTest.matrixTest;
import org.junit.jupiter.api.Test;
import org.xyai.matrix.MatrixCalculator;
import org.xyai.matrix.Matrix;
public class MatrixCalculatorTest {
    @Test
    public void testAdd() {
        String data="1 1\n"+"1 1";
        try {
            Matrix a = new Matrix(2, 2,data );
            Matrix b = new Matrix(2, 2,data );
            Matrix c = MatrixCalculator.add(a, b);
            System.out.println(c);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testSub() {
        String data="1 1\n"+"1 1";
        try {
            Matrix a = new Matrix(2, 2,data );
            Matrix b = new Matrix(2, 2,data );
            Matrix c = MatrixCalculator.sub(a, b);
            System.out.println(c);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testsubMatrix() {
        String data="1 2 -1 \n"+"3 1 0 \n"+"-1 -1 -2 ";
        try {
            Matrix a = new Matrix(3, 3,data );
            Matrix c = MatrixCalculator.subMatrix(a, 1, 3);
            System.out.println(c);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDet() {
        String data="1 2 -4 \n"+"-2 2 1 \n" +"-3 4 -2";
        try {
            Matrix a = new Matrix(3, 3,data );
            double c = MatrixCalculator.det(a);
            System.out.println(c);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testMul() {
        String data="1 2 \n"+"1 1 ";
        try {
            Matrix a = new Matrix(2, 2,data );
            Matrix c = MatrixCalculator.mul(a, 2);
            System.out.println(c);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testTranspose() {
        String data="1 2 2\n"+"1 1 4 \n"+"1 1 1 ";
        try {
            Matrix a = new Matrix(3, 3,data );
            Matrix c = MatrixCalculator.transpose(a);
            System.out.println(c);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAdj() {
        String data="1 2 -1 \n"+"3 1 0 \n"+"-1 -1 -2 ";
        try {
            Matrix a = new Matrix(3, 3,data );
            Matrix c = MatrixCalculator.adj(a);
            System.out.println(c);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testInverse() {
        String data="1 2 3 \n"+"2 2 1 \n"+"3 4 3 ";
        try {
            Matrix a = new Matrix(3, 3,data );
            Matrix a1 = MatrixCalculator.inverse(a);
            Matrix c = MatrixCalculator.mul(a1,a);

            System.out.println(c);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testMulMatrix() {
        String data="1 2 \n"+"1 1 ";
        try {
            Matrix a = new Matrix(2, 2,data );
            Matrix b =MatrixCalculator.inverse(a);
            Matrix c = MatrixCalculator.mul(a,b);
            System.out.println(c);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testNormalEquation() {
        String data="1 2 3 \n"+"2 2 1 \n"+"3 4 3 ";
        try {
            Matrix x = new Matrix(3, 3,data );
            Matrix y = new Matrix(3, 1,"6\n5\n10");
            Matrix c = MatrixCalculator.normalEquation(x,y);
            System.out.println(c);
        }catch (Exception e) {
            e.printStackTrace();
        }


    }

}
