package com.gwzd.model.dbentity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbXiangMuXinXi entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_XiangMuXinXi")
public class TbXiangMuXinXi implements java.io.Serializable
{

	// Fields

	private String xmid;
	private String sbjbxxid;
	private String jgxxid;
	private String xiangMuQianZhui;
	private String xiangMuWeiZhui;
	private String xiangMuDaiHao;
	private String xiangMuMingCheng;
	private Integer xiangMuZhuangTai;
	private String xiangMuFuZeRen;
	private String chanPinHao;
	private String liXiangBaoGaoHao;
	private String heTongHao;
	private String jingYingJiHuaHao;
	private String xiangMuCaiWuDaiMa;
	private String gongChengCaiWuDaiMa;
	private String tianJiaRen;
	private Timestamp tianJiaShiJian;
	private String faBuRen;
	private Timestamp faBuShiJian;
	private String beiZhu;
	private String anZhuangRenYuan;
	private Timestamp anZhuangShiJian;

	// Constructors

	/** default constructor */
	public TbXiangMuXinXi()
	{}

	/** full constructor */
	public TbXiangMuXinXi(String sbjbxxid, String jgxxid, String xiangMuQianZhui, String xiangMuWeiZhui, String xiangMuDaiHao, String xiangMuMingCheng,
			Integer xiangMuZhuangTai, String xiangMuFuZeRen, String chanPinHao, String liXiangBaoGaoHao, String heTongHao, String jingYingJiHuaHao,
			String xiangMuCaiWuDaiMa, String gongChengCaiWuDaiMa, String tianJiaRen, Timestamp tianJiaShiJian, String faBuRen, Timestamp faBuShiJian,
			String beiZhu, String anZhuangRenYuan, Timestamp anZhuangShiJian)
	{
		this.sbjbxxid = sbjbxxid;
		this.jgxxid = jgxxid;
		this.xiangMuQianZhui = xiangMuQianZhui;
		this.xiangMuWeiZhui = xiangMuWeiZhui;
		this.xiangMuDaiHao = xiangMuDaiHao;
		this.xiangMuMingCheng = xiangMuMingCheng;
		this.xiangMuZhuangTai = xiangMuZhuangTai;
		this.xiangMuFuZeRen = xiangMuFuZeRen;
		this.chanPinHao = chanPinHao;
		this.liXiangBaoGaoHao = liXiangBaoGaoHao;
		this.heTongHao = heTongHao;
		this.jingYingJiHuaHao = jingYingJiHuaHao;
		this.xiangMuCaiWuDaiMa = xiangMuCaiWuDaiMa;
		this.gongChengCaiWuDaiMa = gongChengCaiWuDaiMa;
		this.tianJiaRen = tianJiaRen;
		this.tianJiaShiJian = tianJiaShiJian;
		this.faBuRen = faBuRen;
		this.faBuShiJian = faBuShiJian;
		this.beiZhu = beiZhu;
		this.anZhuangRenYuan = anZhuangRenYuan;
		this.anZhuangShiJian = anZhuangShiJian;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "XMID", unique = true, nullable = false, length = 50)
	public String getXmid()
	{
		return this.xmid;
	}

	public void setXmid(String xmid)
	{
		this.xmid = xmid;
	}

	@Column(name = "SBJBXXID", length = 50)
	public String getSbjbxxid()
	{
		return this.sbjbxxid;
	}

	public void setSbjbxxid(String sbjbxxid)
	{
		this.sbjbxxid = sbjbxxid;
	}

	@Column(name = "JGXXID", length = 50)
	public String getJgxxid()
	{
		return this.jgxxid;
	}

	public void setJgxxid(String jgxxid)
	{
		this.jgxxid = jgxxid;
	}

	@Column(name = "XiangMuQianZhui", length = 10)
	public String getXiangMuQianZhui()
	{
		return this.xiangMuQianZhui;
	}

	public void setXiangMuQianZhui(String xiangMuQianZhui)
	{
		this.xiangMuQianZhui = xiangMuQianZhui;
	}

	@Column(name = "XiangMuWeiZhui", length = 50)
	public String getXiangMuWeiZhui()
	{
		return this.xiangMuWeiZhui;
	}

	public void setXiangMuWeiZhui(String xiangMuWeiZhui)
	{
		this.xiangMuWeiZhui = xiangMuWeiZhui;
	}

