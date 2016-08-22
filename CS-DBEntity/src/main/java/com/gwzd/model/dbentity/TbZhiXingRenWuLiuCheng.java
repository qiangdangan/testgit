package com.gwzd.model.dbentity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbZhiXingRenWuLiuCheng entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_ZhiXingRenWuLiuCheng")
public class TbZhiXingRenWuLiuCheng implements java.io.Serializable
{

	// Fields

	private String zxrwxxlc;
	private String rwzxrid;
	private Timestamp kaiShiShiJian;
	private Timestamp jieShuShiJian;
	private String gongZuoNeiRong;
	private String beiZhu;

	// Constructors

	/** default constructor */
	public TbZhiXingRenWuLiuCheng()
	{}

	/** full constructor */
	public TbZhiXingRenWuLiuCheng(String rwzxrid, Timestamp kaiShiShiJian, Timestamp jieShuShiJian, String gongZuoNeiRong, String beiZhu)
	{
		this.rwzxrid = rwzxrid;
		this.kaiShiShiJian = kaiShiShiJian;
		this.jieShuShiJian = jieShuShiJian;
		this.gongZuoNeiRong = gongZuoNeiRong;
		this.beiZhu = beiZhu;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "ZXRWXXLC", unique = true, nullable = false, length = 50)
	public String getZxrwxxlc()
	{
		return this.zxrwxxlc;
	}

	public void setZxrwxxlc(String zxrwxxlc)
	{
		this.zxrwxxlc = zxrwxxlc;
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

	@Column(name = "KaiShiShiJian", length = 19)
	public Timestamp getKaiShiShiJian()
	{
		return this.kaiShiShiJian;
	}

	public void setKaiShiShiJian(Timestamp kaiShiShiJian)
	{
		this.kaiShiShiJian = kaiShiShiJian;
	}

	@Column(name = "JieShuShiJian", length = 19)
	public Timestamp getJieShuShiJian()
	{
		return this.jieShuShiJian;
	}

	public void setJieShuShiJian(Timestamp jieShuShiJian)
	{
		this.jieShuShiJian = jieShuShiJian;
	}

	@Column(name = "GongZuoNeiRong", length = 1000)
	public String getGongZuoNeiRong()
	{
		return this.gongZuoNeiRong;
	}

	public void setGongZuoNeiRong(String gongZuoNeiRong)
	{
		this.gongZuoNeiRong = gongZuoNeiRong;
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