package com.gwzd.model.dbentity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbBiaoZhunMoKuaiJiBenXinXi entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_BiaoZhunMoKuaiJiBenXinXi")
public class TbBiaoZhunMoKuaiJiBenXinXi implements java.io.Serializable
{

	// Fields

	private String bzmkid;
	private String mingCheng;
	private String xingHao;
	private String guiGe;
	private String daiMa;
	private String caiLiao;
	private Double danJia;
	private Double danZhong;
	private String caoZuoYaoQiuGuiFan;
	private String k3wuLiuMa;
	private String tianJiaRen;
	private Timestamp tianJiaShiJian;
	private String xiuGaiRen;
	private Timestamp xiuGaiShiJian;
	private String beiZhu;
	private String jgxxid;

	// Constructors

	/** default constructor */
	public TbBiaoZhunMoKuaiJiBenXinXi()
	{}

	/** minimal constructor */
	public TbBiaoZhunMoKuaiJiBenXinXi(String jgxxid)
	{
		this.jgxxid = jgxxid;
	}

	/** full constructor */
	public TbBiaoZhunMoKuaiJiBenXinXi(String mingCheng, String xingHao, String guiGe, String daiMa, String caiLiao, Double danJia, Double danZhong,
			String caoZuoYaoQiuGuiFan, String k3wuLiuMa, String tianJiaRen, Timestamp tianJiaShiJian, String xiuGaiRen, Timestamp xiuGaiShiJian, String beiZhu,
			String jgxxid)
	{
		this.mingCheng = mingCheng;
		this.xingHao = xingHao;
		this.guiGe = guiGe;
		this.daiMa = daiMa;
		this.caiLiao = caiLiao;
		this.danJia = danJia;
		this.danZhong = danZhong;
		this.caoZuoYaoQiuGuiFan = caoZuoYaoQiuGuiFan;
		this.k3wuLiuMa = k3wuLiuMa;
		this.tianJiaRen = tianJiaRen;
		this.tianJiaShiJian = tianJiaShiJian;
		this.xiuGaiRen = xiuGaiRen;
		this.xiuGaiShiJian = xiuGaiShiJian;
		this.beiZhu = beiZhu;
		this.jgxxid = jgxxid;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "BZMKID", unique = true, nullable = false, length = 50)
	public String getBzmkid()
	{
		return this.bzmkid;
	}

	public void setBzmkid(String bzmkid)
	{
		this.bzmkid = bzmkid;
	}

	@Column(name = "MingCheng", length = 100)
	public String getMingCheng()
	{
		return this.mingCheng;
	}

	public void setMingCheng(String mingCheng)
	{
		this.mingCheng = mingCheng;
	}

	@Column(name = "XingHao", length = 100)
	public String getXingHao()
	{
		return this.xingHao;
	}

	public void setXingHao(String xingHao)
	{
		this.xingHao = xingHao;
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

	@Column(name = "DaiMa", length = 100)
	public String getDaiMa()
	{
		return this.daiMa;
	}

	public void setDaiMa(String daiMa)
	{
		this.daiMa = daiMa;
	}

	@Column(name = "CaiLiao", length = 100)
	public String getCaiLiao()
	{
		return this.caiLiao;
	}

	public void setCaiLiao(String caiLiao)
	{
		this.caiLiao = caiLiao;
	}

	@Column(name = "DanJia", precision = 9)
	public Double getDanJia()
	{
		return this.danJia;
	}

	public void setDanJia(Double danJia)
	{
		this.danJia = danJia;
	}

	@Column(name = "DanZhong", precision = 9)
	public Double getDanZhong()
	{
		return this.danZhong;
	}

	public void setDanZhong(Double danZhong)
	{
		this.danZhong = danZhong;
	}

	@Column(name = "CaoZuoYaoQiuGuiFan", length = 1000)
	public String getCaoZuoYaoQiuGuiFan()
	{
		return this.caoZuoYaoQiuGuiFan;
	}

	public void setCaoZuoYaoQiuGuiFan(String caoZuoYaoQiuGuiFan)
	{
		this.caoZuoYaoQiuGuiFan = caoZuoYaoQiuGuiFan;
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

	@Column(name = "TianJiaRen", length = 50)
	public String getTianJiaRen()
	{
		return this.tianJiaRen;
	}

	public void setTianJiaRen(String tianJiaRen)
	{
		this.tianJiaRen = tianJiaRen;
	}

	@Column(name = "TianJiaShiJian", length = 19)
	public Timestamp getTianJiaShiJian()
	{
		return this.tianJiaShiJian;
	}

	public void setTianJiaShiJian(Timestamp tianJiaShiJian)
	{
		this.tianJiaShiJian = tianJiaShiJian;
	}

	@Column(name = "XiuGaiRen", length = 50)
	public String getXiuGaiRen()
	{
		return this.xiuGaiRen;
	}

	public void setXiuGaiRen(String xiuGaiRen)
	{
		this.xiuGaiRen = xiuGaiRen;
	}

	@Column(name = "XiuGaiShiJian", length = 19)
	public Timestamp getXiuGaiShiJian()
	{
		return this.xiuGaiShiJian;
	}

	public void setXiuGaiShiJian(Timestamp xiuGaiShiJian)
	{
		this.xiuGaiShiJian = xiuGaiShiJian;
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

	@Column(name = "JGXXID", nullable = false, length = 50)
	public String getJgxxid()
	{
		return this.jgxxid;
	}

	public void setJgxxid(String jgxxid)
	{
		this.jgxxid = jgxxid;
	}

}