package org.xyai.matrix;
import org.xyai.matrix.Matrix;
public class MatrixCalculator {
    public static Matrix add(Matrix a, Matrix b) throws Exception {

        //检查矩阵是否同型
        if (a.getRows() != b.getRows() || a.getCols() != b.getCols()) {
            throw new Exception("matrices are not the same size");
        }

        //创建结果矩阵
        Matrix result = new Matrix(a.getRows(), a.getCols());

        //逐个元素相加
        for (int i = 1; i <= a.getRows(); i++) {
            for (int j = 1; j <= a.getCols(); j++) {
                result.set(i, j, a.get(i, j) + b.get(i, j));
            }
        }


            return result;
        }





}
