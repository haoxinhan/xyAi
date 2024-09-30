package Linear_ModelTest;
import org.junit.jupiter.api.Test;
import org.xyai.Linear_Model.LinearRegression;
import org.xyai.matrix.Matrix;



public class LinearRegressionTest {
    @Test
    public void testLinearRegression(){
        LinearRegression lr = new LinearRegression(3);
        String data="1 4 3 \n"+"4 2 1 \n"+"3 2 3 \n"+"1 5 7";
        try {
            Matrix X = new Matrix(4,3,data);
            Matrix y = new Matrix(4, 1,"12\n9\n10\n18");
            lr.fit(X,y);
            System.out.println(lr.getTheta());
            Matrix x_test=new Matrix(1,3,"1 2 3");
            System.out.println(lr.predict(x_test));

        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
