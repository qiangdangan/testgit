package com.gwzd.model.dbentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbFaHuoDanMingXi entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_FaHuoDanMingXi")
public class TbFaHuoDanMingXi implements java.io.Serializable
{

	// Fields

	private String fhdmx;
	private String fhdid;
	private String mingCheng;
	private String daiHao;
	private String guiGe;
	private Integer shuLiang;
	private String k3wuLiuMa;
	private String suoShuMuXiangHao;
	private Integer zhuangTai;
	private String bjid;

	// Constructors

	/** default constructor */
	public TbFaHuoDanMingXi()
	{}

	/** full constructor */
	public TbFaHuoDanMingXi(String fhdid, String mingCheng, String daiHao, String guiGe, Integer shuLiang, String k3wuLiuMa, String suoShuMuXiangHao,
			Integer zhuangTai, String bjid)
	{
		this.fhdid = fhdid;
		this.mingCheng = mingCheng;
		this.daiHao = daiHao;
		this.guiGe = guiGe;
		this.shuLiang = shuLiang;
		this.k3wuLiuMa = k3wuLiuMa;
		this.suoShuMuXiangHao = suoShuMuXiangHao;
		this.zhuangTai = zhuangTai;
		this.bjid = bjid;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "FHDMX", unique = true, nullable = false, length = 50)
	public String getFhdmx()
	{
		return this.fhdmx;
	}

	public void setFhdmx(String fhdmx)
	{
		this.fhdmx = fhdmx;
	}

	@Column(name = "FHDID", length = 50)
	public String getFhdid()
	{
		return this.fhdid;
	}

	public void setFhdid(String fhdid)
	{
		this.fhdid = fhdid;
	}

	@Column(name = "MingCheng", length = 500)
	public String getMingCheng()
	{
		return this.mingCheng;
	}

	public void setMingCheng(String mingCheng)
	{
		this.mingCheng = mingCheng;
	}

	@Column(name = "DaiHao", length = 50)
	public String getDaiHao()
	{
		return this.daiHao;
	}

	public void setDaiHao(String daiHao)
	{
		this.daiHao = daiHao;
	}

	@Column(name = "GuiGe", length = 500)
	public String getGuiGe()
	{
		return this.guiGe;
	}

	public void setGuiGe(String guiGe)
	{
		this.guiGe = guiGe;
	}

	@Column(name = "ShuLiang")
	public Integer getShuLiang()
	{
		return this.shuLiang;
	}

	public void setShuLiang(Integer shuLiang)
	{
		this.shuLiang = shuLiang;
	}

	@Column(name = "K3WuLiuMa", length = 100)
	public String getK3wuLiuMa()
	{
		return this.k3wuLiuMa;
	}

	public void setK3wuLiuMa(String k3wuLiuMa)
	{
		this.k3wuLiuMa = k3wuLiuMa;
	}

	@Column(name = "SuoShuMuXiangHao", length = 100)
	public String getSuoShuMuXiangHao()
	{
		return this.suoShuMuXiangHao;
	}

	public void setSuoShuMuXiangHao(String suoShuMuXiangHao)
	{
		this.suoShuMuXiangHao = suoShuMuXiangHao;
	}

	@Column(name = "ZhuangTai")
	public Integer getZhuangTai()
	{
		return this.zhuangTai;
	}

	public void setZhuangTai(Integer zhuangTai)
	{
		this.zhuangTai = zhuangTai;
	}

	@Column(name = "BJID", length = 50)
	public String getBjid()
	{
		return this.bjid;
	}

	public void setBjid(String bjid)
	{
		this.bjid = bjid;
	}

}