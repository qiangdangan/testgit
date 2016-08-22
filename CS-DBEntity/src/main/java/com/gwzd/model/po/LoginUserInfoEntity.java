package com.gwzd.model.po;

import java.util.List;
import java.util.Map;

/**
 * @文件名称: LoginUserInfoEntity.java
 * @包: com.gwzd.model.po
 * @版本：V1.0
 * @版权所有：北京国网中电自动化技术有限公司
 * 
 * @创建人：高洪涛
 * @创建时间：2014年10月20日
 * @功能简介：用户登录实体共用类
 * 
 */
public class LoginUserInfoEntity
{
	private String xtyh_id; // 系统用户id
	private String ry_id; // 人员id
	private boolean shiFouIpBangDing; // 是否IP绑定
	private String ip; // ip地址
	private String niCheng; // 昵称
	private String xl_id; // 学历id
	private String renYuanDaiMa; // 人员代码
	private String xingMing; // 姓名
	private String xingBie; // 性别
	private String zhiGongHao; // 职工号
	private String banGongDianHua; // 办公电话
	private String geRenDianHua; // 个人电话
	private String shenFenZhengHao; // 身份证号
	private String shiFouZaiZhi; // 是否在职
	private String qq; // qq
	private String weiXinHao; // 微信号
	private String youJianDiZhi; // 邮件地址
	
	private String jiGouDaiMa;	//机构代码
	private String jiGouQuanCheng; //机构全称
	private String jiGouJianCheng; //机构简称
	private String buMenMingCheng;	//部门名称
	
	private List<Map<String,Object>> jueSeList; //角色list
	private String nowJueSeId; //当前角色id
	private String nowJueSeMingCheng; //当前角色名称

	public String getRy_id()
	{
		return ry_id;
	}

	public void setRy_id(String ry_id)
	{
		this.ry_id = ry_id;
	}

	public boolean getShiFouIpBangDing()
	{
		return shiFouIpBangDing;
	}

	public void setShiFouIpBangDing(boolean shiFouIpBangDing)
	{
		this.shiFouIpBangDing = shiFouIpBangDing;
	}

	public String getIp()
	{
		return ip;
	}

	public void setIp(String ip)
	{
		this.ip = ip;
	}

	public String getNiCheng()
	{
		return niCheng;
	}

	public void setNiCheng(String niCheng)
	{
		this.niCheng = niCheng;
	}

	public String getXl_id()
	{
		return xl_id;
	}

	public void setXl_id(String xl_id)
	{
		this.xl_id = xl_id;
	}

	public String getRenYuanDaiMa()
	{
		return renYuanDaiMa;
	}

	public void setRenYuanDaiMa(String renYuanDaiMa)
	{
		this.renYuanDaiMa = renYuanDaiMa;
	}

	public String getXingMing()
	{
		return xingMing;
	}

	public void setXingMing(String xingMing)
	{
		this.xingMing = xingMing;
	}

	public String getXingBie()
	{
		return xingBie;
	}

	public void setXingBie(String xingBie)
	{
		this.xingBie = xingBie;
	}

	public String getZhiGongHao()
	{
		return zhiGongHao;
	}

	public void setZhiGongHao(String zhiGongHao)
	{
		this.zhiGongHao = zhiGongHao;
	}

	public String getBanGongDianHua()
	{
		return banGongDianHua;
	}

	public void setBanGongDianHua(String banGongDianHua)
	{
		this.banGongDianHua = banGongDianHua;
	}

	public String getGeRenDianHua()
	{
		return geRenDianHua;
	}

	public void setGeRenDianHua(String geRenDianHua)
	{
		this.geRenDianHua = geRenDianHua;
	}

	public String getShenFenZhengHao()
	{
		return shenFenZhengHao;
	}

	public void setShenFenZhengHao(String shenFenZhengHao)
	{
		this.shenFenZhengHao = shenFenZhengHao;
	}

	public String getShiFouZaiZhi()
	{
		return shiFouZaiZhi;
	}

	public void setShiFouZaiZhi(String shiFouZaiZhi)
	{
		this.shiFouZaiZhi = shiFouZaiZhi;
	}

	public String getQq()
	{
		return qq;
	}

	public void setQq(String qq)
	{
		this.qq = qq;
	}

	public String getWeiXinHao()
	{
		return weiXinHao;
	}

	public void setWeiXinHao(String weiXinHao)
	{
		this.weiXinHao = weiXinHao;
	}

	public String getYouJianDiZhi()
	{
		return youJianDiZhi;
	}

	public void setYouJianDiZhi(String youJianDiZhi)
	{
		this.youJianDiZhi = youJianDiZhi;
	}

	public String getNowJueSeId()
	{
		return nowJueSeId;
	}

	public void setNowJueSeId(String nowJueSeId)
	{
		this.nowJueSeId = nowJueSeId;
	}

	public String getXtyh_id()
	{
		return xtyh_id;
	}

	public void setXtyh_id(String xtyh_id)
	{
		this.xtyh_id = xtyh_id;
	}

	public String getJiGouDaiMa()
	{
		return jiGouDaiMa;
	}

	public void setJiGouDaiMa(String jiGouDaiMa)
	{
		this.jiGouDaiMa = jiGouDaiMa;
	}

	public String getJiGouQuanCheng()
	{
		return jiGouQuanCheng;
	}

	public void setJiGouQuanCheng(String jiGouQuanCheng)
	{
		this.jiGouQuanCheng = jiGouQuanCheng;
	}

	public String getJiGouJianCheng()
	{
		return jiGouJianCheng;
	}

	public void setJiGouJianCheng(String jiGouJianCheng)
	{
		this.jiGouJianCheng = jiGouJianCheng;
	}

	public String getBuMenMingCheng()
	{
		return buMenMingCheng;
	}

	public void setBuMenMingCheng(String buMenMingCheng)
	{
		this.buMenMingCheng = buMenMingCheng;
	}

	public List<Map<String, Object>> getJueSeList()
	{
		return jueSeList;
	}

	public void setJueSeList(List<Map<String, Object>> jueSeList)
	{
		this.jueSeList = jueSeList;
	}

	public String getNowJueSeMingCheng()
	{
		return nowJueSeMingCheng;
	}

	public void setNowJueSeMingCheng(String nowJueSeMingCheng)
	{
		this.nowJueSeMingCheng = nowJueSeMingCheng;
	}

}
