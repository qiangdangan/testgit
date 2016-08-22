package com.gwzd.model.dbentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbYouJianFuJian entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_YouJianFuJian")
public class TbYouJianFuJian implements java.io.Serializable
{

	// Fields

	private String yjfjid;
	private String yjfsls;
	private String fuJianYuanMingCheng;
	private String fuJianXinMingCheng;
	private String fuJianDiZhI;

	// Constructors

	/** default constructor */
	public TbYouJianFuJian()
	{}

	/** full constructor */
	public TbYouJianFuJian(String yjfsls, String fuJianYuanMingCheng, String fuJianXinMingCheng, String fuJianDiZhI)
	{
		this.yjfsls = yjfsls;
		this.fuJianYuanMingCheng = fuJianYuanMingCheng;
		this.fuJianXinMingCheng = fuJianXinMingCheng;
		this.fuJianDiZhI = fuJianDiZhI;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "YJFJID", unique = true, nullable = false, length = 50)
	public String getYjfjid()
	{
		return this.yjfjid;
	}

	public void setYjfjid(String yjfjid)
	{
		this.yjfjid = yjfjid;
	}

	@Column(name = "YJFSLS", length = 50)
	public String getYjfsls()
	{
		return this.yjfsls;
	}

	public void setYjfsls(String yjfsls)
	{
		this.yjfsls = yjfsls;
	}

	@Column(name = "FuJianYuanMingCheng", length = 200)
	public String getFuJianYuanMingCheng()
	{
		return this.fuJianYuanMingCheng;
	}

	public void setFuJianYuanMingCheng(String fuJianYuanMingCheng)
	{
		this.fuJianYuanMingCheng = fuJianYuanMingCheng;
	}

	@Column(name = "FuJianXinMingCheng", length = 200)
	public String getFuJianXinMingCheng()
	{
		return this.fuJianXinMingCheng;
	}

	public void setFuJianXinMingCheng(String fuJianXinMingCheng)
	{
		this.fuJianXinMingCheng = fuJianXinMingCheng;
	}

	@Column(name = "FuJianDiZhI", length = 500)
	public String getFuJianDiZhI()
	{
		return this.fuJianDiZhI;
	}

	public void setFuJianDiZhI(String fuJianDiZhI)
	{
		this.fuJianDiZhI = fuJianDiZhI;
	}

}