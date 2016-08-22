package com.gwzd.model.dbentity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbShengChanXinXi entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_ShengChanXinXi")
public class TbShengChanXinXi implements java.io.Serializable
{

	// Fields

	private String scxxid;
	private String ddxxid;
	private Integer dangQianDingDanZhuangTai;
	private Timestamp yuJiShengChanShiJian;
	private Timestamp yuJiChuChangShiJina;
	private Timestamp yuJiDaoHuoShiJian;
	private String jgxxid;

	// Constructors

	/** default constructor */
	public TbShengChanXinXi()
	{}

	/** minimal constructor */
	public TbShengChanXinXi(String jgxxid)
	{
		this.jgxxid = jgxxid;
	}

	/** full constructor */
	public TbShengChanXinXi(String ddxxid, Integer dangQianDingDanZhuangTai, Timestamp yuJiShengChanShiJian, Timestamp yuJiChuChangShiJina,
			Timestamp yuJiDaoHuoShiJian, String jgxxid)
	{
		this.ddxxid = ddxxid;
		this.dangQianDingDanZhuangTai = dangQianDingDanZhuangTai;
		this.yuJiShengChanShiJian = yuJiShengChanShiJian;
		this.yuJiChuChangShiJina = yuJiChuChangShiJina;
		this.yuJiDaoHuoShiJian = yuJiDaoHuoShiJian;
		this.jgxxid = jgxxid;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "SCXXID", unique = true, nullable = false, length = 50)
	public String getScxxid()
	{
		return this.scxxid;
	}

	public void setScxxid(String scxxid)
	{
		this.scxxid = scxxid;
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

	@Column(name = "DangQianDingDanZhuangTai")
	public Integer getDangQianDingDanZhuangTai()
	{
		return this.dangQianDingDanZhuangTai;
	}

	public void setDangQianDingDanZhuangTai(Integer dangQianDingDanZhuangTai)
	{
		this.dangQianDingDanZhuangTai = dangQianDingDanZhuangTai;
	}

	@Column(name = "YuJiShengChanShiJian", length = 19)
	public Timestamp getYuJiShengChanShiJian()
	{
		return this.yuJiShengChanShiJian;
	}

	public void setYuJiShengChanShiJian(Timestamp yuJiShengChanShiJian)
	{
		this.yuJiShengChanShiJian = yuJiShengChanShiJian;
	}

	@Column(name = "YuJiChuChangShiJina", length = 19)
	public Timestamp getYuJiChuChangShiJina()
	{
		return this.yuJiChuChangShiJina;
	}

	public void setYuJiChuChangShiJina(Timestamp yuJiChuChangShiJina)
	{
		this.yuJiChuChangShiJina = yuJiChuChangShiJina;
	}

	@Column(name = "YuJiDaoHuoShiJian", length = 19)
	public Timestamp getYuJiDaoHuoShiJian()
	{
		return this.yuJiDaoHuoShiJian;
	}

	public void setYuJiDaoHuoShiJian(Timestamp yuJiDaoHuoShiJian)
	{
		this.yuJiDaoHuoShiJian = yuJiDaoHuoShiJian;
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

}