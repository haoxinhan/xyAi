package org.xyai.matrix;
import org.xyai.matrix.Matrix;
public class MatrixCalculator {


    /**
     * 矩阵加法
     * @param a
     * @param b
     * @return a+b
     * @throws Exception
     */
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

    /**
     * 矩阵减法
     * @param a
     * @param b
     * @return a-b
     * @throws Exception
     */
    public static Matrix sub(Matrix a, Matrix b) throws Exception {
            //检查矩阵是否同型
            if (a.getRows() != b.getRows() || a.getCols() != b.getCols()) {
                throw new Exception("matrices are not the same size");
            }
            //创建结果矩阵
            Matrix result = new Matrix(a.getRows(), a.getCols());
            //逐个元素相减
            for (int i = 1; i <= a.getRows(); i++) {
                for (int j = 1; j <= a.getCols(); j++)
                    result.set(i, j, a.get(i, j) - b.get(i, j));
            }
            return result;


        }


    /**
     * 去除矩阵指定行和列
     * @param m 矩阵
     * @param row 行
     * @param col 列
     * @return 去除指定行列后的矩阵
     * @throws Exception
     */
    public static Matrix subMatrix(Matrix m, int row, int col) throws Exception {

        Matrix result = new Matrix(m.getRows() - 1, m.getCols() - 1);
        for (int i = 1; i <= m.getRows(); i++) {
            for (int j = 1; j <= m.getCols(); j++) {
                if (i != row && j != col) {
                    if (i > row && j > col) {
                        result.set(i - 1, j - 1, m.get(i, j));
                    } else if (i >row) {
                        result.set(i - 1, j, m.get(i, j));
                    } else if (j>col) {
                        result.set(i, j - 1, m.get(i, j));
                    }else {
                        result.set(i , j , m.get(i, j));
                    }

                }
            }
        }
        return result;
    }

    /**
     * 矩阵行列式
     * @param a 矩阵
     * @return 行列式
     * @throws Exception
     */
    public static double det(Matrix a) throws Exception {
        if (a.getRows() != a.getCols()) {
            throw new Exception("matrix is not square");
        }
        if (a.getRows() == 1) {
            return a.get(1, 1);
        }
        double result = 0;
        for (int i = 1; i <= a.getCols(); i++) {
            result += Math.pow(-1, i + 1) * a.get(1, i) * det(subMatrix(a, 1, i));
        }
        return result;
    }


    /**
     * 矩阵转置
     * @param a 矩阵
     * @return 转置后的矩阵
     * @throws Exception
     */
    public static Matrix transpose(Matrix a) throws Exception {
        Matrix result = new Matrix(a.getCols(), a.getRows());
        for (int i = 1; i <= a.getRows(); i++)
            for (int j = 1; j <= a.getCols(); j++)
                result.set(j, i, a.get(i, j));
        return result;
    }

    /**
     * 伴随矩阵
     * @param a 矩阵
     * @return 伴随矩阵
     * @throws Exception
     */
    public static Matrix adj(Matrix a) throws Exception {
        if (a.getRows() != a.getCols()) {
            throw new Exception("matrix is not square");
        }
        Matrix result = new Matrix(a.getRows(), a.getCols());
        for (int i = 1; i <= a.getRows(); i++)
            for (int j = 1; j <= a.getCols(); j++) {
                result.set(i, j, Math.pow(-1, i + j) * det(subMatrix(a, i, j)));
            }
        return transpose(result);

    }

    /**
     * 矩阵乘以一个数
     * @param a 矩阵
     * @param d 数
     * @return 矩阵乘以一个数的结果
     * @throws Exception
     */
    public static Matrix mul(Matrix a, double d) throws Exception {
        Matrix result = new Matrix(a.getRows(), a.getCols());
        for (int i = 1; i <= a.getRows(); i++)
            for (int j = 1; j <= a.getCols(); j++)
                result.set(i, j, a.get(i, j) * d);
        return result;
    }

    /**
     * 矩阵的逆矩阵
     * @param a 矩阵
     * @return 逆矩阵
     * @throws Exception
     */
    public static Matrix inverse(Matrix a) throws Exception {
        if (a.getRows() != a.getCols()) {
            throw new Exception("matrix is not square");
        }
        double det = det(a);
        if (det == 0) {
            throw new Exception("matrix is not invertible");
        }
        return mul(adj(a),(1 / det));
    }

    /**
     * 矩阵相乘
     * @param a 矩阵
     * @param b 矩阵
     * @return 矩阵相乘的结果
     * @throws Exception
     */
    public static Matrix mul(Matrix a, Matrix b) throws Exception {
        if (a.getCols() != b.getRows())
            throw new Exception("matrix is not invertible");
        Matrix result = new Matrix(a.getRows(), b.getCols());
        for (int i = 1; i <= a.getRows(); i++)
            for (int j = 1; j <= b.getCols(); j++)
                for (int k = 1; k <= a.getCols(); k++)
                    result.set(i, j, result.get(i, j) + a.get(i, k) * b.get(k, j));
        return result;

    }
    //正规方程
    public static Matrix normalEquation(Matrix X, Matrix y) throws Exception {
        if (X.getRows() == y.getRows()){
            //将参数矩阵转置
            Matrix matrix1 = transpose(X);
            //转置的参数矩阵乘以参数矩阵
            Matrix matrix2 = mul(matrix1, X);
            //求上一步的逆矩阵 这一步需要矩阵非奇异,若出现奇异矩阵，则返回0矩阵，意味失败
            Matrix matrix3 = inverse(matrix2);
            if (matrix3.getRows() == 1 && matrix3.getCols() == 1) {
                return matrix3;
            } else {
                //逆矩阵乘以转置矩阵
                Matrix matrix4 = mul(matrix3, matrix1);
                //最后乘以输出矩阵,生成权重矩阵并返回
                return mul(matrix4, y);
            }

        }else{
            throw new Exception("matrix is not invertible");
        }
    }







}
