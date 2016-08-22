package com.gwzd.model.dbentity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

/**
 * TbDengLuRiZhi entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_DengLuRiZhi")
public class TbDengLuRiZhi implements java.io.Serializable
{

	// Fields

	private String rzid;
	private String dengLuYongHu;
	private String ip;
	private Date dengLuShiJian;
	private Date liKaiShiJian;

	// Constructors

	/** default constructor */
	public TbDengLuRiZhi()
	{}

	/** full constructor */
	public TbDengLuRiZhi(String dengLuYongHu, String ip, Date dengLuShiJian, Date liKaiShiJian)
	{
		this.dengLuYongHu = dengLuYongHu;
		this.ip = ip;
		this.dengLuShiJian = dengLuShiJian;
		this.liKaiShiJian = liKaiShiJian;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "RZID", unique = true, nullable = false, length = 50)
	public String getRzid()
	{
		return this.rzid;
	}

	public void setRzid(String rzid)
	{
		this.rzid = rzid;
	}

	@Column(name = "DengLuYongHu", length = 50)
	public String getDengLuYongHu()
	{
		return this.dengLuYongHu;
	}

	public void setDengLuYongHu(String dengLuYongHu)
	{
		this.dengLuYongHu = dengLuYongHu;
	}

	@Column(name = "IP", length = 50)
	public String getIp()
	{
		return this.ip;
	}

	public void setIp(String ip)
	{
		this.ip = ip;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DengLuShiJian", length = 19)
	public Date getDengLuShiJian()
	{
		return this.dengLuShiJian;
	}

	public void setDengLuShiJian(Date dengLuShiJian)
	{
		this.dengLuShiJian = dengLuShiJian;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LiKaiShiJian", length = 19)
	public Date getLiKaiShiJian()
	{
		return this.liKaiShiJian;
	}

	public void setLiKaiShiJian(Date liKaiShiJian)
	{
		this.liKaiShiJian = liKaiShiJian;
	}

}