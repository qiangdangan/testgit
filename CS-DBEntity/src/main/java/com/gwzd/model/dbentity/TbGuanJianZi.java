package com.gwzd.model.dbentity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbGuanJianZi entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_GuanJianZi")
public class TbGuanJianZi implements java.io.Serializable
{

	// Fields

	private String gjzid;
	private String guanJianZi;
	private Integer guanJianZiLeiXing;
	private String tiHuanZi;
	private Integer zhuangTai;
	private String tianJiaRen;
	private Timestamp tianJiaShiJian;
	private String xiuGaiRen;
	private Timestamp xiuGaiShiJian;
	private String beiZhu;

	// Constructors

	/** default constructor */
	public TbGuanJianZi()
	{}

	/** full constructor */
	public TbGuanJianZi(String guanJianZi, Integer guanJianZiLeiXing, String tiHuanZi, Integer zhuangTai, String tianJiaRen, Timestamp tianJiaShiJian,
			String xiuGaiRen, Timestamp xiuGaiShiJian, String beiZhu)
	{
		this.guanJianZi = guanJianZi;
		this.guanJianZiLeiXing = guanJianZiLeiXing;
		this.tiHuanZi = tiHuanZi;
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
	@Column(name = "GJZID", unique = true, nullable = false, length = 50)
	public String getGjzid()
	{
		return this.gjzid;
	}

	public void setGjzid(String gjzid)
	{
		this.gjzid = gjzid;
	}

	@Column(name = "GuanJianZi", length = 200)
	public String getGuanJianZi()
	{
		return this.guanJianZi;
	}

	public void setGuanJianZi(String guanJianZi)
	{
		this.guanJianZi = guanJianZi;
	}

	@Column(name = "GuanJianZiLeiXing")
	public Integer getGuanJianZiLeiXing()
	{
		return this.guanJianZiLeiXing;
	}

	public void setGuanJianZiLeiXing(Integer guanJianZiLeiXing)
	{
		this.guanJianZiLeiXing = guanJianZiLeiXing;
	}

	@Column(name = "TiHuanZi", length = 200)
	public String getTiHuanZi()
	{
		return this.tiHuanZi;
	}

	public void setTiHuanZi(String tiHuanZi)
	{
		this.tiHuanZi = tiHuanZi;
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