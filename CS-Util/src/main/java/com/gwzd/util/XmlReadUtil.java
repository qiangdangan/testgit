package com.gwzd.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Attr;
import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * xml的操作工具类
 * @author 强当安
 *
 */
public class XmlReadUtil {
	public static void main(String[] args) {
		String xmlStr = "                          "
				+ "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + "<result>"
				+ "<errcode>" + "<children1>" + "<children2>你好 </children2>"
				+ "<children2>水电费</children2>" + "<children3>ddd</children3>"
				+ "</children1>" + "<children1>"
				+ "<errcode attr='qiangzi'>你好vbn </errcode>"
				+ "<children2>许</children2>" + "<children2>非单身</children2>"
				+ "</children1>" + "</errcode>" + "<errcode>" + "<children1>"
				+ "<errcode attr='dongzi'>你好zxc</errcode>"
				+ "<children2>errcode玩儿</children2>"
				+ "<children2>errcode风格化1</children2>"
				+ "<children3>errcode2ddd</children3>" + "</children1>"
				+ "<children1>" + "<children2>errcode2慈悲 </children2>"
				+ "<children2>errcode电饭锅</children2><" + "/children1>"
				+ "</errcode>" + "</result>" + "                          ";
		String s = XmlReadUtil.getNodeTextContentFromXmlStr(xmlStr,
				"errcode>children1>children2");
		String s2 = XmlReadUtil.getNodeTextContentFromXmlStr(xmlStr,
				"errcode>children1>errcode");
		//String s3 = XmlReadUtil.getNodeAttributeFromXmlStr(xmlStr,"errcode>children1>errcode","attr");
		System.out.println(s);
		System.out.println(s2);
	/*	System.out.println(XmlReadUtil.getNodeSizeFromXmlStr(xmlStr, "children1"));
		System.out.println("s3=="+s3);
		XmlReadUtil.analysisXmlFromXmlStr(xmlStr);

		System.out.println("------------------------------");
		String xmlUrl = "D:/test.xml";
		String str = XmlReadUtil.getNodeTextContentFromXmlUrl(xmlUrl,
				"errcode>children1>children2");
		String str2 = XmlReadUtil.getNodeTextContentFromXmlUrl(xmlUrl,
				"errcode>children1>errcode");
		System.out.println(str);
		System.out.println(str2);
		System.out.println(XmlReadUtil.getNodeSizeFromXmlUrl(xmlUrl, "children1"));
		String xmlUrl = "D:/temp1.xml";
		XmlReadUtil.analysisXmlFromXmlUrl(xmlUrl);*/
//		System.out.println(getNodeXmlContent("D:/test.xml","errcode>children1"));
	}

