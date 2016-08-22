package com.gwzd.model.dbentity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbXiaoXiLeiXing entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_XiaoXiLeiXing")
public class TbXiaoXiLeiXing implements java.io.Serializable
{

	// Fields

	private String xxlxid;
	private String xiaoXiLeiXingMingCheng;
	private String xiaoXiLeiXingDaiMa;
	private Integer zhuangTai;
	private String tianJiaRen;
	private Timestamp tianJiaShiJian;
	private String xiuGaiRen;
	private Timestamp xiuGaiShiJian;
	private String beiZhu;
	private Boolean shiFouZuiZhongCaoZuo;

	// Constructors

	/** default constructor */
	public TbXiaoXiLeiXing()
	{}

	/** full constructor */
	public TbXiaoXiLeiXing(String xiaoXiLeiXingMingCheng, String xiaoXiLeiXingDaiMa, Integer zhuangTai, String tianJiaRen, Timestamp tianJiaShiJian,
			String xiuGaiRen, Timestamp xiuGaiShiJian, String beiZhu, Boolean shiFouZuiZhongCaoZuo)
	{
		this.xiaoXiLeiXingMingCheng = xiaoXiLeiXingMingCheng;
		this.xiaoXiLeiXingDaiMa = xiaoXiLeiXingDaiMa;
		this.zhuangTai = zhuangTai;
		this.tianJiaRen = tianJiaRen;
		this.tianJiaShiJian = tianJiaShiJian;
		this.xiuGaiRen = xiuGaiRen;
		this.xiuGaiShiJian = xiuGaiShiJian;
		this.beiZhu = beiZhu;
		this.shiFouZuiZhongCaoZuo = shiFouZuiZhongCaoZuo;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "XXLXID", unique = true, nullable = false, length = 50)
	public String getXxlxid()
	{
		return this.xxlxid;
	}

	public void setXxlxid(String xxlxid)
	{
		this.xxlxid = xxlxid;
	}

	@Column(name = "XiaoXiLeiXingMingCheng", length = 100)
	public String getXiaoXiLeiXingMingCheng()
	{
		return this.xiaoXiLeiXingMingCheng;
	}

	public void setXiaoXiLeiXingMingCheng(String xiaoXiLeiXingMingCheng)
	{
		this.xiaoXiLeiXingMingCheng = xiaoXiLeiXingMingCheng;
	}

	@Column(name = "XiaoXiLeiXingDaiMa", length = 50)
	public String getXiaoXiLeiXingDaiMa()
	{
		return this.xiaoXiLeiXingDaiMa;
	}

	public void setXiaoXiLeiXingDaiMa(String xiaoXiLeiXingDaiMa)
	{
		this.xiaoXiLeiXingDaiMa = xiaoXiLeiXingDaiMa;
	}

	@Column(name = "ZhuangTai")
	public Integer getZhuangTai()
	{
		return this.zhuangTai;
	}

	public void setZhuangTai(Integer zhuangTai)
	{
		this.zhuangTai = zhuangTai;
	}

	@Column(name = "TianJiaRen", length = 50)
	public String getTianJiaRen()
	{
		return this.tianJiaRen;
	}

	public void setTianJiaRen(String tianJiaRen)
	{
		this.tianJiaRen = tianJiaRen;
	}

	@Column(name = "TianJiaShiJian", length = 19)
	public Timestamp getTianJiaShiJian()
	{
		return this.tianJiaShiJian;
	}

	public void setTianJiaShiJian(Timestamp tianJiaShiJian)
	{
		this.tianJiaShiJian = tianJiaShiJian;
	}

	@Column(name = "XiuGaiRen", length = 50)
	public String getXiuGaiRen()
	{
		return this.xiuGaiRen;
	}

	public void setXiuGaiRen(String xiuGaiRen)
	{
		this.xiuGaiRen = xiuGaiRen;
	}

	@Column(name = "XiuGaiShiJian", length = 19)
	public Timestamp getXiuGaiShiJian()
	{
		return this.xiuGaiShiJian;
	}

	public void setXiuGaiShiJian(Timestamp xiuGaiShiJian)
	{
		this.xiuGaiShiJian = xiuGaiShiJian;
	}

	@Column(name = "BeiZhu", length = 1000)
	public String getBeiZhu()
	{
		return this.beiZhu;
	}

	public void setBeiZhu(String beiZhu)
	{
		this.beiZhu = beiZhu;
	}

	@Column(name = "ShiFouZuiZhongCaoZuo")
	public Boolean getShiFouZuiZhongCaoZuo()
	{
		return this.shiFouZuiZhongCaoZuo;
	}

	public void setShiFouZuiZhongCaoZuo(Boolean shiFouZuiZhongCaoZuo)
	{
		this.shiFouZuiZhongCaoZuo = shiFouZuiZhongCaoZuo;
	}

}