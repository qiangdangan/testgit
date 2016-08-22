package com.gwzd.model.dbentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbRuKuYuBeiDanMingXi entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_RuKuYuBeiDanMingXi")
public class TbRuKuYuBeiDanMingXi implements java.io.Serializable
{

	// Fields

	private String rkybdmxid;
	private String rkybdid;
	private String bjid;
	private String wuLiaoMingCheng;
	private String wuLiaoDaiMa;
	private String k3wuLiuMa;
	private String guiGe;
	private Integer shuLiang;
	private String suoShuMuXiangHao;

	// Constructors

	/** default constructor */
	public TbRuKuYuBeiDanMingXi()
	{}

	/** full constructor */
	public TbRuKuYuBeiDanMingXi(String rkybdid, String bjid, String wuLiaoMingCheng, String wuLiaoDaiMa, String k3wuLiuMa, String guiGe, Integer shuLiang,
			String suoShuMuXiangHao)
	{
		this.rkybdid = rkybdid;
		this.bjid = bjid;
		this.wuLiaoMingCheng = wuLiaoMingCheng;
		this.wuLiaoDaiMa = wuLiaoDaiMa;
		this.k3wuLiuMa = k3wuLiuMa;
		this.guiGe = guiGe;
		this.shuLiang = shuLiang;
		this.suoShuMuXiangHao = suoShuMuXiangHao;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "RKYBDMXID", unique = true, nullable = false, length = 50)
	public String getRkybdmxid()
	{
		return this.rkybdmxid;
	}

	public void setRkybdmxid(String rkybdmxid)
	{
		this.rkybdmxid = rkybdmxid;
	}

	@Column(name = "RKYBDID", length = 50)
	public String getRkybdid()
	{
		return this.rkybdid;
	}

	public void setRkybdid(String rkybdid)
	{
		this.rkybdid = rkybdid;
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

	@Column(name = "WuLiaoMingCheng", length = 100)
	public String getWuLiaoMingCheng()
	{
		return this.wuLiaoMingCheng;
	}

	public void setWuLiaoMingCheng(String wuLiaoMingCheng)
	{
		this.wuLiaoMingCheng = wuLiaoMingCheng;
	}

	@Column(name = "WuLiaoDaiMa", length = 100)
	public String getWuLiaoDaiMa()
	{
		return this.wuLiaoDaiMa;
	}

	public void setWuLiaoDaiMa(String wuLiaoDaiMa)
	{
		this.wuLiaoDaiMa = wuLiaoDaiMa;
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

	@Column(name = "GuiGe", length = 100)
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

	@Column(name = "SuoShuMuXiangHao", length = 100)
	public String getSuoShuMuXiangHao()
	{
		return this.suoShuMuXiangHao;
	}

	public void setSuoShuMuXiangHao(String suoShuMuXiangHao)
	{
		this.suoShuMuXiangHao = suoShuMuXiangHao;
	}

}