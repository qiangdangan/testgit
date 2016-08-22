package com.gwzd.model.dbentity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * TbRenYuanSuoShuLeiXing entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_RenYuanSuoShuLeiXing")
public class TbRenYuanSuoShuLeiXing implements java.io.Serializable
{

	// Fields

	private TbRenYuanSuoShuLeiXingId id;

	// Constructors

	/** default constructor */
	public TbRenYuanSuoShuLeiXing()
	{}

	/** full constructor */
	public TbRenYuanSuoShuLeiXing(TbRenYuanSuoShuLeiXingId id)
	{
		this.id = id;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({ @AttributeOverride(name = "rysslxid", column = @Column(name = "RYSSLXID", length = 50)),
			@AttributeOverride(name = "rylxid", column = @Column(name = "RYLXID", length = 50)),
			@AttributeOverride(name = "ryId", column = @Column(name = "RY_ID", length = 50)) })
	public TbRenYuanSuoShuLeiXingId getId()
	{
		return this.id;
	}

	public void setId(TbRenYuanSuoShuLeiXingId id)
	{
		this.id = id;
	}

}