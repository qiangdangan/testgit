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
 * TbJueSe entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_JueSe")
public class TbJueSe implements java.io.Serializable
{

	// Fields

	private String xtjsId;
	private String jueSeMingCheng;
	private Boolean shiFouYouXiao;
	private String jueSeMiaoShu;
	private Set<TbJueSeQuanXian> tbJueSeQuanXians = new HashSet<TbJueSeQuanXian>(0);

	// Constructors

	/** default constructor */
	public TbJueSe()
	{}

	/** full constructor */
	public TbJueSe(String jueSeMingCheng, Boolean shiFouYouXiao, String jueSeMiaoShu, Set<TbJueSeQuanXian> tbJueSeQuanXians)
	{
		this.jueSeMingCheng = jueSeMingCheng;
		this.shiFouYouXiao = shiFouYouXiao;
		this.jueSeMiaoShu = jueSeMiaoShu;
		this.tbJueSeQuanXians = tbJueSeQuanXians;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "XTJS_ID", unique = true, nullable = false, length = 50)
	public String getXtjsId()
	{
		return this.xtjsId;
	}

	public void setXtjsId(String xtjsId)
	{
		this.xtjsId = xtjsId;
	}

	@Column(name = "JueSeMingCheng", length = 100)
	public String getJueSeMingCheng()
	{
		return this.jueSeMingCheng;
	}

	public void setJueSeMingCheng(String jueSeMingCheng)
	{
		this.jueSeMingCheng = jueSeMingCheng;
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

	@Column(name = "JueSeMiaoShu", length = 1000)
	public String getJueSeMiaoShu()
	{
		return this.jueSeMiaoShu;
	}

	public void setJueSeMiaoShu(String jueSeMiaoShu)
	{
		this.jueSeMiaoShu = jueSeMiaoShu;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tbJueSe")
	public Set<TbJueSeQuanXian> getTbJueSeQuanXians()
	{
		return this.tbJueSeQuanXians;
	}

	public void setTbJueSeQuanXians(Set<TbJueSeQuanXian> tbJueSeQuanXians)
	{
		this.tbJueSeQuanXians = tbJueSeQuanXians;
	}

}