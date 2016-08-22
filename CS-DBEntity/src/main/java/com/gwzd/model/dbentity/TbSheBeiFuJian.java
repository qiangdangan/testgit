package com.gwzd.model.dbentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbSheBeiFuJian entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_SheBeiFuJian")
public class TbSheBeiFuJian implements java.io.Serializable
{

	// Fields

	private String fuJianId;
	private String sbjbxxid;
	private String fuJianYuanMingCheng;
	private String fuJianXinMingCheng;
	private String fuJianDiZhI;
	private Integer fuJianLeiXing;

	// Constructors

	/** default constructor */
	public TbSheBeiFuJian()
	{}

	/** full constructor */
	public TbSheBeiFuJian(String sbjbxxid, String fuJianYuanMingCheng, String fuJianXinMingCheng, String fuJianDiZhI, Integer fuJianLeiXing)
	{
		this.sbjbxxid = sbjbxxid;
		this.fuJianYuanMingCheng = fuJianYuanMingCheng;
		this.fuJianXinMingCheng = fuJianXinMingCheng;
		this.fuJianDiZhI = fuJianDiZhI;
		this.fuJianLeiXing = fuJianLeiXing;
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

	@Column(name = "SBJBXXID", length = 50)
	public String getSbjbxxid()
	{
		return this.sbjbxxid;
	}

	public void setSbjbxxid(String sbjbxxid)
	{
		this.sbjbxxid = sbjbxxid;
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