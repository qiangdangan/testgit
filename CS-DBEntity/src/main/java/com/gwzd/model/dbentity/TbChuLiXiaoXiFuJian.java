package com.gwzd.model.dbentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbChuLiXiaoXiFuJian entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_ChuLiXiaoXiFuJian")
public class TbChuLiXiaoXiFuJian implements java.io.Serializable
{

	// Fields

	private String fuJianId;
	private String clxxid;
	private String fuJianYuanMingCheng;
	private String fuJianXinMingCheng;
	private String fuJianDiZhI;
	private Integer leiXing;

	// Constructors

	/** default constructor */
	public TbChuLiXiaoXiFuJian()
	{}

	/** full constructor */
	public TbChuLiXiaoXiFuJian(String clxxid, String fuJianYuanMingCheng, String fuJianXinMingCheng, String fuJianDiZhI, Integer leiXing)
	{
		this.clxxid = clxxid;
		this.fuJianYuanMingCheng = fuJianYuanMingCheng;
		this.fuJianXinMingCheng = fuJianXinMingCheng;
		this.fuJianDiZhI = fuJianDiZhI;
		this.leiXing = leiXing;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "FuJianID", unique = true, nullable = false, length = 50)
	public String getFuJianId()
	{
		return this.fuJianId;
	}

	public void setFuJianId(String fuJianId)
	{
		this.fuJianId = fuJianId;
	}

	@Column(name = "CLXXID", length = 50)
	public String getClxxid()
	{
		return this.clxxid;
	}

	public void setClxxid(String clxxid)
	{
		this.clxxid = clxxid;
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

	@Column(name = "LeiXing")
	public Integer getLeiXing()
	{
		return this.leiXing;
	}

	public void setLeiXing(Integer leiXing)
	{
		this.leiXing = leiXing;
	}

}