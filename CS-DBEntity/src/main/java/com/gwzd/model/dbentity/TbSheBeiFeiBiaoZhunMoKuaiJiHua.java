package com.gwzd.model.dbentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbSheBeiFeiBiaoZhunMoKuaiJiHua entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_SheBeiFeiBiaoZhunMoKuaiJiHua")
public class TbSheBeiFeiBiaoZhunMoKuaiJiHua implements java.io.Serializable
{

	// Fields

	private String sbfbzmkjhid;
	private String sbfbzmkid;
	private String jhid;
	private String caoZuoNeiRong;
	private String beiZhu;

	// Constructors

	/** default constructor */
	public TbSheBeiFeiBiaoZhunMoKuaiJiHua()
	{}

	/** full constructor */
	public TbSheBeiFeiBiaoZhunMoKuaiJiHua(String sbfbzmkid, String jhid, String caoZuoNeiRong, String beiZhu)
	{
		this.sbfbzmkid = sbfbzmkid;
		this.jhid = jhid;
		this.caoZuoNeiRong = caoZuoNeiRong;
		this.beiZhu = beiZhu;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "SBFBZMKJHID", unique = true, nullable = false, length = 50)
	public String getSbfbzmkjhid()
	{
		return this.sbfbzmkjhid;
	}

	public void setSbfbzmkjhid(String sbfbzmkjhid)
	{
		this.sbfbzmkjhid = sbfbzmkjhid;
	}

	@Column(name = "SBFBZMKID", length = 50)
	public String getSbfbzmkid()
	{
		return this.sbfbzmkid;
	}

	public void setSbfbzmkid(String sbfbzmkid)
	{
		this.sbfbzmkid = sbfbzmkid;
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