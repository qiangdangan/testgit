package com.gwzd.model.dbentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbGuiZeShiYongXiaoXiLeiXing entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_GuiZeShiYongXiaoXiLeiXing")
public class TbGuiZeShiYongXiaoXiLeiXing implements java.io.Serializable
{

	// Fields

	private String gzsyxxlxid;
	private String xxlxid;
	private String guZeId;

	// Constructors

	/** default constructor */
	public TbGuiZeShiYongXiaoXiLeiXing()
	{}

	/** full constructor */
	public TbGuiZeShiYongXiaoXiLeiXing(String xxlxid, String guZeId)
	{
		this.xxlxid = xxlxid;
		this.guZeId = guZeId;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "GZSYXXLXID", unique = true, nullable = false, length = 50)
	public String getGzsyxxlxid()
	{
		return this.gzsyxxlxid;
	}

	public void setGzsyxxlxid(String gzsyxxlxid)
	{
		this.gzsyxxlxid = gzsyxxlxid;
	}

	@Column(name = "XXLXID", length = 50)
	public String getXxlxid()
	{
		return this.xxlxid;
	}

	public void setXxlxid(String xxlxid)
	{
		this.xxlxid = xxlxid;
	}

	@Column(name = "GuZeID", length = 50)
	public String getGuZeId()
	{
		return this.guZeId;
	}

	public void setGuZeId(String guZeId)
	{
		this.guZeId = guZeId;
	}

}