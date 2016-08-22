package com.gwzd.model.dbentity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbRenYuanShiShiWeiZhi entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_RenYuanShiShiWeiZhi")
public class TbRenYuanShiShiWeiZhi implements java.io.Serializable
{

	// Fields

	private String sswzid;
	private String rwzxrid;
	private Timestamp shiJian;
	private String diLiZuoBiao;
	private String xiangXiWeiZhi;
	private String beiZhu;

	// Constructors

	/** default constructor */
	public TbRenYuanShiShiWeiZhi()
	{}

	/** full constructor */
	public TbRenYuanShiShiWeiZhi(String rwzxrid, Timestamp shiJian, String diLiZuoBiao, String xiangXiWeiZhi, String beiZhu)
	{
		this.rwzxrid = rwzxrid;
		this.shiJian = shiJian;
		this.diLiZuoBiao = diLiZuoBiao;
		this.xiangXiWeiZhi = xiangXiWeiZhi;
		this.beiZhu = beiZhu;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "SSWZID", unique = true, nullable = false, length = 50)
	public String getSswzid()
	{
		return this.sswzid;
	}

	public void setSswzid(String sswzid)
	{
		this.sswzid = sswzid;
	}

	@Column(name = "RWZXRID", length = 50)
	public String getRwzxrid()
	{
		return this.rwzxrid;
	}

	public void setRwzxrid(String rwzxrid)
	{
		this.rwzxrid = rwzxrid;
	}

	@Column(name = "ShiJian", length = 19)
	public Timestamp getShiJian()
	{
		return this.shiJian;
	}

	public void setShiJian(Timestamp shiJian)
	{
		this.shiJian = shiJian;
	}

	@Column(name = "DiLiZuoBiao", length = 100)
	public String getDiLiZuoBiao()
	{
		return this.diLiZuoBiao;
	}

	public void setDiLiZuoBiao(String diLiZuoBiao)
	{
		this.diLiZuoBiao = diLiZuoBiao;
	}

	@Column(name = "XiangXiWeiZhi", length = 1000)
	public String getXiangXiWeiZhi()
	{
		return this.xiangXiWeiZhi;
	}

	public void setXiangXiWeiZhi(String xiangXiWeiZhi)
	{
		this.xiangXiWeiZhi = xiangXiWeiZhi;
	}

	@Column(name = "BeiZhu", length = 1000)
	public String getBeiZhu()
	{
		return this.beiZhu;
	}

	public void setBeiZhu(String beiZhu)
	{
		this.beiZhu = beiZhu;
	}

}