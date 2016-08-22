package com.gwzd.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * @文件名称: ReadExcel.java
 * @包: com.gwzd.gwzdapi
 * @版本：V1.0
 * @版权所有：北京国网中电自动化技术有限公司
 * 
 * @创建人：高洪涛
 * @创建时间：2014年10月16日
 * @功能简介：读取Excel操作类
 * 
 */
public class ReadExcel
{
    /**
     * @功能简介：读取Excel，返回listString
     * @应用页面：
     * @作者姓名：高洪涛、强当安
     * @创建时间：2014年10月16日 下午7:17:14
     * @param file
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     *             ：
     */
    public static List<String[]> getExcelData(File file) throws FileNotFoundException, IOException
    {
        HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(file));
        // int sheetNum = workbook.getNumberOfSheets();

        short ignore = 0;
        List<String[]> list = new ArrayList<String[]>();
        HSSFSheet sheet = workbook.getSheetAt(0);
        int rows = sheet.getPhysicalNumberOfRows();
        // System.out.println("测试共有行数："+rows);
        int cellNum = sheet.getRow(0).getPhysicalNumberOfCells();
        for (short r = ignore; r < rows; r++)
        {
            // System.out.println("这是第"+r+"行");
            HSSFRow row = sheet.getRow(r); // 获取第r行
            if (row != null)
            {

                // System.out.println("该行有"+cellNum+"列");
                String[] str = new String[cellNum];
                for (short t = 0; t < cellNum; t++)
                {
                    @SuppressWarnings("deprecation")
                    HSSFCell cell = row.getCell(t);
                    String value = "";
                    if (cell == null)
                    {
                        str[t] = value;
                        continue;
                    }
                    // jyc 2015 1 13
                    if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC)
                    {
                        if (HSSFDateUtil.isCellDateFormatted(cell))
                        {
                            // 如果是日期
                            cell.setCellType(HSSFCell.CELL_TYPE_FORMULA);
                        }
                        else
                        {
                            cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                        }
                    }
                    switch (cell.getCellType())
                    {
                        case HSSFCell.CELL_TYPE_NUMERIC :
                            value += (long) (cell.getNumericCellValue());
                            break;
                        case HSSFCell.CELL_TYPE_FORMULA :
                        {
                            // 判断当前的cell是否为Date
                            // if (HSSFDateUtil.isCellDateFormatted(cell)) {
                            // Date date = cell.getDateCellValue();
                            // SimpleDateFormat sdf = new
                            // SimpleDateFormat("yyyy-MM-dd");
                            // value += sdf.format(date);
                            // }
                            // // 如果是纯数字
                            // else {
                            // // 取得当前Cell的数值
                            // value += (long) cell.getNumericCellValue();
                            // }
                            // break;
                            // 判断当前的cell是否为Date
                            if (HSSFDateUtil.isCellDateFormatted(cell))
                            {
                                Date date = cell.getDateCellValue();
                                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                                value += sdf.format(date);
                            }
                            break;
                        }
                        case HSSFCell.CELL_TYPE_STRING :
                            value += cell.getStringCellValue();
                            break;
                        case HSSFCell.CELL_TYPE_BLANK :// blank
                            break;
                        default :
                            value = "";
                    }
                    str[t] = value;
                }
                list.add(str);
            }
        }
        return list;
    }
    /**
     * @功能简介：根据sheet编号获取excel文件的sheet名称
     * @作者姓名：强当安
     * @创建时间：2015年9月18日 下午1:32:49
     * @param file
     * @param sheetNum
     * @throws IOException 
     * @throws FileNotFoundException 
     * @return：
     */
    public static String getSheetNameBySheetNum(File file, int sheetNum) throws FileNotFoundException, IOException
    {
        HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(file));
        return workbook.getSheetAt(sheetNum).getSheetName();
    }
    /**
     * @功能简介：根据sheet编号获取excel文件的sheet名称
     * @作者姓名：强当安
     * @创建时间：2015年9月18日 下午1:35:26
     * @param filePath
     * @param sheetNum
     * @throws IOException 
     * @throws FileNotFoundException 
     * @return：
     */
    public static String getSheetNameBySheetNum(String filePath, int sheetNum) throws FileNotFoundException, IOException{
        return getSheetNameBySheetNum(new File(filePath), sheetNum);
    }
    /**
     * @功能简介：获取指定sheet文件的数据
     * @作者姓名：焦丽娜
     * @创建时间：2015年5月6日 下午5:07:05
     * @参数说明：@param file
     * @参数说明：@param sheetNum sheet的下标值，第一个sheet的下标传0，依次类推
     * @参数说明：@return
     * @参数说明：@throws FileNotFoundException
     * @参数说明：@throws IOException
     * @返回类型：List<String[]>
     */
    public static List<String[]> getExcelDataBySheetNum(File file, int sheetNum) throws FileNotFoundException, IOException
    {
        HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(file));
        // int sheetNum = workbook.getNumberOfSheets();
        short ignore = 0;
        List<String[]> list = new ArrayList<String[]>();
        HSSFSheet sheet = workbook.getSheetAt(sheetNum);
        int rows = sheet.getPhysicalNumberOfRows();
        // System.out.println("测试共有行数："+rows);
        int cellNum = sheet.getRow(0).getPhysicalNumberOfCells();
        for (short r = ignore; r < rows; r++)
        {
            // System.out.println("这是第"+r+"行");
            HSSFRow row = sheet.getRow(r); // 获取第r行
            if (row != null)
            {

                // System.out.println("该行有"+cellNum+"列");
                String[] str = new String[cellNum];
                for (short t = 0; t < cellNum; t++)
                {
                    @SuppressWarnings("deprecation")
                    HSSFCell cell = row.getCell(t);
                    String value = "";
                    if (cell == null)
                    {
                        str[t] = value;
                        continue;
                    }
                    // jyc 2015 1 13
                    if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC)
                    {
                        if (HSSFDateUtil.isCellDateFormatted(cell))
                        {
                            // 如果是日期
                            cell.setCellType(HSSFCell.CELL_TYPE_FORMULA);
                        }
                        else
                        {
                            cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                        }
                    }
                    switch (cell.getCellType())
                    {
                        case HSSFCell.CELL_TYPE_NUMERIC :
                            value += (long) (cell.getNumericCellValue());
                            break;
                        case HSSFCell.CELL_TYPE_FORMULA :
                        {
                            // 判断当前的cell是否为Date
                            // if (HSSFDateUtil.isCellDateFormatted(cell)) {
                            // Date date = cell.getDateCellValue();
                            // SimpleDateFormat sdf = new
                            // SimpleDateFormat("yyyy-MM-dd");
                            // value += sdf.format(date);
                            // }
                            // // 如果是纯数字
                            // else {
                            // // 取得当前Cell的数值
                            // value += (long) cell.getNumericCellValue();
                            // }
                            // break;
                            // 判断当前的cell是否为Date
                            if (HSSFDateUtil.isCellDateFormatted(cell))
                            {
                                Date date = cell.getDateCellValue();
                                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                                value += sdf.format(date);
                            }
                            break;
                        }
                        case HSSFCell.CELL_TYPE_STRING :
                            value += cell.getStringCellValue();
                            break;
                        case HSSFCell.CELL_TYPE_BLANK :// blank
                            break;
                        default :
                            value = "";
                    }
                    str[t] = value;
                }
                list.add(str);
            }
        }
        return list;
    }

    /**
     * @功能简介：根据文件路径读取Excel
     * @应用页面：
     * @作者姓名：高洪涛、强当安
     * @创建时间：2014年10月16日 下午7:18:11
     * @param path
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     *             ：
     */
    @SuppressWarnings("deprecation")
    public static List<String[]> getExcelData(String path) throws FileNotFoundException, IOException
    {
        return getExcelData(new File(path));
    }

    // }
    /**
     * @功能简介：根据文件路径读取Excel
     * @应用页面：
     * @作者姓名：高洪涛、强当安
     * @创建时间：2014年10月16日 下午7:18:11
     * @param path
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     *             ：
     */
    @SuppressWarnings("deprecation")
    public static List<String[]> getExcelDataBySheetNum(String path, int sheetNum) throws FileNotFoundException, IOException
    {
        return getExcelDataBySheetNum(new File(path), sheetNum);
    }
    /**
     * @功能简介：格式化单元格字符串，主要针对时间，目标没用
     * @应用页面：
     * @作者姓名：高洪涛、强当安
     * @创建时间：2014年10月16日 下午7:21:36
     * @param cell
     * @return：
     */
    @SuppressWarnings("unused")
    @Deprecated
    private String getCellFormatValue(HSSFCell cell)
    {
        String cellvalue = "";
        if (cell != null)
        {
            // 判断当前Cell的Type
            switch (cell.getCellType())
            {
            // 如果当前Cell的Type为NUMERIC
                case HSSFCell.CELL_TYPE_NUMERIC :
                case HSSFCell.CELL_TYPE_FORMULA :
                {
                    // 判断当前的cell是否为Date
                    if (HSSFDateUtil.isCellDateFormatted(cell))
                    {
                        // 如果是Date类型则，转化为Data格式
                        // 方法1：这样子的data格式是带时分秒的：2011-10-12 0:00:00
                        // cellvalue = cell.getDateCellValue().toLocaleString();
                        // 方法2：这样子的data格式是不带带时分秒的：2011-10-12
                        Date date = cell.getDateCellValue();
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        cellvalue = sdf.format(date);
                    }
                    // 如果是纯数字
                    else
                    {
                        // 取得当前Cell的数值
                        cellvalue = String.valueOf(cell.getNumericCellValue());
                    }
                    break;
                }
                // 如果当前Cell的Type为STRIN
                case HSSFCell.CELL_TYPE_STRING :
                    // 取得当前的Cell字符串
                    cellvalue = cell.getRichStringCellValue().getString();
                    break;
                // 默认的Cell值
                default :
                    cellvalue = " ";
            }
        }
        else
        {
            cellvalue = "";
        }
        return cellvalue;
    }

}
