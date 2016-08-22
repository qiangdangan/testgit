package com.gwzd.model.dbentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbFuWuFanWei entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_FuWuFanWei")
public class TbFuWuFanWei implements java.io.Serializable
{

	// Fields

	private String fwfwid;
	private String ryId;
	private Integer fanWei;
	private String fanWeiId;

	// Constructors

	/** default constructor */
	public TbFuWuFanWei()
	{}

	/** full constructor */
	public TbFuWuFanWei(String ryId, Integer fanWei, String fanWeiId)
	{
		this.ryId = ryId;
		this.fanWei = fanWei;
		this.fanWeiId = fanWeiId;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "FWFWID", unique = true, nullable = false, length = 50)
	public String getFwfwid()
	{
		return this.fwfwid;
	}

	public void setFwfwid(String fwfwid)
	{
		this.fwfwid = fwfwid;
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

	@Column(name = "FanWei")
	public Integer getFanWei()
	{
		return this.fanWei;
	}

	public void setFanWei(Integer fanWei)
	{
		this.fanWei = fanWei;
	}

	@Column(name = "FanWeiID", length = 100)
	public String getFanWeiId()
	{
		return this.fanWeiId;
	}

	public void setFanWeiId(String fanWeiId)
	{
		this.fanWeiId = fanWeiId;
	}

}