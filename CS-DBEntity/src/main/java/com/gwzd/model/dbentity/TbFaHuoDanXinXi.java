package com.gwzd.model.dbentity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbFaHuoDanXinXi entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_FaHuoDanXinXi")
public class TbFaHuoDanXinXi implements java.io.Serializable
{

	// Fields

	private String fhdid;
	private String pid;
	private String faHuoDanHao;
	private String shouHuoRen;
	private String shouHuoDiZhi;
	private String shouHuoDianHua;
	private String fanHuoRen;
	private String fhcjxx;
	private String shouHuoDiDian;
	private String shouHuoRenDianHua;
	private String chengYunRen;
	private String chengYunCheHao;
	private String siJiXingMing;
	private String siJiDianHua;
	private Integer yunShuFangShi;
	private String kuaiDiGongSi;
	private String kuaiDiDanHao;
	private String tianJiaRen;
	private Timestamp tianJiaShiJian;
	private Integer zhuangTai;
	private Integer faHuoLeiXing;
	private String beiZhu;

	// Constructors

	/** default constructor */
	public TbFaHuoDanXinXi()
	{}

	/** full constructor */
	public TbFaHuoDanXinXi(String pid, String faHuoDanHao, String shouHuoRen, String shouHuoDiZhi, String shouHuoDianHua, String fanHuoRen, String fhcjxx,
			String shouHuoDiDian, String shouHuoRenDianHua, String chengYunRen, String chengYunCheHao, String siJiXingMing, String siJiDianHua,
			Integer yunShuFangShi, String kuaiDiGongSi, String kuaiDiDanHao, String tianJiaRen, Timestamp tianJiaShiJian, Integer zhuangTai,
			Integer faHuoLeiXing, String beiZhu)
	{
		this.pid = pid;
		this.faHuoDanHao = faHuoDanHao;
		this.shouHuoRen = shouHuoRen;
		this.shouHuoDiZhi = shouHuoDiZhi;
		this.shouHuoDianHua = shouHuoDianHua;
		this.fanHuoRen = fanHuoRen;
		this.fhcjxx = fhcjxx;
		this.shouHuoDiDian = shouHuoDiDian;
		this.shouHuoRenDianHua = shouHuoRenDianHua;
		this.chengYunRen = chengYunRen;
		this.chengYunCheHao = chengYunCheHao;
		this.siJiXingMing = siJiXingMing;
		this.siJiDianHua = siJiDianHua;
		this.yunShuFangShi = yunShuFangShi;
		this.kuaiDiGongSi = kuaiDiGongSi;
		this.kuaiDiDanHao = kuaiDiDanHao;
		this.tianJiaRen = tianJiaRen;
		this.tianJiaShiJian = tianJiaShiJian;
		this.zhuangTai = zhuangTai;
		this.faHuoLeiXing = faHuoLeiXing;
		this.beiZhu = beiZhu;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "FHDID", unique = true, nullable = false, length = 50)
	public String getFhdid()
	{
		return this.fhdid;
	}

