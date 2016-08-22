package com.gwzd.model.dbentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbXiTongYongHu entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_XiTongYongHu")
public class TbXiTongYongHu implements java.io.Serializable
{

	// Fields

	private String xtyhId;
	private String ryId;
	private String dengLuMing;
	private String miMa;
	private Boolean shiFouYunXuDengLu;
	private Boolean shiFouIpbangDing;
	private String ip;
	private String xiTongNiCheng;

	// Constructors

	/** default constructor */
	public TbXiTongYongHu()
	{}

	/** full constructor */
	public TbXiTongYongHu(String ryId, String dengLuMing, String miMa, Boolean shiFouYunXuDengLu, Boolean shiFouIpbangDing, String ip, String xiTongNiCheng)
	{
		this.ryId = ryId;
		this.dengLuMing = dengLuMing;
		this.miMa = miMa;
		this.shiFouYunXuDengLu = shiFouYunXuDengLu;
		this.shiFouIpbangDing = shiFouIpbangDing;
		this.ip = ip;
		this.xiTongNiCheng = xiTongNiCheng;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "XTYH_ID", unique = true, nullable = false, length = 50)
	public String getXtyhId()
	{
		return this.xtyhId;
	}

	public void setXtyhId(String xtyhId)
	{
		this.xtyhId = xtyhId;
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

	@Column(name = "DengLuMing", length = 50)
	public String getDengLuMing()
	{
		return this.dengLuMing;
	}

	public void setDengLuMing(String dengLuMing)
	{
		this.dengLuMing = dengLuMing;
	}

	@Column(name = "MiMa", length = 50)
	public String getMiMa()
	{
		return this.miMa;
	}

	public void setMiMa(String miMa)
	{
		this.miMa = miMa;
	}

	@Column(name = "ShiFouYunXuDengLu")
	public Boolean getShiFouYunXuDengLu()
	{
		return this.shiFouYunXuDengLu;
	}

	public void setShiFouYunXuDengLu(Boolean shiFouYunXuDengLu)
	{
		this.shiFouYunXuDengLu = shiFouYunXuDengLu;
	}

	@Column(name = "ShiFouIPBangDing")
	public Boolean getShiFouIpbangDing()
	{
		return this.shiFouIpbangDing;
	}

	public void setShiFouIpbangDing(Boolean shiFouIpbangDing)
	{
		this.shiFouIpbangDing = shiFouIpbangDing;
	}

	@Column(name = "IP", length = 50)
	public String getIp()
	{
		return this.ip;
	}

	public void setIp(String ip)
	{
		this.ip = ip;
	}

	@Column(name = "XiTongNiCheng", length = 100)
	public String getXiTongNiCheng()
	{
		return this.xiTongNiCheng;
	}

	public void setXiTongNiCheng(String xiTongNiCheng)
	{
		this.xiTongNiCheng = xiTongNiCheng;
	}

}