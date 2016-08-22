package com.gwzd.model.dbentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbZhiXingRenWuFuJian entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_ZhiXingRenWuFuJian")
public class TbZhiXingRenWuFuJian implements java.io.Serializable
{

	// Fields

	private String zxrwfjid;
	private String rxxxid;
	private String fuJianYuanMingCheng;
	private String fuJianXinMingCheng;
	private String fuJianDiZhI;
	private Integer fuJianLeiXing;

	// Constructors

	/** default constructor */
	public TbZhiXingRenWuFuJian()
	{}

	/** full constructor */
	public TbZhiXingRenWuFuJian(String rxxxid, String fuJianYuanMingCheng, String fuJianXinMingCheng, String fuJianDiZhI, Integer fuJianLeiXing)
	{
		this.rxxxid = rxxxid;
		this.fuJianYuanMingCheng = fuJianYuanMingCheng;
		this.fuJianXinMingCheng = fuJianXinMingCheng;
		this.fuJianDiZhI = fuJianDiZhI;
		this.fuJianLeiXing = fuJianLeiXing;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "ZXRWFJID", unique = true, nullable = false, length = 50)
	public String getZxrwfjid()
	{
		return this.zxrwfjid;
	}

	public void setZxrwfjid(String zxrwfjid)
	{
		this.zxrwfjid = zxrwfjid;
	}

	@Column(name = "RXXXID", length = 50)
	public String getRxxxid()
	{
		return this.rxxxid;
	}

	public void setRxxxid(String rxxxid)
	{
		this.rxxxid = rxxxid;
	}

	@Column(name = "FuJianYuanMingCheng", length = 200)
	public String getFuJianYuanMingCheng()
	{
		return this.fuJianYuanMingCheng;
	}

	public void setFuJianYuanMingCheng(String fuJianYuanMingCheng)
	{
		this.fuJianYuanMingCheng = fuJianYuanMingCheng;
	}

	@Column(name = "FuJianXinMingCheng", length = 200)
	public String getFuJianXinMingCheng()
	{
		return this.fuJianXinMingCheng;
	}

	public void setFuJianXinMingCheng(String fuJianXinMingCheng)
	{
		this.fuJianXinMingCheng = fuJianXinMingCheng;
	}

	@Column(name = "FuJianDiZhI", length = 500)
	public String getFuJianDiZhI()
	{
		return this.fuJianDiZhI;
	}

	public void setFuJianDiZhI(String fuJianDiZhI)
	{
		this.fuJianDiZhI = fuJianDiZhI;
	}

	@Column(name = "FuJianLeiXing")
	public Integer getFuJianLeiXing()
	{
		return this.fuJianLeiXing;
	}

	public void setFuJianLeiXing(Integer fuJianLeiXing)
	{
		this.fuJianLeiXing = fuJianLeiXing;
	}

}