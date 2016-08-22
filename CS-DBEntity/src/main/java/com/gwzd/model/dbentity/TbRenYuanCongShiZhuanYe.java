package com.gwzd.model.dbentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbRenYuanCongShiZhuanYe entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_RenYuanCongShiZhuanYe")
public class TbRenYuanCongShiZhuanYe implements java.io.Serializable
{

	// Fields

	private String zyryid;
	private String zyid;
	private String ryId;

	// Constructors

	/** default constructor */
	public TbRenYuanCongShiZhuanYe()
	{}

	/** full constructor */
	public TbRenYuanCongShiZhuanYe(String zyid, String ryId)
	{
		this.zyid = zyid;
		this.ryId = ryId;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "ZYRYID", unique = true, nullable = false, length = 50)
	public String getZyryid()
	{
		return this.zyryid;
	}

	public void setZyryid(String zyryid)
	{
		this.zyryid = zyryid;
	}

	@Column(name = "ZYID", length = 50)
	public String getZyid()
	{
		return this.zyid;
	}

	public void setZyid(String zyid)
	{
		this.zyid = zyid;
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