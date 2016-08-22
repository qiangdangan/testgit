package com.gwzd.model.dbentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbRenYuanZhiWu entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_RenYuanZhiWu")
public class TbRenYuanZhiWu implements java.io.Serializable
{

	// Fields

	private String ryzwId;
	private String ryId;
	private String zwId;

	// Constructors

	/** default constructor */
	public TbRenYuanZhiWu()
	{}

	/** full constructor */
	public TbRenYuanZhiWu(String ryId, String zwId)
	{
		this.ryId = ryId;
		this.zwId = zwId;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "RYZW_ID", unique = true, nullable = false, length = 50)
	public String getRyzwId()
	{
		return this.ryzwId;
	}

	public void setRyzwId(String ryzwId)
	{
		this.ryzwId = ryzwId;
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

	@Column(name = "ZW_ID", length = 50)
	public String getZwId()
	{
		return this.zwId;
	}

	public void setZwId(String zwId)
	{
		this.zwId = zwId;
	}

}