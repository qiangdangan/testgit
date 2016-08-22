package com.gwzd.model.dbentity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbCangKu entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_CangKu")
public class TbCangKu implements java.io.Serializable
{

	// Fields

	private String cangKuId;
	private String cangKuBianHao;
	private String cangKuMingCheng;
	private Integer cangKuLeiXing;
	private Integer cangKuZhuangTai;
	private Integer cangHaoShangXian;
	private Integer huoJiaHaoShangXian;
	private Integer huoJiaCengShuShangXian;
	private Integer huoWeiShuShangXian;
	private String chuangJianRen;
	private Timestamp chuangJianShiJian;
	private String xiuGaiRen;
	private Timestamp xiuGaiShiJian;
	private String cangKuLianXiRen;
	private String youJianDiZhi;
	private String lianXiFangShi;
	private String beiZhu;

	// Constructors

	/** default constructor */
	public TbCangKu()
	{}

	/** full constructor */
	public TbCangKu(String cangKuBianHao, String cangKuMingCheng, Integer cangKuLeiXing, Integer cangKuZhuangTai, Integer cangHaoShangXian,
			Integer huoJiaHaoShangXian, Integer huoJiaCengShuShangXian, Integer huoWeiShuShangXian, String chuangJianRen, Timestamp chuangJianShiJian,
			String xiuGaiRen, Timestamp xiuGaiShiJian, String cangKuLianXiRen, String youJianDiZhi, String lianXiFangShi, String beiZhu)
	{
		this.cangKuBianHao = cangKuBianHao;
		this.cangKuMingCheng = cangKuMingCheng;
		this.cangKuLeiXing = cangKuLeiXing;
		this.cangKuZhuangTai = cangKuZhuangTai;
		this.cangHaoShangXian = cangHaoShangXian;
		this.huoJiaHaoShangXian = huoJiaHaoShangXian;
		this.huoJiaCengShuShangXian = huoJiaCengShuShangXian;
		this.huoWeiShuShangXian = huoWeiShuShangXian;
		this.chuangJianRen = chuangJianRen;
		this.chuangJianShiJian = chuangJianShiJian;
		this.xiuGaiRen = xiuGaiRen;
		this.xiuGaiShiJian = xiuGaiShiJian;
		this.cangKuLianXiRen = cangKuLianXiRen;
		this.youJianDiZhi = youJianDiZhi;
		this.lianXiFangShi = lianXiFangShi;
		this.beiZhu = beiZhu;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "CangKuID", unique = true, nullable = false, length = 50)
	public String getCangKuId()
	{
		return this.cangKuId;
	}

	public void setCangKuId(String cangKuId)
	{
		this.cangKuId = cangKuId;
	}

	@Column(name = "CangKuBianHao", length = 50)
	public String getCangKuBianHao()
	{
		return this.cangKuBianHao;
	}

	public void setCangKuBianHao(String cangKuBianHao)
	{
		this.cangKuBianHao = cangKuBianHao;
	}

	@Column(name = "CangKuMingCheng", length = 50)
	public String getCangKuMingCheng()
	{
		return this.cangKuMingCheng;
	}

	public void setCangKuMingCheng(String cangKuMingCheng)
	{
		this.cangKuMingCheng = cangKuMingCheng;
	}

	@Column(name = "CangKuLeiXing")
	public Integer getCangKuLeiXing()
	{
		return this.cangKuLeiXing;
	}

	public void setCangKuLeiXing(Integer cangKuLeiXing)
	{
		this.cangKuLeiXing = cangKuLeiXing;
	}

	@Column(name = "CangKuZhuangTai")
	public Integer getCangKuZhuangTai()
	{
		return this.cangKuZhuangTai;
	}

	public void setCangKuZhuangTai(Integer cangKuZhuangTai)
	{
		this.cangKuZhuangTai = cangKuZhuangTai;
	}

	@Column(name = "CangHaoShangXian")
	public Integer getCangHaoShangXian()
	{
		return this.cangHaoShangXian;
	}

	public void setCangHaoShangXian(Integer cangHaoShangXian)
	{
		this.cangHaoShangXian = cangHaoShangXian;
	}

	@Column(name = "HuoJiaHaoShangXian")
	public Integer getHuoJiaHaoShangXian()
	{
		return this.huoJiaHaoShangXian;
	}

	public void setHuoJiaHaoShangXian(Integer huoJiaHaoShangXian)
	{
		this.huoJiaHaoShangXian = huoJiaHaoShangXian;
	}

	@Column(name = "HuoJiaCengShuShangXian")
	public Integer getHuoJiaCengShuShangXian()
	{
		return this.huoJiaCengShuShangXian;
	}

	public void setHuoJiaCengShuShangXian(Integer huoJiaCengShuShangXian)
	{
		this.huoJiaCengShuShangXian = huoJiaCengShuShangXian;
	}

	@Column(name = "HuoWeiShuShangXian")
	public Integer getHuoWeiShuShangXian()
	{
		return this.huoWeiShuShangXian;
	}

	public void setHuoWeiShuShangXian(Integer huoWeiShuShangXian)
	{
		this.huoWeiShuShangXian = huoWeiShuShangXian;
	}

	@Column(name = "ChuangJianRen", length = 50)
	public String getChuangJianRen()
	{
		return this.chuangJianRen;
	}

	public void setChuangJianRen(String chuangJianRen)
	{
		this.chuangJianRen = chuangJianRen;
	}

	@Column(name = "ChuangJianShiJian", length = 19)
	public Timestamp getChuangJianShiJian()
	{
		return this.chuangJianShiJian;
	}

	public void setChuangJianShiJian(Timestamp chuangJianShiJian)
	{
		this.chuangJianShiJian = chuangJianShiJian;
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

	@Column(name = "CangKuLianXiRen", length = 50)
	public String getCangKuLianXiRen()
	{
		return this.cangKuLianXiRen;
	}

	public void setCangKuLianXiRen(String cangKuLianXiRen)
	{
		this.cangKuLianXiRen = cangKuLianXiRen;
	}

	@Column(name = "YouJianDiZhi", length = 50)
	public String getYouJianDiZhi()
	{
		return this.youJianDiZhi;
	}

	public void setYouJianDiZhi(String youJianDiZhi)
	{
		this.youJianDiZhi = youJianDiZhi;
	}

	@Column(name = "LianXiFangShi", length = 50)
	public String getLianXiFangShi()
	{
		return this.lianXiFangShi;
	}

	public void setLianXiFangShi(String lianXiFangShi)
	{
		this.lianXiFangShi = lianXiFangShi;
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