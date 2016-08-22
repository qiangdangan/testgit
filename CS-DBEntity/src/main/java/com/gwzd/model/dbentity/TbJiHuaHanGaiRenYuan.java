package com.gwzd.model.dbentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbJiHuaHanGaiRenYuan entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_JiHuaHanGaiRenYuan")
public class TbJiHuaHanGaiRenYuan implements java.io.Serializable
{

	// Fields

	private String jhhgryid;
	private String jhid;
	private String ryId;

	// Constructors

	/** default constructor */
	public TbJiHuaHanGaiRenYuan()
	{}

	/** full constructor */
	public TbJiHuaHanGaiRenYuan(String jhid, String ryId)
	{
		this.jhid = jhid;
		this.ryId = ryId;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "JHHGRYID", unique = true, nullable = false, length = 50)
	public String getJhhgryid()
	{
		return this.jhhgryid;
	}

	public void setJhhgryid(String jhhgryid)
	{
		this.jhhgryid = jhhgryid;
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