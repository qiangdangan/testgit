package com.gwzd.model.dbentity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TbFaHuoPiCi entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_FaHuoPiCi")
public class TbFaHuoPiCi implements java.io.Serializable
{

	// Fields

	private String fhpcid;
	private String piCiMingCheng;
	private String piCiDaiHao;
	private Timestamp faHuoShiJian;
	private String faHuoRen;
	private String beiZhu;

	// Constructors

	/** default constructor */
	public TbFaHuoPiCi()
	{}

	/** full constructor */
	public TbFaHuoPiCi(String piCiMingCheng, String piCiDaiHao, Timestamp faHuoShiJian, String faHuoRen, String beiZhu)
	{
		this.piCiMingCheng = piCiMingCheng;
		this.piCiDaiHao = piCiDaiHao;
		this.faHuoShiJian = faHuoShiJian;
		this.faHuoRen = faHuoRen;
		this.beiZhu = beiZhu;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "FHPCID", unique = true, nullable = false, length = 50)
	public String getFhpcid()
	{
		return this.fhpcid;
	}

	public void setFhpcid(String fhpcid)
	{
		this.fhpcid = fhpcid;
	}

	@Column(name = "PiCiMingCheng", length = 100)
	public String getPiCiMingCheng()
	{
		return this.piCiMingCheng;
	}

	public void setPiCiMingCheng(String piCiMingCheng)
	{
		this.piCiMingCheng = piCiMingCheng;
	}

	@Column(name = "PiCiDaiHao", length = 50)
	public String getPiCiDaiHao()
	{
		return this.piCiDaiHao;
	}

	public void setPiCiDaiHao(String piCiDaiHao)
	{
		this.piCiDaiHao = piCiDaiHao;
	}

	@Column(name = "FaHuoShiJian", length = 19)
	public Timestamp getFaHuoShiJian()
	{
		return this.faHuoShiJian;
	}

	public void setFaHuoShiJian(Timestamp faHuoShiJian)
	{
		this.faHuoShiJian = faHuoShiJian;
	}

	@Column(name = "FaHuoRen", length = 50)
	public String getFaHuoRen()
	{
		return this.faHuoRen;
	}

	public void setFaHuoRen(String faHuoRen)
	{
		this.faHuoRen = faHuoRen;
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

}