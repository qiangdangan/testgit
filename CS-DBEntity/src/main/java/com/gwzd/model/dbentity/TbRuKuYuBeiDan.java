package com.gwzd.model.dbentity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbRuKuYuBeiDan entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_RuKuYuBeiDan")
public class TbRuKuYuBeiDan implements java.io.Serializable
{

	// Fields

	private String rkybdid;
	private String shdxxid;
	private String cangKuId;
	private String ruKuYuBeiDanHao;
	private String shouHuoDanHao;
	private String jieShouRen;
	private Integer zhuangTai;
	private Timestamp ruKuShiJian;
	private String ruKuCaoZuoRen;
	private String beiZhu;

	// Constructors

	/** default constructor */
	public TbRuKuYuBeiDan()
	{}

	/** full constructor */
	public TbRuKuYuBeiDan(String shdxxid, String cangKuId, String ruKuYuBeiDanHao, String shouHuoDanHao, String jieShouRen, Integer zhuangTai,
			Timestamp ruKuShiJian, String ruKuCaoZuoRen, String beiZhu)
	{
		this.shdxxid = shdxxid;
		this.cangKuId = cangKuId;
		this.ruKuYuBeiDanHao = ruKuYuBeiDanHao;
		this.shouHuoDanHao = shouHuoDanHao;
		this.jieShouRen = jieShouRen;
		this.zhuangTai = zhuangTai;
		this.ruKuShiJian = ruKuShiJian;
		this.ruKuCaoZuoRen = ruKuCaoZuoRen;
		this.beiZhu = beiZhu;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "RKYBDID", unique = true, nullable = false, length = 50)
	public String getRkybdid()
	{
		return this.rkybdid;
	}

	public void setRkybdid(String rkybdid)
	{
		this.rkybdid = rkybdid;
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

	@Column(name = "CangKuID", length = 50)
	public String getCangKuId()
	{
		return this.cangKuId;
	}

	public void setCangKuId(String cangKuId)
	{
		this.cangKuId = cangKuId;
	}

	@Column(name = "RuKuYuBeiDanHao", length = 100)
	public String getRuKuYuBeiDanHao()
	{
		return this.ruKuYuBeiDanHao;
	}

	public void setRuKuYuBeiDanHao(String ruKuYuBeiDanHao)
	{
		this.ruKuYuBeiDanHao = ruKuYuBeiDanHao;
	}

	@Column(name = "ShouHuoDanHao", length = 100)
	public String getShouHuoDanHao()
	{
		return this.shouHuoDanHao;
	}

	public void setShouHuoDanHao(String shouHuoDanHao)
	{
		this.shouHuoDanHao = shouHuoDanHao;
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

	@Column(name = "ZhuangTai")
	public Integer getZhuangTai()
	{
		return this.zhuangTai;
	}

	public void setZhuangTai(Integer zhuangTai)
	{
		this.zhuangTai = zhuangTai;
	}

	@Column(name = "RuKuShiJian", length = 19)
	public Timestamp getRuKuShiJian()
	{
		return this.ruKuShiJian;
	}

	public void setRuKuShiJian(Timestamp ruKuShiJian)
	{
		this.ruKuShiJian = ruKuShiJian;
	}

	@Column(name = "RuKuCaoZuoRen", length = 50)
	public String getRuKuCaoZuoRen()
	{
		return this.ruKuCaoZuoRen;
	}

	public void setRuKuCaoZuoRen(String ruKuCaoZuoRen)
	{
		this.ruKuCaoZuoRen = ruKuCaoZuoRen;
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