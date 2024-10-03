package dataTest;
import org.xyai.data.DataFrame;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataFreamTest
{
    @Test
    public void testNew(){
        DataFrame df = new DataFrame();
    }
    @Test
    public void testAddColumn(){
        DataFrame df = new DataFrame();
        df.addColumn("col1",new ArrayList<Double>());
        df.print();
        List<Double> list = new ArrayList<>();
        list.add(1.0);
        list.add(2.0);
        df.addColumn("age",list);
        df.print();

    }
    @Test
    public void testAddRow(){
        DataFrame df = new DataFrame();
        df.addColumn("col1",new ArrayList<Double>());

        Map<String, Double> r1=new HashMap<>();
        r1.put("col1",1.0);

        df.addRow(r1);
        df.print();
    }
    @Test
    public void testDeleteNullRow(){
        DataFrame df = new DataFrame();
        df.addColumn("col1",new ArrayList<Double>());
        df.addColumn("col2",new ArrayList<Double>());
        Map<String, Double> r1=new HashMap<>();
        r1.put("col1",1.0);
        r1.put("col2",2.0);
        df.addRow(r1);
        Map<String, Double> r2=new HashMap<>();
        Map<String, Double> r3=new HashMap<>();
        r2.put("col1",null);
        r2.put("col2",3.0);
        r3.put("col1",null);
        r3.put("col2",null);
        df.addRow(r2);
        df.addRow(r3);
        df.print();
        df.deleteNullRow();
        df.print();

    }
    @Test
    public void testToMatrix() throws Exception {
        DataFrame df = new DataFrame();
        df.addColumn("col1",new ArrayList<Double>());
        df.addColumn("col2",new ArrayList<Double>());
        Map<String, Double> r1=new HashMap<>();
        r1.put("col1",1.0);
        r1.put("col2",2.0);
        df.addRow(r1);
        Map<String, Double> r2=new HashMap<>();
        Map<String, Double> r3=new HashMap<>();
        r2.put("col1",null);
        r2.put("col2",3.0);
        r3.put("col1",null);
        r3.put("col2",null);
        df.addRow(r2);
        df.addRow(r3);
        df.deleteNullRow();
        df.print();


        System.out.println(df.toMatrix());
    }
    @Test
    public void testTolist(){
        DataFrame df = new DataFrame();
        df.addColumn("col1",new ArrayList<Double>());
        df.addColumn("col2",new ArrayList<Double>());
        Map<String, Double> r1=new HashMap<>();
        r1.put("col1",1.0);
        r1.put("col2",2.0);
        df.addRow(r1);
        Map<String, Double> r2=new HashMap<>();
        Map<String, Double> r3=new HashMap<>();
        r2.put("col1",null);
        r2.put("col2",3.0);
        r3.put("col1",null);
        r3.put("col2",null);
        df.addRow(r2);
        df.addRow(r3);
        df.deleteNullRow();
        df.print();
        System.out.println(df.toList());


    }


    @Test
    public void testTrainTestSplit() throws Exception {
        DataFrame df = new DataFrame();
        df.addColumn("col1",new ArrayList<Double>());
        Map<String, Double> r1=new HashMap<>();
        r1.put("col1",1.0);
        df.addRow(r1);
        Map<String, Double> r2=new HashMap<>();
        r2.put("col1",2.0);
        df.addRow(r2);
        Map<String, Double> r3=new HashMap<>();
        r3.put("col1",3.0);
        df.addRow(r3);
        Map<String,Double> r4=new HashMap<>();
        r4.put("col1",4.0);
        df.addRow(r4);
        df.print();
        Map<String,DataFrame> map = df.trainTestSplit(df,0.5,1);
        map.forEach((k,v)->{v.print();});

    }
}
