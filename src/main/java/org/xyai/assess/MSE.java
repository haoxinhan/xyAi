package org.xyai.assess;
import org.xyai.matrix.Matrix;
public class MSE {
    public  double compute(Matrix y,Matrix y_hat )throws Exception{
        if (y.getRows()!=y_hat.getRows()||y.getCols()!=y_hat.getCols()){
            throw new Exception("y和y_hat的维度不匹配");
        }
        double sum=0;
        for (int i=1;i<=y.getRows();i++){
            for (int j=1;j<=y.getCols();j++){
                sum+=Math.pow(y.get(i,j)-y_hat.get(i,j),2);
            }
        }
        return sum/(y.getRows()*y.getCols());
    }
}
