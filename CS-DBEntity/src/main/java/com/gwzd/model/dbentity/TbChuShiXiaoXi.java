package com.gwzd.model.dbentity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbChuShiXiaoXi entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_ChuShiXiaoXi")
public class TbChuShiXiaoXi implements java.io.Serializable
{

	// Fields

	private String csxxid;
	private String ryId;
	private Timestamp fqsj;
	private String zt;
	private Boolean sfhf;
	private String zxnr;
	private String xiaoXiFaQiLeiXing;
	private String qiWangChuLiFangShi;
	private String shenHeZhuangTai;
	private String shenHeShiJian;
	private String shenHeRen;
	private String shenHeYiJian;
	private String beiZhu;

	// Constructors

	/** default constructor */
	public TbChuShiXiaoXi()
	{}

	/** full constructor */
	public TbChuShiXiaoXi(String ryId, Timestamp fqsj, String zt, Boolean sfhf, String zxnr, String xiaoXiFaQiLeiXing, String qiWangChuLiFangShi,
			String shenHeZhuangTai, String shenHeShiJian, String shenHeRen, String shenHeYiJian, String beiZhu)
	{
		this.ryId = ryId;
		this.fqsj = fqsj;
		this.zt = zt;
		this.sfhf = sfhf;
		this.zxnr = zxnr;
		this.xiaoXiFaQiLeiXing = xiaoXiFaQiLeiXing;
		this.qiWangChuLiFangShi = qiWangChuLiFangShi;
		this.shenHeZhuangTai = shenHeZhuangTai;
		this.shenHeShiJian = shenHeShiJian;
		this.shenHeRen = shenHeRen;
		this.shenHeYiJian = shenHeYiJian;
		this.beiZhu = beiZhu;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "CSXXID", unique = true, nullable = false, length = 50)
	public String getCsxxid()
	{
		return this.csxxid;
	}

	public void setCsxxid(String csxxid)
	{
		this.csxxid = csxxid;
	}

	@Column(name = "RY_ID", length = 50)
	public String getRyId()
	{
		return this.ryId;
	}

	public void setRyId(String ryId)
	{
		this.ryId = ryId;
	}

	@Column(name = "FQSJ", length = 19)
	public Timestamp getFqsj()
	{
		return this.fqsj;
	}

	public void setFqsj(Timestamp fqsj)
	{
		this.fqsj = fqsj;
	}

	@Column(name = "ZT", length = 50)
	public String getZt()
	{
		return this.zt;
	}

	public void setZt(String zt)
	{
		this.zt = zt;
	}

	@Column(name = "SFHF")
	public Boolean getSfhf()
	{
		return this.sfhf;
	}

	public void setSfhf(Boolean sfhf)
	{
		this.sfhf = sfhf;
	}

	@Column(name = "ZXNR", length = 500)
	public String getZxnr()
	{
		return this.zxnr;
	}

	public void setZxnr(String zxnr)
	{
		this.zxnr = zxnr;
	}

	@Column(name = "XiaoXiFaQiLeiXing", length = 50)
	public String getXiaoXiFaQiLeiXing()
	{
		return this.xiaoXiFaQiLeiXing;
	}

	public void setXiaoXiFaQiLeiXing(String xiaoXiFaQiLeiXing)
	{
		this.xiaoXiFaQiLeiXing = xiaoXiFaQiLeiXing;
	}

	@Column(name = "QiWangChuLiFangShi", length = 50)
	public String getQiWangChuLiFangShi()
	{
		return this.qiWangChuLiFangShi;
	}

	public void setQiWangChuLiFangShi(String qiWangChuLiFangShi)
	{
		this.qiWangChuLiFangShi = qiWangChuLiFangShi;
	}

	@Column(name = "ShenHeZhuangTai", length = 50)
	public String getShenHeZhuangTai()
	{
		return this.shenHeZhuangTai;
	}

	public void setShenHeZhuangTai(String shenHeZhuangTai)
	{
		this.shenHeZhuangTai = shenHeZhuangTai;
	}

	@Column(name = "ShenHeShiJian", length = 50)
	public String getShenHeShiJian()
	{
		return this.shenHeShiJian;
	}

	public void setShenHeShiJian(String shenHeShiJian)
	{
		this.shenHeShiJian = shenHeShiJian;
	}

	@Column(name = "ShenHeRen", length = 50)
	public String getShenHeRen()
	{
		return this.shenHeRen;
	}

	public void setShenHeRen(String shenHeRen)
	{
		this.shenHeRen = shenHeRen;
	}

	@Column(name = "ShenHeYiJian", length = 1000)
	public String getShenHeYiJian()
	{
		return this.shenHeYiJian;
	}

	public void setShenHeYiJian(String shenHeYiJian)
	{
		this.shenHeYiJian = shenHeYiJian;
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