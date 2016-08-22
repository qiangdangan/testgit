package com.gwzd.model.dbentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbXiangMuJiHua entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_XiangMuJiHua")
public class TbXiangMuJiHua implements java.io.Serializable
{

	// Fields

	private String xmjhid;
	private String xmid;
	private String jhid;

	// Constructors

	/** default constructor */
	public TbXiangMuJiHua()
	{}

	/** full constructor */
	public TbXiangMuJiHua(String xmid, String jhid)
	{
		this.xmid = xmid;
		this.jhid = jhid;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "XMJHID", unique = true, nullable = false, length = 50)
	public String getXmjhid()
	{
		return this.xmjhid;
	}

	public void setXmjhid(String xmjhid)
	{
		this.xmjhid = xmjhid;
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

	@Column(name = "JHID", length = 50)
	public String getJhid()
	{
		return this.jhid;
	}

	public void setJhid(String jhid)
	{
		this.jhid = jhid;
	}

}