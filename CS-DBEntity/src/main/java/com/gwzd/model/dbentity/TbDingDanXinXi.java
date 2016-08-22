package com.gwzd.model.dbentity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbDingDanXinXi entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_DingDanXinXi")
public class TbDingDanXinXi implements java.io.Serializable
{

	// Fields

	private String ddxxid;
	private String mingCheng;
	private String dingDanBianHao;
	private String tianJiaRen;
	private Timestamp tianJiaShiJian;
	private String xiuGaiRen;
	private Timestamp xiuGaiShiJian;
	private Integer zhuangTai;
	private String changJiaJieShouRen;
	private String dingDanCaiGouFuZeRen;
	private String beiZhu;

	// Constructors

	/** default constructor */
	public TbDingDanXinXi()
	{}

	/** full constructor */
	public TbDingDanXinXi(String mingCheng, String dingDanBianHao, String tianJiaRen, Timestamp tianJiaShiJian, String xiuGaiRen, Timestamp xiuGaiShiJian,
			Integer zhuangTai, String changJiaJieShouRen, String dingDanCaiGouFuZeRen, String beiZhu)
	{
		this.mingCheng = mingCheng;
		this.dingDanBianHao = dingDanBianHao;
		this.tianJiaRen = tianJiaRen;
		this.tianJiaShiJian = tianJiaShiJian;
		this.xiuGaiRen = xiuGaiRen;
		this.xiuGaiShiJian = xiuGaiShiJian;
		this.zhuangTai = zhuangTai;
		this.changJiaJieShouRen = changJiaJieShouRen;
		this.dingDanCaiGouFuZeRen = dingDanCaiGouFuZeRen;
		this.beiZhu = beiZhu;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "DDXXID", unique = true, nullable = false, length = 50)
	public String getDdxxid()
	{
		return this.ddxxid;
	}

	public void setDdxxid(String ddxxid)
	{
		this.ddxxid = ddxxid;
	}

	@Column(name = "MingCheng", length = 200)
	public String getMingCheng()
	{
		return this.mingCheng;
	}

	public void setMingCheng(String mingCheng)
	{
		this.mingCheng = mingCheng;
	}

	@Column(name = "DingDanBianHao", length = 50)
	public String getDingDanBianHao()
	{
		return this.dingDanBianHao;
	}

	public void setDingDanBianHao(String dingDanBianHao)
	{
		this.dingDanBianHao = dingDanBianHao;
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

	@Column(name = "ZhuangTai")
	public Integer getZhuangTai()
	{
		return this.zhuangTai;
	}

	public void setZhuangTai(Integer zhuangTai)
	{
		this.zhuangTai = zhuangTai;
	}

	@Column(name = "ChangJiaJieShouRen", length = 50)
	public String getChangJiaJieShouRen()
	{
		return this.changJiaJieShouRen;
	}

	public void setChangJiaJieShouRen(String changJiaJieShouRen)
	{
		this.changJiaJieShouRen = changJiaJieShouRen;
	}

	@Column(name = "DingDanCaiGouFuZeRen", length = 50)
	public String getDingDanCaiGouFuZeRen()
	{
		return this.dingDanCaiGouFuZeRen;
	}

	public void setDingDanCaiGouFuZeRen(String dingDanCaiGouFuZeRen)
	{
		this.dingDanCaiGouFuZeRen = dingDanCaiGouFuZeRen;
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