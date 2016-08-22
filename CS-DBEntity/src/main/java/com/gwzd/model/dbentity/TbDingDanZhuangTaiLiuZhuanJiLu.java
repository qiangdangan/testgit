package com.gwzd.model.dbentity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbDingDanZhuangTaiLiuZhuanJiLu entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_DingDanZhuangTaiLiuZhuanJiLu")
public class TbDingDanZhuangTaiLiuZhuanJiLu implements java.io.Serializable
{

	// Fields

	private String ddztjlid;
	private String ddxxid;
	private Integer dingDangZhuangTai;
	private Timestamp gengGaiShiJian;

	// Constructors

	/** default constructor */
	public TbDingDanZhuangTaiLiuZhuanJiLu()
	{}

	/** full constructor */
	public TbDingDanZhuangTaiLiuZhuanJiLu(String ddxxid, Integer dingDangZhuangTai, Timestamp gengGaiShiJian)
	{
		this.ddxxid = ddxxid;
		this.dingDangZhuangTai = dingDangZhuangTai;
		this.gengGaiShiJian = gengGaiShiJian;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "DDZTJLID", unique = true, nullable = false, length = 50)
	public String getDdztjlid()
	{
		return this.ddztjlid;
	}

	public void setDdztjlid(String ddztjlid)
	{
		this.ddztjlid = ddztjlid;
	}

	@Column(name = "DDXXID", length = 50)
	public String getDdxxid()
	{
		return this.ddxxid;
	}

	public void setDdxxid(String ddxxid)
	{
		this.ddxxid = ddxxid;
	}

	@Column(name = "DingDangZhuangTai")
	public Integer getDingDangZhuangTai()
	{
		return this.dingDangZhuangTai;
	}

	public void setDingDangZhuangTai(Integer dingDangZhuangTai)
	{
		this.dingDangZhuangTai = dingDangZhuangTai;
	}

	@Column(name = "GengGaiShiJian", length = 19)
	public Timestamp getGengGaiShiJian()
	{
		return this.gengGaiShiJian;
	}

	public void setGengGaiShiJian(Timestamp gengGaiShiJian)
	{
		this.gengGaiShiJian = gengGaiShiJian;
	}

}