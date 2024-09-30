package OptimizerTest;
import org.junit.jupiter.api.Test;
import org.xyai.Optimizer.SGD;
import org.xyai.loss.CrossEntropyLoss;
import org.xyai.AF.af;
import org.xyai.matrix.Matrix;


public class SGDTest {
    @Test
    public void test() throws Exception{

        String data1="1 2 3\n"+"2 3 4\n"+ "3 4 5\n"+ "4 5 6\n"+"5 6 7\n";
        String data2="14\n20\n26\n32\n38";


        SGD sgd = new SGD(0.00001,new CrossEntropyLoss(),new af(),2000000,0.0);
        Matrix x = new Matrix(5,3,data1);
        Matrix y = new Matrix(5,1,data2);
        Matrix w = new Matrix(3,1,"0\n0\n0");
        Matrix a = sgd.optimize(x,y,w);
        System.out.println(a);

    }
}
