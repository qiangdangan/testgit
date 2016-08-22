package com.gwzd.model.dbentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbZiDingYiGuiZeJieShouRenYuan entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_ZiDingYiGuiZeJieShouRenYuan")
public class TbZiDingYiGuiZeJieShouRenYuan implements java.io.Serializable
{

	// Fields

	private String zdyzdryid;
	private String guZeId;
	private String ryId;

	// Constructors

	/** default constructor */
	public TbZiDingYiGuiZeJieShouRenYuan()
	{}

	/** full constructor */
	public TbZiDingYiGuiZeJieShouRenYuan(String guZeId, String ryId)
	{
		this.guZeId = guZeId;
		this.ryId = ryId;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "ZDYZDRYID", unique = true, nullable = false, length = 50)
	public String getZdyzdryid()
	{
		return this.zdyzdryid;
	}

	public void setZdyzdryid(String zdyzdryid)
	{
		this.zdyzdryid = zdyzdryid;
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