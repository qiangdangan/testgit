package com.gwzd.action;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.gwzd.model.dbentity.TDemo;
import com.gwzd.model.enumeration.publicenum.ReturnFlagEnum;
import com.gwzd.model.findentity.TestFindEntity;
import com.gwzd.model.po.LoginUserInfoEntity;
import com.gwzd.service.TestService;
import com.gwzd.util.DataSwitch;
import com.gwzd.util.MyException;
import com.gwzd.util.Pager;
import com.gwzd.util.PublicMethod;

/**
 * @文件名称: TestAction.java
 * @包: com.gwzd.action
 * @版本：V1.0
 * @版权所有：北京国网中电自动化技术有限公司
 * 
 * @创建人：强子
 * @创建时间：2016年8月17日
 * @功能简介：框架测试
 * 
 */
@Controller
@Scope("prototype")
@Namespace("/")
@ParentPackage(value = "default-package")
@Results({ @Result(name = "ListPage", location = "/BaseDataM/demo_list.jsp"), @Result(name = "InitAddPage", location = "/BaseDataM/demo_add.jsp"),
		@Result(name = "InitEditPage", location = "/BaseDataM/demo_edit.jsp") })
public class TestAction extends BaseAction
{
	private static final long serialVersionUID = 1L;

	private TestService testService;

	@Resource
	public void setTestService(TestService testService)
	{
		this.testService = testService;
		super.setJieDianUrl("test.listUI.action");
	}

	private TDemo demo; // demo实体

	/**
	 * @功能简介：初始化列表页面
	 * @应用页面：/CS-Web/src/main/webapp/BaseDataM/test/list_demo.jsp
	 * @作者姓名：强子
	 * @创建时间：2016年8月18日 上午10:24:54
	 * @参数说明：@return
	 * @参数说明：@throws MyException
	 * @返回类型：String
	 * 
	 */
	@Action(value = "test.listUI")
	public String listUI() throws MyException
	{
		return ReturnFlagEnum.ListPage;
	}

	/**
	 * @功能简介：分页查询
	 * @应用页面：/CS-Web/src/main/webapp/BaseDataM/test/list_demo.jsp
	 * @作者姓名：强子
	 * @创建时间：2016年8月18日 上午10:16:59
	 * @参数说明：
	 * @返回类型：void
	 * 
	 */
	@Action(value = "test.searchTest")
	public void searchTest()
	{
		try
		{
			TestFindEntity testFindEntity = super.convertRequestToEntity(TestFindEntity.class);
			Map<String, Object> pageMap = getParameterMap();
			super.setSessionAttr("test", pageMap);
			Pager pager = testService.searchTest(testFindEntity);
			String pagerJson = DataSwitch.convertEntityToJson(pager);
			PublicMethod.writeToPage(pagerJson);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * @功能简介：初始化添加页面
	 * @应用页面：
	 * @作者姓名：强子
	 * @创建时间：2016年8月20日 上午12:50:55
	 * @参数说明：@return
	 * @返回类型：String
	 * 
	 */
	@Action(value = "test.initAddPage")
	public String initAddPage()
	{
		return ReturnFlagEnum.InitAddPage;
	}

	/**
	 * @功能简介：异步验证姓名是否存在
	 * @应用页面：
	 * @作者姓名：强子
	 * @创建时间：2016年8月20日 下午4:53:07
	 * @参数说明：
	 * @返回类型：void
	 * 
	 */
	@Action(value = "test.ajaxValidateNameIsExist")
	public void ajaxValidateNameIsExist()
	{
		try
		{
			String id = super.getParameter("validateparam2");
			String username = super.getParameter("validateparam1");
			boolean isExist = this.testService.searchUserNameIsExist(id, username);
			if (!isExist)
			{
				PublicMethod.writeToPage(ReturnFlagEnum.trueMessage);
			}
			else
			{
				PublicMethod.writeToPage(ReturnFlagEnum.falseMessage);
			}
		}
		catch (Exception e)
		{
			PublicMethod.writeToPage(ReturnFlagEnum.falseMessage);
			e.printStackTrace();
		}
	}

	/**
	 * @功能简介：保存demo
	 * @应用页面：
	 * @作者姓名：强子
	 * @创建时间：2016年8月20日 下午5:01:34
	 * @参数说明：
	 * @返回类型：void
	 * 
	 */
	@Action("test.saveDemo")
	public void saveDemo()
	{
		try
		{
			boolean result = this.testService.saveDemo(demo);
			if (result)
			{
				PublicMethod.writeToPage(ReturnFlagEnum.trueMessage);
			}
			else
			{
				PublicMethod.writeToPage(ReturnFlagEnum.falseMessage);
			}
		}
		catch (Exception e)
		{
			PublicMethod.writeToPage(ReturnFlagEnum.falseMessage);
			e.printStackTrace();
		}
	}

	/**
	 * @throws Exception
	 * @功能简介：初始化修改页面
	 * @应用页面：
	 * @作者姓名：强子
	 * @创建时间：2016年8月20日 下午5:23:37
	 * @参数说明：@return
	 * @返回类型：String
	 * 
	 */
	@Action("test.initEditPage")
	public String initEditPage() throws Exception
	{
		try
		{
			String id = super.getParameter("id");
			demo = PublicMethod.getEntityByPrimaryId(TDemo.class, id);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		return ReturnFlagEnum.InitEditPage;
	}

	/**
	 * @功能简介：修改Demo
	 * @应用页面：
	 * @作者姓名：强子
	 * @创建时间：2016年8月20日 下午5:05:05
	 * @参数说明：
	 * @返回类型：void
	 * 
	 */
	@Action("test.updateDemo")
	public void updateDemo()
	{
		try
		{
			TDemo dbDemo = PublicMethod.getEntityByPrimaryId(TDemo.class, demo.getId());
			Map<String, String[]> parameterMap = this.getRequest().getParameterMap();
			TDemo updateDemo = DataSwitch.mergeEntity(dbDemo, demo, "demo", parameterMap);
			LoginUserInfoEntity loginUser = super.getLoginUserInfoEntity();
			updateDemo.setXgr(loginUser.getXingMing());
			updateDemo.setXgrzgh(loginUser.getZhiGongHao());
			updateDemo.setXgsj(new Date());
			boolean result = this.testService.updateDemo(updateDemo);
			if (result)
			{
				PublicMethod.writeToPage(ReturnFlagEnum.trueMessage);
			}
			else
			{
				PublicMethod.writeToPage(ReturnFlagEnum.falseMessage);
			}
		}
		catch (Exception e)
		{
			PublicMethod.writeToPage(ReturnFlagEnum.falseMessage);
			e.printStackTrace();
		}
	}

	/**
	 * @功能简介：删除demo
	 * @应用页面：
	 * @作者姓名：强子
	 * @创建时间：2016年8月20日 下午8:12:52
	 * @参数说明：
	 * @返回类型：void
	 * 
	 */
	@Action("test.deleteDemo")
	public void deleteDemo()
	{
		try
		{
			String ids = super.getParameter("ids");
			boolean result = this.testService.deleteDemo(ids);
			if (result)
			{
				PublicMethod.writeToPage(ReturnFlagEnum.trueMessage);
			}
			else
			{
				PublicMethod.writeToPage(ReturnFlagEnum.falseMessage);
			}
		}
		catch (Exception e)
		{
			PublicMethod.writeToPage(ReturnFlagEnum.falseMessage);
			e.printStackTrace();
		}
	}

	public TDemo getDemo()
	{
		return demo;
	}

	public void setDemo(TDemo demo)
	{
		this.demo = demo;
	}
}
