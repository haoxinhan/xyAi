package org.xyai.Optimizer;
import org.xyai.matrix.Matrix;
import org.xyai.loss.loss;
import org.xyai.AF.af;
import org.xyai.matrix.MatrixCalculator;

public class SGD
{
    //学习率
    private double learningRate;
    //损失函数
    private loss lossFunction;
    //循环次数
    private int epochs;
    //激活函数
    private af activationFunction;
    //损失最小
    private double threshold;

//优化器
    public SGD(double learningRate,loss lossFunction,af AF,int epochs,double threshold)
    {
        this.learningRate=learningRate;
        this.lossFunction=lossFunction;
        this.epochs=epochs;
        this.activationFunction=AF;
        this.threshold=threshold;
    }
    public Matrix compute_gradient(Matrix x,Matrix y,Matrix w) throws Exception{
        double m=x.getCols();
        Matrix l=MatrixCalculator.mul(x,w);
        Matrix y_hat=activationFunction.compute(l);
        Matrix sub=MatrixCalculator.sub(y,y_hat);
        Matrix xt=MatrixCalculator.transpose(x);
        Matrix gradient=MatrixCalculator.mul(xt,sub);
        return MatrixCalculator.mul(gradient,1/m);
    }
    public Matrix optimize(Matrix x,Matrix y,Matrix w) throws Exception{
        for(int i=0;i<epochs;i++){
            Matrix gradient=compute_gradient(x,y,w);
            w=MatrixCalculator.add(w,MatrixCalculator.mul(gradient,learningRate));
            if(i%100==0){
                if(threshold!=0.0){
                    if(lossFunction.compute(y,MatrixCalculator.mul(x,w))<threshold){
                        break;
                    }
                }
            }

        }
        return w;
    }


}
