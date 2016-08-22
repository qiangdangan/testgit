package com.gwzd.model.dbentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbRenYuanZhiCheng entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_RenYuanZhiCheng")
public class TbRenYuanZhiCheng implements java.io.Serializable
{

	// Fields

	private String ryzcId;
	private String ryId;
	private String zcId;

	// Constructors

	/** default constructor */
	public TbRenYuanZhiCheng()
	{}

	/** full constructor */
	public TbRenYuanZhiCheng(String ryId, String zcId)
	{
		this.ryId = ryId;
		this.zcId = zcId;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "RYZC_ID", unique = true, nullable = false, length = 50)
	public String getRyzcId()
	{
		return this.ryzcId;
	}

	public void setRyzcId(String ryzcId)
	{
		this.ryzcId = ryzcId;
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

	@Column(name = "ZC_ID", length = 50)
	public String getZcId()
	{
		return this.zcId;
	}

	public void setZcId(String zcId)
	{
		this.zcId = zcId;
	}

}