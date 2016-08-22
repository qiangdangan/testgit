package com.gwzd.model.dbentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbJiGouXinXi entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_JiGouXinXi")
public class TbJiGouXinXi implements java.io.Serializable
{

	// Fields

	private String jgxxid;
	private String diaMa;
	private String quanCheng;
	private String jianCheng;
	private String wangZhi;
	private String jianJie;
	private String tongXunDiZhi;
	private Integer zhuangTai;
	private Integer leiXing;
	private String fuZeRen;
	private String fzrlianXiDianHua;
	private String fzrtongXunDiZhi;
	private String fzryouXiang;
	private String qq;
	private String weiXinHao;
	private String beiZhu;

	// Constructors

	/** default constructor */
	public TbJiGouXinXi()
	{}

	/** full constructor */
	public TbJiGouXinXi(String diaMa, String quanCheng, String jianCheng, String wangZhi, String jianJie, String tongXunDiZhi, Integer zhuangTai,
			Integer leiXing, String fuZeRen, String fzrlianXiDianHua, String fzrtongXunDiZhi, String fzryouXiang, String qq, String weiXinHao, String beiZhu)
	{
		this.diaMa = diaMa;
		this.quanCheng = quanCheng;
		this.jianCheng = jianCheng;
		this.wangZhi = wangZhi;
		this.jianJie = jianJie;
		this.tongXunDiZhi = tongXunDiZhi;
		this.zhuangTai = zhuangTai;
		this.leiXing = leiXing;
		this.fuZeRen = fuZeRen;
		this.fzrlianXiDianHua = fzrlianXiDianHua;
		this.fzrtongXunDiZhi = fzrtongXunDiZhi;
		this.fzryouXiang = fzryouXiang;
		this.qq = qq;
		this.weiXinHao = weiXinHao;
		this.beiZhu = beiZhu;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "JGXXID", unique = true, nullable = false, length = 50)
	public String getJgxxid()
	{
		return this.jgxxid;
	}

	public void setJgxxid(String jgxxid)
	{
		this.jgxxid = jgxxid;
	}

	@Column(name = "DiaMa", length = 50)
	public String getDiaMa()
	{
		return this.diaMa;
	}

	public void setDiaMa(String diaMa)
	{
		this.diaMa = diaMa;
	}

	@Column(name = "QuanCheng", length = 50)
	public String getQuanCheng()
	{
		return this.quanCheng;
	}

	public void setQuanCheng(String quanCheng)
	{
		this.quanCheng = quanCheng;
	}

	@Column(name = "JianCheng", length = 50)
	public String getJianCheng()
	{
		return this.jianCheng;
	}

	public void setJianCheng(String jianCheng)
	{
		this.jianCheng = jianCheng;
	}

	@Column(name = "WangZhi", length = 200)
	public String getWangZhi()
	{
		return this.wangZhi;
	}

	public void setWangZhi(String wangZhi)
	{
		this.wangZhi = wangZhi;
	}

	@Column(name = "JianJie", length = 500)
	public String getJianJie()
	{
		return this.jianJie;
	}

	public void setJianJie(String jianJie)
	{
		this.jianJie = jianJie;
	}

	@Column(name = "TongXunDiZhi", length = 500)
	public String getTongXunDiZhi()
	{
		return this.tongXunDiZhi;
	}

	public void setTongXunDiZhi(String tongXunDiZhi)
	{
		this.tongXunDiZhi = tongXunDiZhi;
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

	@Column(name = "LeiXing")
	public Integer getLeiXing()
	{
		return this.leiXing;
	}

	public void setLeiXing(Integer leiXing)
	{
		this.leiXing = leiXing;
	}

	@Column(name = "FuZeRen", length = 50)
	public String getFuZeRen()
	{
		return this.fuZeRen;
	}

	public void setFuZeRen(String fuZeRen)
	{
		this.fuZeRen = fuZeRen;
	}

	@Column(name = "FZRLianXiDianHua", length = 50)
	public String getFzrlianXiDianHua()
	{
		return this.fzrlianXiDianHua;
	}

	public void setFzrlianXiDianHua(String fzrlianXiDianHua)
	{
		this.fzrlianXiDianHua = fzrlianXiDianHua;
	}

	@Column(name = "FZRTongXunDiZhi", length = 500)
	public String getFzrtongXunDiZhi()
	{
		return this.fzrtongXunDiZhi;
	}

	public void setFzrtongXunDiZhi(String fzrtongXunDiZhi)
	{
		this.fzrtongXunDiZhi = fzrtongXunDiZhi;
	}

	@Column(name = "FZRYouXiang", length = 50)
	public String getFzryouXiang()
	{
		return this.fzryouXiang;
	}

	public void setFzryouXiang(String fzryouXiang)
	{
		this.fzryouXiang = fzryouXiang;
	}

	@Column(name = "QQ", length = 50)
	public String getQq()
	{
		return this.qq;
	}

	public void setQq(String qq)
	{
		this.qq = qq;
	}

	@Column(name = "WeiXinHao", length = 50)
	public String getWeiXinHao()
	{
		return this.weiXinHao;
	}

	public void setWeiXinHao(String weiXinHao)
	{
		this.weiXinHao = weiXinHao;
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