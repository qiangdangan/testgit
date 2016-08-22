package com.gwzd.model.dbentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbShi entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_Shi")
public class TbShi implements java.io.Serializable
{

	// Fields

	private String shid;
	private String sid;
	private String mc;
	private String dm;
	private String hscd;

	// Constructors

	/** default constructor */
	public TbShi()
	{}

	/** full constructor */
	public TbShi(String sid, String mc, String dm, String hscd)
	{
		this.sid = sid;
		this.mc = mc;
		this.dm = dm;
		this.hscd = hscd;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "SHID", unique = true, nullable = false, length = 50)
	public String getShid()
	{
		return this.shid;
	}

	public void setShid(String shid)
	{
		this.shid = shid;
	}

	@Column(name = "SID", length = 50)
	public String getSid()
	{
		return this.sid;
	}

	public void setSid(String sid)
	{
		this.sid = sid;
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