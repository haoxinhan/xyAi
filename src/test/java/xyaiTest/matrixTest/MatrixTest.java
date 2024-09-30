package xyaiTest.matrixTest;
import org.junit.jupiter.api.Test;
import org.xyai.matrix.Matrix;


public class MatrixTest {

    @Test
    public void matrixInitTest() {

        Matrix m = new Matrix(2, 2);
        System.out.println(m);

        Matrix m2=new Matrix(1,1);
        System.out.println(m2);

        Matrix m3=new Matrix(1,2);
        System.out.println(m3);

        Matrix m4=new Matrix(2,1);
        System.out.println(m4);




    }
    @Test
    public void matrixSetAllTest() {

        String data1="1 1\n" +
                "2 2 ";
        try {
            Matrix m1 = new Matrix(2, 2,data1);
            System.out.println(m1);
        }
        catch (Exception e){
            System.out.println("m1:");
            System.out.println(e.getMessage());
        }

        String data2="1 1 1\n" +
                "2 2 2 ";
        try {
            Matrix m2 = new Matrix(2, 2,data2);
            System.out.println(m2);
        }
        catch (Exception e){
            System.out.println("m2:");
            System.out.println(e.getMessage());
        }
        String data3="1 1 1 1\n" +
                "2 2 2 2 ";
        try {
            Matrix m3 = new Matrix(1, 2,data3);
            System.out.println(m3);
        }
        catch (Exception e){
            System.out.println("m3:");
            System.out.println(e.getMessage());
        }

    }



}
