package com.gwzd.model.dbentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbQu entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_Qu")
public class TbQu implements java.io.Serializable
{

	// Fields

	private String qid;
	private String shid;
	private String mc;
	private String dm;
	private String hscd;

	// Constructors

	/** default constructor */
	public TbQu()
	{}

	/** full constructor */
	public TbQu(String shid, String mc, String dm, String hscd)
	{
		this.shid = shid;
		this.mc = mc;
		this.dm = dm;
		this.hscd = hscd;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "QID", unique = true, nullable = false, length = 50)
	public String getQid()
	{
		return this.qid;
	}

	public void setQid(String qid)
	{
		this.qid = qid;
	}

	@Column(name = "SHID", length = 50)
	public String getShid()
	{
		return this.shid;
	}

	public void setShid(String shid)
	{
		this.shid = shid;
	}

	@Column(name = "MC", length = 50)
	public String getMc()
	{
		return this.mc;
	}

	public void setMc(String mc)
	{
		this.mc = mc;
	}

	@Column(name = "DM", length = 50)
	public String getDm()
	{
		return this.dm;
	}

	public void setDm(String dm)
	{
		this.dm = dm;
	}

	@Column(name = "HSCD", length = 100)
	public String getHscd()
	{
		return this.hscd;
	}

	public void setHscd(String hscd)
	{
		this.hscd = hscd;
	}

}