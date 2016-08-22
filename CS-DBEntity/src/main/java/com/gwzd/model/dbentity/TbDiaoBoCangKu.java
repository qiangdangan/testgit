package com.gwzd.model.dbentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbDiaoBoCangKu entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_DiaoBoCangKu")
public class TbDiaoBoCangKu implements java.io.Serializable
{

	// Fields

	private String dbckid;
	private String xqsjid;
	private String cangKuId;
	private Integer diaoBoShuLiang;

	// Constructors

	/** default constructor */
	public TbDiaoBoCangKu()
	{}

	/** full constructor */
	public TbDiaoBoCangKu(String xqsjid, String cangKuId, Integer diaoBoShuLiang)
	{
		this.xqsjid = xqsjid;
		this.cangKuId = cangKuId;
		this.diaoBoShuLiang = diaoBoShuLiang;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "DBCKID", unique = true, nullable = false, length = 50)
	public String getDbckid()
	{
		return this.dbckid;
	}

	public void setDbckid(String dbckid)
	{
		this.dbckid = dbckid;
	}

	@Column(name = "XQSJID", length = 50)
	public String getXqsjid()
	{
		return this.xqsjid;
	}

	public void setXqsjid(String xqsjid)
	{
		this.xqsjid = xqsjid;
	}

	@Column(name = "CangKuID", length = 50)
	public String getCangKuId()
	{
		return this.cangKuId;
	}

	public void setCangKuId(String cangKuId)
	{
		this.cangKuId = cangKuId;
	}

	@Column(name = "DiaoBoShuLiang")
	public Integer getDiaoBoShuLiang()
	{
		return this.diaoBoShuLiang;
	}

	public void setDiaoBoShuLiang(Integer diaoBoShuLiang)
	{
		this.diaoBoShuLiang = diaoBoShuLiang;
	}

}