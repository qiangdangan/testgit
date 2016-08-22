package com.gwzd.model.dbentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbJueSeQuanXian entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_JueSeQuanXian")
public class TbJueSeQuanXian implements java.io.Serializable
{

	// Fields

	private String jsqxId;
	private TbQuanXian tbQuanXian;
	private TbJueSe tbJueSe;

	// Constructors

	/** default constructor */
	public TbJueSeQuanXian()
	{}

	/** full constructor */
	public TbJueSeQuanXian(TbQuanXian tbQuanXian, TbJueSe tbJueSe)
	{
		this.tbQuanXian = tbQuanXian;
		this.tbJueSe = tbJueSe;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "JSQX_ID", unique = true, nullable = false, length = 50)
	public String getJsqxId()
	{
		return this.jsqxId;
	}

	public void setJsqxId(String jsqxId)
	{
		this.jsqxId = jsqxId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "QX_ID")
	public TbQuanXian getTbQuanXian()
	{
		return this.tbQuanXian;
	}

	public void setTbQuanXian(TbQuanXian tbQuanXian)
	{
		this.tbQuanXian = tbQuanXian;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "XTJS_ID")
	public TbJueSe getTbJueSe()
	{
		return this.tbJueSe;
	}

	public void setTbJueSe(TbJueSe tbJueSe)
	{
		this.tbJueSe = tbJueSe;
	}

}