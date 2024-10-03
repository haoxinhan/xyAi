package dataTest;
import org.junit.jupiter.api.Test;
import org.xyai.data.CSVLoader;
import org.xyai.data.DataFrame;

import java.util.List;

public class CSVLoaderTest {
    @Test
    public void testLoadCSV ()  throws Exception{
        CSVLoader csvLoader = new CSVLoader("E:\\pl\\wq\\data\\wine_df.csv");
        DataFrame df=csvLoader.getDataFrame();
        df.print();


    }
}
