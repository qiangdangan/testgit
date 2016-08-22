package com.gwzd.model.dbentity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbGongGao entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_GongGao")
public class TbGongGao implements java.io.Serializable
{

	// Fields

	private String ggid;
	private String ggnr;
	private Boolean sfcqyx;
	private Timestamp yxqzsj;
	private Timestamp yxjzsj;
	private String ggwhr;
	private Timestamp ggwhsj;

	// Constructors

	/** default constructor */
	public TbGongGao()
	{}

	/** full constructor */
	public TbGongGao(String ggnr, Boolean sfcqyx, Timestamp yxqzsj, Timestamp yxjzsj, String ggwhr, Timestamp ggwhsj)
	{
		this.ggnr = ggnr;
		this.sfcqyx = sfcqyx;
		this.yxqzsj = yxqzsj;
		this.yxjzsj = yxjzsj;
		this.ggwhr = ggwhr;
		this.ggwhsj = ggwhsj;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "GGID", unique = true, nullable = false, length = 50)
	public String getGgid()
	{
		return this.ggid;
	}

	public void setGgid(String ggid)
	{
		this.ggid = ggid;
	}

	@Column(name = "GGNR", length = 1000)
	public String getGgnr()
	{
		return this.ggnr;
	}

	public void setGgnr(String ggnr)
	{
		this.ggnr = ggnr;
	}

	@Column(name = "SFCQYX")
	public Boolean getSfcqyx()
	{
		return this.sfcqyx;
	}

	public void setSfcqyx(Boolean sfcqyx)
	{
		this.sfcqyx = sfcqyx;
	}

	@Column(name = "YXQZSJ", length = 19)
	public Timestamp getYxqzsj()
	{
		return this.yxqzsj;
	}

	public void setYxqzsj(Timestamp yxqzsj)
	{
		this.yxqzsj = yxqzsj;
	}

	@Column(name = "YXJZSJ", length = 19)
	public Timestamp getYxjzsj()
	{
		return this.yxjzsj;
	}

	public void setYxjzsj(Timestamp yxjzsj)
	{
		this.yxjzsj = yxjzsj;
	}

	@Column(name = "GGWHR", length = 50)
	public String getGgwhr()
	{
		return this.ggwhr;
	}

	public void setGgwhr(String ggwhr)
	{
		this.ggwhr = ggwhr;
	}

	@Column(name = "GGWHSJ", length = 19)
	public Timestamp getGgwhsj()
	{
		return this.ggwhsj;
	}

	public void setGgwhsj(Timestamp ggwhsj)
	{
		this.ggwhsj = ggwhsj;
	}

}