package com.gwzd.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gwzd.servicedao.basedao.BaseDBDao;

/**
 * @文件名称: publicMethod.java
 * @包: com.gwzd.model.entity
 * @版本：V1.0
 * @版权所有：北京国网中电自动化技术有限公司
 * 
 * @创建人：高洪涛
 * @创建时间：2014年10月16日
 * @功能简介：全部应用基础公用方法类
 * 
 */
@Component("publicMethod")
public class PublicMethod
{
    static BaseDBDao baseDao;

    @Autowired
    public void setBaseDao(BaseDBDao baseDao)
    {
        PublicMethod.baseDao = baseDao;
    }

    /**
     * @功能简介：向页面输出内容，任何格式
     * @应用页面：
     * @作者姓名：高洪涛、强当安
     * @创建时间：2014年10月16日 下午7:24:05
     * @param json
     *            ：
     */
    public static void writeToPage(String objStr)
    {
        if (objStr == null)
        {
            objStr = "";
        }

        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = null;
        try
        {
            writer = response.getWriter();
            writer.write(objStr);

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (writer != null)
            {
                writer.close();
            }
        }
    }

    

    /****************************************** 数据库方法 *******************************************/

    /**
     * @功能简介：查询实体对象
     * @作者姓名：强当安
     * @创建时间：2014年11月6日 下午5:06:44
     * @param typClass
     * @param primaryId
     * @return
     * @throws MyException
     *             ：
     */
    public static <T> T getEntityByPrimaryId(Class<T> typClass, Serializable primaryId) throws Exception
    {
        try
        {
            return baseDao.getEntityByPrimaryId(typClass, primaryId);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * @功能简介：根据单个的propertyName和propertyValue查询实体的结果集
     * @应用页面：
     * @作者姓名：强当安
     * @创建时间：2016年6月12日 下午14：10
     * @param typClass
     *            ：泛型实体的class
     * @param propertyName
     *            ：使用实体中的属性名
     * @param propertyValue
     *            ：查询的值
     * @return
     * @throws Exception
     *             ：
     */
    public static <T> List<T> getEntityListByField(final Class<T> typClass, String propertyName, Object propertyValue) throws Exception
    {
        try
        {
            return baseDao.getEntitiesListByProperty(typClass, propertyName, propertyValue);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * @功能简介：根据课程代码查询课程信息
     * @作者姓名：李倩
     * @创建时间：2015年5月13日 下午2:20:07
     * @参数说明：@param keChengDm
     * @参数说明：@return
     * @参数说明：@throws MyException
     * @返回类型：XTkechengkuEntity
     * 
     */
    /*
     * public static XTkechengkuEntity getKeChengEntityByKeChengDM(String keChengDm) throws MyException { try { List<XTkechengkuEntity> list =
     * baseDao.getEntitiesByProperties(XTkechengkuEntity.class, "kcdm", keChengDm); return list != null && list.size() > 0 ? list.get(0) : null; } catch (Exception e) {
     * e.printStackTrace(); throw new MyException(e, e.getClass(), "获取当前周中老师的课表出错"); } }
     */

    /**
     * @功能简介：通过学期编号获取学期
     * @应用页面：
     * @作者姓名：王飞
     * @创建时间：2015年8月17日 下午3:16:37
     * @参数说明：@param xueQiBH
     * @参数说明：@return
     * @参数说明：@throws MyException
     * @返回类型：XTxueqiEntity
     * 
     */
    /*
     * public static XTxueqiEntity getXueQiByXueQiBH(String xueQiBH) throws MyException { try { Map<String, Object> propertyMap = new HashMap<String, Object>();
     * propertyMap.put("xqbh", xueQiBH); propertyMap.put("sfyx", ShiFouEnum.SHI); List<XTxueqiEntity> list = baseDao.getEntitiesListByProperties(XTxueqiEntity.class, propertyMap,
     * "xqid"); return list != null && list.size() > 0 ? list.get(0) : null; } catch (Exception e) { e.printStackTrace(); throw new MyException("根据实验课Id查看上课信息出错"); } }
     */

}
