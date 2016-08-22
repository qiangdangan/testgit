package com.gwzd.model.dbentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbCangKuBeiJianChuRuKuShuLiang entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_CangKuBeiJianChuRuKuShuLiang")
public class TbCangKuBeiJianChuRuKuShuLiang implements java.io.Serializable
{

	// Fields

	private String ckbjcrkslid;
	private String jsqsdtjwlcrkId;
	private String ckbjccwzid;
	private Integer shuLiang;

	// Constructors

	/** default constructor */
	public TbCangKuBeiJianChuRuKuShuLiang()
	{}

	/** full constructor */
	public TbCangKuBeiJianChuRuKuShuLiang(String jsqsdtjwlcrkId, String ckbjccwzid, Integer shuLiang)
	{
		this.jsqsdtjwlcrkId = jsqsdtjwlcrkId;
		this.ckbjccwzid = ckbjccwzid;
		this.shuLiang = shuLiang;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "CKBJCRKSLID", unique = true, nullable = false, length = 50)
	public String getCkbjcrkslid()
	{
		return this.ckbjcrkslid;
	}

	public void setCkbjcrkslid(String ckbjcrkslid)
	{
		this.ckbjcrkslid = ckbjcrkslid;
	}

	@Column(name = "JSQSDTJWLCRK_ID", length = 50)
	public String getJsqsdtjwlcrkId()
	{
		return this.jsqsdtjwlcrkId;
	}

	public void setJsqsdtjwlcrkId(String jsqsdtjwlcrkId)
	{
		this.jsqsdtjwlcrkId = jsqsdtjwlcrkId;
	}

	@Column(name = "CKBJCCWZID", length = 50)
	public String getCkbjccwzid()
	{
		return this.ckbjccwzid;
	}

	public void setCkbjccwzid(String ckbjccwzid)
	{
		this.ckbjccwzid = ckbjccwzid;
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