package com.gwzd.model.dbentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbJiHuaHanGaiZhuanYe entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_JiHuaHanGaiZhuanYe")
public class TbJiHuaHanGaiZhuanYe implements java.io.Serializable
{

	// Fields

	private String jhhgzyid;
	private String jhid;
	private String zyid;

	// Constructors

	/** default constructor */
	public TbJiHuaHanGaiZhuanYe()
	{}

	/** full constructor */
	public TbJiHuaHanGaiZhuanYe(String jhid, String zyid)
	{
		this.jhid = jhid;
		this.zyid = zyid;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "JHHGZYID", unique = true, nullable = false, length = 50)
	public String getJhhgzyid()
	{
		return this.jhhgzyid;
	}

	public void setJhhgzyid(String jhhgzyid)
	{
		this.jhhgzyid = jhhgzyid;
	}

	@Column(name = "JHID", length = 50)
	public String getJhid()
	{
		return this.jhid;
	}

	public void setJhid(String jhid)
	{
		this.jhid = jhid;
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

}