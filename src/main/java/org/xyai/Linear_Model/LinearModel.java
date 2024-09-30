package org.xyai.Linear_Model;

import org.xyai.matrix.Matrix;

public class LinearModel {
    protected Matrix theta;
    //截距
    protected double intercept;

    protected int m;

    public Matrix t;
    public LinearModel(int n){
        this.theta=new Matrix(n,1);
        this.t=new Matrix(n+1,1);
        this.m=n;

    }

    protected Matrix xToX(Matrix X) throws Exception{
        int n = X.getRows();
        Matrix X1 = new Matrix(n, m + 1);
        for (int i = 1; i <= n; i++) {
            X1.set(i, 1, 1);
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 2; j <= m + 1; j++) {
                X1.set(i, j, X.get(i, j - 1));
            }
        }
        return X1;
    }

    protected void tToTAndI() throws Exception{
        this.intercept=t.get(1,1);
        for (int i = 1; i <= m; i++) {
            this.theta.set(i, 1, t.get(i + 1, 1));
        }

    }
    protected void TAndITot() throws Exception{
        this.t.set(1,1,this.intercept);
        for (int i = 1; i <= m; i++) {
            this.t.set(i+1,1,this.theta.get(i,1));
        }
    }
}
