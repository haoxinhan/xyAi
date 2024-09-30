package org.xyai.Linear_Model;

import org.xyai.AF.Sigmoid;
import org.xyai.AF.af;
import org.xyai.Optimizer.SGD;
import org.xyai.loss.BCELoss;
import org.xyai.matrix.Matrix;
import org.xyai.matrix.MatrixCalculator;

public class SGDLinearRegression extends LinearModel{
    private double learningRate;
    //迭代次数
    private int iteration;

    private double threshold=0;
    public SGDLinearRegression(int n ,double learningRate,int iteration){
        super(n);
        this.learningRate=learningRate;
        this.iteration=iteration;
        this.theta.setallNum(0);
        this.intercept=0;
    };
    public void setThreshold (double n){
        this.threshold=n;
    }
    public void fit(Matrix X, Matrix y) throws Exception{
        Matrix X1 = xToX(X);
        TAndITot();
        SGD sgd = new SGD(learningRate, new BCELoss(), new af(), iteration, this.threshold);
        t= sgd.optimize(X1, y, t);
        tToTAndI();

    }
    public Matrix predict(Matrix X) throws Exception{
        Matrix X1 = xToX(X);
        Matrix y_pred = MatrixCalculator.mul(X1, t);
        return y_pred;
    }
    public Matrix getTheta(){
        return this.theta;
    }
    public double getIntercept(){
        return this.intercept;
    }
}
