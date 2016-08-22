package com.gwzd.model.dbentity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbJiGouBuMen entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_JiGouBuMen")
public class TbJiGouBuMen implements java.io.Serializable
{

	// Fields

	private String bmid;
	private String jgxxid;
	private String buMenMingCheng;
	private String buMenDianHua;
	private Integer zhuangTai;
	private String tianJiaRen;
	private Timestamp tianJiaShiJian;
	private String xiuGaiRen;
	private Timestamp xiuGaiShiJian;
	private String beiZhu;

	// Constructors

	/** default constructor */
	public TbJiGouBuMen()
	{}

	/** full constructor */
	public TbJiGouBuMen(String jgxxid, String buMenMingCheng, String buMenDianHua, Integer zhuangTai, String tianJiaRen, Timestamp tianJiaShiJian,
			String xiuGaiRen, Timestamp xiuGaiShiJian, String beiZhu)
	{
		this.jgxxid = jgxxid;
		this.buMenMingCheng = buMenMingCheng;
		this.buMenDianHua = buMenDianHua;
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
	@Column(name = "BMID", unique = true, nullable = false, length = 50)
	public String getBmid()
	{
		return this.bmid;
	}

	public void setBmid(String bmid)
	{
		this.bmid = bmid;
	}

	@Column(name = "JGXXID", length = 50)
	public String getJgxxid()
	{
		return this.jgxxid;
	}

	public void setJgxxid(String jgxxid)
	{
		this.jgxxid = jgxxid;
	}

	@Column(name = "BuMenMingCheng", length = 100)
	public String getBuMenMingCheng()
	{
		return this.buMenMingCheng;
	}

	public void setBuMenMingCheng(String buMenMingCheng)
	{
		this.buMenMingCheng = buMenMingCheng;
	}

	@Column(name = "BuMenDianHua", length = 50)
	public String getBuMenDianHua()
	{
		return this.buMenDianHua;
	}

	public void setBuMenDianHua(String buMenDianHua)
	{
		this.buMenDianHua = buMenDianHua;
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