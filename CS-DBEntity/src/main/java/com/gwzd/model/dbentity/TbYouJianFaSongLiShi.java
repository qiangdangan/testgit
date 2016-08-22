package com.gwzd.model.dbentity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbYouJianFaSongLiShi entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_YouJianFaSongLiShi")
public class TbYouJianFaSongLiShi implements java.io.Serializable
{

	// Fields

	private String yjfsls;
	private String ddxxid;
	private String faSongRen;
	private Timestamp faSongShiJian;
	private String faSongRenYouXiang;
	private String jieShouRen;
	private String jieSongRenYouXian;
	private String chaoSongRen;
	private String chaoSongYouXiang;
	private String youJianNeiRong;
	private String beiZhu;

	// Constructors

	/** default constructor */
	public TbYouJianFaSongLiShi()
	{}

	/** full constructor */
	public TbYouJianFaSongLiShi(String ddxxid, String faSongRen, Timestamp faSongShiJian, String faSongRenYouXiang, String jieShouRen,
			String jieSongRenYouXian, String chaoSongRen, String chaoSongYouXiang, String youJianNeiRong, String beiZhu)
	{
		this.ddxxid = ddxxid;
		this.faSongRen = faSongRen;
		this.faSongShiJian = faSongShiJian;
		this.faSongRenYouXiang = faSongRenYouXiang;
		this.jieShouRen = jieShouRen;
		this.jieSongRenYouXian = jieSongRenYouXian;
		this.chaoSongRen = chaoSongRen;
		this.chaoSongYouXiang = chaoSongYouXiang;
		this.youJianNeiRong = youJianNeiRong;
		this.beiZhu = beiZhu;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "YJFSLS", unique = true, nullable = false, length = 50)
	public String getYjfsls()
	{
		return this.yjfsls;
	}

	public void setYjfsls(String yjfsls)
	{
		this.yjfsls = yjfsls;
	}

	@Column(name = "DDXXID", length = 50)
	public String getDdxxid()
	{
		return this.ddxxid;
	}

	public void setDdxxid(String ddxxid)
	{
		this.ddxxid = ddxxid;
	}

	@Column(name = "FaSongRen", length = 50)
	public String getFaSongRen()
	{
		return this.faSongRen;
	}

	public void setFaSongRen(String faSongRen)
	{
		this.faSongRen = faSongRen;
	}

	@Column(name = "FaSongShiJian", length = 19)
	public Timestamp getFaSongShiJian()
	{
		return this.faSongShiJian;
	}

	public void setFaSongShiJian(Timestamp faSongShiJian)
	{
		this.faSongShiJian = faSongShiJian;
	}

	@Column(name = "FaSongRenYouXiang", length = 100)
	public String getFaSongRenYouXiang()
	{
		return this.faSongRenYouXiang;
	}

	public void setFaSongRenYouXiang(String faSongRenYouXiang)
	{
		this.faSongRenYouXiang = faSongRenYouXiang;
	}

	@Column(name = "JieShouRen", length = 50)
	public String getJieShouRen()
	{
		return this.jieShouRen;
	}

	public void setJieShouRen(String jieShouRen)
	{
		this.jieShouRen = jieShouRen;
	}

	@Column(name = "JieSongRenYouXian", length = 100)
	public String getJieSongRenYouXian()
	{
		return this.jieSongRenYouXian;
	}

	public void setJieSongRenYouXian(String jieSongRenYouXian)
	{
		this.jieSongRenYouXian = jieSongRenYouXian;
	}

	@Column(name = "ChaoSongRen", length = 50)
	public String getChaoSongRen()
	{
		return this.chaoSongRen;
	}

	public void setChaoSongRen(String chaoSongRen)
	{
		this.chaoSongRen = chaoSongRen;
	}

	@Column(name = "ChaoSongYouXiang", length = 50)
	public String getChaoSongYouXiang()
	{
		return this.chaoSongYouXiang;
	}

	public void setChaoSongYouXiang(String chaoSongYouXiang)
	{
		this.chaoSongYouXiang = chaoSongYouXiang;
	}

	@Column(name = "YouJianNeiRong", length = 1000)
	public String getYouJianNeiRong()
	{
		return this.youJianNeiRong;
	}

	public void setYouJianNeiRong(String youJianNeiRong)
	{
		this.youJianNeiRong = youJianNeiRong;
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