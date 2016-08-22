package com.gwzd.model.dbentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbFeiBiaoZhunMoKuaiBeiJianJiHua entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_FeiBiaoZhunMoKuaiBeiJianJiHua")
public class TbFeiBiaoZhunMoKuaiBeiJianJiHua implements java.io.Serializable
{

	// Fields

	private String fbzmkjhid;
	private String sbqtmkjhid;
	private String bjid;
	private Integer beiJianShuLiang;

	// Constructors

	/** default constructor */
	public TbFeiBiaoZhunMoKuaiBeiJianJiHua()
	{}

	/** full constructor */
	public TbFeiBiaoZhunMoKuaiBeiJianJiHua(String sbqtmkjhid, String bjid, Integer beiJianShuLiang)
	{
		this.sbqtmkjhid = sbqtmkjhid;
		this.bjid = bjid;
		this.beiJianShuLiang = beiJianShuLiang;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "FBZMKJHID", unique = true, nullable = false, length = 50)
	public String getFbzmkjhid()
	{
		return this.fbzmkjhid;
	}

	public void setFbzmkjhid(String fbzmkjhid)
	{
		this.fbzmkjhid = fbzmkjhid;
	}

	@Column(name = "SBQTMKJHID", length = 50)
	public String getSbqtmkjhid()
	{
		return this.sbqtmkjhid;
	}

	public void setSbqtmkjhid(String sbqtmkjhid)
	{
		this.sbqtmkjhid = sbqtmkjhid;
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