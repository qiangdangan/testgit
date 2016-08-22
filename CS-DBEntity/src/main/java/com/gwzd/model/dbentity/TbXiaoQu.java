package com.gwzd.model.dbentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbXiaoQu entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_XiaoQu")
public class TbXiaoQu implements java.io.Serializable
{

	// Fields

	private String cid;
	private String jid;
	private String hscd;
	private String mc;
	private String dm;
	private String dz;

	// Constructors

	/** default constructor */
	public TbXiaoQu()
	{}

	/** full constructor */
	public TbXiaoQu(String jid, String hscd, String mc, String dm, String dz)
	{
		this.jid = jid;
		this.hscd = hscd;
		this.mc = mc;
		this.dm = dm;
		this.dz = dz;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "CID", unique = true, nullable = false, length = 50)
	public String getCid()
	{
		return this.cid;
	}

	public void setCid(String cid)
	{
		this.cid = cid;
	}

	@Column(name = "JID", length = 50)
	public String getJid()
	{
		return this.jid;
	}

	public void setJid(String jid)
	{
		this.jid = jid;
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

	@Column(name = "DZ", length = 500)
	public String getDz()
	{
		return this.dz;
	}

	public void setDz(String dz)
	{
		this.dz = dz;
	}

}