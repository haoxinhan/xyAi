package org.xyai.Linear_Model;
import org.xyai.matrix.Matrix;
import org.xyai.matrix.MatrixCalculator;

public class LinearRegression {
    //参数矩阵
    private Matrix theta;
    //截距
    private double intercept;

    public LinearRegression(int n){
        this.theta=new Matrix(n,1);
        this.intercept=0;
    }
    public void fit(Matrix X,Matrix y) throws Exception {
        int n = X.getRows();
        int m = X.getCols();
        Matrix X1 = new Matrix(n, m + 1);
        for (int i = 1; i <= n; i++) {
            X1.set(i, 1, 1);
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 2; j <= m + 1; j++) {
                X1.set(i, j, X.get(i, j - 1));
            }
        }
        Matrix X1T = MatrixCalculator.transpose(X1);
        Matrix X1TX1 = MatrixCalculator.mul(X1T, X1);
        Matrix X1Ty = MatrixCalculator.mul(X1T, y);
        Matrix t = MatrixCalculator.mul(MatrixCalculator.inverse(X1TX1),X1Ty);
        //分离截距
        this.intercept=t.get(1,1);
        for (int i = 1; i <= m; i++) {
            this.theta.set(i, 1, t.get(i + 1, 1));
        }


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
