package com.gwzd.model.dbentity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbChuLiXiaoXi entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_ChuLiXiaoXi")
public class TbChuLiXiaoXi implements java.io.Serializable
{

	// Fields

	private String clxxid;
	private String csxxid;
	private String zxgzbm;
	private String gznr;
	private Timestamp gzsj;
	private String ryid;
	private String xxlxid;

	// Constructors

	/** default constructor */
	public TbChuLiXiaoXi()
	{}

	/** full constructor */
	public TbChuLiXiaoXi(String csxxid, String zxgzbm, String gznr, Timestamp gzsj, String ryid, String xxlxid)
	{
		this.csxxid = csxxid;
		this.zxgzbm = zxgzbm;
		this.gznr = gznr;
		this.gzsj = gzsj;
		this.ryid = ryid;
		this.xxlxid = xxlxid;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "CLXXID", unique = true, nullable = false, length = 50)
	public String getClxxid()
	{
		return this.clxxid;
	}

	public void setClxxid(String clxxid)
	{
		this.clxxid = clxxid;
	}

	@Column(name = "CSXXID", length = 50)
	public String getCsxxid()
	{
		return this.csxxid;
	}

	public void setCsxxid(String csxxid)
	{
		this.csxxid = csxxid;
	}

	@Column(name = "ZXGZBM", length = 50)
	public String getZxgzbm()
	{
		return this.zxgzbm;
	}

	public void setZxgzbm(String zxgzbm)
	{
		this.zxgzbm = zxgzbm;
	}

	@Column(name = "GZNR", length = 500)
	public String getGznr()
	{
		return this.gznr;
	}

	public void setGznr(String gznr)
	{
		this.gznr = gznr;
	}

	@Column(name = "GZSJ", length = 19)
	public Timestamp getGzsj()
	{
		return this.gzsj;
	}

	public void setGzsj(Timestamp gzsj)
	{
		this.gzsj = gzsj;
	}

	@Column(name = "RYID", length = 50)
	public String getRyid()
	{
		return this.ryid;
	}

	public void setRyid(String ryid)
	{
		this.ryid = ryid;
	}

	@Column(name = "XXLXID", length = 50)
	public String getXxlxid()
	{
		return this.xxlxid;
	}

	public void setXxlxid(String xxlxid)
	{
		this.xxlxid = xxlxid;
	}

}