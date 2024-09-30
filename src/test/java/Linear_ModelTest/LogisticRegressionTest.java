package Linear_ModelTest;

import org.junit.jupiter.api.Test;
import org.xyai.Linear_Model.LogisticRegression;
import org.xyai.matrix.Matrix;
import org.xyai.matrix.MatrixCalculator;



public class LogisticRegressionTest {
    @Test
    public void test() throws Exception {
        String data1="1\n2\n3\n4\n5\n6\n7\n8\n9\n10";
        String data2="0\n0\n0\n0\n0\n1\n1\n1\n1\n1";
        Matrix X=new Matrix(10,1,data1);
        Matrix y=new Matrix(10,1,data2);
        LogisticRegression logisticRegression=new LogisticRegression(1,0.0000001,10000000);
        logisticRegression.fit(X,y);
        //预测
        Matrix X1=new Matrix(1,1,"0");
        System.out.println(logisticRegression.predict(X1));
        Matrix X2=new Matrix(1,1,"20");
        System.out.println(logisticRegression.predict(X2));

        //print w b
        System.out.println(logisticRegression.getTheta());
        System.out.println(logisticRegression.getIntercept());



    }
}
