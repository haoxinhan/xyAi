package org.xyai.Linear_Model;
import org.xyai.matrix.Matrix;
import org.xyai.loss.BCELoss;
import org.xyai.AF.Sigmoid;
import org.xyai.Optimizer.SGD;
import org.xyai.matrix.MatrixCalculator;

public class LogisticRegression extends LinearModel
{

    //学习率
    private double learningRate;
    //迭代次数
    private int iteration;

    private double threshold=0;
    public LogisticRegression(int n ,double learningRate,int iteration){
        super(n);
        this.learningRate=learningRate;
        this.iteration=iteration;
        this.theta.setallNum(0);
        this.intercept=0;

    };

    public void setThreshold (double n){
        this.threshold=n;
    }
    public void fit(Matrix X,Matrix y) throws Exception{
        Matrix X1 = xToX(X);
        TAndITot();
        SGD sgd = new SGD(learningRate, new BCELoss(), new Sigmoid(), iteration, this.threshold);
        t= sgd.optimize(X1, y, t);
        tToTAndI();

    }
    public Matrix predict(Matrix X) throws Exception{
        Matrix X1 = xToX(X);
        TAndITot();
        int n = X1.getRows();
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
