package org.xyai.data;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class CSVLoader {

    private File file;
    public CSVLoader(String filePath) {
        //open the file
        file = new File(filePath);
        if (!file.exists()) {
            throw new IllegalArgumentException("File not found: " + filePath);
        }
    }
    public DataFrame getDataFrame() throws IOException {
        DataFrame df = new DataFrame();
        List<String> allLines = Files.readAllLines(Paths.get(file.getAbsolutePath()));
        List<String>headers = Arrays.asList(allLines.get(0).split(","));
        for (int i = 0; i < headers.size(); i++) {
            df.addColumn(headers.get(i), new ArrayList<Double>());
        }
        for (int i = 1; i < allLines.size(); i++) {
            ArrayList<String> vs=new ArrayList<>();

            String[] values = allLines.get(i).split(",");
            for (int j=0 ;j<headers.size();j++){
                if (j>=values.length){
                    vs.add(null);
                }else {
                    vs.add(values[j]);
                }
            }

            for (int j = 0; j < vs.size(); j++) {
                String vname = headers.get(j);
                HashMap<String, Double> row = new HashMap<>();
                try {
                    row.put(vname, Double.parseDouble(vs.get(j)));
                }catch (Exception e){
                    row.put(vname, null);
                }
                df.addRow(row);
            }

        }

        return df;

    }
}
