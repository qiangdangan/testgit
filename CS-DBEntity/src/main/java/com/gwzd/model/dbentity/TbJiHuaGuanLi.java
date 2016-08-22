package com.gwzd.model.dbentity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbJiHuaGuanLi entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_JiHuaGuanLi")
public class TbJiHuaGuanLi implements java.io.Serializable
{

	// Fields

	private String jhid;
	private String renWuLeiXingId;
	private String baoYangNeiRong;
	private String shuoMing;
	private Integer zhuangTai;
	private Timestamp jiHuaKaiShiShiJian;
	private Timestamp jiHuaJieShuShiJian;
	private Integer jiHuaLeiXing;
	private String beiZhu;

	// Constructors

	/** default constructor */
	public TbJiHuaGuanLi()
	{}

	/** full constructor */
	public TbJiHuaGuanLi(String renWuLeiXingId, String baoYangNeiRong, String shuoMing, Integer zhuangTai, Timestamp jiHuaKaiShiShiJian,
			Timestamp jiHuaJieShuShiJian, Integer jiHuaLeiXing, String beiZhu)
	{
		this.renWuLeiXingId = renWuLeiXingId;
		this.baoYangNeiRong = baoYangNeiRong;
		this.shuoMing = shuoMing;
		this.zhuangTai = zhuangTai;
		this.jiHuaKaiShiShiJian = jiHuaKaiShiShiJian;
		this.jiHuaJieShuShiJian = jiHuaJieShuShiJian;
		this.jiHuaLeiXing = jiHuaLeiXing;
		this.beiZhu = beiZhu;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "JHID", unique = true, nullable = false, length = 50)
	public String getJhid()
	{
		return this.jhid;
	}

	public void setJhid(String jhid)
	{
		this.jhid = jhid;
	}

	@Column(name = "RenWuLeiXingID", length = 50)
	public String getRenWuLeiXingId()
	{
		return this.renWuLeiXingId;
	}

	public void setRenWuLeiXingId(String renWuLeiXingId)
	{
		this.renWuLeiXingId = renWuLeiXingId;
	}

	@Column(name = "BaoYangNeiRong", length = 1000)
	public String getBaoYangNeiRong()
	{
		return this.baoYangNeiRong;
	}

	public void setBaoYangNeiRong(String baoYangNeiRong)
	{
		this.baoYangNeiRong = baoYangNeiRong;
	}

	@Column(name = "ShuoMing", length = 1000)
	public String getShuoMing()
	{
		return this.shuoMing;
	}

	public void setShuoMing(String shuoMing)
	{
		this.shuoMing = shuoMing;
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

	@Column(name = "JiHuaKaiShiShiJian", length = 19)
	public Timestamp getJiHuaKaiShiShiJian()
	{
		return this.jiHuaKaiShiShiJian;
	}

	public void setJiHuaKaiShiShiJian(Timestamp jiHuaKaiShiShiJian)
	{
		this.jiHuaKaiShiShiJian = jiHuaKaiShiShiJian;
	}

	@Column(name = "JiHuaJieShuShiJian", length = 19)
	public Timestamp getJiHuaJieShuShiJian()
	{
		return this.jiHuaJieShuShiJian;
	}

	public void setJiHuaJieShuShiJian(Timestamp jiHuaJieShuShiJian)
	{
		this.jiHuaJieShuShiJian = jiHuaJieShuShiJian;
	}

	@Column(name = "JiHuaLeiXing")
	public Integer getJiHuaLeiXing()
	{
		return this.jiHuaLeiXing;
	}

	public void setJiHuaLeiXing(Integer jiHuaLeiXing)
	{
		this.jiHuaLeiXing = jiHuaLeiXing;
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