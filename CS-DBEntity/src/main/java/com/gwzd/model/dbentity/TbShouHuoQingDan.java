package com.gwzd.model.dbentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbShouHuoQingDan entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_ShouHuoQingDan")
public class TbShouHuoQingDan implements java.io.Serializable
{

	// Fields

	private String shqdid;
	private String bjid;
	private String shdxxid;
	private String wuLiaoMingCheng;
	private String daiHao;
	private String guiGe;
	private String k3wuLiuMa;
	private String suoShuMuXiangHao;
	private Integer shuLiang;

	// Constructors

	/** default constructor */
	public TbShouHuoQingDan()
	{}

	/** full constructor */
	public TbShouHuoQingDan(String bjid, String shdxxid, String wuLiaoMingCheng, String daiHao, String guiGe, String k3wuLiuMa, String suoShuMuXiangHao,
			Integer shuLiang)
	{
		this.bjid = bjid;
		this.shdxxid = shdxxid;
		this.wuLiaoMingCheng = wuLiaoMingCheng;
		this.daiHao = daiHao;
		this.guiGe = guiGe;
		this.k3wuLiuMa = k3wuLiuMa;
		this.suoShuMuXiangHao = suoShuMuXiangHao;
		this.shuLiang = shuLiang;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "SHQDID", unique = true, nullable = false, length = 50)
	public String getShqdid()
	{
		return this.shqdid;
	}

	public void setShqdid(String shqdid)
	{
		this.shqdid = shqdid;
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

	@Column(name = "SHDXXID", length = 50)
	public String getShdxxid()
	{
		return this.shdxxid;
	}

	public void setShdxxid(String shdxxid)
	{
		this.shdxxid = shdxxid;
	}

	@Column(name = "WuLiaoMingCheng", length = 500)
	public String getWuLiaoMingCheng()
	{
		return this.wuLiaoMingCheng;
	}

	public void setWuLiaoMingCheng(String wuLiaoMingCheng)
	{
		this.wuLiaoMingCheng = wuLiaoMingCheng;
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

	@Column(name = "ShuLiang")
	public Integer getShuLiang()
	{
		return this.shuLiang;
	}

	public void setShuLiang(Integer shuLiang)
	{
		this.shuLiang = shuLiang;
	}

}