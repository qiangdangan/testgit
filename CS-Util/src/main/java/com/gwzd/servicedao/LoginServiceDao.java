package com.gwzd.servicedao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.gwzd.model.enumeration.publicenum.ShiFouEnum;
import com.gwzd.servicedao.basedao.BaseDBDao;
import com.gwzd.util.DataSwitch;

/**
 * @文件名称: LoginServiceDao.java 
 * @包: com.gwzd.servicedao 
 * @版本：V1.0  
 * @版权所有：北京国网中电自动化技术有限公司
 * 
 * @创建人：强子
 * @创建时间：2016年8月18日
 * @功能简介：用户登录dao
 *
 */
@Repository("loginServiceDao")
public class LoginServiceDao extends BaseDBDao
{

	/**
	 * @throws Exception 
	 * @功能简介：查询用户名是否存在
	 * @应用页面：
	 * @作者姓名：强子
	 * @创建时间：2016年8月18日 下午5:32:19
	 * @参数说明：@param userName
	 * @参数说明：@return
	 * @返回类型：boolean
	 *
	 */
	public boolean searchUserNameIsExist(String userName) throws Exception
	{
		String sql="SELECT COUNT(1) FROM TB_XiTongYongHu WHERE DengLuMing=:DengLuMing";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("DengLuMing", userName);
		try
		{
			int n = super.getTotalCount(sql, map);
			return n>0;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * @throws Exception 
	 * @功能简介：查询登录用户信息
	 * @应用页面：
	 * @作者姓名：强子
	 * @创建时间：2016年8月18日 下午5:46:12
	 * @参数说明：@param userName 用户名
	 * @参数说明：@param password 密码
	 * @参数说明：@return
	 * @返回类型：Map<String,Object>
	 *
	 */
	public Map<String, Object> seachLoginUserMap(String userName, String password) throws Exception
	{
		StringBuilder sbSql=new StringBuilder();
		sbSql.append(" SELECT TB_XiTongYongHu.XTYH_ID, ");
		sbSql.append(" 		  TB_RenYuan.RY_ID, ");
		sbSql.append("        ShiFouYunXuDengLu, ");
		sbSql.append("        ShiFouIPBangDing, ");
		sbSql.append("        IP, ");
		sbSql.append("        XiTongNiCheng, ");
		sbSql.append("        XL_ID, ");
		sbSql.append("        RenYuanDaiMa, ");
		sbSql.append("        XingMing, ");
		sbSql.append("        XingBie, ");
		sbSql.append("        ZhiGongHao, ");
		sbSql.append("        BanGongDianHua, ");
		sbSql.append("        GeRenDianHua, ");
		sbSql.append("        ShenFenZhengHao, ");
		sbSql.append("        ShiFouZaiZhi, ");
		sbSql.append("        TB_RenYuan.QQ, ");
		sbSql.append("        TB_RenYuan.WeiXinHao, ");
		sbSql.append("        YouJianDiZhi, ");
		sbSql.append("        Ifnull(ryqx.ryqxcnt,0) ryqxcnt, ");
		sbSql.append("        Ifnull(jsqx.jsqxcnt,0) jsqxcnt, ");
		sbSql.append("        TB_JiGouXinXi.DiaMa, ");
		sbSql.append("        TB_JiGouXinXi.QuanCheng, ");
		sbSql.append("        TB_JiGouXinXi.JianCheng, ");
		sbSql.append("        TB_JiGouBuMen.BuMenMingCheng ");
		sbSql.append(" FROM   TB_XiTongYongHu ");
		sbSql.append("        LEFT JOIN TB_RenYuan ");
		sbSql.append("          ON TB_RenYuan.RY_ID = TB_XiTongYongHu.RY_ID ");
		sbSql.append("        LEFT JOIN TB_JiGouBuMenRenYuan ");
		sbSql.append("          ON TB_JiGouBuMenRenYuan.RY_ID = TB_RenYuan.RY_ID ");
		sbSql.append("        LEFT JOIN TB_JiGouBuMen ");
		sbSql.append("          ON TB_JiGouBuMen.BMID = TB_JiGouBuMenRenYuan.BMID ");
		sbSql.append("        LEFT JOIN TB_JiGouXinXi ");
		sbSql.append("          ON TB_JiGouXinXi.JGXXID = TB_JiGouBuMen.JGXXID ");
		sbSql.append("        left join (SELECT   TB_YongHuQuanXian.XTYH_ID, ");
		sbSql.append("                            Count(1) ryqxcnt ");
		sbSql.append("                   FROM     TB_YongHuQuanXian ");
		sbSql.append("                   GROUP BY TB_YongHuQuanXian.XTYH_ID) ryqx ");
		sbSql.append("          on ryqx.XTYH_ID = TB_XiTongYongHu.XTYH_ID ");
		sbSql.append("        LEFT JOIN (SELECT   TB_YongHuJueSe.XTYH_ID, ");
		sbSql.append("                            Count(1) jsqxcnt ");
		sbSql.append("                   FROM     TB_JueSeQuanXian ");
		sbSql.append("                            LEFT JOIN TB_JueSe ");
		sbSql.append("                              ON TB_JueSe.XTJS_ID = TB_JueSeQuanXian.XTJS_ID ");
		sbSql.append("                            LEFT JOIN TB_YongHuJueSe ");
		sbSql.append("                              ON TB_YongHuJueSe.XTJS_ID = TB_JueSe.XTJS_ID ");
		sbSql.append("                   WHERE    TB_JueSe.ShiFouYouXiao = '1' ");
		sbSql.append("                   GROUP BY TB_YongHuJueSe.XTYH_ID) jsqx ");
		sbSql.append("          on jsqx.XTYH_ID = TB_XiTongYongHu.XTYH_ID ");
		sbSql.append(" WHERE  DengLuMing = :dengluming ");
		sbSql.append("        AND MiMa = :mima ");
		Map<String, Object> parasMaps=new HashMap<String, Object>();
		parasMaps.put("dengluming", userName);
		parasMaps.put("mima", password);
		try
		{
			return super.getFirstRecord(sbSql.toString(), parasMaps);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * @throws Exception 
	 * @功能简介：查询用户角色
	 * @应用页面：
	 * @作者姓名：强子
	 * @创建时间：2016年8月19日 上午11:51:44
	 * @参数说明：@param yongHuId
	 * @参数说明：@return
	 * @返回类型：List<Map<String,Object>>
	 *
	 */
	public List<Map<String, Object>> searchUserJueSeList(String yongHuId) throws Exception
	{
		StringBuilder sbSql=new StringBuilder();
		sbSql.append(" SELECT TB_JueSe.XTJS_ID, ");
		sbSql.append("        JueSeMingCheng, ");
		sbSql.append("        JueSeMiaoShu ");
		sbSql.append(" FROM   TB_JueSe ");
		sbSql.append("        LEFT JOIN TB_YongHuJueSe ");
		sbSql.append("          ON TB_YongHuJueSe.XTJS_ID = TB_JueSe.XTJS_ID ");
		sbSql.append(" WHERE  ShiFouYouXiao = :ShiFouYouXiao ");
		sbSql.append("        AND XTYH_ID = :XTYH_ID ");

		Map<String, Object> parasMaps=new HashMap<String, Object>();
		parasMaps.put("ShiFouYouXiao", ShiFouEnum.SHI);
		parasMaps.put("XTYH_ID", yongHuId);
		try
		{
			return super.getList(sbSql.toString(), parasMaps);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * @throws Exception 
	 * @功能简介：查询用户模块
	 * @应用页面：
	 * @作者姓名：强子
	 * @创建时间：2016年8月19日 下午2:28:43
	 * @参数说明：@param yongHuId
	 * @参数说明：@return
	 * @返回类型：List<Map<String,Object>>
	 *
	 */
	public List<Map<String, Object>> searchUserMoKuai(String yongHuId, String jueSeId) throws Exception
	{
		StringBuilder sbSql=new StringBuilder();
		sbSql.append(" SELECT   DISTINCT MOKUAN.CDID, ");
		sbSql.append("                   MOKUAN.PID, ");
		sbSql.append("                   MOKUAN.CaiDanMingCheng, ");
		sbSql.append("                   MOKUAN.CaiDanTuBiao, ");
		sbSql.append("                   MOKUAN.URL, ");
		sbSql.append("                   MOKUAN.CaiDanJiBie, ");
		sbSql.append("                   MOKUAN.CaiDanPaiXu, ");
		sbSql.append("                   MOKUAN.DaKaiFangShi, ");
		sbSql.append("                   MOKUAN.ZhuangTai, ");
		sbSql.append("                   MOKUAN.BeiZhu ");
		sbSql.append(" FROM     TB_CaiDanBiao MOKUAN ");
		sbSql.append("          LEFT JOIN TB_CaiDanBiao CAIDANZU ");
		sbSql.append("            ON MOKUAN.CDID = CAIDANZU.PID ");
		sbSql.append("          LEFT JOIN TB_CaiDanBiao TB_CaiDanBiao ");
		sbSql.append("            ON CAIDANZU.CDID = TB_CaiDanBiao.PID ");
		sbSql.append("          LEFT JOIN TB_CaiDanQuanXianGuanLian ");
		sbSql.append("            ON TB_CaiDanQuanXianGuanLian.CDID = TB_CaiDanBiao.CDID ");
		sbSql.append("          LEFT JOIN TB_QuanXian ");
		sbSql.append("            ON TB_QuanXian.QX_ID = TB_CaiDanQuanXianGuanLian.QX_ID ");
		sbSql.append(" WHERE    TB_QuanXian.ShiFouYouXiao = :ShiFouYouXiao ");
		sbSql.append("          AND (EXISTS (SELECT TB_JueSeQuanXian.QX_ID ");
		sbSql.append("                       FROM   TB_JueSeQuanXian ");
		sbSql.append("                              LEFT JOIN TB_JueSe ");
		sbSql.append("                                ON TB_JueSe.XTJS_ID = TB_JueSeQuanXian.XTJS_ID ");
		sbSql.append("                              LEFT JOIN TB_YongHuJueSe ");
		sbSql.append("                                ON TB_YongHuJueSe.XTJS_ID = TB_JueSe.XTJS_ID ");
		sbSql.append("                       WHERE  TB_JueSeQuanXian.QX_ID = TB_QuanXian.QX_ID ");
		sbSql.append("                              AND TB_JueSe.XTJS_ID = :XTJS_ID ");
		sbSql.append("                              AND TB_YongHuJueSe.XTYH_ID = :XTYH_ID)) ");
		sbSql.append(" ORDER BY MOKUAN.PID, ");
		sbSql.append("          MOKUAN.CaiDanPaiXu ");
		Map<String, Object> parasMaps=new HashMap<String, Object>();
		parasMaps.put("ShiFouYouXiao", ShiFouEnum.SHI);
		parasMaps.put("XTYH_ID", yongHuId);
		parasMaps.put("XTJS_ID", jueSeId);
		try
		{
			return super.getList(sbSql.toString(), parasMaps);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * @throws Exception 
	 * @功能简介：查询用户菜单组
	 * @应用页面：
	 * @作者姓名：强子
	 * @创建时间：2016年8月19日 下午2:31:32
	 * @参数说明：@param yongHuId
	 * @参数说明：@return
	 * @返回类型：List<Map<String,Object>>
	 *
	 */
	public List<Map<String, Object>> searchUserCaiDanZu(String yongHuId, String jueSeId) throws Exception
	{
		StringBuilder sbSql=new StringBuilder();
		sbSql.append(" SELECT   DISTINCT CAIDANZU.CDID, ");
		sbSql.append("                   CAIDANZU.PID, ");
		sbSql.append("                   CAIDANZU.CaiDanMingCheng, ");
		sbSql.append("                   CAIDANZU.CaiDanTuBiao, ");
		sbSql.append("                   CAIDANZU.URL, ");
		sbSql.append("                   CAIDANZU.CaiDanJiBie, ");
		sbSql.append("                   CAIDANZU.CaiDanPaiXu, ");
		sbSql.append("                   CAIDANZU.DaKaiFangShi, ");
		sbSql.append("                   CAIDANZU.ZhuangTai, ");
		sbSql.append("                   CAIDANZU.BeiZhu ");
		sbSql.append(" FROM     TB_CaiDanBiao CAIDANZU ");
		sbSql.append("          LEFT JOIN TB_CaiDanBiao TB_CaiDanBiao ");
		sbSql.append("            ON CAIDANZU.CDID = TB_CaiDanBiao.PID ");
		sbSql.append("          LEFT JOIN TB_CaiDanQuanXianGuanLian ");
		sbSql.append("            ON TB_CaiDanQuanXianGuanLian.CDID = TB_CaiDanBiao.CDID ");
		sbSql.append("          LEFT JOIN TB_QuanXian ");
		sbSql.append("            ON TB_QuanXian.QX_ID = TB_CaiDanQuanXianGuanLian.QX_ID ");
		sbSql.append(" WHERE    TB_QuanXian.ShiFouYouXiao = :ShiFouYouXiao ");
		sbSql.append("          AND (EXISTS (SELECT TB_JueSeQuanXian.QX_ID ");
		sbSql.append("                       FROM   TB_JueSeQuanXian ");
		sbSql.append("                              LEFT JOIN TB_JueSe ");
		sbSql.append("                                ON TB_JueSe.XTJS_ID = TB_JueSeQuanXian.XTJS_ID ");
		sbSql.append("                              LEFT JOIN TB_YongHuJueSe ");
		sbSql.append("                                ON TB_YongHuJueSe.XTJS_ID = TB_JueSe.XTJS_ID ");
		sbSql.append("                       WHERE  TB_JueSeQuanXian.QX_ID = TB_QuanXian.QX_ID ");
		sbSql.append("                              AND TB_JueSe.XTJS_ID = :XTJS_ID ");
		sbSql.append("                              AND TB_YongHuJueSe.XTYH_ID = :XTYH_ID)) ");
		sbSql.append(" ORDER BY CAIDANZU.PID, ");
		sbSql.append("          CAIDANZU.CaiDanPaiXu ");
		
		Map<String, Object> parasMaps=new HashMap<String, Object>();
		parasMaps.put("ShiFouYouXiao", ShiFouEnum.SHI);
		parasMaps.put("XTYH_ID", yongHuId);
		parasMaps.put("XTJS_ID", jueSeId);
		try
		{
			return super.getList(sbSql.toString(), parasMaps);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * @throws Exception 
	 * @功能简介：查询用户菜单
	 * @应用页面：
	 * @作者姓名：强子
	 * @创建时间：2016年8月19日 下午2:33:33
	 * @参数说明：@param yongHuId
	 * @参数说明：@return
	 * @返回类型：List<Map<String,Object>>
	 *
	 */
	public List<Map<String, Object>> searchUserCaiDan(String yongHuId, String jueSeId) throws Exception
	{
		StringBuilder sbSql=new StringBuilder();
		sbSql.append(" SELECT   TB_CaiDanBiao.CDID, ");
		sbSql.append("          PID, ");
		sbSql.append("          CaiDanMingCheng, ");
		sbSql.append("          CaiDanTuBiao, ");
		sbSql.append("          URL, ");
		sbSql.append("          CaiDanJiBie, ");
		sbSql.append("          CaiDanPaiXu, ");
		sbSql.append("          DaKaiFangShi, ");
		sbSql.append("          ZhuangTai, ");
		sbSql.append("          TB_CaiDanBiao.BeiZhu ");
		sbSql.append(" FROM     TB_CaiDanBiao ");
		sbSql.append("          LEFT JOIN TB_CaiDanQuanXianGuanLian ");
		sbSql.append("            ON TB_CaiDanQuanXianGuanLian.CDID = TB_CaiDanBiao.CDID ");
		sbSql.append("          LEFT JOIN TB_QuanXian ");
		sbSql.append("            ON TB_QuanXian.QX_ID = TB_CaiDanQuanXianGuanLian.QX_ID ");
		sbSql.append(" WHERE    TB_QuanXian.ShiFouYouXiao = :ShiFouYouXiao ");
		sbSql.append("          AND (EXISTS (SELECT TB_JueSeQuanXian.QX_ID ");
		sbSql.append("                       FROM   TB_JueSeQuanXian ");
		sbSql.append("                              LEFT JOIN TB_JueSe ");
		sbSql.append("                                ON TB_JueSe.XTJS_ID = TB_JueSeQuanXian.XTJS_ID ");
		sbSql.append("                              LEFT JOIN TB_YongHuJueSe ");
		sbSql.append("                                ON TB_YongHuJueSe.XTJS_ID = TB_JueSe.XTJS_ID ");
		sbSql.append("                       WHERE  TB_JueSeQuanXian.QX_ID = TB_QuanXian.QX_ID ");
		sbSql.append("                              AND TB_JueSe.XTJS_ID = :XTJS_ID ");
		sbSql.append("                              AND TB_YongHuJueSe.XTYH_ID = :XTYH_ID)) ");
		sbSql.append(" ORDER BY TB_CaiDanBiao.PID, ");
		sbSql.append("          TB_CaiDanBiao.CaiDanPaiXu ");

		Map<String, Object> parasMaps=new HashMap<String, Object>();
		parasMaps.put("ShiFouYouXiao", ShiFouEnum.SHI);
		parasMaps.put("XTYH_ID", yongHuId);
		parasMaps.put("XTJS_ID", jueSeId);
		try
		{
			return super.getList(sbSql.toString(), parasMaps);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * @throws Exception 
	 * @功能简介：查询用户上次登录时间
	 * @应用页面：
	 * @作者姓名：强子
	 * @创建时间：2016年8月19日 下午3:52:04
	 * @参数说明：@param yongHuId
	 * @参数说明：@return
	 * @返回类型：String
	 *
	 */
	public String searchShangCiDengLuShiJian(String yongHuId) throws Exception
	{
		StringBuilder sbSql=new StringBuilder();
		sbSql.append(" SELECT   Date_format(DengLuShiJian,'%Y-%m-%d %T') DengLuShiJian ");
		sbSql.append(" FROM     TB_DengLuRiZhi ");
		sbSql.append(" WHERE    DengLuYongHu = :DengLuYongHu ");
		sbSql.append(" ORDER BY DengLuShiJian DESC ");
		Map<String, Object> parasMaps=new HashMap<String, Object>();
		parasMaps.put("DengLuYongHu", yongHuId);
		try
		{
			String shangCiDengLuShiJian="";
			List<Map<String,Object>> list =super.getList(sbSql.toString(), parasMaps, 1);
			if(list!=null && list.size()>0)
			{
				Map<String,Object> map = list.get(0);
				shangCiDengLuShiJian= DataSwitch.convertObjectToString(map.get("DengLuShiJian"));
			}
			return shangCiDengLuShiJian;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * @throws Exception 
	 * @功能简介：获取用户登录日志Id
	 * @应用页面：
	 * @作者姓名：强子
	 * @创建时间：2016年8月19日 下午4:03:47
	 * @参数说明：@param yongHuId
	 * @参数说明：@return
	 * @返回类型：String
	 *
	 */
	public String getDengLuRiZhiId(String yongHuId) throws Exception
	{
		String sql="SELECT RZID  FROM TB_DengLuRiZhi WHERE DengLuYongHu=:DengLuYongHu ORDER BY DengLuShiJian DESC";
		Map<String, Object> parasMaps=new HashMap<String, Object>();
		parasMaps.put("DengLuYongHu", yongHuId);
		try
		{
			List<Map<String,Object>> list =super.getList(sql, parasMaps, 1);
			String dengLuRiZhiId= "";
			if(list!=null && list.size()>0)
			{
				Map<String,Object> map = list.get(0);
				dengLuRiZhiId= DataSwitch.convertObjectToString(map.get("RZID"));
				
			}
			return dengLuRiZhiId;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}

}
