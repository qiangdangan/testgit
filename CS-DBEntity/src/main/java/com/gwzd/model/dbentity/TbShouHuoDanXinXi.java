package com.gwzd.model.dbentity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbShouHuoDanXinXi entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_ShouHuoDanXinXi")
public class TbShouHuoDanXinXi implements java.io.Serializable
{

	// Fields

	private String shdxxid;
	private String shouHuoDanHao;
	private Integer youWuDanZiShouHuoDan;
	private String dianZiFaHuoDanHao;
	private Integer zhuangTai;
	private String jiaoGeRen;
	private String jieShouRen;
	private Timestamp jieShouShiJian;
	private String cangKuId;
	private String beiZhu;

	// Constructors

	/** default constructor */
	public TbShouHuoDanXinXi()
	{}

	/** full constructor */
	public TbShouHuoDanXinXi(String shouHuoDanHao, Integer youWuDanZiShouHuoDan, String dianZiFaHuoDanHao, Integer zhuangTai, String jiaoGeRen,
			String jieShouRen, Timestamp jieShouShiJian, String cangKuId, String beiZhu)
	{
		this.shouHuoDanHao = shouHuoDanHao;
		this.youWuDanZiShouHuoDan = youWuDanZiShouHuoDan;
		this.dianZiFaHuoDanHao = dianZiFaHuoDanHao;
		this.zhuangTai = zhuangTai;
		this.jiaoGeRen = jiaoGeRen;
		this.jieShouRen = jieShouRen;
		this.jieShouShiJian = jieShouShiJian;
		this.cangKuId = cangKuId;
		this.beiZhu = beiZhu;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "SHDXXID", unique = true, nullable = false, length = 50)
	public String getShdxxid()
	{
		return this.shdxxid;
	}

	public void setShdxxid(String shdxxid)
	{
		this.shdxxid = shdxxid;
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

	@Column(name = "YouWuDanZiShouHuoDan")
	public Integer getYouWuDanZiShouHuoDan()
	{
		return this.youWuDanZiShouHuoDan;
	}

	public void setYouWuDanZiShouHuoDan(Integer youWuDanZiShouHuoDan)
	{
		this.youWuDanZiShouHuoDan = youWuDanZiShouHuoDan;
	}

	@Column(name = "DianZiFaHuoDanHao", length = 100)
	public String getDianZiFaHuoDanHao()
	{
		return this.dianZiFaHuoDanHao;
	}

	public void setDianZiFaHuoDanHao(String dianZiFaHuoDanHao)
	{
		this.dianZiFaHuoDanHao = dianZiFaHuoDanHao;
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

	@Column(name = "JiaoGeRen", length = 50)
	public String getJiaoGeRen()
	{
		return this.jiaoGeRen;
	}

	public void setJiaoGeRen(String jiaoGeRen)
	{
		this.jiaoGeRen = jiaoGeRen;
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

	@Column(name = "JieShouShiJian", length = 19)
	public Timestamp getJieShouShiJian()
	{
		return this.jieShouShiJian;
	}

	public void setJieShouShiJian(Timestamp jieShouShiJian)
	{
		this.jieShouShiJian = jieShouShiJian;
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