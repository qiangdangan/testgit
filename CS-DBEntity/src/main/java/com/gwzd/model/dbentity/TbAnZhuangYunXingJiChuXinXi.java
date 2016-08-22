package com.gwzd.model.dbentity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbAnZhuangYunXingJiChuXinXi entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_AnZhuangYunXingJiChuXinXi")
public class TbAnZhuangYunXingJiChuXinXi implements java.io.Serializable
{

	// Fields

	private String azyxjcxxid;
	private String tiaoMuMingCheng;
	private Integer zhuangTai;
	private Float fenShu;
	private String tianJiaRen;
	private Timestamp tianJiaShiJian;
	private String xiuGaiRen;
	private Timestamp xiuGaiShiJian;
	private String beiZhu;

	// Constructors

	/** default constructor */
	public TbAnZhuangYunXingJiChuXinXi()
	{}

	/** full constructor */
	public TbAnZhuangYunXingJiChuXinXi(String tiaoMuMingCheng, Integer zhuangTai, Float fenShu, String tianJiaRen, Timestamp tianJiaShiJian, String xiuGaiRen,
			Timestamp xiuGaiShiJian, String beiZhu)
	{
		this.tiaoMuMingCheng = tiaoMuMingCheng;
		this.zhuangTai = zhuangTai;
		this.fenShu = fenShu;
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
	@Column(name = "AZYXJCXXID", unique = true, nullable = false, length = 50)
	public String getAzyxjcxxid()
	{
		return this.azyxjcxxid;
	}

	public void setAzyxjcxxid(String azyxjcxxid)
	{
		this.azyxjcxxid = azyxjcxxid;
	}

	@Column(name = "TiaoMuMingCheng", length = 200)
	public String getTiaoMuMingCheng()
	{
		return this.tiaoMuMingCheng;
	}

	public void setTiaoMuMingCheng(String tiaoMuMingCheng)
	{
		this.tiaoMuMingCheng = tiaoMuMingCheng;
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

	@Column(name = "FenShu", precision = 12, scale = 0)
	public Float getFenShu()
	{
		return this.fenShu;
	}

	public void setFenShu(Float fenShu)
	{
		this.fenShu = fenShu;
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