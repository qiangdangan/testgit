package com.gwzd.model.dbentity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbBeiJianXinXi entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_BeiJianXinXi")
public class TbBeiJianXinXi implements java.io.Serializable
{

	// Fields

	private String bjid;
	private String wuLiaoBianHao;
	private String wuLiaoMingCheng;
	private String k3ma;
	private String jgxxid;
	private String guiGeXingHao;
	private Double danJianZhongLiang;
	private Double danJia;
	private String tianJiaRen;
	private Timestamp tianJiaShiJian;
	private String xiuGaiRen;
	private Timestamp xiuGaiShiJian;
	private String beiZhu;

	// Constructors

	/** default constructor */
	public TbBeiJianXinXi()
	{}

	/** minimal constructor */
	public TbBeiJianXinXi(String jgxxid)
	{
		this.jgxxid = jgxxid;
	}

	/** full constructor */
	public TbBeiJianXinXi(String wuLiaoBianHao, String wuLiaoMingCheng, String k3ma, String jgxxid, String guiGeXingHao, Double danJianZhongLiang,
			Double danJia, String tianJiaRen, Timestamp tianJiaShiJian, String xiuGaiRen, Timestamp xiuGaiShiJian, String beiZhu)
	{
		this.wuLiaoBianHao = wuLiaoBianHao;
		this.wuLiaoMingCheng = wuLiaoMingCheng;
		this.k3ma = k3ma;
		this.jgxxid = jgxxid;
		this.guiGeXingHao = guiGeXingHao;
		this.danJianZhongLiang = danJianZhongLiang;
		this.danJia = danJia;
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
	@Column(name = "BJID", unique = true, nullable = false, length = 50)
	public String getBjid()
	{
		return this.bjid;
	}

	public void setBjid(String bjid)
	{
		this.bjid = bjid;
	}

	@Column(name = "WuLiaoBianHao", length = 50)
	public String getWuLiaoBianHao()
	{
		return this.wuLiaoBianHao;
	}

	public void setWuLiaoBianHao(String wuLiaoBianHao)
	{
		this.wuLiaoBianHao = wuLiaoBianHao;
	}

	@Column(name = "WuLiaoMingCheng", length = 100)
	public String getWuLiaoMingCheng()
	{
		return this.wuLiaoMingCheng;
	}

	public void setWuLiaoMingCheng(String wuLiaoMingCheng)
	{
		this.wuLiaoMingCheng = wuLiaoMingCheng;
	}

	@Column(name = "K3Ma", length = 50)
	public String getK3ma()
	{
		return this.k3ma;
	}

	public void setK3ma(String k3ma)
	{
		this.k3ma = k3ma;
	}

	@Column(name = "JGXXID", nullable = false, length = 50)
	public String getJgxxid()
	{
		return this.jgxxid;
	}

	public void setJgxxid(String jgxxid)
	{
		this.jgxxid = jgxxid;
	}

	@Column(name = "GuiGeXingHao", length = 100)
	public String getGuiGeXingHao()
	{
		return this.guiGeXingHao;
	}

	public void setGuiGeXingHao(String guiGeXingHao)
	{
		this.guiGeXingHao = guiGeXingHao;
	}

	@Column(name = "DanJianZhongLiang", precision = 9)
	public Double getDanJianZhongLiang()
	{
		return this.danJianZhongLiang;
	}

	public void setDanJianZhongLiang(Double danJianZhongLiang)
	{
		this.danJianZhongLiang = danJianZhongLiang;
	}

	@Column(name = "DanJia", precision = 9)
	public Double getDanJia()
	{
		return this.danJia;
	}

	public void setDanJia(Double danJia)
	{
		this.danJia = danJia;
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