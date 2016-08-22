package com.gwzd.model.dbentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbYeMianYuanSuQuanXianGuanLian entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_YeMianYuanSuQuanXianGuanLian")
public class TbYeMianYuanSuQuanXianGuanLian implements java.io.Serializable
{

	// Fields

	private String ymysqxglid;
	private String ymysid;
	private String qxId;

	// Constructors

	/** default constructor */
	public TbYeMianYuanSuQuanXianGuanLian()
	{}

	/** full constructor */
	public TbYeMianYuanSuQuanXianGuanLian(String ymysid, String qxId)
	{
		this.ymysid = ymysid;
		this.qxId = qxId;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "YMYSQXGLID", unique = true, nullable = false, length = 50)
	public String getYmysqxglid()
	{
		return this.ymysqxglid;
	}

	public void setYmysqxglid(String ymysqxglid)
	{
		this.ymysqxglid = ymysqxglid;
	}

	@Column(name = "YMYSID", length = 50)
	public String getYmysid()
	{
		return this.ymysid;
	}

	public void setYmysid(String ymysid)
	{
		this.ymysid = ymysid;
	}

	@Column(name = "QX_ID", length = 50)
	public String getQxId()
	{
		return this.qxId;
	}

	public void setQxId(String qxId)
	{
		this.qxId = qxId;
	}

}