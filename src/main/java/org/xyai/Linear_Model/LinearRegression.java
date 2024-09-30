package org.xyai.Linear_Model;
import org.xyai.matrix.Matrix;
import org.xyai.matrix.MatrixCalculator;

public class LinearRegression extends LinearModel{
    //参数矩阵


    public LinearRegression(int n){
        super(n);
        this.intercept=0;
    }
    public void fit(Matrix X,Matrix y) throws Exception {
        Matrix X1 = xToX(X);


        /*
        Matrix X1T = MatrixCalculator.transpose(X1);
        Matrix X1TX1 = MatrixCalculator.mul(X1T, X1);
        Matrix X1Ty = MatrixCalculator.mul(X1T, y);
        Matrix t = MatrixCalculator.mul(MatrixCalculator.inverse(X1TX1),X1Ty);

         */
        this.t = MatrixCalculator.normalEquation(X1, y);
        //分离截距
        tToTAndI();


    }
    public Matrix predict(Matrix X) throws Exception {
        Matrix y = MatrixCalculator.mul(X, this.theta);
        double n = y.get(1,1);
        y.set(1, 1, n + this.intercept);
        return y;
    }

    public Matrix getTheta() {
        return theta;
    }
    public double getIntercept() {
        return intercept;
    }


}
