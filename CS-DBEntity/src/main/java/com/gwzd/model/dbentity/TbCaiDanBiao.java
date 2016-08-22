package com.gwzd.model.dbentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbCaiDanBiao entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_CaiDanBiao")
public class TbCaiDanBiao implements java.io.Serializable
{

	// Fields

	private String cdid;
	private String pid;
	private String caiDanMingCheng;
	private String caiDanTuBiao;
	private String url;
	private String caiDanJiBie;
	private Integer caiDanPaiXu;
	private String daKaiFangShi;
	private Integer zhuangTai;
	private String beiZhu;

	// Constructors

	/** default constructor */
	public TbCaiDanBiao()
	{}

	/** full constructor */
	public TbCaiDanBiao(String pid, String caiDanMingCheng, String caiDanTuBiao, String url, String caiDanJiBie, Integer caiDanPaiXu, String daKaiFangShi,
			Integer zhuangTai, String beiZhu)
	{
		this.pid = pid;
		this.caiDanMingCheng = caiDanMingCheng;
		this.caiDanTuBiao = caiDanTuBiao;
		this.url = url;
		this.caiDanJiBie = caiDanJiBie;
		this.caiDanPaiXu = caiDanPaiXu;
		this.daKaiFangShi = daKaiFangShi;
		this.zhuangTai = zhuangTai;
		this.beiZhu = beiZhu;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "CDID", unique = true, nullable = false, length = 50)
	public String getCdid()
	{
		return this.cdid;
	}

	public void setCdid(String cdid)
	{
		this.cdid = cdid;
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

	@Column(name = "CaiDanMingCheng", length = 100)
	public String getCaiDanMingCheng()
	{
		return this.caiDanMingCheng;
	}

	public void setCaiDanMingCheng(String caiDanMingCheng)
	{
		this.caiDanMingCheng = caiDanMingCheng;
	}

	@Column(name = "CaiDanTuBiao", length = 50)
	public String getCaiDanTuBiao()
	{
		return this.caiDanTuBiao;
	}

	public void setCaiDanTuBiao(String caiDanTuBiao)
	{
		this.caiDanTuBiao = caiDanTuBiao;
	}

	@Column(name = "URL", length = 100)
	public String getUrl()
	{
		return this.url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	@Column(name = "CaiDanJiBie", length = 100)
	public String getCaiDanJiBie()
	{
		return this.caiDanJiBie;
	}

	public void setCaiDanJiBie(String caiDanJiBie)
	{
		this.caiDanJiBie = caiDanJiBie;
	}

	@Column(name = "CaiDanPaiXu")
	public Integer getCaiDanPaiXu()
	{
		return this.caiDanPaiXu;
	}

	public void setCaiDanPaiXu(Integer caiDanPaiXu)
	{
		this.caiDanPaiXu = caiDanPaiXu;
	}

	@Column(name = "DaKaiFangShi", length = 50)
	public String getDaKaiFangShi()
	{
		return this.daKaiFangShi;
	}

	public void setDaKaiFangShi(String daKaiFangShi)
	{
		this.daKaiFangShi = daKaiFangShi;
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