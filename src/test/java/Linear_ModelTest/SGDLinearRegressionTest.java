package Linear_ModelTest;
import org.junit.jupiter.api.Test;
import org.xyai.Linear_Model.SGDLinearRegression;
import org.xyai.matrix.Matrix;
public class SGDLinearRegressionTest
{
    @Test
    public void testLinearRegression1(){
        //生成随机数 math.random
        Matrix x=new Matrix(30,1);
        Matrix y=new Matrix(30,1);
        try {
            for (int i=1;i<=x.getRows();i++){
                x.set(i,1,i);
                y.set(i,1,i*2+Math.random()*10);
            }
            System.out.println(y);
            SGDLinearRegression lr = new SGDLinearRegression(1, 0.00001,100000);
            lr.fit(x,y);
            System.out.println(lr.getTheta());
            System.out.println(lr.getIntercept());

            Matrix x_test=new Matrix(1,1,"11");
            System.out.println(lr.predict(x_test));

        }catch (Exception e){
            e.printStackTrace();
        }



    }
}
