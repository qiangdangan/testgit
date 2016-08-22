package com.gwzd.model.dbentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbGongGaoFanWei entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_GongGaoFanWei")
public class TbGongGaoFanWei implements java.io.Serializable
{

	// Fields

	private String ggfwid;
	private String ggid;
	private String fanWeiBiao;
	private String fanWeiBiaoId;

	// Constructors

	/** default constructor */
	public TbGongGaoFanWei()
	{}

	/** full constructor */
	public TbGongGaoFanWei(String ggid, String fanWeiBiao, String fanWeiBiaoId)
	{
		this.ggid = ggid;
		this.fanWeiBiao = fanWeiBiao;
		this.fanWeiBiaoId = fanWeiBiaoId;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "GGFWID", unique = true, nullable = false, length = 50)
	public String getGgfwid()
	{
		return this.ggfwid;
	}

	public void setGgfwid(String ggfwid)
	{
		this.ggfwid = ggfwid;
	}

	@Column(name = "GGID", length = 50)
	public String getGgid()
	{
		return this.ggid;
	}

	public void setGgid(String ggid)
	{
		this.ggid = ggid;
	}

	@Column(name = "FanWeiBiao", length = 50)
	public String getFanWeiBiao()
	{
		return this.fanWeiBiao;
	}

	public void setFanWeiBiao(String fanWeiBiao)
	{
		this.fanWeiBiao = fanWeiBiao;
	}

	@Column(name = "FanWeiBiaoID", length = 50)
	public String getFanWeiBiaoId()
	{
		return this.fanWeiBiaoId;
	}

	public void setFanWeiBiaoId(String fanWeiBiaoId)
	{
		this.fanWeiBiaoId = fanWeiBiaoId;
	}

}