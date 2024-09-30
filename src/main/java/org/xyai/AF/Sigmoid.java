package org.xyai.AF;

import org.xyai.matrix.Matrix;

public class Sigmoid extends af {
    public Matrix compute (Matrix x)throws Exception{
        Matrix y=new Matrix(x.getRows(),x.getCols());
        for (int i=1;i<=x.getRows();i++){
            for (int j=1;j<=x.getCols();j++)
                y.set(i,j,1/(1+Math.exp(-x.get(i,j))));
        }
        return y;
    }

}
