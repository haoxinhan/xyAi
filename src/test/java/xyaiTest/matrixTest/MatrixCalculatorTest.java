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
        String data="1 1 3\n"+"1 1 3\n"+"3 3 3";
        try {
            Matrix a = new Matrix(3, 3,data );
            Matrix c = MatrixCalculator.subMatrix(a, 1, 2);
            System.out.println(c);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDet() {
        String data="1 2 \n"+"1 1 ";
        try {
            Matrix a = new Matrix(2, 2,data );
            double c = MatrixCalculator.det(a);
            System.out.println(c);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAdj() {
        String data="1 2 \n"+"1 1 ";
        try {
            Matrix a = new Matrix(2, 2,data );
            Matrix c = MatrixCalculator.adj(a);
            System.out.println(c);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
