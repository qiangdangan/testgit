package com.gwzd.model.dbentity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbJiChuTiaoMuXinXi entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_JiChuTiaoMuXinXi")
public class TbJiChuTiaoMuXinXi implements java.io.Serializable
{

	// Fields

	private String jctmid;
	private String pingJiaNeiRong;
	private String tiaoMuDaiMa;
	private Integer zhuangTai;
	private String tianJiaRen;
	private Timestamp tianJiaShiJian;
	private String beiZhu;
	private Integer pingJiaLeiXiang;
	private Float fenShu;

	// Constructors

	/** default constructor */
	public TbJiChuTiaoMuXinXi()
	{}

	/** full constructor */
	public TbJiChuTiaoMuXinXi(String pingJiaNeiRong, String tiaoMuDaiMa, Integer zhuangTai, String tianJiaRen, Timestamp tianJiaShiJian, String beiZhu,
			Integer pingJiaLeiXiang, Float fenShu)
	{
		this.pingJiaNeiRong = pingJiaNeiRong;
		this.tiaoMuDaiMa = tiaoMuDaiMa;
		this.zhuangTai = zhuangTai;
		this.tianJiaRen = tianJiaRen;
		this.tianJiaShiJian = tianJiaShiJian;
		this.beiZhu = beiZhu;
		this.pingJiaLeiXiang = pingJiaLeiXiang;
		this.fenShu = fenShu;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "JCTMID", unique = true, nullable = false, length = 50)
	public String getJctmid()
	{
		return this.jctmid;
	}

	public void setJctmid(String jctmid)
	{
		this.jctmid = jctmid;
	}

	@Column(name = "PingJiaNeiRong", length = 200)
	public String getPingJiaNeiRong()
	{
		return this.pingJiaNeiRong;
	}

	public void setPingJiaNeiRong(String pingJiaNeiRong)
	{
		this.pingJiaNeiRong = pingJiaNeiRong;
	}

	@Column(name = "TiaoMuDaiMa", length = 50)
	public String getTiaoMuDaiMa()
	{
		return this.tiaoMuDaiMa;
	}

	public void setTiaoMuDaiMa(String tiaoMuDaiMa)
	{
		this.tiaoMuDaiMa = tiaoMuDaiMa;
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

	@Column(name = "BeiZhu", length = 1000)
	public String getBeiZhu()
	{
		return this.beiZhu;
	}

	public void setBeiZhu(String beiZhu)
	{
		this.beiZhu = beiZhu;
	}

	@Column(name = "PingJiaLeiXiang")
	public Integer getPingJiaLeiXiang()
	{
		return this.pingJiaLeiXiang;
	}

	public void setPingJiaLeiXiang(Integer pingJiaLeiXiang)
	{
		this.pingJiaLeiXiang = pingJiaLeiXiang;
	}

	@Column(name = "FenShu", precision = 12, scale = 0)
	public Float getFenShu()
	{
		return this.fenShu;
	}

	public void setFenShu(Float fenShu)
	{
		this.fenShu = fenShu;
	}

}