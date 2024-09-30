package lossTest;
import org.xyai.loss.CrossEntropyLoss;
import org.junit.jupiter.api.Test;
import org.xyai.matrix.Matrix;


public class CrossEntropyLossTest {
    @Test
    public void test(){
        String data1="0\n1\n0";
        String data2="0.2\n0.7\n0.1";
        try {
            Matrix y_true=new Matrix(3,1,data1);
            Matrix y_pred=new Matrix(3,1,data2);
            double loss= CrossEntropyLoss.compute(y_true,y_pred);
            System.out.println(loss);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
