package com.gwzd.model.dbentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbFeiBiaoZhunMoKuaiFuJian entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_FeiBiaoZhunMoKuaiFuJian")
public class TbFeiBiaoZhunMoKuaiFuJian implements java.io.Serializable
{

	// Fields

	private String fbzmkfjid;
	private String sbqtmkid;
	private String fuJianYuanMingCheng;
	private String fuJianXinMingCheng;
	private String fuJianDiZhI;
	private Integer fuJianLeiXing;

	// Constructors

	/** default constructor */
	public TbFeiBiaoZhunMoKuaiFuJian()
	{}

	/** full constructor */
	public TbFeiBiaoZhunMoKuaiFuJian(String sbqtmkid, String fuJianYuanMingCheng, String fuJianXinMingCheng, String fuJianDiZhI, Integer fuJianLeiXing)
	{
		this.sbqtmkid = sbqtmkid;
		this.fuJianYuanMingCheng = fuJianYuanMingCheng;
		this.fuJianXinMingCheng = fuJianXinMingCheng;
		this.fuJianDiZhI = fuJianDiZhI;
		this.fuJianLeiXing = fuJianLeiXing;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "FBZMKFJID", unique = true, nullable = false, length = 50)
	public String getFbzmkfjid()
	{
		return this.fbzmkfjid;
	}

	public void setFbzmkfjid(String fbzmkfjid)
	{
		this.fbzmkfjid = fbzmkfjid;
	}

	@Column(name = "SBQTMKID", length = 50)
	public String getSbqtmkid()
	{
		return this.sbqtmkid;
	}

	public void setSbqtmkid(String sbqtmkid)
	{
		this.sbqtmkid = sbqtmkid;
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