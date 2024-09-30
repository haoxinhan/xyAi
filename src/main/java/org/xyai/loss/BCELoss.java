package org.xyai.loss;
import org.xyai.matrix.Matrix;
import org.xyai.loss.loss;
import org.xyai.matrix.MatrixCalculator;
public class BCELoss extends loss
{
    //二值交叉熵
    public  double  compute(Matrix y_pred,Matrix y_true)throws Exception {
        //使用循环
        double loss = 0;
        for(int i = 0;i < y_pred.getRows();i++){
            for(int j = 0;j < y_pred.getCols();j++)
                loss += -y_true.get(i,j)*Math.log(y_pred.get(i,j))-(1-y_true.get(i,j))*Math.log(1-y_pred.get(i,j));

        }
        return loss/y_pred.getRows();
    }

}
