package com.gwzd.model.dbentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbYongHuZu entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_YongHuZu")
public class TbYongHuZu implements java.io.Serializable
{

	// Fields

	private String yhzid;
	private String yongHuZuMingCheng;
	private String pid;
	private Boolean shiFouYouXiao;
	private String beiZhu;

	// Constructors

	/** default constructor */
	public TbYongHuZu()
	{}

	/** full constructor */
	public TbYongHuZu(String yongHuZuMingCheng, String pid, Boolean shiFouYouXiao, String beiZhu)
	{
		this.yongHuZuMingCheng = yongHuZuMingCheng;
		this.pid = pid;
		this.shiFouYouXiao = shiFouYouXiao;
		this.beiZhu = beiZhu;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "YHZID", unique = true, nullable = false, length = 50)
	public String getYhzid()
	{
		return this.yhzid;
	}

	public void setYhzid(String yhzid)
	{
		this.yhzid = yhzid;
	}

	@Column(name = "YongHuZuMingCheng", length = 100)
	public String getYongHuZuMingCheng()
	{
		return this.yongHuZuMingCheng;
	}

	public void setYongHuZuMingCheng(String yongHuZuMingCheng)
	{
		this.yongHuZuMingCheng = yongHuZuMingCheng;
	}

	@Column(name = "PID", length = 50)
	public String getPid()
	{
		return this.pid;
	}

	public void setPid(String pid)
	{
		this.pid = pid;
	}

	@Column(name = "ShiFouYouXiao")
	public Boolean getShiFouYouXiao()
	{
		return this.shiFouYouXiao;
	}

	public void setShiFouYouXiao(Boolean shiFouYouXiao)
	{
		this.shiFouYouXiao = shiFouYouXiao;
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