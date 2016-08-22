package com.gwzd.model.dbentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbSheBieBiaoZhunMoKuaiJiHua entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_SheBieBiaoZhunMoKuaiJiHua")
public class TbSheBieBiaoZhunMoKuaiJiHua implements java.io.Serializable
{

	// Fields

	private String sbmkjhid;
	private String sbbzmkid;
	private String jhid;
	private String caoZuoNeiRong;
	private String beiZhu;

	// Constructors

	/** default constructor */
	public TbSheBieBiaoZhunMoKuaiJiHua()
	{}

	/** full constructor */
	public TbSheBieBiaoZhunMoKuaiJiHua(String sbbzmkid, String jhid, String caoZuoNeiRong, String beiZhu)
	{
		this.sbbzmkid = sbbzmkid;
		this.jhid = jhid;
		this.caoZuoNeiRong = caoZuoNeiRong;
		this.beiZhu = beiZhu;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "SBMKJHID", unique = true, nullable = false, length = 50)
	public String getSbmkjhid()
	{
		return this.sbmkjhid;
	}

	public void setSbmkjhid(String sbmkjhid)
	{
		this.sbmkjhid = sbmkjhid;
	}

	@Column(name = "SBBZMKID", length = 50)
	public String getSbbzmkid()
	{
		return this.sbbzmkid;
	}

	public void setSbbzmkid(String sbbzmkid)
	{
		this.sbbzmkid = sbbzmkid;
	}

	@Column(name = "JHID", length = 50)
	public String getJhid()
	{
		return this.jhid;
	}

	public void setJhid(String jhid)
	{
		this.jhid = jhid;
	}

	@Column(name = "CaoZuoNeiRong", length = 1000)
	public String getCaoZuoNeiRong()
	{
		return this.caoZuoNeiRong;
	}

	public void setCaoZuoNeiRong(String caoZuoNeiRong)
	{
		this.caoZuoNeiRong = caoZuoNeiRong;
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