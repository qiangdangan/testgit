package com.gwzd.model.dbentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbChuLiXiaoXiJieShouRen entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_ChuLiXiaoXiJieShouRen")
public class TbChuLiXiaoXiJieShouRen implements java.io.Serializable
{

	// Fields

	private String zxgzgbid;
	private String zxgzId;
	private String zxid;
	private String ryid;
	private Integer ydzt;

	// Constructors

	/** default constructor */
	public TbChuLiXiaoXiJieShouRen()
	{}

	/** full constructor */
	public TbChuLiXiaoXiJieShouRen(String zxgzId, String zxid, String ryid, Integer ydzt)
	{
		this.zxgzId = zxgzId;
		this.zxid = zxid;
		this.ryid = ryid;
		this.ydzt = ydzt;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "ZXGZGBID", unique = true, nullable = false, length = 50)
	public String getZxgzgbid()
	{
		return this.zxgzgbid;
	}

	public void setZxgzgbid(String zxgzgbid)
	{
		this.zxgzgbid = zxgzgbid;
	}

	@Column(name = "ZXGZ_ID", length = 50)
	public String getZxgzId()
	{
		return this.zxgzId;
	}

	public void setZxgzId(String zxgzId)
	{
		this.zxgzId = zxgzId;
	}

	@Column(name = "ZXID", length = 50)
	public String getZxid()
	{
		return this.zxid;
	}

	public void setZxid(String zxid)
	{
		this.zxid = zxid;
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

	@Column(name = "YDZT")
	public Integer getYdzt()
	{
		return this.ydzt;
	}

	public void setYdzt(Integer ydzt)
	{
		this.ydzt = ydzt;
	}

}