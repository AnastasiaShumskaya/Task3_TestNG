import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Class_DataProviderFile {


    private static String fileName = "src\\main\\resources\\provider.txt";
    private Mathematics rez = new Mathematics();

    @BeforeMethod
    public void setUpClass(){
        rez.setResult(0);
    }

    @DataProvider(name = "someDataFile")
    public  Object[][] getFromFile() throws IOException {

        File tFile = new File(fileName);
        FileReader fileReader = new FileReader(tFile);
        List<String> lines = new ArrayList<String>();

        try {
            String line;

            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int fileSize = lines.size();

        Object[][] data = new Object[fileSize][];

        for (int i = 0; i<fileSize; i++) {
            String[] strArr = lines.get(i).split(" ");
            Object[] d = new Object[strArr.length];
            for (int j = 0; j<strArr.length; j++) {
                d[j] = Integer.parseInt(strArr[j]);
            }
            data[i] = d;
        }
        return data;
    }

    @Test(dataProvider = "someDataFile")
    public void testAddDDT(int x, int y) {
        rez.add(x,y);
        Assert.assertEquals(rez.getResult(),x+y);
    }
}
