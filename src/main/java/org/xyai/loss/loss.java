package org.xyai.loss;
import org.xyai.matrix.Matrix;

public abstract class loss {
    public abstract double compute(Matrix y,Matrix y_hat )throws Exception;
}
