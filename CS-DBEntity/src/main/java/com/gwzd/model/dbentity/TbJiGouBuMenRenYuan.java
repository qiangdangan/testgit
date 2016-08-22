package com.gwzd.model.dbentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbJiGouBuMenRenYuan entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_JiGouBuMenRenYuan")
public class TbJiGouBuMenRenYuan implements java.io.Serializable
{

	// Fields

	private String bmryid;
	private String ryId;
	private String bmid;
	private Boolean shiFouBuMenLingDao;

	// Constructors

	/** default constructor */
	public TbJiGouBuMenRenYuan()
	{}

	/** full constructor */
	public TbJiGouBuMenRenYuan(String ryId, String bmid, Boolean shiFouBuMenLingDao)
	{
		this.ryId = ryId;
		this.bmid = bmid;
		this.shiFouBuMenLingDao = shiFouBuMenLingDao;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "BMRYID", unique = true, nullable = false, length = 50)
	public String getBmryid()
	{
		return this.bmryid;
	}

	public void setBmryid(String bmryid)
	{
		this.bmryid = bmryid;
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

	@Column(name = "BMID", length = 50)
	public String getBmid()
	{
		return this.bmid;
	}

	public void setBmid(String bmid)
	{
		this.bmid = bmid;
	}

	@Column(name = "ShiFouBuMenLingDao")
	public Boolean getShiFouBuMenLingDao()
	{
		return this.shiFouBuMenLingDao;
	}

	public void setShiFouBuMenLingDao(Boolean shiFouBuMenLingDao)
	{
		this.shiFouBuMenLingDao = shiFouBuMenLingDao;
	}

}