package com.gwzd.model.dbentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbCangKuRenYuan entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_CangKuRenYuan")
public class TbCangKuRenYuan implements java.io.Serializable
{

	// Fields

	private String ckryczid;
	private String shtCangKuId;
	private String ryId;
	private Integer caoZuoLeiXing;

	// Constructors

	/** default constructor */
	public TbCangKuRenYuan()
	{}

	/** full constructor */
	public TbCangKuRenYuan(String shtCangKuId, String ryId, Integer caoZuoLeiXing)
	{
		this.shtCangKuId = shtCangKuId;
		this.ryId = ryId;
		this.caoZuoLeiXing = caoZuoLeiXing;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "CKRYCZID", unique = true, nullable = false, length = 50)
	public String getCkryczid()
	{
		return this.ckryczid;
	}

	public void setCkryczid(String ckryczid)
	{
		this.ckryczid = ckryczid;
	}

	@Column(name = "SHT_CangKuID", length = 50)
	public String getShtCangKuId()
	{
		return this.shtCangKuId;
	}

	public void setShtCangKuId(String shtCangKuId)
	{
		this.shtCangKuId = shtCangKuId;
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

	@Column(name = "CaoZuoLeiXing")
	public Integer getCaoZuoLeiXing()
	{
		return this.caoZuoLeiXing;
	}

	public void setCaoZuoLeiXing(Integer caoZuoLeiXing)
	{
		this.caoZuoLeiXing = caoZuoLeiXing;
	}

}