	/**
	 * 获取指定节点名称的个数
	 * @param xmlStr  xml格式的字符串
	 * @param nodeName 节点名称
	 * @return
	 */
	public static int getNodeSizeFromXmlStr(String xmlStr, String nodeName) {
		int size=0;
		xmlStr=xmlStr.trim();
		Element element = getRootNodeFromXmlStr(xmlStr);
		size=element.getElementsByTagName(nodeName).getLength();
		return size;
	}
	/**
	 * 获取指定节点名称的个数
	 * @param xmlUrl xml路径
	 * @param nodeName 节点名称
	 * @return
	 */
	public static int getNodeSizeFromXmlUrl(String xmlUrl, String nodeName) {
		int size=0;
		xmlUrl=xmlUrl.trim();
		Element element = getRootNodeFromXmlUrl(xmlUrl);
		size=element.getElementsByTagName(nodeName).getLength();
		return size;
	}
	/**
	 * 获取xml指定节点的值
	 * 
	 * @param xmlStr
	 *            xml格式的字符串
	 * @param nodeWeiZhi
	 *            节点位置 如 nodename1 或者 nodename1>nodename1_1>nodename1_1_1...
	 *            根节点名称除外
	 * @return 节点的值,用逗号隔开
	 */
	public static String getNodeTextContentFromXmlStr(String xmlStr, String nodeWeiZhi) {
		String result = "";
		try {
			xmlStr=xmlStr.trim();
			Element element = getRootNodeFromXmlStr(xmlStr);
			result = getNodeText(element, nodeWeiZhi);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result.replaceFirst(",", "");
	}
	/**
	 * 获取xml指定节点的值
	 * 
	 * @param xmlUrl
	 *            xml路径
	 * @param nodeWeiZhi
	 *            节点位置 如 nodename1 或者 nodename1>nodename1_1>nodename1_1_1...
	 *            根节点名称除外
	 * @return 节点的值,用逗号隔开
	 */
	public static String getNodeTextContentFromXmlUrl(String xmlUrl, String nodeWeiZhi) {
		String result = "";
		try {
			xmlUrl=xmlUrl.trim();
			Element element = getRootNodeFromXmlUrl(xmlUrl);
			result = getNodeText(element, nodeWeiZhi);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result.replaceFirst(",", "");
	}
	//数据库表配置文件，节点位置
	/*private static Element dataBaseTableConfigElement;
	static{
	    String classPath = XmlReadUtil.class.getResource("/").getPath();
        String dataBaseTableConfigUrl = classPath + "com/gwzd/logaop/config/dataBaseTableConfig.xml";
        dataBaseTableConfigElement=getRootNodeFromXmlUrl(dataBaseTableConfigUrl);
	}*/
	
	/**
	 * @功能简介：从数据库表配置文件中获取节点内容
	 * @作者姓名：强当安
	 * @创建时间：2015年1月26日 下午3:19:25
	 * @param nodeWeiZhi
	 * @return：
	 */
	/*public static String getNodeContentFromDataBaseTableConfig(String nodeWeiZhi) {
        String result = "";
        try {
            Element element = dataBaseTableConfigElement;
            result = getNodeText(element, nodeWeiZhi);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.replaceFirst(",", "");
    }*/
	
	
	/**
	 * 
	 * @param xmlUrl
	 * @param nodeWeiZhi
	 * @return
	 */
	public static String getNodeXmlContent(String xmlUrl, String nodeWeiZhi){
		String result = "";
		try {
			xmlUrl=xmlUrl.trim();
			Element element = getRootNodeFromXmlUrl(xmlUrl);
			List<Node> nodes=getNode(element,nodeWeiZhi);
			for(Node node :nodes){
				result+=parseElement((Element) node);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 获取xml指定节点的指定属性值
	 * 
	 * @param xmlStr
	 *            xml格式的字符串
	 * @param nodeWeiZhi
	 *            节点位置 如 nodename1 或者 nodename1>nodename1_1>nodename1_1_1...
	 *            根节点名称除外
	 * @param attributeName
	 *            节点属性          
	 * @return 节点的值,用逗号隔开
	 */
	public static String getNodeAttributeFromXmlStr(String xmlStr, String nodeWeiZhi,String attributeName) {
		String result = "";
		try {
			xmlStr=xmlStr.trim();
			Element element = getRootNodeFromXmlStr(xmlStr);
			result = getNodeAttribute(element, nodeWeiZhi,attributeName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result.replaceFirst(",", "");
	}
	/**
	 * 获取xml指定节点的指定属性值
	 * 
	 * @param xmlUrl
	 *            xml路径
	 * @param nodeWeiZhi
	 *            节点位置 如 nodename1 或者 nodename1>nodename1_1>nodename1_1_1...
	 *            根节点名称除外
	 * @param attributeName
	 *            节点属性
	 * @return 节点的值,用逗号隔开
	 */
	public static String getNodeAttributeFromXmlUrl(String xmlUrl, String nodeWeiZhi,String attributeName) {
		String result = "";
		try {
			xmlUrl=xmlUrl.trim();
			Element element = getRootNodeFromXmlUrl(xmlUrl);
			result = getNodeAttribute(element, nodeWeiZhi,attributeName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result.replaceFirst(",", "");
	}

	/**
	 * 解析xml 输出xml格式的内容
	 * @param xmlUrl xml格式字符串
	 */
	public static void analysisXmlFromXmlStr(String xmlStr){
		xmlStr=xmlStr.trim();
		Element element=getRootNodeFromXmlStr(xmlStr);
		parseElement(element);
	}
	/**
	 * 解析xml 输出xml格式的内容
	 * @param xmlUrl xml路径
	 */
	public static void analysisXmlFromXmlUrl(String xmlUrl){
		xmlUrl=xmlUrl.trim();
		Element element=getRootNodeFromXmlUrl(xmlUrl);
		parseElement(element);
	}

	/**
	 * 获取节点的值去掉左右空格
	 * 
	 * @param element
	 * @param nodeWeiZhi
	 *            节点位置 如 nodename1 或者 nodename1>nodename1_1>nodename1_1_1...
	 *            根节点名称除外
	 * @return 节点的值,用逗号隔开
	 */
	private static String getNodeText(Element element, String nodeWeiZhi) {
		String result = "";
		String[] nodeNames = nodeWeiZhi.split(">");
		NodeList children = element.getChildNodes();
		for (int i = 0; i < children.getLength(); i++) {
			Node node = children.item(i);
			String nodeName = node.getNodeName();
			if (nodeName.equals(nodeNames[0])) {
				if (nodeNames.length == 1) {
					result += "," + node.getTextContent().trim();
				}
				String nodeWeiZhiTemp = nodeWeiZhi.replaceFirst(nodeNames[0],"").replaceFirst(">", "");
				NodeList childrenTempList = node.getChildNodes();
				if (childrenTempList.getLength() > 0 && !nodeWeiZhiTemp.equals("")) {
					result += getNodeText((Element) node, nodeWeiZhiTemp);
				}
			}
		}
		return result;
	}
	/**
	 * 获取节点
	 * 
	 * @param element
	 * @param nodeWeiZhi
	 *            节点位置 如 nodename1 或者 nodename1>nodename1_1>nodename1_1_1...
	 *            根节点名称除外
	 * @return 节点集合
	 */
	private static List<Node> getNode(Element element, String nodeWeiZhi) {
		List<Node> notes=new ArrayList<Node>();
		String[] nodeNames = nodeWeiZhi.split(">");
		NodeList children = element.getChildNodes();
		for (int i = 0; i < children.getLength(); i++) {
			Node node = children.item(i);
			String nodeName = node.getNodeName();
			if (nodeName.equals(nodeNames[0])) {
				if (nodeNames.length == 1) {
					notes.add(node);
				}
				String nodeWeiZhiTemp = nodeWeiZhi.replaceFirst(nodeNames[0],"").replaceFirst(">", "");
				NodeList childrenTempList = node.getChildNodes();
				if (childrenTempList.getLength() > 0 && !nodeWeiZhiTemp.equals("")) {
					notes.addAll(getNode((Element) node, nodeWeiZhiTemp));
				}
			}
		}
		return notes;
	}
	/**
	 * 获取节点属性的值去掉左右空格
	 * 
	 * @param element
	 * @param nodeWeiZhi
	 *            节点位置 如 nodename1 或者 nodename1>nodename1_1>nodename1_1_1...
	 *            根节点名称除外
	 * @return 节点的值,用逗号隔开
	 */
	private static String getNodeAttribute(Element element, String nodeWeiZhi, String attributeName) {
		String result = "";
		String[] nodeNames = nodeWeiZhi.split(">");
		NodeList children = element.getChildNodes();
		for (int i = 0; i < children.getLength(); i++) {
			Node node = children.item(i);
			String nodeName = node.getNodeName();
			if (nodeName.equals(nodeNames[0])) {
				if (nodeNames.length == 1) {
					result += "," + node.getAttributes().getNamedItem(attributeName).getNodeValue().trim();
				}
				String nodeWeiZhiTemp = nodeWeiZhi.replaceFirst(nodeNames[0],"").replaceFirst(">", "");
				NodeList childrenTempList = node.getChildNodes();
				if (childrenTempList.getLength() > 0 && !nodeWeiZhiTemp.equals("")) {
					result += getNodeAttribute((Element) node, nodeWeiZhiTemp,attributeName);
				}
			}
		}
		return result;
	}
	/**
	 * 获取xml的根节点
	 * @param xmlStr  xml格式的字符串
	 * @return
	 */
	private static Element getRootNodeFromXmlStr(String xmlStr){
		Element element = null;
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			InputStream is = new ByteArrayInputStream(xmlStr.getBytes("UTF-8"));
			Document document = db.parse(is);
			element = document.getDocumentElement();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return element;
	}
	/**
	 * 获取xml的根节点
	 * @param xmlUrl  xml路径
	 * @return
	 */
	private static Element getRootNodeFromXmlUrl(String xmlUrl){
		Element element = null;
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document document = db.parse(xmlUrl);
			element = document.getDocumentElement();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return element;
	}
	/**
	 * 解析xml 输出xml格式的内容
	 * @param element
	 */
	private static String parseElement(Element element) {
		StringBuffer sb=new StringBuffer();
		String tagName = element.getNodeName();
		NodeList children = element.getChildNodes();
		System.out.print("<" + tagName);
		sb.append("<" + tagName);
		// element元素的所有属性所构成的NamedNodeMap对象，需要对其进行判断
		NamedNodeMap map = element.getAttributes();
		// 如果该元素存在属性
		if (null != map) {
			for (int i = 0; i < map.getLength(); i++) {
				// 获得该元素的每一个属性
				Attr attr = (Attr) map.item(i);
				String attrName = attr.getName();
				String attrValue = attr.getValue();
				System.out.print(" " + attrName + "=\"" + attrValue + "\"");
				sb.append(" " + attrName + "=\"" + attrValue + "\"");
			}
		}
		System.out.print(">");
		sb.append(">");
		for (int i = 0; i < children.getLength(); i++) {
			Node node = children.item(i);
			// 获得结点的类型
			short nodeType = node.getNodeType();
			if (nodeType == Node.ELEMENT_NODE) {
				// 是元素，继续递归
				sb.append(parseElement((Element) node));
			} else if (nodeType == Node.TEXT_NODE) {
				// 递归出口
				System.out.print(node.getNodeValue());
				sb.append(node.getNodeValue());
			} else if (nodeType == Node.COMMENT_NODE) {
				System.out.print("<!--");
				Comment comment = (Comment) node;
				// 注释内容
				String data = comment.getData();
				System.out.print(data);
				System.out.print("-->");
			}
		}
		System.out.print("</" + tagName + ">\n"); 
		sb.append("</" + tagName + ">\n");
		return sb.toString();
	}
	/**
	 * 读取导出excel文件名称信息
	 * @param xmlPath 配置文件地址
	 * @param jdNodeName 节点名称
	 * @return
	 */
	public static String getExpExcelFileName(String xmlPath,String jdNodeName){
		String path=XmlReadUtil.class.getResource("/").getPath();
		path=path.substring(0, path.indexOf("WEB-INF"));
		xmlPath=path+xmlPath;
		String fileName="";
		Element element = getRootNodeFromXmlUrl(xmlPath);
		NodeList children = element.getChildNodes();
		for (int i = 0; i < children.getLength(); i++) {
			
			Node node = children.item(i);
			String nodeName = node.getNodeName();
			
			if (nodeName.equals(jdNodeName)) {
				NodeList children2 =node.getChildNodes();
				for (int j = 0; j < children2.getLength(); j++) {
					
					Node node2 = children2.item(j);
					String nodeName2 = node2.getNodeName();
					
					if (nodeName2.equals("fileName")) {
						fileName=node2.getTextContent().trim()+".xls";
					}
					
				}
				
			}
			
		}
		return fileName;
	}
	/**
	 * 读取导出excel字段配置信息
	 * @param xmlPath 配置文件地址
	 * @param jdNodeName 节点名称
	 * @return
	 */
	public static List<Map<String,Object>> getExpExcelFields(String xmlPath,String jdNodeName){
		
		String path=XmlReadUtil.class.getResource("/").getPath();
		path=path.substring(0, path.indexOf("WEB-INF"));
		xmlPath=path+xmlPath;
		List<Map<String,Object>> expExcelFields=new ArrayList<Map<String,Object>>();
		Element element = getRootNodeFromXmlUrl(xmlPath);
		NodeList children = element.getChildNodes();
		for (int i = 0; i < children.getLength(); i++) {
			
			Node node = children.item(i);
			String nodeName = node.getNodeName();
			
			if (nodeName.equals(jdNodeName)) {
				NodeList children2 =node.getChildNodes();
				for (int j = 0; j < children2.getLength(); j++) {
					
					Node node2 = children2.item(j);
					String nodeName2 = node2.getNodeName();
					
					if (nodeName2.equals("fields")) {
						NodeList fieldsNode=node2.getChildNodes();
						
						for (int k = 0; k < fieldsNode.getLength(); k++) {
							
							Node fieldNode = fieldsNode.item(k);
							String fieldNodeName=fieldNode.getNodeName();
							if(fieldNodeName.equals("field")){
								NamedNodeMap attributes=fieldNode.getAttributes();
								
								Map<String,Object> fieldMap=new HashMap<String, Object>();
								String width=attributes.getNamedItem("width").getNodeValue().trim();
								fieldMap.put("width", width);
								String valueMember=attributes.getNamedItem("valueMember").getNodeValue().trim();
								fieldMap.put("valueMember", valueMember);
								String fieldName=fieldNode.getTextContent().trim();
								fieldMap.put("fieldName", fieldName);
								
								expExcelFields.add(fieldMap);
							}
						}
					}
				}
			}
		}
		return expExcelFields;
	}
}
