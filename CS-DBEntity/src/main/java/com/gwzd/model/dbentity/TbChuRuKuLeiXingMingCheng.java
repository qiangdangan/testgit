package com.gwzd.model.dbentity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbChuRuKuLeiXingMingCheng entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_ChuRuKuLeiXingMingCheng")
public class TbChuRuKuLeiXingMingCheng implements java.io.Serializable
{

	// Fields

	private String crklxmcid;
	private String mingCheng;
	private Integer zhuangTai;
	private String tianJiaRen;
	private Timestamp tianJiaShiJian;
	private String xiuGaiRen;
	private Timestamp xiuGaiShiJian;
	private String beiZhu;
	private String leiXingDaiMa;
	private Integer leiXing;

	// Constructors

	/** default constructor */
	public TbChuRuKuLeiXingMingCheng()
	{}

	/** full constructor */
	public TbChuRuKuLeiXingMingCheng(String mingCheng, Integer zhuangTai, String tianJiaRen, Timestamp tianJiaShiJian, String xiuGaiRen,
			Timestamp xiuGaiShiJian, String beiZhu, String leiXingDaiMa, Integer leiXing)
	{
		this.mingCheng = mingCheng;
		this.zhuangTai = zhuangTai;
		this.tianJiaRen = tianJiaRen;
		this.tianJiaShiJian = tianJiaShiJian;
		this.xiuGaiRen = xiuGaiRen;
		this.xiuGaiShiJian = xiuGaiShiJian;
		this.beiZhu = beiZhu;
		this.leiXingDaiMa = leiXingDaiMa;
		this.leiXing = leiXing;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "CRKLXMCID", unique = true, nullable = false, length = 50)
	public String getCrklxmcid()
	{
		return this.crklxmcid;
	}

	public void setCrklxmcid(String crklxmcid)
	{
		this.crklxmcid = crklxmcid;
	}

	@Column(name = "MingCheng", length = 100)
	public String getMingCheng()
	{
		return this.mingCheng;
	}

	public void setMingCheng(String mingCheng)
	{
		this.mingCheng = mingCheng;
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

	@Column(name = "BeiZhu", length = 500)
	public String getBeiZhu()
	{
		return this.beiZhu;
	}

	public void setBeiZhu(String beiZhu)
	{
		this.beiZhu = beiZhu;
	}

	@Column(name = "LeiXingDaiMa", length = 50)
	public String getLeiXingDaiMa()
	{
		return this.leiXingDaiMa;
	}

	public void setLeiXingDaiMa(String leiXingDaiMa)
	{
		this.leiXingDaiMa = leiXingDaiMa;
	}

	@Column(name = "LeiXing")
	public Integer getLeiXing()
	{
		return this.leiXing;
	}

	public void setLeiXing(Integer leiXing)
	{
		this.leiXing = leiXing;
	}

}