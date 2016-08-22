package com.gwzd.model.dbentity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

/**
 * TDemo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_demo")
public class TDemo implements java.io.Serializable
{

	// Fields

	private String id;
	private String username;
	private Integer age;
	private Integer sex;
	private String phone;
	private String email;
	private String zhuanye;
	private String jianjie;
	private String xgr;
	private String xgrzgh;
	private Date xgsj;

	// Constructors

	/** default constructor */
	public TDemo()
	{}

	/** full constructor */
	public TDemo(String username, Integer age, Integer sex, String phone, String email, String zhuanye, String jianjie)
	{
		this.username = username;
		this.age = age;
		this.sex = sex;
		this.phone = phone;
		this.email = email;
		this.zhuanye = zhuanye;
		this.jianjie = jianjie;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "id", unique = true, nullable = false, length = 50)
	public String getId()
	{
		return this.id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	@Column(name = "username", length = 150)
	public String getUsername()
	{
		return this.username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	@Column(name = "age")
	public Integer getAge()
	{
		return this.age;
	}

	public void setAge(Integer age)
	{
		this.age = age;
	}

	@Column(name = "sex")
	public Integer getSex()
	{
		return this.sex;
	}

	public void setSex(Integer sex)
	{
		this.sex = sex;
	}

	@Column(name = "phone", length = 20)
	public String getPhone()
	{
		return this.phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	@Column(name = "email", length = 100)
	public String getEmail()
	{
		return this.email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	@Column(name = "zhuanye", length = 50)
	public String getZhuanye()
	{
		return this.zhuanye;
	}

	public void setZhuanye(String zhuanye)
	{
		this.zhuanye = zhuanye;
	}

	@Column(name = "jianjie", length = 200)
	public String getJianjie()
	{
		return this.jianjie;
	}

	public void setJianjie(String jianjie)
	{
		this.jianjie = jianjie;
	}

	@Column(name = "xgr", length = 50)
	public String getXgr()
	{
		return xgr;
	}

	public void setXgr(String xgr)
	{
		this.xgr = xgr;
	}

	@Column(name = "xgrzgh", length = 50)
	public String getXgrzgh()
	{
		return xgrzgh;
	}

	public void setXgrzgh(String xgrzgh)
	{
		this.xgrzgh = xgrzgh;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "xgsj", length = 19)
	public Date getXgsj()
	{
		return xgsj;
	}

	public void setXgsj(Date xgsj)
	{
		this.xgsj = xgsj;
	}

}