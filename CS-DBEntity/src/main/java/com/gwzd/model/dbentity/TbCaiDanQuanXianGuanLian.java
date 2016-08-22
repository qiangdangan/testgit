package com.gwzd.model.dbentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbCaiDanQuanXianGuanLian entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_CaiDanQuanXianGuanLian")
public class TbCaiDanQuanXianGuanLian implements java.io.Serializable
{

	// Fields

	private String cdqxglid;
	private String cdid;
	private String qxId;

	// Constructors

	/** default constructor */
	public TbCaiDanQuanXianGuanLian()
	{}

	/** full constructor */
	public TbCaiDanQuanXianGuanLian(String cdid, String qxId)
	{
		this.cdid = cdid;
		this.qxId = qxId;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "CDQXGLID", unique = true, nullable = false, length = 50)
	public String getCdqxglid()
	{
		return this.cdqxglid;
	}

	public void setCdqxglid(String cdqxglid)
	{
		this.cdqxglid = cdqxglid;
	}

	@Column(name = "CDID", length = 50)
	public String getCdid()
	{
		return this.cdid;
	}

	public void setCdid(String cdid)
	{
		this.cdid = cdid;
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