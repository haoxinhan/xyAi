package org.xyai.matrix;

public class Matrix {
    //行数和列数
    private int rows;
    private int cols;
    //矩阵元素
    private double[][] data;

    public boolean isVector=false;
    public boolean isRowVector=false;
    public boolean isZero=false;


    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

    public Matrix(int rows, int cols) {
        data=new double[rows][cols];
        this.rows=rows;
        this.cols=cols;

        //set state
        if (rows==1 && cols==1){
            isVector=true;
            isZero=true;
        }else if(rows==1 || cols==1) {
            isVector = true;
            if (rows == 1) {
                isRowVector = true;
            } else {
                isRowVector = false;
            }

        }
    }




    public Matrix(int rows,int cols, String d)throws Exception {

        data=new double[rows][cols];
        this.rows=rows;
        this.cols=cols;

        //set state
        if (rows==1 && cols==1){
            isZero=true;
        }else if(rows==1 || cols==1) {
            isVector = true;
            if (rows == 1) {
                isRowVector = true;
            } else {
                isRowVector = false;
            }

        }
        setAll(d);
    }

    public void setAll  (String d)throws Exception {
        String[] rs=d.split("\n");
        if (rs.length==rows){
            for (int i=0;i<rows;i++){
                String r = rs[i];
                String[] es=r.split(" ");
                if (es.length==cols){
                    for (int j=0;j<cols;j++){
                        data[i][j]=Double.parseDouble(es[j]);
                    }
                }
                else throw new Exception("cols not match");


            }

        } else throw new Exception("rows not match");




    }


    public String getString() {
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                sb.append(data[i][j]);
                sb.append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Matrix{" +"\n"+
                "rows=" + rows +"\n"+
                "cols=" + cols +"\n"+
                "isVector="+isVector+"\n"+
                "isRowVector="+isRowVector+"\n"+
                "isZero="+isZero+"\n"+
                "data=" + "\n" +getString()+
                '}';
    }

    public double get(int i,int j)throws Exception {

        if (i<=rows && j<=cols && i>0 && j>0){
            return data[i-1][j-1];
        }else throw new Exception("out of range");
    }


    public void set(int i,int j,double d)throws Exception {
        if (i<=rows && j<=cols && i>0 && j>0)
            data[i-1][j-1]=d;
        else throw new Exception("out of range");

    }




}
