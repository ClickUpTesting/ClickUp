package unittest;

import core.utils.ExcelReader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class ExcelReaderTest {
    ExcelReader excelReader = new ExcelReader();

    @DataProvider(name = "excelReader")
    public static Object[][] valuesOfCellAndSheep() {
        return new Object[][]{{"Staff", "Jorge", "30"},
                {"Video Games", "Dark Soul", "2005"},
                {"Video Games", "Minecraft", "2001"},
                {"Product", "Potato", "5"},
                {"Product", "Tomato", "2"}};
    }

    @Test(dataProvider = "excelReader")
    public void getValueOfCorrespondsTheCell(String nameSheep, String valueToFind, String expected) throws IOException {
        excelReader.openLocation("src/test/resources/test/ExcelReaderTest.xlsx");
        String actual = excelReader.getValueInNextColumn(nameSheep, valueToFind);
        Assert.assertEquals(actual, expected);
    }
}
