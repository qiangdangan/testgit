package com.gwzd.model.dbentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbRenWuZhiXingRen entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_RenWuZhiXingRen")
public class TbRenWuZhiXingRen implements java.io.Serializable
{

	// Fields

	private String rwzxrid;
	private String ryId;
	private String rxxxid;
	private String beiZhu;

	// Constructors

	/** default constructor */
	public TbRenWuZhiXingRen()
	{}

	/** full constructor */
	public TbRenWuZhiXingRen(String ryId, String rxxxid, String beiZhu)
	{
		this.ryId = ryId;
		this.rxxxid = rxxxid;
		this.beiZhu = beiZhu;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "RWZXRID", unique = true, nullable = false, length = 50)
	public String getRwzxrid()
	{
		return this.rwzxrid;
	}

	public void setRwzxrid(String rwzxrid)
	{
		this.rwzxrid = rwzxrid;
	}

	@Column(name = "RY_ID", length = 50)
	public String getRyId()
	{
		return this.ryId;
	}

	public void setRyId(String ryId)
	{
		this.ryId = ryId;
	}

	@Column(name = "RXXXID", length = 50)
	public String getRxxxid()
	{
		return this.rxxxid;
	}

	public void setRxxxid(String rxxxid)
	{
		this.rxxxid = rxxxid;
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