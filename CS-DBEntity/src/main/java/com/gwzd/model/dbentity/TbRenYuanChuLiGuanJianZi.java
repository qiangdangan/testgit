package com.gwzd.model.dbentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbRenYuanChuLiGuanJianZi entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_RenYuanChuLiGuanJianZi")
public class TbRenYuanChuLiGuanJianZi implements java.io.Serializable
{

	// Fields

	private String gzgjzid;
	private String gjzid;
	private String ryId;

	// Constructors

	/** default constructor */
	public TbRenYuanChuLiGuanJianZi()
	{}

	/** full constructor */
	public TbRenYuanChuLiGuanJianZi(String gjzid, String ryId)
	{
		this.gjzid = gjzid;
		this.ryId = ryId;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "GZGJZID", unique = true, nullable = false, length = 50)
	public String getGzgjzid()
	{
		return this.gzgjzid;
	}

	public void setGzgjzid(String gzgjzid)
	{
		this.gzgjzid = gzgjzid;
	}

	@Column(name = "GJZID", length = 50)
	public String getGjzid()
	{
		return this.gjzid;
	}

	public void setGjzid(String gjzid)
	{
		this.gjzid = gjzid;
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