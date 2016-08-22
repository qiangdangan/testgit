package com.gwzd.model.dbentity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbZhiXingRenWuXinXi entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_ZhiXingRenWuXinXi")
public class TbZhiXingRenWuXinXi implements java.io.Serializable
{

	// Fields

	private String rxxxid;
	private String renWuMiaoShu;
	private String canKaoXinXi;
	private Timestamp renWuKaiShiJian;
	private Timestamp renWuJieZhiShiJian;
	private String jhid;
	private String xmid;
	private Boolean shifouRenWuChaoShi;
	private String chaoShiYuanYin;

	// Constructors

	/** default constructor */
	public TbZhiXingRenWuXinXi()
	{}

	/** full constructor */
	public TbZhiXingRenWuXinXi(String renWuMiaoShu, String canKaoXinXi, Timestamp renWuKaiShiJian, Timestamp renWuJieZhiShiJian, String jhid, String xmid,
			Boolean shifouRenWuChaoShi, String chaoShiYuanYin)
	{
		this.renWuMiaoShu = renWuMiaoShu;
		this.canKaoXinXi = canKaoXinXi;
		this.renWuKaiShiJian = renWuKaiShiJian;
		this.renWuJieZhiShiJian = renWuJieZhiShiJian;
		this.jhid = jhid;
		this.xmid = xmid;
		this.shifouRenWuChaoShi = shifouRenWuChaoShi;
		this.chaoShiYuanYin = chaoShiYuanYin;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "RXXXID", unique = true, nullable = false, length = 50)
	public String getRxxxid()
	{
		return this.rxxxid;
	}

	public void setRxxxid(String rxxxid)
	{
		this.rxxxid = rxxxid;
	}

	@Column(name = "RenWuMiaoShu", length = 1000)
	public String getRenWuMiaoShu()
	{
		return this.renWuMiaoShu;
	}

	public void setRenWuMiaoShu(String renWuMiaoShu)
	{
		this.renWuMiaoShu = renWuMiaoShu;
	}

	@Column(name = "CanKaoXinXi", length = 1000)
	public String getCanKaoXinXi()
	{
		return this.canKaoXinXi;
	}

	public void setCanKaoXinXi(String canKaoXinXi)
	{
		this.canKaoXinXi = canKaoXinXi;
	}

	@Column(name = "RenWuKaiShiJian", length = 19)
	public Timestamp getRenWuKaiShiJian()
	{
		return this.renWuKaiShiJian;
	}

	public void setRenWuKaiShiJian(Timestamp renWuKaiShiJian)
	{
		this.renWuKaiShiJian = renWuKaiShiJian;
	}

	@Column(name = "RenWuJieZhiShiJian", length = 19)
	public Timestamp getRenWuJieZhiShiJian()
	{
		return this.renWuJieZhiShiJian;
	}

	public void setRenWuJieZhiShiJian(Timestamp renWuJieZhiShiJian)
	{
		this.renWuJieZhiShiJian = renWuJieZhiShiJian;
	}

	@Column(name = "JHID", length = 50)
	public String getJhid()
	{
		return this.jhid;
	}

	public void setJhid(String jhid)
	{
		this.jhid = jhid;
	}

	@Column(name = "XMID", length = 50)
	public String getXmid()
	{
		return this.xmid;
	}

	public void setXmid(String xmid)
	{
		this.xmid = xmid;
	}

	@Column(name = "SHIFouRenWuChaoShi")
	public Boolean getShifouRenWuChaoShi()
	{
		return this.shifouRenWuChaoShi;
	}

	public void setShifouRenWuChaoShi(Boolean shifouRenWuChaoShi)
	{
		this.shifouRenWuChaoShi = shifouRenWuChaoShi;
	}

	@Column(name = "ChaoShiYuanYin", length = 1000)
	public String getChaoShiYuanYin()
	{
		return this.chaoShiYuanYin;
	}

	public void setChaoShiYuanYin(String chaoShiYuanYin)
	{
		this.chaoShiYuanYin = chaoShiYuanYin;
	}

}