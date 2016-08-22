package com.gwzd.model.dbentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbCangKuBeiJianCunChuWeiZhi entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_CangKuBeiJianCunChuWeiZhi")
public class TbCangKuBeiJianCunChuWeiZhi implements java.io.Serializable
{

	// Fields

	private String ckbjccwzid;
	private String ckbjid;
	private String cunChuWeiZhi;
	private Integer cunChuShuLiang;

	// Constructors

	/** default constructor */
	public TbCangKuBeiJianCunChuWeiZhi()
	{}

	/** full constructor */
	public TbCangKuBeiJianCunChuWeiZhi(String ckbjid, String cunChuWeiZhi, Integer cunChuShuLiang)
	{
		this.ckbjid = ckbjid;
		this.cunChuWeiZhi = cunChuWeiZhi;
		this.cunChuShuLiang = cunChuShuLiang;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "CKBJCCWZID", unique = true, nullable = false, length = 50)
	public String getCkbjccwzid()
	{
		return this.ckbjccwzid;
	}

	public void setCkbjccwzid(String ckbjccwzid)
	{
		this.ckbjccwzid = ckbjccwzid;
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

	@Column(name = "CunChuWeiZhi", length = 300)
	public String getCunChuWeiZhi()
	{
		return this.cunChuWeiZhi;
	}

	public void setCunChuWeiZhi(String cunChuWeiZhi)
	{
		this.cunChuWeiZhi = cunChuWeiZhi;
	}

	@Column(name = "CunChuShuLiang")
	public Integer getCunChuShuLiang()
	{
		return this.cunChuShuLiang;
	}

	public void setCunChuShuLiang(Integer cunChuShuLiang)
	{
		this.cunChuShuLiang = cunChuShuLiang;
	}

}