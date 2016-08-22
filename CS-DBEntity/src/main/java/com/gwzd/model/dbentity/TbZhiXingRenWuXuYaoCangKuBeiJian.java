package com.gwzd.model.dbentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbZhiXingRenWuXuYaoCangKuBeiJian entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_ZhiXingRenWuXuYaoCangKuBeiJian")
public class TbZhiXingRenWuXuYaoCangKuBeiJian implements java.io.Serializable
{

	// Fields

	private String zxrwxybjid;
	private String rxxxid;
	private String ckbjid;
	private Integer shuLiang;

	// Constructors

	/** default constructor */
	public TbZhiXingRenWuXuYaoCangKuBeiJian()
	{}

	/** full constructor */
	public TbZhiXingRenWuXuYaoCangKuBeiJian(String rxxxid, String ckbjid, Integer shuLiang)
	{
		this.rxxxid = rxxxid;
		this.ckbjid = ckbjid;
		this.shuLiang = shuLiang;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "ZXRWXYBJID", unique = true, nullable = false, length = 50)
	public String getZxrwxybjid()
	{
		return this.zxrwxybjid;
	}

	public void setZxrwxybjid(String zxrwxybjid)
	{
		this.zxrwxybjid = zxrwxybjid;
	}

	@Column(name = "RXXXID", length = 50)
	public String getRxxxid()
	{
		return this.rxxxid;
	}

	public void setRxxxid(String rxxxid)
	{
		this.rxxxid = rxxxid;
	}

	@Column(name = "CKBJID", length = 50)
	public String getCkbjid()
	{
		return this.ckbjid;
	}

	public void setCkbjid(String ckbjid)
	{
		this.ckbjid = ckbjid;
	}

	@Column(name = "ShuLiang")
	public Integer getShuLiang()
	{
		return this.shuLiang;
	}

	public void setShuLiang(Integer shuLiang)
	{
		this.shuLiang = shuLiang;
	}

}