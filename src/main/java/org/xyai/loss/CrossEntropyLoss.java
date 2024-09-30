package org.xyai.loss;
import org.xyai.matrix.Matrix;


public class CrossEntropyLoss
{
    public static double compute(Matrix y, Matrix y_hat)throws Exception
    {
        if (y.getRows() != y_hat.getRows()){
            throw new Exception("y and y_hat must have the same number of rows");
        }

        double loss = 0.0;
        for(int i = 1; i <= y.getRows(); i++)
        {
            loss += y.get(i,1) * Math.log(y_hat.get(i,1));
        }
        return -loss;
    }
}
