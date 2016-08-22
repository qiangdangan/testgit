package com.gwzd.model.dbentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbGuiZeWeiDu entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_GuiZeWeiDu")
public class TbGuiZeWeiDu implements java.io.Serializable
{

	// Fields

	private String gzwdid;
	private String wdxxid;
	private String guZeId;

	// Constructors

	/** default constructor */
	public TbGuiZeWeiDu()
	{}

	/** full constructor */
	public TbGuiZeWeiDu(String wdxxid, String guZeId)
	{
		this.wdxxid = wdxxid;
		this.guZeId = guZeId;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "GZWDID", unique = true, nullable = false, length = 50)
	public String getGzwdid()
	{
		return this.gzwdid;
	}

	public void setGzwdid(String gzwdid)
	{
		this.gzwdid = gzwdid;
	}

	@Column(name = "WDXXID", length = 50)
	public String getWdxxid()
	{
		return this.wdxxid;
	}

	public void setWdxxid(String wdxxid)
	{
		this.wdxxid = wdxxid;
	}

	@Column(name = "GuZeID", length = 50)
	public String getGuZeId()
	{
		return this.guZeId;
	}

	public void setGuZeId(String guZeId)
	{
		this.guZeId = guZeId;
	}

}