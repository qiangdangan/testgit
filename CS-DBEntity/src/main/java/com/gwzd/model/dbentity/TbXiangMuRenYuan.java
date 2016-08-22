package com.gwzd.model.dbentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbXiangMuRenYuan entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_XiangMuRenYuan")
public class TbXiangMuRenYuan implements java.io.Serializable
{

	// Fields

	private String xmryid;
	private String xmid;
	private String ryId;

	// Constructors

	/** default constructor */
	public TbXiangMuRenYuan()
	{}

	/** full constructor */
	public TbXiangMuRenYuan(String xmid, String ryId)
	{
		this.xmid = xmid;
		this.ryId = ryId;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "XMRYID", unique = true, nullable = false, length = 50)
	public String getXmryid()
	{
		return this.xmryid;
	}

	public void setXmryid(String xmryid)
	{
		this.xmryid = xmryid;
	}

	@Column(name = "XMID", length = 50)
	public String getXmid()
	{
		return this.xmid;
	}

	public void setXmid(String xmid)
	{
		this.xmid = xmid;
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

}