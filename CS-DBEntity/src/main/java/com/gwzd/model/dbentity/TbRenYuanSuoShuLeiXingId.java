package com.gwzd.model.dbentity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TbRenYuanSuoShuLeiXingId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class TbRenYuanSuoShuLeiXingId implements java.io.Serializable
{

	// Fields

	private String rysslxid;
	private String rylxid;
	private String ryId;

	// Constructors

	/** default constructor */
	public TbRenYuanSuoShuLeiXingId()
	{}

	/** full constructor */
	public TbRenYuanSuoShuLeiXingId(String rysslxid, String rylxid, String ryId)
	{
		this.rysslxid = rysslxid;
		this.rylxid = rylxid;
		this.ryId = ryId;
	}

	// Property accessors

	@Column(name = "RYSSLXID", length = 50)
	public String getRysslxid()
	{
		return this.rysslxid;
	}

	public void setRysslxid(String rysslxid)
	{
		this.rysslxid = rysslxid;
	}

	@Column(name = "RYLXID", length = 50)
	public String getRylxid()
	{
		return this.rylxid;
	}

	public void setRylxid(String rylxid)
	{
		this.rylxid = rylxid;
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

	public boolean equals(Object other)
	{
		if ((this == other)) return true;
		if ((other == null)) return false;
		if (!(other instanceof TbRenYuanSuoShuLeiXingId)) return false;
		TbRenYuanSuoShuLeiXingId castOther = (TbRenYuanSuoShuLeiXingId) other;

		return ((this.getRysslxid() == castOther.getRysslxid()) || (this.getRysslxid() != null && castOther.getRysslxid() != null && this.getRysslxid().equals(
				castOther.getRysslxid())))
				&& ((this.getRylxid() == castOther.getRylxid()) || (this.getRylxid() != null && castOther.getRylxid() != null && this.getRylxid().equals(
						castOther.getRylxid())))
				&& ((this.getRyId() == castOther.getRyId()) || (this.getRyId() != null && castOther.getRyId() != null && this.getRyId().equals(
						castOther.getRyId())));
	}

	public int hashCode()
	{
		int result = 17;

		result = 37 * result + (getRysslxid() == null ? 0 : this.getRysslxid().hashCode());
		result = 37 * result + (getRylxid() == null ? 0 : this.getRylxid().hashCode());
		result = 37 * result + (getRyId() == null ? 0 : this.getRyId().hashCode());
		return result;
	}

}