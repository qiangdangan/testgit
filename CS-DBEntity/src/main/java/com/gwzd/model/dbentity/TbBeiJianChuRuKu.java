package com.gwzd.model.dbentity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbBeiJianChuRuKu entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_BeiJianChuRuKu")
public class TbBeiJianChuRuKu implements java.io.Serializable
{

	// Fields

	private String bjcrkid;
	private String crklxmcid;
	private Timestamp chuKuShiJian;
	private Integer chuKuShuLiang;
	private String luRuRen;
	private Timestamp luRuShiJian;
	private Long chuKuDaoKu;
	private Integer tiaoBoZhuangTai;
	private Integer shenPiZhuangTai;
	private String liuShuiHao;
	private Integer liuShuiBianHao;
	private String chuKuBeiZhu;

	// Constructors

	/** default constructor */
	public TbBeiJianChuRuKu()
	{}

	/** full constructor */
	public TbBeiJianChuRuKu(String crklxmcid, Timestamp chuKuShiJian, Integer chuKuShuLiang, String luRuRen, Timestamp luRuShiJian, Long chuKuDaoKu,
			Integer tiaoBoZhuangTai, Integer shenPiZhuangTai, String liuShuiHao, Integer liuShuiBianHao, String chuKuBeiZhu)
	{
		this.crklxmcid = crklxmcid;
		this.chuKuShiJian = chuKuShiJian;
		this.chuKuShuLiang = chuKuShuLiang;
		this.luRuRen = luRuRen;
		this.luRuShiJian = luRuShiJian;
		this.chuKuDaoKu = chuKuDaoKu;
		this.tiaoBoZhuangTai = tiaoBoZhuangTai;
		this.shenPiZhuangTai = shenPiZhuangTai;
		this.liuShuiHao = liuShuiHao;
		this.liuShuiBianHao = liuShuiBianHao;
		this.chuKuBeiZhu = chuKuBeiZhu;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "BJCRKID", unique = true, nullable = false, length = 50)
	public String getBjcrkid()
	{
		return this.bjcrkid;
	}

	public void setBjcrkid(String bjcrkid)
	{
		this.bjcrkid = bjcrkid;
	}

	@Column(name = "CRKLXMCID", length = 50)
	public String getCrklxmcid()
	{
		return this.crklxmcid;
	}

	public void setCrklxmcid(String crklxmcid)
	{
		this.crklxmcid = crklxmcid;
	}

	@Column(name = "ChuKuShiJian", length = 19)
	public Timestamp getChuKuShiJian()
	{
		return this.chuKuShiJian;
	}

	public void setChuKuShiJian(Timestamp chuKuShiJian)
	{
		this.chuKuShiJian = chuKuShiJian;
	}

	@Column(name = "ChuKuShuLiang")
	public Integer getChuKuShuLiang()
	{
		return this.chuKuShuLiang;
	}

	public void setChuKuShuLiang(Integer chuKuShuLiang)
	{
		this.chuKuShuLiang = chuKuShuLiang;
	}

	@Column(name = "LuRuRen", length = 50)
	public String getLuRuRen()
	{
		return this.luRuRen;
	}

	public void setLuRuRen(String luRuRen)
	{
		this.luRuRen = luRuRen;
	}

	@Column(name = "LuRuShiJian", length = 19)
	public Timestamp getLuRuShiJian()
	{
		return this.luRuShiJian;
	}

	public void setLuRuShiJian(Timestamp luRuShiJian)
	{
		this.luRuShiJian = luRuShiJian;
	}

	@Column(name = "ChuKuDaoKu")
	public Long getChuKuDaoKu()
	{
		return this.chuKuDaoKu;
	}

	public void setChuKuDaoKu(Long chuKuDaoKu)
	{
		this.chuKuDaoKu = chuKuDaoKu;
	}

	@Column(name = "TiaoBoZhuangTai")
	public Integer getTiaoBoZhuangTai()
	{
		return this.tiaoBoZhuangTai;
	}

	public void setTiaoBoZhuangTai(Integer tiaoBoZhuangTai)
	{
		this.tiaoBoZhuangTai = tiaoBoZhuangTai;
	}

	@Column(name = "ShenPiZhuangTai")
	public Integer getShenPiZhuangTai()
	{
		return this.shenPiZhuangTai;
	}

	public void setShenPiZhuangTai(Integer shenPiZhuangTai)
	{
		this.shenPiZhuangTai = shenPiZhuangTai;
	}

	@Column(name = "LiuShuiHao", length = 50)
	public String getLiuShuiHao()
	{
		return this.liuShuiHao;
	}

	public void setLiuShuiHao(String liuShuiHao)
	{
		this.liuShuiHao = liuShuiHao;
	}

	@Column(name = "LiuShuiBianHao")
	public Integer getLiuShuiBianHao()
	{
		return this.liuShuiBianHao;
	}

	public void setLiuShuiBianHao(Integer liuShuiBianHao)
	{
		this.liuShuiBianHao = liuShuiBianHao;
	}

	@Column(name = "ChuKuBeiZhu", length = 1000)
	public String getChuKuBeiZhu()
	{
		return this.chuKuBeiZhu;
	}

	public void setChuKuBeiZhu(String chuKuBeiZhu)
	{
		this.chuKuBeiZhu = chuKuBeiZhu;
	}

}