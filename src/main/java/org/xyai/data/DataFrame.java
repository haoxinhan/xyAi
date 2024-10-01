package org.xyai.data;

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


    // 构造函数
    public DataFrame() {
        this.data = new LinkedHashMap<>(); // 使用LinkedHashMap来保持插入顺序
        this.columnNames = new ArrayList<>();
    }

    // 添加一行数据
    public void addRow(Map<String, Double> row) {
        for (String columnName : row.keySet()) {
            if (!data.containsKey(columnName)) {
                data.put(columnName, new ArrayList<>());
                columnNames.add(columnName);
            }
            data.get(columnName).add(row.get(columnName));
        }
    }

    // 添加一列数据
    public void addColumn(String columnName, List<Double> columnData) {
        if (columnData == null || (data.containsKey(columnName) && columnData.size() != getRowCount())) {
            throw new IllegalArgumentException("Column data size must match number of rows if column exists");
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
    public int getRowCount() {
        if (data.isEmpty()) {
            return 0;
        }
        return data.get(columnNames.get(0)).size();
    }

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

        for (int i = 0; i < n; i++) {
            for (String columnName : columnNames) {
                System.out.print(data.get(columnName).get(i) + ",\t");
            }
            System.out.println();
        }
    }


}

