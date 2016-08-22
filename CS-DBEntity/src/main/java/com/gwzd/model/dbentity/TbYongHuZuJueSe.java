package com.gwzd.model.dbentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbYongHuZuJueSe entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_YongHuZuJueSe")
public class TbYongHuZuJueSe implements java.io.Serializable
{

	// Fields

	private String yhzjsid;
	private String yhzid;
	private String xtjsId;

	// Constructors

	/** default constructor */
	public TbYongHuZuJueSe()
	{}

	/** full constructor */
	public TbYongHuZuJueSe(String yhzid, String xtjsId)
	{
		this.yhzid = yhzid;
		this.xtjsId = xtjsId;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "YHZJSID", unique = true, nullable = false, length = 50)
	public String getYhzjsid()
	{
		return this.yhzjsid;
	}

	public void setYhzjsid(String yhzjsid)
	{
		this.yhzjsid = yhzjsid;
	}

	@Column(name = "YHZID", length = 50)
	public String getYhzid()
	{
		return this.yhzid;
	}

	public void setYhzid(String yhzid)
	{
		this.yhzid = yhzid;
	}

	@Column(name = "XTJS_ID", length = 50)
	public String getXtjsId()
	{
		return this.xtjsId;
	}

	public void setXtjsId(String xtjsId)
	{
		this.xtjsId = xtjsId;
	}

}