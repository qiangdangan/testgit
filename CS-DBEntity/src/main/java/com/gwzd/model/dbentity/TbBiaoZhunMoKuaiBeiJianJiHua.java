package com.gwzd.model.dbentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbBiaoZhunMoKuaiBeiJianJiHua entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_BiaoZhunMoKuaiBeiJianJiHua")
public class TbBiaoZhunMoKuaiBeiJianJiHua implements java.io.Serializable
{

	// Fields

	private String bzmkjhid;
	private String bjid;
	private String sbmkjhid;
	private Integer beiJianShuLiang;

	// Constructors

	/** default constructor */
	public TbBiaoZhunMoKuaiBeiJianJiHua()
	{}

	/** full constructor */
	public TbBiaoZhunMoKuaiBeiJianJiHua(String bjid, String sbmkjhid, Integer beiJianShuLiang)
	{
		this.bjid = bjid;
		this.sbmkjhid = sbmkjhid;
		this.beiJianShuLiang = beiJianShuLiang;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "BZMKJHID", unique = true, nullable = false, length = 50)
	public String getBzmkjhid()
	{
		return this.bzmkjhid;
	}

	public void setBzmkjhid(String bzmkjhid)
	{
		this.bzmkjhid = bzmkjhid;
	}

	@Column(name = "BJID", length = 50)
	public String getBjid()
	{
		return this.bjid;
	}

	public void setBjid(String bjid)
	{
		this.bjid = bjid;
	}

	@Column(name = "SBMKJHID", length = 50)
	public String getSbmkjhid()
	{
		return this.sbmkjhid;
	}

	public void setSbmkjhid(String sbmkjhid)
	{
		this.sbmkjhid = sbmkjhid;
	}

	@Column(name = "BeiJianShuLiang")
	public Integer getBeiJianShuLiang()
	{
		return this.beiJianShuLiang;
	}

	public void setBeiJianShuLiang(Integer beiJianShuLiang)
	{
		this.beiJianShuLiang = beiJianShuLiang;
	}

}