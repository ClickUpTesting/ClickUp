/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Gustavo Huanca
 */

package core.utils;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import java.io.File;
import java.io.IOException;

public class ExcelReader {
    public Workbook workbook;
    private DataFormatter dataFormatter;

    public ExcelReader() {
        dataFormatter = new DataFormatter();
    }

    /**
     * Opens a file type .xlsx
     *
     * @param fileLocation is file to locate excel file
     * @throws IOException is exception file doesn't exist or wrong path
     * @author Gustavo Huanca
     */
    public void openLocation(final String fileLocation) throws IOException {
        workbook = WorkbookFactory.create(new File(fileLocation));
    }

    /**
     * Sets sheet of excel or workbook
     *
     * @param sheetName is name of sheet
     * @return a Sheet with name sheetName
     * @author Gustavo Huanca
     */
    protected Sheet setSheet(final String sheetName) {
        return workbook.getSheet(sheetName);
    }

    /**
     * Gets coordinate of valueToFind in the sheetName.
     *
     * @param sheetName   is name of sheet
     * @param valueToFind is a value to find in sheet
     * @return is of Coordinate type
     * @author Gustavo Huanca
     */
    protected Coordinate getValueOfCell(final String sheetName, final String valueToFind) {
        Sheet sheet = setSheet(sheetName);
        for (Row row : sheet) {
            for (Cell cell : row) {
                String cellValue = dataFormatter.formatCellValue(cell);
                if (cellValue.equals(valueToFind)) {
                    return new Coordinate(cell.getColumnIndex(), row.getRowNum());
                }
            }
        }
        return null;
    }

    /**
     * Gets a value in coordinate
     *
     * @param sheetName is name of sheet
     * @param rowNum    is number row of cell
     * @param columnNum is number column of cell
     * @return a value of cell
     * @author Gustavo Huanca
     */
    public String getValueASpecificCellAndRow(final String sheetName, final int rowNum, final int columnNum) {
        Sheet sheet = setSheet(sheetName);
        Row row = sheet.getRow(rowNum);
        Cell cell = row.getCell(columnNum);
        return dataFormatter.formatCellValue(cell);
    }

    /**
     * Gets value the next column and the same row where found the valueToFind.
     *
     * @param sheetName   is name of sheet
     * @param valueToFind is value to find
     * @return a value of next to column
     * @author Gustavo Huanca
     */
    public String getValueInNextColumn(final String sheetName, final String valueToFind) {
        Coordinate coordinate = getValueOfCell(sheetName, valueToFind);
        return getValueASpecificCellAndRow(sheetName, coordinate.getRow(), coordinate.getColumn() + 1);
    }
}
