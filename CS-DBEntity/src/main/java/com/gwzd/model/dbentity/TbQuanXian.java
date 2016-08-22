package com.gwzd.model.dbentity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbQuanXian entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_QuanXian")
public class TbQuanXian implements java.io.Serializable
{

	// Fields

	private String qxId;
	private String quanXianDaiMa;
	private String quanXianMingCheng;
	private Integer quanXianXuHao;
	private Boolean shiFouYouXiao;
	private String beiZhu;
	private Set<TbJueSeQuanXian> tbJueSeQuanXians = new HashSet<TbJueSeQuanXian>(0);

	// Constructors

	/** default constructor */
	public TbQuanXian()
	{}

	/** full constructor */
	public TbQuanXian(String quanXianDaiMa, String quanXianMingCheng, Integer quanXianXuHao, Boolean shiFouYouXiao, String beiZhu,
			Set<TbJueSeQuanXian> tbJueSeQuanXians)
	{
		this.quanXianDaiMa = quanXianDaiMa;
		this.quanXianMingCheng = quanXianMingCheng;
		this.quanXianXuHao = quanXianXuHao;
		this.shiFouYouXiao = shiFouYouXiao;
		this.beiZhu = beiZhu;
		this.tbJueSeQuanXians = tbJueSeQuanXians;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "QX_ID", unique = true, nullable = false, length = 50)
	public String getQxId()
	{
		return this.qxId;
	}

	public void setQxId(String qxId)
	{
		this.qxId = qxId;
	}

	@Column(name = "QuanXianDaiMa", length = 50)
	public String getQuanXianDaiMa()
	{
		return this.quanXianDaiMa;
	}

	public void setQuanXianDaiMa(String quanXianDaiMa)
	{
		this.quanXianDaiMa = quanXianDaiMa;
	}

	@Column(name = "QuanXianMingCheng", length = 100)
	public String getQuanXianMingCheng()
	{
		return this.quanXianMingCheng;
	}

	public void setQuanXianMingCheng(String quanXianMingCheng)
	{
		this.quanXianMingCheng = quanXianMingCheng;
	}

	@Column(name = "QuanXianXuHao")
	public Integer getQuanXianXuHao()
	{
		return this.quanXianXuHao;
	}

	public void setQuanXianXuHao(Integer quanXianXuHao)
	{
		this.quanXianXuHao = quanXianXuHao;
	}

	@Column(name = "ShiFouYouXiao")
	public Boolean getShiFouYouXiao()
	{
		return this.shiFouYouXiao;
	}

	public void setShiFouYouXiao(Boolean shiFouYouXiao)
	{
		this.shiFouYouXiao = shiFouYouXiao;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tbQuanXian")
	public Set<TbJueSeQuanXian> getTbJueSeQuanXians()
	{
		return this.tbJueSeQuanXians;
	}

	public void setTbJueSeQuanXians(Set<TbJueSeQuanXian> tbJueSeQuanXians)
	{
		this.tbJueSeQuanXians = tbJueSeQuanXians;
	}

}