package org.xyai.data;

import org.xymatrix.Matrix;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

import java.util.*;
import java.util.stream.Collectors;

public class DataFrame {
    // 使用Map来存储列名和列数据
    private Map<String, List<Double>> data;
    // 存储列名的列表，用于保持顺序
    private List<String> columnNames;
    //get row
    public List<Object> getRow(int rowIndex) {

        return data.values().stream()
                .map(column -> column.get(rowIndex))
                .collect(Collectors.toList());
    }


    public int getRowCount() {
        if (data.isEmpty()) {
            return 0;
        }
        int max=0;
        for (String columnName : columnNames) {
            if (data.get(columnName).size() > max) {
                max = data.get(columnName).size();

            }
        }
        return max;
    }


    // 构造函数
    public DataFrame() {
        this.data = new LinkedHashMap<>(); // 使用LinkedHashMap来保持插入顺序
        this.columnNames = new ArrayList<>();
    }

    // 添加一行数据
    public void addRow(Map<String, Double> row) {
        for (String columnName : row.keySet()) {
            if (!data.containsKey(columnName)) {
                throw new IllegalArgumentException("Column " + columnName + " does not exist");
            }
            data.get(columnName).add(row.get(columnName));
        }
    }

    // 添加一列数据
    public void addColumn(String columnName, List<Double> columnData) {
        if (columnData == null || (data.containsKey(columnName) && columnData.size() != getRowCount())) {
            throw new IllegalArgumentException("Column data size must match number of rows if column exists");
        }
        int length=this.getRowCount();
        if (columnData.size() != length) {
            if (columnData.size() < length) {
                for (int i = columnData.size(); i < length; i++) {
                    columnData.add(null);
                }
            }
            else {
                for (String cname: columnNames) {
                    if (cname.equals(columnName)) {
                        continue;
                    }
                    List<Double> cdata = data.get(cname);
                    for (int i = cdata.size(); i < columnData.size() ; i++) {
                        cdata.add(null);
                    }
                }
            }
        }
        data.put(columnName, columnData);
        if (!columnNames.contains(columnName)) {
            columnNames.add(columnName);
        }
    }

    // 获取指定列名的数据
    public List<Double> getColumn(String columnName) {
        if (!data.containsKey(columnName)) {
            throw new NoSuchElementException("Column name not found");
        }
        return data.get(columnName);
    }

    // 获取所有列名
    public List<String> getColumnNames() {
        return new ArrayList<>(columnNames);
    }

    // 获取行数

    // 获取列数
    public int getColumnCount() {
        return columnNames.size();
    }

    // 打印DataFrame的内容
    public void print() {
        // 打印列名
        System.out.print("  ");
        for (String columnName : columnNames) {
            System.out.print(columnName + ",\t");
        }
        System.out.println();

        // 打印分隔线（可选）
        System.out.print("---");
        for (int i = 0; i < columnNames.size(); i++) {
            System.out.print("---\t");
        }
        System.out.println();

        // 打印每一行的数据
        for (int i = 0; i < getRowCount(); i++) {
            for (String columnName : columnNames) {
                System.out.print(data.get(columnName).get(i) + ",\t");

            }
            System.out.println();
        }
    }

    // 删除一列
    public void deleteColumn(String columnName) {
        if (data.containsKey(columnName)) {
            data.remove(columnName);
            columnNames.remove(columnName);
        } else {
            System.out.println("Column name not found");
        }
    }

    // 删除一行（通过索引）
    public void deleteRow(int rowIndex) {
        if (rowIndex < 0 || rowIndex >= getRowCount()) {
            throw new IndexOutOfBoundsException("Row index out of bounds");
        }
        for (List<Double> column : data.values()) {
            column.remove(rowIndex);
        }
    }

    public void print_head(){
        //print head

        for (String columnName : columnNames) {
            System.out.print(columnName + ",\t");

        }
    }

    public void print(int n){
        print_head();
        System.out.println();
        for (int i = 0; i < n; i++) {
            for (String columnName : columnNames) {
                System.out.print(data.get(columnName).get(i) + ",\t");
            }
            System.out.println();
        }
    }
    public DataFrame getRowToDataFrame(int n){
        DataFrame df = new DataFrame();
        for (String columnName : columnNames) {
            List<Double> d = new ArrayList<>();
            d.add(data.get(columnName).get(n));

            df.addColumn(columnName, d);
        }
        return df;
    }
public DataFrame getColumnToDataFrame(String columnName) {
    DataFrame df = new DataFrame();
    df.addColumn(columnName, data.get(columnName));
    return df;
}

//删除有null的行
public void deleteNullRow(){
    for (int i = 0; i < getRowCount(); i++) {
        for (String columnName : columnNames) {
            if (data.get(columnName).get(i) == null) {
                deleteRow(i);
                i--;
                break;
            }
        }
    }
}

public Matrix toMatrix() throws Exception {
    Matrix m = new Matrix(getRowCount(), getColumnCount());
    for (int i = 0; i < getRowCount(); i++) {
        for (int j = 0; j < getColumnCount(); j++) {
            m.set(i+1, j+1, data.get(columnNames.get(j)).get(i));

        }
    }
    return m;
}

    public List<Map<String,Double>> toList(){
        List<Map<String,Double>> list = new ArrayList<>();
        for (int i = 0; i < getRowCount(); i++) {
            Map<String,Double> map = new HashMap<>();
            for (String columnName : columnNames) {
                map.put(columnName,data.get(columnName).get(i));
            }
            list.add(map);
        }
        return list;
    }
    public void addColumn(String columnName) {
        if (!columnNames.contains(columnName)) {
            columnNames.add(columnName);
            data.put(columnName, new ArrayList<>());

        }
    }

    public void addColumns(List<String> columns) {
        for (String columnName : columns) {
            if (!columnNames.contains(columnName)) {
                this.addColumn(columnName);
            }
        }

    }

    public static Map<String,DataFrame> trainTestSplit(DataFrame dataFrame, double test_size, long random_state	) throws Exception
    {
        Map<String,DataFrame> map = new HashMap<>();
        DataFrame train = new DataFrame();
        DataFrame test = new DataFrame();

        train.addColumns(dataFrame.getColumnNames());
        test.addColumns(dataFrame.getColumnNames());


        //随机打乱数据
        List<Map<String,Double>> list = dataFrame.toList();
        if(random_state!=0){
            Random random = new Random(random_state);
            Collections.shuffle(list,random);

        }else {
            Random random = new Random();
            Collections.shuffle(list,random);
        }
        int train_size = (int) (list.size() * (1 - test_size));
        for (int i = 0; i < train_size; i++) {
            train.addRow(list.get(i));
        }
        for (int i = train_size; i < list.size(); i++) {
            test.addRow(list.get(i));
        }
        map.put("train",train);
        map.put("test",test);

        return map;


    }

    public DataFrame copy(){
        DataFrame df = new DataFrame();
        df.columnNames = new ArrayList<>(columnNames);
        df.data = new HashMap<>(data);
        return df;

    }

    public DataFrame dropColumn(String columnName) {
        if (columnNames.contains(columnName)) {
            DataFrame df=copy();
            df.columnNames.remove(columnName);
            df.data.remove(columnName);
            return df;

        }
        throw new IllegalArgumentException("Column " + columnName + " does not exist in the DataFrame");


    }



}

