package assessTest;
import org.junit.jupiter.api.Test;
import org.xyai.assess.MSE;
import org.xyai.matrix.Matrix;
public class MSETest {
    @Test
    public void testCompute() throws Exception {
        MSE mse = new MSE();
        Matrix y = new Matrix(1,2,"1 3");
        Matrix y_hat = new Matrix(1,2,"1 2");
        double result = mse.compute(y,y_hat);
        System.out.println(result);
    }
}
