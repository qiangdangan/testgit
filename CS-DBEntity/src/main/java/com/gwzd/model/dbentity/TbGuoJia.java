package com.gwzd.model.dbentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbGuoJia entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_GuoJia")
public class TbGuoJia implements java.io.Serializable
{

	// Fields

	private String gid;
	private String mc;
	private String dm;
	private String hscd;

	// Constructors

	/** default constructor */
	public TbGuoJia()
	{}

	/** full constructor */
	public TbGuoJia(String mc, String dm, String hscd)
	{
		this.mc = mc;
		this.dm = dm;
		this.hscd = hscd;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "GID", unique = true, nullable = false, length = 50)
	public String getGid()
	{
		return this.gid;
	}

	public void setGid(String gid)
	{
		this.gid = gid;
	}

	@Column(name = "MC", length = 100)
	public String getMc()
	{
		return this.mc;
	}

	public void setMc(String mc)
	{
		this.mc = mc;
	}

	@Column(name = "DM", length = 100)
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