package com.gwzd.model.dbentity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbRenYuan entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_RenYuan")
public class TbRenYuan implements java.io.Serializable
{

	// Fields

	private String ryId;
	private String xlId;
	private String renYuanDaiMa;
	private String xingMing;
	private Integer xingBie;
	private String zhiGongHao;
	private String banGongDianHua;
	private String geRenDianHua;
	private String shenFenZhengHao;
	private String tianJiaRen;
	private Timestamp tianJiaRiQi;
	private Boolean shiFouZaiZhi;
	private Integer shiFouYouXiao;
	private String qq;
	private String weiXinHao;
	private String youJianDiZhi;
	private String beiZhu;

	// Constructors

	/** default constructor */
	public TbRenYuan()
	{}

	/** full constructor */
	public TbRenYuan(String xlId, String renYuanDaiMa, String xingMing, Integer xingBie, String zhiGongHao, String banGongDianHua, String geRenDianHua,
			String shenFenZhengHao, String tianJiaRen, Timestamp tianJiaRiQi, Boolean shiFouZaiZhi, Integer shiFouYouXiao, String qq, String weiXinHao,
			String youJianDiZhi, String beiZhu)
	{
		this.xlId = xlId;
		this.renYuanDaiMa = renYuanDaiMa;
		this.xingMing = xingMing;
		this.xingBie = xingBie;
		this.zhiGongHao = zhiGongHao;
		this.banGongDianHua = banGongDianHua;
		this.geRenDianHua = geRenDianHua;
		this.shenFenZhengHao = shenFenZhengHao;
		this.tianJiaRen = tianJiaRen;
		this.tianJiaRiQi = tianJiaRiQi;
		this.shiFouZaiZhi = shiFouZaiZhi;
		this.shiFouYouXiao = shiFouYouXiao;
		this.qq = qq;
		this.weiXinHao = weiXinHao;
		this.youJianDiZhi = youJianDiZhi;
		this.beiZhu = beiZhu;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "RY_ID", unique = true, nullable = false, length = 50)
	public String getRyId()
	{
		return this.ryId;
	}

	public void setRyId(String ryId)
	{
		this.ryId = ryId;
	}

	@Column(name = "XL_ID", length = 50)
	public String getXlId()
	{
		return this.xlId;
	}

	public void setXlId(String xlId)
	{
		this.xlId = xlId;
	}

	@Column(name = "RenYuanDaiMa", length = 50)
	public String getRenYuanDaiMa()
	{
		return this.renYuanDaiMa;
	}

	public void setRenYuanDaiMa(String renYuanDaiMa)
	{
		this.renYuanDaiMa = renYuanDaiMa;
	}

	@Column(name = "XingMing", length = 50)
	public String getXingMing()
	{
		return this.xingMing;
	}

	public void setXingMing(String xingMing)
	{
		this.xingMing = xingMing;
	}

	@Column(name = "XingBie")
	public Integer getXingBie()
	{
		return this.xingBie;
	}

	public void setXingBie(Integer xingBie)
	{
		this.xingBie = xingBie;
	}

	@Column(name = "ZhiGongHao", length = 100)
	public String getZhiGongHao()
	{
		return this.zhiGongHao;
	}

	public void setZhiGongHao(String zhiGongHao)
	{
		this.zhiGongHao = zhiGongHao;
	}

	@Column(name = "BanGongDianHua", length = 50)
	public String getBanGongDianHua()
	{
		return this.banGongDianHua;
	}

	public void setBanGongDianHua(String banGongDianHua)
	{
		this.banGongDianHua = banGongDianHua;
	}

	@Column(name = "GeRenDianHua", length = 50)
	public String getGeRenDianHua()
	{
		return this.geRenDianHua;
	}

	public void setGeRenDianHua(String geRenDianHua)
	{
		this.geRenDianHua = geRenDianHua;
	}

	@Column(name = "ShenFenZhengHao", length = 50)
	public String getShenFenZhengHao()
	{
		return this.shenFenZhengHao;
	}

	public void setShenFenZhengHao(String shenFenZhengHao)
	{
		this.shenFenZhengHao = shenFenZhengHao;
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

	@Column(name = "TianJiaRiQi", length = 19)
	public Timestamp getTianJiaRiQi()
	{
		return this.tianJiaRiQi;
	}

	public void setTianJiaRiQi(Timestamp tianJiaRiQi)
	{
		this.tianJiaRiQi = tianJiaRiQi;
	}

	@Column(name = "ShiFouZaiZhi")
	public Boolean getShiFouZaiZhi()
	{
		return this.shiFouZaiZhi;
	}

	public void setShiFouZaiZhi(Boolean shiFouZaiZhi)
	{
		this.shiFouZaiZhi = shiFouZaiZhi;
	}

	@Column(name = "ShiFouYouXiao")
	public Integer getShiFouYouXiao()
	{
		return this.shiFouYouXiao;
	}

	public void setShiFouYouXiao(Integer shiFouYouXiao)
	{
		this.shiFouYouXiao = shiFouYouXiao;
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

	@Column(name = "YouJianDiZhi", length = 50)
	public String getYouJianDiZhi()
	{
		return this.youJianDiZhi;
	}

	public void setYouJianDiZhi(String youJianDiZhi)
	{
		this.youJianDiZhi = youJianDiZhi;
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