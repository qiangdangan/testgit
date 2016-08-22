package com.gwzd.util;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;


/**
 * @文件名称: ExportExcelUtil.java 
 * @包: com.gwzd.gwzdapi 
 * @版本：V1.0  
 * @版权所有：北京国网中电自动化技术有限公司
 * 
 * @创建人：高洪涛
 * @创建时间：2014年10月16日
 * @功能简介：Excel导出类
 *
 */
public class ExportExcelUtil
{
    /**
     * 导出excel
     * @param contentList 内容list
     * @param xmlPath 配置文件地址
     * @param jdNodeName 节点名称
     * @return
     */
    public static String exportExcel(
            List<Map<String, Object>> contentList, String xmlPath,
            String jdNodeName) {
        WritableWorkbook wwb = null;
        String fileName="";
        try {
            String filePath=ExportExcelUtil.class.getResource("/").getPath();
            filePath=filePath.substring(0, filePath.indexOf("WEB-INF"))+"tmp/";
            filePath=filePath.replaceAll("%20", " ");
            fileName=filePath+UUID.randomUUID().toString()+"tmp.xls";
            File file=new File(fileName);
            if(!file.exists()){
//              file.getParentFile().mkdir();
//              FileUtil.deleteFile(filePath);
                file.getParentFile().mkdir();
                file.createNewFile();
            }
            // 首先要使用Workbook类的工厂方法创建一个可写入的工作薄(Workbook)对象
            wwb = Workbook.createWorkbook(new File(fileName));
            // 创建一个可写入的工作表
            // Workbook的createSheet方法有两个参数，第一个是工作表的名称，第二个是工作表在工作薄中的位置
            WritableSheet ws = wwb.createSheet("sheet1", 0);
            
            // 表头 字体样式
            WritableFont wf_title = new WritableFont(WritableFont.createFont("黑体"),
                    13, WritableFont.NO_BOLD, false);
            WritableCellFormat wctitle = new WritableCellFormat(wf_title);
            wctitle.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
            wctitle.setAlignment(Alignment.CENTRE);
            wctitle.setBackground(Colour.GRAY_25);
            /***
             * jyq setWrap 控制可换行
             */
            wctitle.setVerticalAlignment(VerticalAlignment.CENTRE);// 字体上下居中
            wctitle.setWrap(true);
            
            //写入表头
            List<Map<String,Object>> list=XmlReadUtil.getExpExcelFields(xmlPath, jdNodeName);
            Label labelC = new Label(0, 0, "序号",wctitle);
            ws.addCell(labelC);
            String[] valueMembers=new String[list.size()+1];
            valueMembers[0]="";
            for(int i=0; i<list.size(); i++){
                
                Map<String,Object> map = list.get(i);
                String width =map.get("width").toString(); //宽度
                String valueMember =map.get("valueMember").toString(); //字段属性
                String fieldName =map.get("fieldName").toString(); //字段名称
                valueMembers[i+1]=valueMember;
                Label labelC2 = new Label(i+1, 0, fieldName,wctitle);
                ws.addCell(labelC2);
                ws.setColumnView(i+1, DataSwitch.convertObjectToInteger(width));
            }
            if(contentList!=null && contentList.size()>0){
                WritableFont w2 = new WritableFont(WritableFont.ARIAL, 10,
                        WritableFont.NO_BOLD, false,
                        UnderlineStyle.NO_UNDERLINE, Colour.BLACK);
                WritableCellFormat ww2 = new WritableCellFormat(w2);
                ww2.setBorder(jxl.format.Border.ALL,jxl.format.BorderLineStyle.THIN);
                ww2.setAlignment(Alignment.CENTRE);
                /***
                 * jyq setWrap 控制可换行
                 */
                ww2.setVerticalAlignment(VerticalAlignment.CENTRE);// 字体上下居中
                ww2.setWrap(true);
                for(int i=0; i<contentList.size(); i++){
                    Map<String, Object> map = contentList.get(i);
                    Label labelC2 = new Label(0, i+1, (i+1)+"",ww2);
                    ws.addCell(labelC2);
                    for(int j=1; j<valueMembers.length; j++){
                        Label labelC3 = new Label(j, i+1, DataSwitch.convertObjectToString(map.get(valueMembers[j])),ww2);
                        ws.addCell(labelC3);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                // 从内存中写入文件中
                wwb.write();
                // 关闭资源，释放内存
                wwb.close();
            } catch (Exception e) {
                e.printStackTrace();
            } 
        }
        return fileName;
    }
	/**
	 * 导出excel
	 * 
	 * @param contentList
	 *            内容list
	 * @param fieldList
	 *            数据字段和列名
	 * @return
	 */
	public static String exportExcel(List<Map<String, Object>> contentList, List<Map<String, Object>> fieldList)
	{
		WritableWorkbook wwb = null;
		String fileName = "";
		try
		{
			String filePath = ExportExcelUtil.class.getResource("/").getPath();
			filePath = filePath.substring(0, filePath.indexOf("WEB-INF")) + "tmp/";
			filePath = filePath.replaceAll("%20", " ");
			fileName = filePath + UUID.randomUUID().toString() + "tmp.xls";
			File file = new File(fileName);
			if (!file.exists())
			{
				// file.getParentFile().mkdir();
				// FileUtil.deleteFile(filePath);
				file.getParentFile().mkdir();
				file.createNewFile();
			}
			// 首先要使用Workbook类的工厂方法创建一个可写入的工作薄(Workbook)对象
			wwb = Workbook.createWorkbook(new File(fileName));
			// 创建一个可写入的工作表
			// Workbook的createSheet方法有两个参数，第一个是工作表的名称，第二个是工作表在工作薄中的位置
			WritableSheet ws = wwb.createSheet("sheet1", 0);

			// 表头 字体样式
			WritableFont wf_title = new WritableFont(WritableFont.createFont("黑体"), 13, WritableFont.NO_BOLD, false);
			WritableCellFormat wctitle = new WritableCellFormat(wf_title);
			wctitle.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
			wctitle.setAlignment(Alignment.CENTRE);
			wctitle.setBackground(Colour.GRAY_25);

			// 写入表头
			Label labelC = new Label(0, 0, "序号", wctitle);
			ws.addCell(labelC);
			String[] valueMembers = new String[fieldList.size() + 1];
			valueMembers[0] = "";
			for (int i = 0; i < fieldList.size(); i++)
			{

				Map<String, Object> map = fieldList.get(i);
				String width = "30"; // 宽度
				String valueMember = map.get("field").toString(); // 字段属性
				String fieldName = map.get("columnName").toString(); // 字段名称
				valueMembers[i + 1] = valueMember;
				Label labelC2 = new Label(i + 1, 0, fieldName, wctitle);
				ws.addCell(labelC2);
				ws.setColumnView(i + 1, DataSwitch.convertObjectToInteger(width));
			}

			if (contentList != null && contentList.size() > 0)
			{
				WritableFont w2 = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.BLACK);
				WritableCellFormat ww2 = new WritableCellFormat(w2);
				ww2.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
				ww2.setAlignment(Alignment.CENTRE);
				for (int i = 0; i < contentList.size(); i++)
				{
					Map<String, Object> map = contentList.get(i);
					Label labelC2 = new Label(0, i + 1, (i + 1) + "", ww2);
					ws.addCell(labelC2);
					for (int j = 1; j < valueMembers.length; j++)
					{
						Label labelC3 = new Label(j, i + 1, DataSwitch.convertObjectToString(map.get(valueMembers[j])), ww2);
						ws.addCell(labelC3);
					}
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				// 从内存中写入文件中
				wwb.write();
				// 关闭资源，释放内存
				wwb.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		return fileName;
	}

	/**
	 * 导出excel
	 * 
	 * @param contentList
	 *            内容list
	 * @param titleList
	 *            表头
	 * @return
	 */
	public static String exportExcel(List<String[]> contentList, String[] titleNames)
	{
		WritableWorkbook wwb = null;
		String fileName = "";
		try
		{
			String filePath = ExportExcelUtil.class.getResource("/").getPath();
			filePath = filePath.substring(0, filePath.indexOf("WEB-INF")) + "tmp/";
			filePath = filePath.replaceAll("%20", " ");
			fileName = filePath + UUID.randomUUID().toString() + "tmp.xls";
			File file = new File(fileName);
			if (!file.exists())
			{
				// file.getParentFile().mkdir();
				// FileUtil.deleteFile(filePath);
				file.getParentFile().mkdir();
				file.createNewFile();
			}
			// 首先要使用Workbook类的工厂方法创建一个可写入的工作薄(Workbook)对象
			wwb = Workbook.createWorkbook(new File(fileName));
			// 创建一个可写入的工作表
			// Workbook的createSheet方法有两个参数，第一个是工作表的名称，第二个是工作表在工作薄中的位置
			WritableSheet ws = wwb.createSheet("sheet1", 0);

			// 表头 字体样式
			WritableFont wf_title = new WritableFont(WritableFont.createFont("黑体"), 13, WritableFont.NO_BOLD, false);
			WritableCellFormat wctitle = new WritableCellFormat(wf_title);
			wctitle.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
			wctitle.setAlignment(Alignment.CENTRE);
			wctitle.setBackground(Colour.GRAY_25);

			// 写入表头
			for (int i = 0; i < titleNames.length; i++)
			{

				String width = "20"; // 宽度
				Label labelC2 = new Label(i, 0, titleNames[i], wctitle);
				ws.addCell(labelC2);
				ws.setColumnView(i, DataSwitch.convertObjectToInteger(width));
			}
			Label labelC2 = new Label(titleNames.length, 0, "备注", wctitle);
			ws.addCell(labelC2);
			ws.setColumnView(titleNames.length, 50);

			// 写入数据
			if (contentList != null && contentList.size() > 0)
			{
				WritableFont w2 = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.BLACK);
				WritableCellFormat ww2 = new WritableCellFormat(w2);
				ww2.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
				ww2.setAlignment(Alignment.CENTRE);
				for (int i = 0; i < contentList.size(); i++)
				{
					String[] datas = contentList.get(i);
					for (int j = 0; j < datas.length; j++)
					{
						Label labelC3 = new Label(j, i + 1, datas[j], ww2);
						ws.addCell(labelC3);
					}
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				// 从内存中写入文件中
				wwb.write();
				// 关闭资源，释放内存
				wwb.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		return fileName;
	}

	/**
	 * @功能简介：导出Execl
	 * @作者姓名：焦丽娜
	 * @创建时间：2014年12月15日 上午10:46:20
	 * @参数说明：@param contentList
	 * @参数说明：@param xmlPath
	 * @参数说明：@param jdNodeName
	 * @参数说明：@return
	 * @返回类型：String
	 */
	public static String exportExcel(
			List<Map<String, Object>> contentList, String xmlPath,
			String jdNodeName,String fileTitle) {
		WritableWorkbook wwb = null;
		String fileName="";
		try {
			String filePath=ExportExcelUtil.class.getResource("/").getPath();
			filePath=filePath.substring(0, filePath.indexOf("WEB-INF"))+"tmp/";
			filePath=filePath.replaceAll("%20", " ");
			fileName=filePath+UUID.randomUUID().toString()+"tmp.xls";
			File file=new File(fileName);
			if(!file.exists()){
//				file.getParentFile().mkdir();
//				FileUtil.deleteFile(filePath);
				file.getParentFile().mkdir();
			    file.createNewFile();
			}
			// 首先要使用Workbook类的工厂方法创建一个可写入的工作薄(Workbook)对象
			wwb = Workbook.createWorkbook(new File(fileName));
			// 创建一个可写入的工作表
			// Workbook的createSheet方法有两个参数，第一个是工作表的名称，第二个是工作表在工作薄中的位置
			WritableSheet ws = wwb.createSheet("sheet1", 0);
			
			// 表头 字体样式
			WritableFont wf_title = new WritableFont(WritableFont.createFont("黑体"),
					13, WritableFont.NO_BOLD, false);
			WritableCellFormat wctitle = new WritableCellFormat(wf_title);
			wctitle.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
			wctitle.setAlignment(Alignment.CENTRE);
			wctitle.setBackground(Colour.GRAY_25);
			
			//写入表头
			List<Map<String,Object>> list=XmlReadUtil.getExpExcelFields(xmlPath, jdNodeName);
//			Label labelC = new Label(0, 0, "序号",wctitle);
//			ws.addCell(labelC); 
			String[] valueMembers=new String[list.size()+1];
			valueMembers[0]="";
			
			//把 单元格（column, row）到单元格（column1, row1）进行合并。
//			ws.mergeCells(column, row, column1, row1);
			ws.mergeCells(0, 0, list.size()-1, 0);//合并第一行从第1列到29列
			Label lb = new Label(0, 0,fileTitle,wctitle);
			ws.addCell(lb);
			
			
			for(int i=0; i<list.size(); i++){
				
				Map<String,Object> map = list.get(i);
				String width =map.get("width").toString();             //宽度
				String valueMember =map.get("valueMember").toString(); //字段属性
				String fieldName =map.get("fieldName").toString();     //字段名称
				valueMembers[i]=valueMember;
				Label labelC2 = new Label(i, 1, fieldName,wctitle);
				ws.addCell(labelC2);
				ws.setColumnView(i, DataSwitch.convertObjectToInteger(width));
			}
			if(contentList!=null && contentList.size()>0){
				WritableFont w2 = new WritableFont(WritableFont.ARIAL, 10,
						WritableFont.NO_BOLD, false,
						UnderlineStyle.NO_UNDERLINE, Colour.BLACK);
				WritableCellFormat ww2 = new WritableCellFormat(w2);
				ww2.setBorder(jxl.format.Border.ALL,jxl.format.BorderLineStyle.THIN);
				ww2.setAlignment(Alignment.CENTRE);
				ww2.setWrap(true);
				for(int i=0; i<contentList.size(); i++){
					Map<String, Object> map = contentList.get(i);
//					Label labelC2 = new Label(0, i, i+"",ww2);
//					ws.addCell(labelC2);
					for(int j=0; j<valueMembers.length-1; j++){
						Label labelC3 = new Label(j, i+2, DataSwitch.convertObjectToString(map.get(valueMembers[j])),ww2);
						ws.addCell(labelC3);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				// 从内存中写入文件中
				wwb.write();
				// 关闭资源，释放内存
				wwb.close();
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		return fileName;
	}
	
}