	@Column(name = "XiangMuDaiHao", length = 100)
	public String getXiangMuDaiHao()
	{
		return this.xiangMuDaiHao;
	}

	public void setXiangMuDaiHao(String xiangMuDaiHao)
	{
		this.xiangMuDaiHao = xiangMuDaiHao;
	}

	@Column(name = "XiangMuMingCheng", length = 100)
	public String getXiangMuMingCheng()
	{
		return this.xiangMuMingCheng;
	}

	public void setXiangMuMingCheng(String xiangMuMingCheng)
	{
		this.xiangMuMingCheng = xiangMuMingCheng;
	}

	@Column(name = "XiangMuZhuangTai")
	public Integer getXiangMuZhuangTai()
	{
		return this.xiangMuZhuangTai;
	}

	public void setXiangMuZhuangTai(Integer xiangMuZhuangTai)
	{
		this.xiangMuZhuangTai = xiangMuZhuangTai;
	}

	@Column(name = "XiangMuFuZeRen", length = 50)
	public String getXiangMuFuZeRen()
	{
		return this.xiangMuFuZeRen;
	}

	public void setXiangMuFuZeRen(String xiangMuFuZeRen)
	{
		this.xiangMuFuZeRen = xiangMuFuZeRen;
	}

	@Column(name = "ChanPinHao", length = 100)
	public String getChanPinHao()
	{
		return this.chanPinHao;
	}

	public void setChanPinHao(String chanPinHao)
	{
		this.chanPinHao = chanPinHao;
	}

	@Column(name = "LiXiangBaoGaoHao", length = 100)
	public String getLiXiangBaoGaoHao()
	{
		return this.liXiangBaoGaoHao;
	}

	public void setLiXiangBaoGaoHao(String liXiangBaoGaoHao)
	{
		this.liXiangBaoGaoHao = liXiangBaoGaoHao;
	}

	@Column(name = "HeTongHao", length = 150)
	public String getHeTongHao()
	{
		return this.heTongHao;
	}

	public void setHeTongHao(String heTongHao)
	{
		this.heTongHao = heTongHao;
	}

	@Column(name = "JingYingJiHuaHao", length = 150)
	public String getJingYingJiHuaHao()
	{
		return this.jingYingJiHuaHao;
	}

	public void setJingYingJiHuaHao(String jingYingJiHuaHao)
	{
		this.jingYingJiHuaHao = jingYingJiHuaHao;
	}

	@Column(name = "XiangMuCaiWuDaiMa", length = 150)
	public String getXiangMuCaiWuDaiMa()
	{
		return this.xiangMuCaiWuDaiMa;
	}

	public void setXiangMuCaiWuDaiMa(String xiangMuCaiWuDaiMa)
	{
		this.xiangMuCaiWuDaiMa = xiangMuCaiWuDaiMa;
	}

	@Column(name = "GongChengCaiWuDaiMa", length = 150)
	public String getGongChengCaiWuDaiMa()
	{
		return this.gongChengCaiWuDaiMa;
	}

	public void setGongChengCaiWuDaiMa(String gongChengCaiWuDaiMa)
	{
		this.gongChengCaiWuDaiMa = gongChengCaiWuDaiMa;
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

	@Column(name = "FaBuRen", length = 50)
	public String getFaBuRen()
	{
		return this.faBuRen;
	}

	public void setFaBuRen(String faBuRen)
	{
		this.faBuRen = faBuRen;
	}

	@Column(name = "FaBuShiJian", length = 19)
	public Timestamp getFaBuShiJian()
	{
		return this.faBuShiJian;
	}

	public void setFaBuShiJian(Timestamp faBuShiJian)
	{
		this.faBuShiJian = faBuShiJian;
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

	@Column(name = "AnZhuangRenYuan", length = 50)
	public String getAnZhuangRenYuan()
	{
		return this.anZhuangRenYuan;
	}

	public void setAnZhuangRenYuan(String anZhuangRenYuan)
	{
		this.anZhuangRenYuan = anZhuangRenYuan;
	}

	@Column(name = "AnZhuangShiJian", length = 19)
	public Timestamp getAnZhuangShiJian()
	{
		return this.anZhuangShiJian;
	}

	public void setAnZhuangShiJian(Timestamp anZhuangShiJian)
	{
		this.anZhuangShiJian = anZhuangShiJian;
	}

}