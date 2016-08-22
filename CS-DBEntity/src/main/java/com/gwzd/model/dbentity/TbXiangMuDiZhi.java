package com.gwzd.model.dbentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbXiangMuDiZhi entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_XiangMuDiZhi")
public class TbXiangMuDiZhi implements java.io.Serializable
{

	// Fields

	private String xmdzid;
	private String xmid;
	private String hscd;
	private String cid;

	// Constructors

	/** default constructor */
	public TbXiangMuDiZhi()
	{}

	/** full constructor */
	public TbXiangMuDiZhi(String xmid, String hscd, String cid)
	{
		this.xmid = xmid;
		this.hscd = hscd;
		this.cid = cid;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "XMDZID", unique = true, nullable = false, length = 50)
	public String getXmdzid()
	{
		return this.xmdzid;
	}

	public void setXmdzid(String xmdzid)
	{
		this.xmdzid = xmdzid;
	}

	@Column(name = "XMID", length = 50)
	public String getXmid()
	{
		return this.xmid;
	}

	public void setXmid(String xmid)
	{
		this.xmid = xmid;
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