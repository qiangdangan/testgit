package com.gwzd.model.dbentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbCangKuDiZhi entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_CangKuDiZhi")
public class TbCangKuDiZhi implements java.io.Serializable
{

	// Fields

	private String ckdzid;
	private String cangKuId;
	private String hscd;
	private String cid;

	// Constructors

	/** default constructor */
	public TbCangKuDiZhi()
	{}

	/** full constructor */
	public TbCangKuDiZhi(String cangKuId, String hscd, String cid)
	{
		this.cangKuId = cangKuId;
		this.hscd = hscd;
		this.cid = cid;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "CKDZID", unique = true, nullable = false, length = 50)
	public String getCkdzid()
	{
		return this.ckdzid;
	}

	public void setCkdzid(String ckdzid)
	{
		this.ckdzid = ckdzid;
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

	@Column(name = "HSCD", length = 100)
	public String getHscd()
	{
		return this.hscd;
	}

	public void setHscd(String hscd)
	{
		this.hscd = hscd;
	}

	@Column(name = "CID", length = 50)
	public String getCid()
	{
		return this.cid;
	}

	public void setCid(String cid)
	{
		this.cid = cid;
	}

}