	public void setFhdid(String fhdid)
	{
		this.fhdid = fhdid;
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

	@Column(name = "FaHuoDanHao", length = 100)
	public String getFaHuoDanHao()
	{
		return this.faHuoDanHao;
	}

	public void setFaHuoDanHao(String faHuoDanHao)
	{
		this.faHuoDanHao = faHuoDanHao;
	}

	@Column(name = "ShouHuoRen", length = 50)
	public String getShouHuoRen()
	{
		return this.shouHuoRen;
	}

	public void setShouHuoRen(String shouHuoRen)
	{
		this.shouHuoRen = shouHuoRen;
	}

	@Column(name = "ShouHuoDiZhi", length = 1000)
	public String getShouHuoDiZhi()
	{
		return this.shouHuoDiZhi;
	}

	public void setShouHuoDiZhi(String shouHuoDiZhi)
	{
		this.shouHuoDiZhi = shouHuoDiZhi;
	}

	@Column(name = "ShouHuoDianHua", length = 50)
	public String getShouHuoDianHua()
	{
		return this.shouHuoDianHua;
	}

	public void setShouHuoDianHua(String shouHuoDianHua)
	{
		this.shouHuoDianHua = shouHuoDianHua;
	}

	@Column(name = "FanHuoRen", length = 50)
	public String getFanHuoRen()
	{
		return this.fanHuoRen;
	}

	public void setFanHuoRen(String fanHuoRen)
	{
		this.fanHuoRen = fanHuoRen;
	}

	@Column(name = "FHCJXX", length = 50)
	public String getFhcjxx()
	{
		return this.fhcjxx;
	}

	public void setFhcjxx(String fhcjxx)
	{
		this.fhcjxx = fhcjxx;
	}

	@Column(name = "ShouHuoDiDian", length = 1000)
	public String getShouHuoDiDian()
	{
		return this.shouHuoDiDian;
	}

	public void setShouHuoDiDian(String shouHuoDiDian)
	{
		this.shouHuoDiDian = shouHuoDiDian;
	}

	@Column(name = "ShouHuoRenDianHua", length = 50)
	public String getShouHuoRenDianHua()
	{
		return this.shouHuoRenDianHua;
	}

	public void setShouHuoRenDianHua(String shouHuoRenDianHua)
	{
		this.shouHuoRenDianHua = shouHuoRenDianHua;
	}

	@Column(name = "ChengYunRen", length = 50)
	public String getChengYunRen()
	{
		return this.chengYunRen;
	}

	public void setChengYunRen(String chengYunRen)
	{
		this.chengYunRen = chengYunRen;
	}

	@Column(name = "ChengYunCheHao", length = 50)
	public String getChengYunCheHao()
	{
		return this.chengYunCheHao;
	}

	public void setChengYunCheHao(String chengYunCheHao)
	{
		this.chengYunCheHao = chengYunCheHao;
	}

	@Column(name = "SiJiXingMing", length = 50)
	public String getSiJiXingMing()
	{
		return this.siJiXingMing;
	}

	public void setSiJiXingMing(String siJiXingMing)
	{
		this.siJiXingMing = siJiXingMing;
	}

	@Column(name = "SiJiDianHua", length = 50)
	public String getSiJiDianHua()
	{
		return this.siJiDianHua;
	}

	public void setSiJiDianHua(String siJiDianHua)
	{
		this.siJiDianHua = siJiDianHua;
	}

	@Column(name = "YunShuFangShi")
	public Integer getYunShuFangShi()
	{
		return this.yunShuFangShi;
	}

	public void setYunShuFangShi(Integer yunShuFangShi)
	{
		this.yunShuFangShi = yunShuFangShi;
	}

	@Column(name = "KuaiDiGongSi", length = 200)
	public String getKuaiDiGongSi()
	{
		return this.kuaiDiGongSi;
	}

	public void setKuaiDiGongSi(String kuaiDiGongSi)
	{
		this.kuaiDiGongSi = kuaiDiGongSi;
	}

	@Column(name = "KuaiDiDanHao", length = 100)
	public String getKuaiDiDanHao()
	{
		return this.kuaiDiDanHao;
	}

	public void setKuaiDiDanHao(String kuaiDiDanHao)
	{
		this.kuaiDiDanHao = kuaiDiDanHao;
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

	@Column(name = "ZhuangTai")
	public Integer getZhuangTai()
	{
		return this.zhuangTai;
	}

	public void setZhuangTai(Integer zhuangTai)
	{
		this.zhuangTai = zhuangTai;
	}

	@Column(name = "FaHuoLeiXing")
	public Integer getFaHuoLeiXing()
	{
		return this.faHuoLeiXing;
	}

	public void setFaHuoLeiXing(Integer faHuoLeiXing)
	{
		this.faHuoLeiXing = faHuoLeiXing;
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