package com.gwzd.model.dbentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbYongHuJueSe entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_YongHuJueSe")
public class TbYongHuJueSe implements java.io.Serializable
{

	// Fields

	private String yhjsId;
	private String xtjsId;
	private String xtyhId;

	// Constructors

	/** default constructor */
	public TbYongHuJueSe()
	{}

	/** full constructor */
	public TbYongHuJueSe(String xtjsId, String xtyhId)
	{
		this.xtjsId = xtjsId;
		this.xtyhId = xtyhId;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "YHJS_ID", unique = true, nullable = false, length = 50)
	public String getYhjsId()
	{
		return this.yhjsId;
	}

	public void setYhjsId(String yhjsId)
	{
		this.yhjsId = yhjsId;
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

	@Column(name = "XTYH_ID", length = 50)
	public String getXtyhId()
	{
		return this.xtyhId;
	}

	public void setXtyhId(String xtyhId)
	{
		this.xtyhId = xtyhId;
	}

}