package com.gwzd.model.dbentity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbZhuanYeXinXi entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_ZhuanYeXinXi")
public class TbZhuanYeXinXi implements java.io.Serializable
{

	// Fields

	private String zyid;
	private String zhuanYeMingCheng;
	private String zhuanYeDaiMa;
	private Integer zhuangTai;
	private String tianJiaRen;
	private Timestamp tianJiaShiJian;
	private String xiuGaiRen;
	private Timestamp xiuGaiShiJian;
	private String beiZhu;

	// Constructors

	/** default constructor */
	public TbZhuanYeXinXi()
	{}

	/** full constructor */
	public TbZhuanYeXinXi(String zhuanYeMingCheng, String zhuanYeDaiMa, Integer zhuangTai, String tianJiaRen, Timestamp tianJiaShiJian, String xiuGaiRen,
			Timestamp xiuGaiShiJian, String beiZhu)
	{
		this.zhuanYeMingCheng = zhuanYeMingCheng;
		this.zhuanYeDaiMa = zhuanYeDaiMa;
		this.zhuangTai = zhuangTai;
		this.tianJiaRen = tianJiaRen;
		this.tianJiaShiJian = tianJiaShiJian;
		this.xiuGaiRen = xiuGaiRen;
		this.xiuGaiShiJian = xiuGaiShiJian;
		this.beiZhu = beiZhu;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "ZYID", unique = true, nullable = false, length = 50)
	public String getZyid()
	{
		return this.zyid;
	}

	public void setZyid(String zyid)
	{
		this.zyid = zyid;
	}

	@Column(name = "ZhuanYeMingCheng", length = 100)
	public String getZhuanYeMingCheng()
	{
		return this.zhuanYeMingCheng;
	}

	public void setZhuanYeMingCheng(String zhuanYeMingCheng)
	{
		this.zhuanYeMingCheng = zhuanYeMingCheng;
	}

	@Column(name = "ZhuanYeDaiMa", length = 30)
	public String getZhuanYeDaiMa()
	{
		return this.zhuanYeDaiMa;
	}

	public void setZhuanYeDaiMa(String zhuanYeDaiMa)
	{
		this.zhuanYeDaiMa = zhuanYeDaiMa;
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

}