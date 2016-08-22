package com.gwzd.model.dbentity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbSheBeiJiBenXinXi entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_SheBeiJiBenXinXi")
public class TbSheBeiJiBenXinXi implements java.io.Serializable
{

	// Fields

	private String sbjbxxid;
	private String sheBeiMingCheng;
	private String sheBeiXingHao;
	private Double zhongLiang;
	private Double danJia;
	private String k3wuLiuMa;
	private String caoZuoYaoQiuYuGuiFan;
	private String tianJiaRen;
	private Timestamp tianJiaShiJian;
	private String xiuGaiRen;
	private Timestamp xiuGaiShiJian;
	private String beiZhu;
	private Integer zhuangTai;
	private String jgxxid;

	// Constructors

	/** default constructor */
	public TbSheBeiJiBenXinXi()
	{}

	/** minimal constructor */
	public TbSheBeiJiBenXinXi(String jgxxid)
	{
		this.jgxxid = jgxxid;
	}

	/** full constructor */
	public TbSheBeiJiBenXinXi(String sheBeiMingCheng, String sheBeiXingHao, Double zhongLiang, Double danJia, String k3wuLiuMa, String caoZuoYaoQiuYuGuiFan,
			String tianJiaRen, Timestamp tianJiaShiJian, String xiuGaiRen, Timestamp xiuGaiShiJian, String beiZhu, Integer zhuangTai, String jgxxid)
	{
		this.sheBeiMingCheng = sheBeiMingCheng;
		this.sheBeiXingHao = sheBeiXingHao;
		this.zhongLiang = zhongLiang;
		this.danJia = danJia;
		this.k3wuLiuMa = k3wuLiuMa;
		this.caoZuoYaoQiuYuGuiFan = caoZuoYaoQiuYuGuiFan;
		this.tianJiaRen = tianJiaRen;
		this.tianJiaShiJian = tianJiaShiJian;
		this.xiuGaiRen = xiuGaiRen;
		this.xiuGaiShiJian = xiuGaiShiJian;
		this.beiZhu = beiZhu;
		this.zhuangTai = zhuangTai;
		this.jgxxid = jgxxid;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "SBJBXXID", unique = true, nullable = false, length = 50)
	public String getSbjbxxid()
	{
		return this.sbjbxxid;
	}

	public void setSbjbxxid(String sbjbxxid)
	{
		this.sbjbxxid = sbjbxxid;
	}

	@Column(name = "SheBeiMingCheng", length = 50)
	public String getSheBeiMingCheng()
	{
		return this.sheBeiMingCheng;
	}

	public void setSheBeiMingCheng(String sheBeiMingCheng)
	{
		this.sheBeiMingCheng = sheBeiMingCheng;
	}

	@Column(name = "SheBeiXingHao", length = 50)
	public String getSheBeiXingHao()
	{
		return this.sheBeiXingHao;
	}

	public void setSheBeiXingHao(String sheBeiXingHao)
	{
		this.sheBeiXingHao = sheBeiXingHao;
	}

	@Column(name = "ZhongLiang", precision = 9)
	public Double getZhongLiang()
	{
		return this.zhongLiang;
	}

	public void setZhongLiang(Double zhongLiang)
	{
		this.zhongLiang = zhongLiang;
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

	@Column(name = "K3WuLiuMa", length = 50)
	public String getK3wuLiuMa()
	{
		return this.k3wuLiuMa;
	}

	public void setK3wuLiuMa(String k3wuLiuMa)
	{
		this.k3wuLiuMa = k3wuLiuMa;
	}

	@Column(name = "CaoZuoYaoQiuYuGuiFan", length = 1000)
	public String getCaoZuoYaoQiuYuGuiFan()
	{
		return this.caoZuoYaoQiuYuGuiFan;
	}

	public void setCaoZuoYaoQiuYuGuiFan(String caoZuoYaoQiuYuGuiFan)
	{
		this.caoZuoYaoQiuYuGuiFan = caoZuoYaoQiuYuGuiFan;
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

	@Column(name = "ZhuangTai")
	public Integer getZhuangTai()
	{
		return this.zhuangTai;
	}

	public void setZhuangTai(Integer zhuangTai)
	{
		this.zhuangTai = zhuangTai;
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