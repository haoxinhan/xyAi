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
}
