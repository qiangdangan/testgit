package com.gwzd.model.dbentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbSheBeiPeiZhiShuoMing entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_SheBeiPeiZhiShuoMing")
public class TbSheBeiPeiZhiShuoMing implements java.io.Serializable
{

	// Fields

	private String sbpzsmid;
	private String sbjbxxid;
	private Double keLianXuKaiJiShiChang;
	private Double weiHuJianGe;
	private Double yiYunXingShiChang;
	private String qiTaYaoQiu;
	private String beiZhu;

	// Constructors

	/** default constructor */
	public TbSheBeiPeiZhiShuoMing()
	{}

	/** full constructor */
	public TbSheBeiPeiZhiShuoMing(String sbjbxxid, Double keLianXuKaiJiShiChang, Double weiHuJianGe, Double yiYunXingShiChang, String qiTaYaoQiu, String beiZhu)
	{
		this.sbjbxxid = sbjbxxid;
		this.keLianXuKaiJiShiChang = keLianXuKaiJiShiChang;
		this.weiHuJianGe = weiHuJianGe;
		this.yiYunXingShiChang = yiYunXingShiChang;
		this.qiTaYaoQiu = qiTaYaoQiu;
		this.beiZhu = beiZhu;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "SBPZSMID", unique = true, nullable = false, length = 50)
	public String getSbpzsmid()
	{
		return this.sbpzsmid;
	}

	public void setSbpzsmid(String sbpzsmid)
	{
		this.sbpzsmid = sbpzsmid;
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

	@Column(name = "KeLianXuKaiJiShiChang", precision = 9)
	public Double getKeLianXuKaiJiShiChang()
	{
		return this.keLianXuKaiJiShiChang;
	}

	public void setKeLianXuKaiJiShiChang(Double keLianXuKaiJiShiChang)
	{
		this.keLianXuKaiJiShiChang = keLianXuKaiJiShiChang;
	}

	@Column(name = "WeiHuJianGe", precision = 9)
	public Double getWeiHuJianGe()
	{
		return this.weiHuJianGe;
	}

	public void setWeiHuJianGe(Double weiHuJianGe)
	{
		this.weiHuJianGe = weiHuJianGe;
	}

	@Column(name = "YiYunXingShiChang", precision = 9)
	public Double getYiYunXingShiChang()
	{
		return this.yiYunXingShiChang;
	}

	public void setYiYunXingShiChang(Double yiYunXingShiChang)
	{
		this.yiYunXingShiChang = yiYunXingShiChang;
	}

	@Column(name = "QiTaYaoQiu", length = 1000)
	public String getQiTaYaoQiu()
	{
		return this.qiTaYaoQiu;
	}

	public void setQiTaYaoQiu(String qiTaYaoQiu)
	{
		this.qiTaYaoQiu = qiTaYaoQiu;
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