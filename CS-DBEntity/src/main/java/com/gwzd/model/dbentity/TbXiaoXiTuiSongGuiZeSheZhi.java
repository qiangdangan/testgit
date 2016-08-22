package com.gwzd.model.dbentity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbXiaoXiTuiSongGuiZeSheZhi entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_XiaoXiTuiSongGuiZeSheZhi")
public class TbXiaoXiTuiSongGuiZeSheZhi implements java.io.Serializable
{

	// Fields

	private String guZeId;
	private String faQiRenZhiWu;
	private Float xiaoXiChuLiShiChang;
	private String guiZeMingCheng;
	private Integer zhuangTai;
	private String tianJiaRen;
	private Timestamp tianJiaShiJian;
	private String xiuGaiRen;
	private Timestamp xiuGaiShiJian;
	private String beiZhu;
	private String guiZeWeiDuGuanXi;

	// Constructors

	/** default constructor */
	public TbXiaoXiTuiSongGuiZeSheZhi()
	{}

	/** full constructor */
	public TbXiaoXiTuiSongGuiZeSheZhi(String faQiRenZhiWu, Float xiaoXiChuLiShiChang, String guiZeMingCheng, Integer zhuangTai, String tianJiaRen,
			Timestamp tianJiaShiJian, String xiuGaiRen, Timestamp xiuGaiShiJian, String beiZhu, String guiZeWeiDuGuanXi)
	{
		this.faQiRenZhiWu = faQiRenZhiWu;
		this.xiaoXiChuLiShiChang = xiaoXiChuLiShiChang;
		this.guiZeMingCheng = guiZeMingCheng;
		this.zhuangTai = zhuangTai;
		this.tianJiaRen = tianJiaRen;
		this.tianJiaShiJian = tianJiaShiJian;
		this.xiuGaiRen = xiuGaiRen;
		this.xiuGaiShiJian = xiuGaiShiJian;
		this.beiZhu = beiZhu;
		this.guiZeWeiDuGuanXi = guiZeWeiDuGuanXi;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "GuZeID", unique = true, nullable = false, length = 50)
	public String getGuZeId()
	{
		return this.guZeId;
	}

	public void setGuZeId(String guZeId)
	{
		this.guZeId = guZeId;
	}

	@Column(name = "FaQiRenZhiWu", length = 50)
	public String getFaQiRenZhiWu()
	{
		return this.faQiRenZhiWu;
	}

	public void setFaQiRenZhiWu(String faQiRenZhiWu)
	{
		this.faQiRenZhiWu = faQiRenZhiWu;
	}

	@Column(name = "XiaoXiChuLiShiChang", precision = 12, scale = 0)
	public Float getXiaoXiChuLiShiChang()
	{
		return this.xiaoXiChuLiShiChang;
	}

	public void setXiaoXiChuLiShiChang(Float xiaoXiChuLiShiChang)
	{
		this.xiaoXiChuLiShiChang = xiaoXiChuLiShiChang;
	}

	@Column(name = "GuiZeMingCheng", length = 50)
	public String getGuiZeMingCheng()
	{
		return this.guiZeMingCheng;
	}

	public void setGuiZeMingCheng(String guiZeMingCheng)
	{
		this.guiZeMingCheng = guiZeMingCheng;
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

	@Column(name = "GuiZeWeiDuGuanXi", length = 50)
	public String getGuiZeWeiDuGuanXi()
	{
		return this.guiZeWeiDuGuanXi;
	}

	public void setGuiZeWeiDuGuanXi(String guiZeWeiDuGuanXi)
	{
		this.guiZeWeiDuGuanXi = guiZeWeiDuGuanXi;
	}

}