package util;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Minister on 2017/5/3.
 */
public class ExcelHelper {
    /**
     * 将单元格数据转换为字符串对象
     * @param cell 单元格对象
     * @return 处理后的数据
     */
    private String getValue(Cell cell){
        String result = "";
        switch (cell.getCellType()){
            case Cell.CELL_TYPE_BOOLEAN:
                result = cell.getBooleanCellValue()+"";
                break;
            case Cell.CELL_TYPE_STRING:
                result = cell.getStringCellValue();
                break;
            case Cell.CELL_TYPE_FORMULA:
                result = cell.getCellFormula();
                break;
            case Cell.CELL_TYPE_NUMERIC:
                // 可能是普通数字，也可能是日期
                if (HSSFDateUtil.isCellDateFormatted(cell)) {
                    result = DateUtil.getJavaDate(cell.getNumericCellValue())
                            .toString();
                } else {
                    result = cell.getNumericCellValue() + "";
                }
                break;
        }
        return result;
    }

    /**
     * 读取EXCEL(.xlsx)文件 MS2007及以上
     * @param in 待处理文件的输入流
     * @param fieldNum 处理的字段数
     * @param startRowIndex 开始的行数,从0开始
     */
    public List<List<String>> importXlsx(InputStream in, int fieldNum, int startRowIndex){
        List<List<String>> tableList = new ArrayList<>();
        try {
            Workbook wb = WorkbookFactory.create(in);
            //循环生成工作簿对象
            for (int i = 0,len = wb.getNumberOfSheets();i < len;i ++){
                Sheet sheet = wb.getSheetAt(i);
                if(sheet == null){
                    continue;
                }
                //循环生成行对象
                row:for (int j = 0;j <= sheet.getLastRowNum();j ++){
                    Row row = sheet.getRow(j);
                    if(row == null||j<startRowIndex){
                        continue;
                    }
                    List<String> rowList = new ArrayList<>();
                    //循环生成单元格对象
                    cell:for(int k=0;k<fieldNum;k++){
                        Cell cell = row.getCell(k);
                        if(cell == null||getValue(cell).equals("")){
                            if(k<1){continue row;}
                            rowList.add("");
                            //System.out.print("null\t");
                            continue;
                        }
                        rowList.add(getValue(cell));
                        //System.out.print(getValue(cell)+"\t");
                    }
                    tableList.add(rowList);
                    //System.out.println();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tableList;
    }
    //测试
    public static void main(String[] args){
        ExcelHelper helper = new ExcelHelper();
        try {
            InputStream in = new FileInputStream(new File("d:/a.xlsx"));
            List<List<String>> l = helper.importXlsx(in,15,1);
            System.out.println(l.size()+" "+l.get(0).size());
            for (List<String> row:l) {
                for (String cell:row) {
                    System.out.print(cell+"\t");
                }
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
