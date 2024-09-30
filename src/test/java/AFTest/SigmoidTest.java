package AFTest;
import org.junit.jupiter.api.Test;
import org.xyai.AF.Sigmoid;
import org.xyai.matrix.Matrix;
public class SigmoidTest
{
    @Test
    public void test() throws Exception
    {
        Matrix x=new Matrix(1,3,"1 1 1");

        Sigmoid sigmoid=new Sigmoid();
        Matrix y=sigmoid.compute(x);
        System.out.println(y);
    }

}
