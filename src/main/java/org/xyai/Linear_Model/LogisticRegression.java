package org.xyai.Linear_Model;
import org.xyai.matrix.Matrix;
import org.xyai.loss.BCELoss;
import org.xyai.AF.Sigmoid;
import org.xyai.Optimizer.SGD;
import org.xyai.matrix.MatrixCalculator;

public class LogisticRegression
{
    //参数矩阵
    private Matrix theta;
    //截距
    private double intercept;
    //学习率
    private double learningRate;
    //迭代次数
    private int iteration;

    private double threshold=0;
    public LogisticRegression(int n ,double learningRate,int iteration){
        this.theta=new Matrix(n,1);
        this.learningRate=learningRate;
        this.iteration=iteration;
        this.theta.setallNum(0);
        this.intercept=0;

    };

    public void setThreshold (double n){
        this.threshold=n;
    }
    public void fit(Matrix X,Matrix y) throws Exception{
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
        Matrix t = new Matrix(m + 1, 1);
        t.set(1, 1, this.intercept);
        for (int i = 1; i <= m; i++) {
            t.set(i + 1, 1, this.theta.get(i, 1));
        }

        SGD sgd = new SGD(learningRate, new BCELoss(), new Sigmoid(), iteration, this.threshold);
        t= sgd.optimize(X1, y, t);
        this.intercept = t.get(1, 1);
        for (int i = 1; i <= m; i++) {
            this.theta.set(i, 1, t.get(i + 1, 1));
        }

    }
    public Matrix predict(Matrix X) throws Exception{
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
        Matrix t=new Matrix(m+1,1);
        t.set(1,1,this.intercept);
        for (int i = 1; i <= m; i++) {
            t.set(i+1, 1, this.theta.get(i, 1));
        }
        Sigmoid sigmoid = new Sigmoid();
        Matrix y1 = MatrixCalculator.mul(X1, t);
        Matrix y2 = sigmoid.compute(y1);
        Matrix y3 = new Matrix(n, 1);
        for (int i = 1; i <= n; i++) {

            if (y2.get(i, 1) > 0.5) {
                y3.set(i, 1, 1);
            } else {
                y3.set(i, 1, 0);
            }

        }
        return y3;

    }

    public Matrix getTheta() {

        return this.theta;
    }

    public double getIntercept(){
        return this.intercept;
        }


}
