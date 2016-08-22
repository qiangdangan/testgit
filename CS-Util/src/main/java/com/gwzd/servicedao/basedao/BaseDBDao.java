package com.gwzd.servicedao.basedao;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.persister.entity.AbstractEntityPersister;
import org.hibernate.persister.entity.SingleTableEntityPersister;
import org.springframework.stereotype.Repository;
import org.springframework.util.ReflectionUtils;

import com.gwzd.model.enumeration.publicenum.ShiFouEnum;
import com.gwzd.model.findentity.basefindentity.BaseFindEntity;
import com.gwzd.util.DataSwitch;
import com.gwzd.util.MyException;
import com.gwzd.util.Pager;

;

/**
 * @文件名称: BaseDBDAL.java
 * @包: com.gwzd.servicedao.basedao
 * @版本：V1.0
 * @版权所有：北京国网中电自动化技术有限公司
 * 
 * @创建人：高洪涛
 * @创建时间：2014年10月16日
 * @功能简介：
 * 
 */
@Repository("baseDao")
public class BaseDBDao
{
	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory = null;

	/**
	 * 
	 * @功能简介：获得 Hibernate 的 SessionFactory
	 * @应用页面：
	 * @作者姓名：高洪涛
	 * @创建时间：2014年10月16日 下午2:22:06
	 * @参数说明：@param sessionFactory
	 * @返回类型：void
	 * 
	 */
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}

	private Session session = null;

	/**
	 * 
	 * @创建人：应洪峰
	 * @创建时间：2012-4-17
	 * @功能说明：获得session
	 * @return
	 */
	private Session getSession()
	{
		try
		{
			session = sessionFactory.getCurrentSession();
		}
		catch (HibernateException e)
		{
			e.printStackTrace();
		}
		return session;
	}

	/**
	 * 
	 * @创建人：强当安
	 * @创建时间：2012-4-18
	 * @功能说明：根据泛型实体的class获得ClassMetadata
	 * @param <T>
	 * @param typClass
	 * @return
	 */
	private <T> AbstractEntityPersister getClassMetadata(Class<T> typClass)
	{
		return (SingleTableEntityPersister) sessionFactory.getClassMetadata(typClass);
	}

	/**
	 * 
	 * @创建人：强当安
	 * @创建时间：2012-4-18
	 * @功能说明：根据泛型实体的class获得该实体对应表中主键
	 * @param <T>
	 * @param typClass
	 * @return
	 */
	private <T> String getPrimaryKey(Class<T> typClass)
	{
		AbstractEntityPersister classMetadata = (SingleTableEntityPersister) sessionFactory.getClassMetadata(typClass);
		return classMetadata.getIdentifierColumnNames()[0];
	}

	/**
	 * 
	 * @创建人：强当安
	 * @创建时间：2012-12-18
	 * @功能说明：根据泛型实体的class获得该实体对应表中主键名称
	 * @param <T>
	 * @param typClass
	 * @return
	 */
	private <T> String getPrimaryPropertyName(Class<T> typClass)
	{
		ClassMetadata meta = sessionFactory.getClassMetadata(typClass);
		return meta.getIdentifierPropertyName();// 主键名称
	}

	/**
	 * 
	 * @创建人：强当安
	 * @创建时间：2012-4-18
	 * @功能说明：根据泛型实体的typClass和primaryId获得相应的实体
	 * @param <T>
	 * @param typClass
	 *            泛型实体的class
	 * @param primaryId
	 *            实体中主键属性
	 * @return
	 * @throws Exception
	 */

	@SuppressWarnings("unchecked")
	public <T> T getEntityByPrimaryId(Class<T> typClass, Serializable primaryId) throws Exception
	{
		T returnClass = null;

		try
		{
			returnClass = (T) this.getSession().get(typClass, primaryId);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		return returnClass;
	}

	/**
	 * 
	 * @创建人：强当安
	 * @创建时间：2012-4-18
	 * @功能说明：根据泛型实体的typClass和primaryId获得相应的实体 与懒加载相关
	 * @param <T>
	 * @param typClass
	 *            泛型实体的class
	 * @param primaryId
	 *            实体中主键属性
	 * @return
	 * @throws Exception
	 */

	@SuppressWarnings("unchecked")
	public <T> T loadEntityByPrimaryId(Class<T> typClass, Serializable primaryId) throws Exception
	{
		T returnClass = null;

		try
		{
			returnClass = (T) this.getSession().load(typClass, primaryId);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		return returnClass;
	}

	/**
	 * 基于泛型的添加逻辑接口，通过连接Hibernate完成添加操作
	 * 
	 * @author 强当安 北京国网中电 2011-4-17
	 * @param entity
	 *            Hibernate自动生成的实体类
	 * @return true 成功 | false 失败
	 * @throws Exception
	 * 
	 */
	public boolean addEntity(Object entity) throws Exception
	{
		boolean result = false;
		try
		{
			Session session = getSession();
			String s = session.save(entity).toString();
			session.flush();
			if (s.trim().length() != 0)
			{
				result = true;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	/**
	 * 基于泛型的添加逻辑接口，通过连接Hibernate完成添加操作
	 * 
	 * @author 强当安 北京国网中电 2011-4-17
	 * @param entity
	 *            Hibernate自动生成的实体类
	 * @return Id
	 * @throws Exception
	 * 
	 */
	public String addEntityReturnId(Object entity) throws Exception
	{
		String ret = null;
		try
		{
			Session session = getSession();
			String s = session.save(entity).toString();
			session.flush();
			ret = s;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		return ret;
	}

	/**
	 * 将实体游离化，使其不跟数据库做关联
	 * 
	 * @author 强当安 北京国网中电 2011-4-17
	 * @param entity
	 *            Hibernate自动生成的实体类
	 * @return true 成功 | false 失败
	 * @throws Exception
	 * 
	 */
	public void evictEntity(Object entity) throws Exception
	{
		try
		{
			this.getSession().evict(entity);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * @功能简介：更新实体，若实体中某项未赋值 则为null
	 * @应用页面：
	 * @作者姓名：高洪涛、强当安
	 * @创建时间：2014年10月17日 下午5:01:32
	 * @param entity
	 * @return
	 * @throws Exception
	 *             ：
	 */
	public boolean updateEntity(Object entity) throws Exception
	{
		boolean result = false;
		try
		{
			Session session = getSession();
			session.update(entity);
			session.flush();
			result = true;
		}
		catch (Exception e)
		{
			throw e;
		}
		return result;
	}

	/**
	 * 
	 * @创建人：焦元超
	 * @创建时间：2012-6-12
	 * @功能说明：合并更新实体,缓存中存在实体时，不允许直接更新实体
	 * @param entity
	 * @return
	 */
	public boolean mergeEntiy(Object entity) throws Exception
	{
		boolean result = false;
		try
		{
			Session session = getSession();
			session.merge(entity);
			session.flush();
			result = true;
		}
		catch (Exception e)
		{
			throw e;
		}
		return result;
	}

	/**
	 * 
	 * @创建人：强当安
	 * @创建时间：2012-6-12
	 * @功能说明：合并更新实体,缓存中存在实体时，不允许直接更新实体
	 * @param entity
	 * @return
	 */
	public boolean deleteEntiy(Object entity) throws Exception
	{
		boolean result = false;
		try
		{
			Session session = getSession();
			session.delete(entity);
			session.flush();
			result = true;
		}
		catch (Exception e)
		{
			throw e;
		}
		return result;
	}

	/**
	 * 
	 * @创建人：应洪峰
	 * @创建时间：2012-3-21
	 * @功能说明：根据主键id批量修改某一字段的值
	 * @param typeClass
	 *            泛型实体的class
	 * @param primaryKeyValues
	 *            主键的id值,例如1,2,3
	 * @param key
	 *            数据库中字段
	 * @param value
	 *            需要修改字段的值
	 * @return
	 * @throws Exception
	 */
	public <T> boolean updateAllBySql(Class<T> typeClass, String primaryKeyValues, String fieldName, Object fieldValue) throws Exception
	{
		boolean result = false;
		String keys = "";
		try
		{
			String[] idArr = primaryKeyValues.split(",");
			for (String id : idArr)
			{
				keys += "'" + id + "',";
			}
			keys += "'-1'";

			String tableName = typeClass.getAnnotation(Table.class).name();
			String primaryKey = this.getPrimaryKey(typeClass);
			String sql = "UPDATE " + tableName + " SET " + fieldName + "='" + fieldValue + "' WHERE " + primaryKey + " in (" + keys + ")";
			SQLQuery query = this.getSession().createSQLQuery(sql);
			int flag = query.executeUpdate();
			if (flag > 0) result = true;
		}
		catch (Exception e)
		{
			throw e;
		}
		return result;
	}

	/**
	 * 
	 * @创建人：焦元超
	 * @创建时间：2012-5-13
	 * @功能说明：根据sql更新数据
	 * @param sql
	 * @param parasMaps
	 * @return
	 * @throws Exception
	 */
	public boolean updateBySql(String sql, Map<String, Object> parasMaps) throws Exception
	{
		boolean result = false;
		try
		{
			Session session = this.getSession();
			SQLQuery query = session.createSQLQuery(sql);
			if (parasMaps != null && parasMaps.size() > 0)
			{
				Iterator<String> keySet = parasMaps.keySet().iterator();
				while (keySet.hasNext())
				{
					String key = keySet.next();
					if (sql.contains(":" + key)) query.setParameter(key, parasMaps.get(key));
				}
			}
			if (query.executeUpdate() > 0)
			{
				result = true;
			}
			session.flush();
		}
		catch (Exception e)
		{
			throw e;
		}
		return result;
	}

	/**
	 * 
	 * @创建人：司徒
	 * @创建时间：2011-9-22
	 * @功能说明：更新实体，若实体中某项未赋值 则不更新该字段 可更新本实体中的自由字段和外键字段 需要至少为该实体主键和其他任意一字段赋值
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	public boolean updateEntiyFieldBySql(Object entity) throws Exception
	{
		Boolean result = false;
		try
		{
			Map<String, Object> paras = new HashMap<String, Object>();
			String tableName = entity.getClass().getAnnotation(Table.class).name();
			String primaryKey = this.getPrimaryKey(entity.getClass());
			Object primaryValue = "";
			boolean isPrimaryKey = false;
			StringBuffer sbSql = new StringBuffer();
			sbSql.append(" UPDATE ");
			sbSql.append(tableName);
			sbSql.append(" SET ");
			BeanInfo beanInfo = Introspector.getBeanInfo(entity.getClass());
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor propertyDescriptor : propertyDescriptors)
			{
				String name = propertyDescriptor.getName();
				Type type = propertyDescriptor.getPropertyType();
				String typeStr = type.toString();
				if (typeStr.contains("java.util.Set") || typeStr.contains("java.util.List") || typeStr.contains("java.lang.Class") || typeStr.equals("class")
						|| name.trim().length() == 0)
				{
					continue;
				}
				Method method = propertyDescriptor.getReadMethod();
				Object value = method.invoke(entity);
				if (value == null)
				{
					continue;
				}
				String[] dbKeyNameArr = this.getClassMetadata(entity.getClass()).getPropertyColumnNames(name);
				String key = "";
				if (dbKeyNameArr.length > 0)
				{
					key = dbKeyNameArr[0];
				}
				else
				{
					continue;
				}
				if (key.equalsIgnoreCase(primaryKey))
				{
					primaryValue = value;
					isPrimaryKey = true;
				}
				if (isPrimaryKey && value == null)
				{
					throw new MyException(entity.getClass(), "该实体主键未赋值，无法更新!");
				}
				else if (value == null)
				{
					continue;
				}

				if (typeStr.contains(".model.dbentity"))
				{
					String foreignKey = this.getClassMetadata(value.getClass()).getIdentifierPropertyName();
					BeanInfo foreignBeanInfo = Introspector.getBeanInfo(value.getClass());

					PropertyDescriptor[] foreignpropertyDescriptors = foreignBeanInfo.getPropertyDescriptors();

					for (PropertyDescriptor foreignpropertyDescriptor : foreignpropertyDescriptors)
					{
						String tempKey = foreignpropertyDescriptor.getName();
						if (tempKey.equalsIgnoreCase(foreignKey))
						{
							value = foreignpropertyDescriptor.getReadMethod().invoke(value);
							break;
						}
					}
				}

				sbSql.append(key);
				sbSql.append(" = :");
				sbSql.append(key);
				sbSql.append(",");
				paras.put(key, value);
			}
			String sql = sbSql.toString().substring(0, sbSql.toString().length() - 1);
			sbSql = new StringBuffer(sql);
			sbSql.append(" WHERE ");
			sbSql.append(primaryKey);
			sbSql.append(" = :");
			sbSql.append(primaryKey);
			paras.put(primaryKey, primaryValue);
			if (paras.values().size() < 2)
			{
				throw new MyException(entity.getClass(), "需要至少为该实体主键和其他任意一字段赋值，无法更新!");
			}

			SQLQuery query = this.getSession().createSQLQuery(sbSql.toString());
			for (String parasKey : paras.keySet())
			{
				query.setParameter(parasKey, paras.get(parasKey));
			}

			int flag = query.executeUpdate();
			if (flag > 0) result = true;

		}
		catch (Exception e)
		{
			throw e;
		}

		return result;
	}

	/**
	 * @功能简介：根据单个的propertyName和propertyValue查询实体的结果集
	 * @应用页面：
	 * @作者姓名：高洪涛、强当安
	 * @创建时间：2014年10月17日 下午6:47:43
	 * @param typClass
	 *            ：泛型实体的class
	 * @param propertyName
	 *            ：使用实体中的属性名
	 * @param propertyValue
	 *            ：查询的值
	 * @return
	 * @throws Exception
	 *             ：
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> getEntitiesListByProperty(final Class<T> typClass, String propertyName, Object propertyValue) throws Exception
	{
		try
		{
			String primaryKey = this.getPrimaryKey(typClass).replace("_", "");
			final SimpleExpression expression = Restrictions.eq(propertyName, propertyValue);
			if (propertyValue instanceof String && !propertyName.equalsIgnoreCase(primaryKey))
			{
				expression.ignoreCase();
			}
			final Criteria criteria = this.getSession().createCriteria(typClass).add(expression);
			return criteria.list();
		}
		catch (Exception e)
		{
			throw e;
		}
	}

	/**
	 * @功能简介：根据数据库字段名返回List
	 * @应用页面：
	 * @作者姓名：高洪涛、强当安
	 * @创建时间：2014年10月17日 下午7:14:23
	 * @param typClass
	 * @param dbFieldName
	 *            ：字段名
	 * @param dbFieldValue
	 *            ：字段值
	 * @param orderBy
	 *            ：排序
	 * @return
	 * @throws Exception
	 *             ：
	 */
	@SuppressWarnings("unchecked")
	public <T> List<Map<String, Object>> getListByFieldName(Class<T> typClass, String dbFieldName, Object dbFieldValue, String orderBy) throws Exception
	{
		try
		{

			String tableName = typClass.getAnnotation(Table.class).name();
			String dBColumnNames = getEntityDBColumnNames(typClass);
			String sql = "SELECT " + dBColumnNames + " FROM " + tableName + " WHERE " + dbFieldName + "= :dbFieldValue";
			if (orderBy != null && !(orderBy.equals("")))
			{
				sql += " ORDER BY " + orderBy;
			}
			SQLQuery query = this.getSession().createSQLQuery(sql);
			query.setParameter("dbFieldValue", dbFieldValue);
			query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			return query.list();

		}
		catch (Exception e)
		{
			throw e;
		}
	}

	private <T> String getEntityDBColumnNames(Class<T> typClass)
	{

		Method[] fields = typClass.getMethods();
		String columName = "";
		for (int i = 0; i < fields.length; i++)
		{
			Annotation[] annotations = fields[i].getAnnotations();
			for (int j = 0; j < annotations.length; j++)
			{
				if (annotations[j] instanceof Column)
				{
					Column column = (Column) annotations[j];
					columName += column.name() + ",";
				}
				else if (annotations[j] instanceof JoinColumn)
				{
					JoinColumn column = (JoinColumn) annotations[j];
					columName += column.name() + ",";
				}

			}
		}
		return columName.equals("") ? "*" : columName.substring(0, columName.length() - 1);

	}

	/**
	 * 
	 * @创建人：强当安
	 * @创建时间：2011-9-29
	 * @功能说明： 根据单个的propertyName和propertyValue模糊查询实体的结果集
	 * @param typClass
	 *            泛型实体的class
	 * @param propertyName
	 *            使用实体中的属性名
	 * @param propertyValue
	 *            查询的值
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> getEntitiesListByLikeProperty(final Class<T> typClass, String propertyName, Object propertyValue) throws Exception
	{
		try
		{
			String primaryKey = this.getPrimaryKey(typClass).replace("_", "");
			final SimpleExpression expression = Restrictions.like(propertyName, "%" + propertyValue + "%");
			if (propertyValue instanceof String && !propertyName.equalsIgnoreCase(primaryKey))
			{
				expression.ignoreCase();
			}
			final Criteria criteria = this.getSession().createCriteria(typClass).add(expression);
			return criteria.list();
		}
		catch (Exception e)
		{
			throw e;
		}
	}

	/**
	 * @功能简介：根据单个的propertyName和propertyValue查询实体的结果集,并根据orderBy进行排序
	 * @应用页面：
	 * @作者姓名：高洪涛、强当安
	 * @创建时间：2014年10月17日 下午6:55:18
	 * @param typClass
	 *            :泛型实体的class
	 * @param propertyName
	 *            :查询条件中的字段,使用实体中的属性名,非数据库字段名
	 * @param propertyValue
	 *            :查询的值
	 * @param orderBy
	 *            :格式 : sbxhId asc——升序 、sbxiId——升序 、sbxhId desc——降序
	 * @return
	 * @throws Exception
	 *             ：
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> getEntitiesListByProperty(final Class<T> typClass, String propertyName, Object propertyValue, String... orderBy) throws Exception
	{
		try
		{
			String primaryKey = this.getPrimaryKey(typClass).replace("_", "");

			final SimpleExpression expression = Restrictions.eq(propertyName, propertyValue);
			if (propertyValue instanceof String && !propertyName.equalsIgnoreCase(primaryKey))
			{
				expression.ignoreCase();
			}
			final Criteria criteria = this.getSession().createCriteria(typClass).add(expression);
			for (String order : orderBy)
			{
				order = order.trim();
				if (order.length() == 0)
				{
					continue;
				}
				String[] orderArr = order.split(" ");
				String keyName = orderArr[0];
				String ascOrDesc = "ASC";
				if (orderArr.length > 1)
				{
					ascOrDesc = orderArr[1];
				}
				if (ascOrDesc.equalsIgnoreCase("ASC"))
				{
					criteria.addOrder(Order.asc(keyName));
				}
				else
				{
					criteria.addOrder(Order.desc(keyName));
				}
			}
			return criteria.list();
		}
		catch (Exception e)
		{
			throw e;
		}
	}

	/**
	 * @功能简介：根据多个属性条件查询List，并根据orderBy排序
	 * @应用页面：
	 * @作者姓名：高洪涛、强当安
	 * @创建时间：2014年10月17日 下午6:58:10
	 * @param typClass
	 *            ：泛型实体的class
	 * @param propertyMap
	 *            ：查询条件的参数，key为实体中的属性名，value要查询的值
	 * @param orderBy
	 *            ：格式 : sbxhId asc——升序 、sbxiId——升序 、sbxhId desc——降序
	 * @return
	 * @throws Exception
	 *             ：
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> getEntitiesListByProperties(final Class<T> typClass, Map<String, Object> propertyMap, String... orderBy) throws Exception
	{
		try
		{
			String primaryKey = this.getPrimaryKey(typClass).replace("_", "");

			final Criteria criteria = this.getSession().createCriteria(typClass);
			if (propertyMap != null && propertyMap.size() > 0)
			{
				for (String key : propertyMap.keySet())
				{
					if (key.trim().length() == 0)
					{
						continue;
					}
					SimpleExpression expression = Restrictions.eq(key, propertyMap.get(key));
					if (propertyMap.get(key) instanceof String && !key.equalsIgnoreCase(primaryKey))
					{
						expression.ignoreCase();
					}
					criteria.add(expression);
				}
			}
			for (String order : orderBy)
			{
				order = order.trim();
				if (order.length() == 0)
				{
					continue;
				}
				String[] orderArr = order.split(" ");
				String keyName = orderArr[0];
				String ascOrDesc = "ASC";
				if (orderArr.length > 1)
				{
					ascOrDesc = orderArr[1];
				}
				if (ascOrDesc.equalsIgnoreCase("ASC"))
				{
					criteria.addOrder(Order.asc(keyName));
				}
				else
				{
					criteria.addOrder(Order.desc(keyName));
				}
			}
			return criteria.list();
		}
		catch (Exception e)
		{
			throw e;
		}
	}

	/**
	 * @功能简介：根据ids 查询列表
	 * @应用页面：
	 * @作者姓名：高洪涛、强当安
	 * @创建时间：2014年10月17日 下午6:59:07
	 * @param typClass
	 *            ：泛型实体的class
	 * @param ids
	 *            ：格式'1222,323232,232323'
	 * @return
	 * @throws Exception
	 *             ：
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> getEntitiesByIds(final Class<T> typClass, String ids) throws Exception
	{
		try
		{
			String primaryKey = this.getPrimaryPropertyName(typClass);
			String[] idArr = ids.split(",");
			final Criteria criteria = this.getSession().createCriteria(typClass);
			criteria.add(Restrictions.in(primaryKey, idArr));
			return criteria.list();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * @功能简介：根据字段多个值获得List
	 * @应用页面：
	 * @作者姓名：高洪涛、强当安
	 * @创建时间：2014年10月17日 下午7:27:07
	 * @param typClass
	 * @param Propertyname
	 * @param PropertyValues
	 * @return
	 * @throws Exception
	 *             ：
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> getEntitiesByProperties(final Class<T> typClass, String Propertyname, String PropertyValues) throws Exception
	{
		try
		{
			String[] idArr = PropertyValues.split(",");
			final Criteria criteria = this.getSession().createCriteria(typClass);
			criteria.add(Restrictions.in(Propertyname, idArr));
			return criteria.list();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * @功能简介：根据指定数据中字段值删除记录,并返回删除的记录条数
	 * @应用页面：
	 * @作者姓名：高洪涛、强当安
	 * @创建时间：2014年10月17日 下午7:16:14
	 * @param typClass
	 * @param fieldName
	 *            ：数据库字段名称
	 * @param fieldValue
	 *            ：数据库中字段值
	 * @return
	 * @throws Exception
	 *             ：
	 */
	public <T> int deleteByDBFieldReturnRowsSize(Class<T> typClass, String fieldName, Object fieldValue) throws Exception
	{
		int resultValue = 0;
		try
		{
			String tableName = typClass.getAnnotation(Table.class).name();
			//String primaryKey = this.getPrimaryKey(typClass);
			//String valueClassName = fieldValue.getClass().getName();
			String sql = "DELETE FROM " + tableName + " WHERE " + fieldName + " = :filedValue";
			SQLQuery query = this.getSession().createSQLQuery(sql);
			query.setParameter("filedValue", fieldValue);
			resultValue = query.executeUpdate();
		}
		catch (Exception e)
		{
			resultValue = 0;
			throw e;
		}
		return resultValue;
	}

	/**
	 * @功能简介：根据指定数据中字段值删除记录,并返回是否删除成功
	 * @应用页面：
	 * @作者姓名：高洪涛、强当安
	 * @创建时间：2014年10月17日 下午7:32:11
	 * @param typClass
	 * @param fieldName
	 *            ：数据库字段名称
	 * @param fieldValue
	 *            ：数据库中字段值
	 * @return
	 * @throws Exception
	 *             ：
	 */
	public <T> boolean deleteByDBField(Class<T> typClass, String fieldName, Object fieldValue) throws Exception
	{
		return this.deleteByDBFieldReturnRowsSize(typClass, fieldName, fieldValue) > 0;
	}

	/**
	 * @功能简介：根据指定数据中字段值删除记录,并返回删除的记录条数
	 * @应用页面：
	 * @作者姓名：高洪涛、强当安
	 * @创建时间：2014年10月17日 下午7:23:51
	 * @param typClass
	 * @param fieldName
	 * @param fieldValues
	 * @return
	 * @throws Exception
	 *             ：
	 */
	public <T> int deleteAllByDBFieldReturnRowsSize(Class<T> typClass, String fieldName, String fieldValues) throws Exception
	{
		int resultValue = 0;
		try
		{
			if (fieldValues == null)
			{
				throw new MyException(typClass, "传值参数错误：fieldValues");
			}
			String tableName = typClass.getAnnotation(Table.class).name();
			String primaryKey = this.getPrimaryKey(typClass);
			String[] valueArr = fieldValues.split(",");
			String idStr = "";

			String prefixStr = "";
			String suffixStr = "";
			if (fieldName.equalsIgnoreCase(primaryKey))
			{
				prefixStr = "LOWER(";
				suffixStr = ")";
			}

			for (String id : valueArr)
			{
				if (id.trim().length() == 0)
				{
					continue;
				}
				idStr += prefixStr + "'" + id + "'" + suffixStr + ",";
			}
			if (idStr.length() > 0)
			{
				idStr = idStr.substring(0, idStr.length() - 1);
			}

			final String sql = "DELETE FROM " + tableName + " WHERE " + prefixStr + fieldName + suffixStr + " in (" + idStr + ")";
			final SQLQuery query = this.getSession().createSQLQuery(sql);
			resultValue = query.executeUpdate();
		}
		catch (Exception e)
		{
			resultValue = 0;
			e.printStackTrace();
			throw e;
		}
		return resultValue;
	}

	/**
	 * @功能简介：根据指定数据中字段值删除记录,并返回是否删除成功
	 * @应用页面：
	 * @作者姓名：高洪涛、强当安
	 * @创建时间：2014年10月17日 下午7:39:42
	 * @param typClass
	 * @param fieldName
	 * @param fieldValues
	 * @return
	 * @throws Exception
	 *             ：
	 */
	public <T> boolean deleteAllByDBField(Class<T> typClass, String fieldName, String fieldValues) throws Exception
	{
		return deleteAllByDBFieldReturnRowsSize(typClass, fieldName, fieldValues) > 0;
	}

	/**
	 * @功能简介：根据主键批量删除,通过IN，返回删除记录数
	 * @应用页面：
	 * @作者姓名：高洪涛、强当安
	 * @创建时间：2014年10月17日 下午7:47:07
	 * @param typClass
	 *            ：实体类的class
	 * @param primaryKeyValues
	 *            ：主键 格式如a,b,c
	 * @return
	 * @throws Exception
	 *             ：
	 */
	public <T> int deleteByPrimaryKeyReturnRowSize(Class<T> typClass, String primaryKeyValues) throws Exception
	{
		int resultValue = 0;
		try
		{
			String[] keyArr = primaryKeyValues.split(",");
			String key = "";
			for (String string : keyArr)
			{
				key += "'" + string + "',";
			}
			key += "'-1'";

			String tableName = typClass.getAnnotation(Table.class).name();
			String primaryKey = this.getPrimaryKey(typClass);
			final String sql = "DELETE FROM " + tableName + " WHERE " + primaryKey + " in (" + key + ")";

			SQLQuery query = this.getSession().createSQLQuery(sql);
			resultValue = query.executeUpdate();

		}
		catch (Exception e)
		{
			resultValue = 0;
			e.printStackTrace();
			throw e;
		}
		return resultValue;
	}

	/**
	 * @功能简介：根据主键批量删除,通过IN，返回是否成功
	 * @应用页面：
	 * @作者姓名：高洪涛、强当安
	 * @创建时间：2014年10月17日 下午7:47:59
	 * @param typClass
	 * @param primaryKeyValues
	 *            ：主键值
	 * @return
	 * @throws Exception
	 *             ：
	 */
	public <T> boolean deleteByPrimaryKey(Class<T> typClass, String primaryKeyValues) throws Exception
	{
		return deleteByPrimaryKeyReturnRowSize(typClass, primaryKeyValues) > 0;
	}

	/**
	 * @功能简介：根据指定数据库字段和字段值，判断这个值是否存在
	 * @应用页面：
	 * @作者姓名：高洪涛、强当安
	 * @创建时间：2014年10月17日 下午8:00:22
	 * @param typClass
	 *            ：数据表对应的H实体
	 * @param fieldName
	 *            ：数据库中字段
	 * @param fieldValue
	 *            ：数据库字段值
	 * @return
	 * @throws Exception
	 *             ：
	 */
	public <T> boolean validateIsExist(Class<T> typClass, String dbFieldName, String dbFieldValue) throws Exception
	{
		boolean isExist = false;
		try
		{
			String tableName = typClass.getAnnotation(Table.class).name();
			String primaryKey = this.getPrimaryKey(typClass);
			String sql = "SELECT COUNT(" + primaryKey + ") AS NUM FROM " + tableName + " WHERE " + dbFieldName + "= :key";
			SQLQuery query = this.getSession().createSQLQuery(sql);
			query.setParameter("key", dbFieldValue);
			int flag = DataSwitch.convertObjectToInteger(query.uniqueResult());
			if (flag > 0)
			{
				isExist = true;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		return isExist;
	}

	/**
	 * @功能简介：根据指定数据库字段和字段值，判断这个值是否存在
	 * @应用页面：
	 * @作者姓名：高洪涛、强当安
	 * @创建时间：2014年10月17日 下午8:03:06
	 * @param typeClass
	 *            ：数据表对应的H实体
	 * @param fieldMap
	 *            ：多个字段Map
	 * @return
	 * @throws Exception
	 *             ：
	 */
	public <T> boolean validateIsExist(Class<T> typeClass, Map<String, Object> fieldMap) throws Exception
	{
		boolean isExist = false;

		try
		{
			String tableName = typeClass.getAnnotation(Table.class).name();
			String primaryKey = this.getPrimaryKey(typeClass);
			StringBuffer sbSql = new StringBuffer();
			sbSql.append("SELECT COUNT(" + primaryKey + ") AS NUM FROM " + tableName + " WHERE 1 = 1 ");

			if (fieldMap == null || fieldMap.size() == 0)
			{
				throw new Exception("条件Map为空！");
			}
			for (String key : fieldMap.keySet())
			{
				String valueClassName = fieldMap.get(key).getClass().getName();
				sbSql.append(" AND ");
				if (valueClassName.contains("String") && !key.toLowerCase().equals(primaryKey.toLowerCase()))
				{
					if (fieldMap.get(key) == "" || fieldMap.get(key) == null)
					{
						sbSql.append(key);
						sbSql.append(" IS NULL");
					}
					else
					{
						sbSql.append(" LOWER(");
						sbSql.append(key);
						sbSql.append(") =");
						sbSql.append("  LOWER(:" + key + ")");
					}

				}
				else
				{
					sbSql.append(key);
					sbSql.append(" = :" + key);
				}
			}
			SQLQuery query = this.getSession().createSQLQuery(sbSql.toString());
			for (String key : fieldMap.keySet())
			{
				if (fieldMap.get(key) == "" || fieldMap.get(key) == null)
				{
					continue;
				}
				else
				{
					query.setParameter(key, fieldMap.get(key));
				}
			}

			int flag = DataSwitch.convertObjectToInteger(query.uniqueResult());

			if (flag > 0)
			{
				isExist = true;
			}
		}
		catch (Exception e)
		{
			new MyException(e, this.getClass(), "验证多个字段是否存在失败,方法：isExist");
			throw e;
		}
		return isExist;
	}

	/**
	 * @功能简介：分页查询，返回Pager分页对象
	 * @应用页面：
	 * @作者姓名：高洪涛、强当安
	 * @创建时间：2014年10月20日 下午12:04:22
	 * @param sql
	 *            ：查询的Sql语句
	 * @param parasMaps
	 *            ：参数
	 * @param findEntity
	 *            ：查询实体
	 * @return
	 * @throws Exception
	 *             ：
	 */
	public Pager getListBySQLQuery(final String sql, Map<String, Object> parasMaps, BaseFindEntity findEntity) throws Exception
	{
		Pager pager = new Pager();
		try
		{
			String isFenYe = findEntity.getIsFenYe();
			if (isFenYe.equals(ShiFouEnum.SHI))
			{

				SQLQuery query = this.getSession().createSQLQuery(sql);
				query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
				if (parasMaps != null)
				{
					Iterator<String> keySet = parasMaps.keySet().iterator();
					while (keySet.hasNext())
					{
						String key = keySet.next();
						if (sql.contains(":" + key))
						{
							query.setParameter(key, parasMaps.get(key));
						}
					}
				}
				int pageSize = findEntity.getPageSize();
				query.setMaxResults(pageSize);
				pager.setPageSize(pageSize);

				/*int page = findEntity.getPage();
				pager.setPageNo(page);
				query.setFirstResult((page - 1) * pageSize);*/
				
				int page = findEntity.getPageNum();
				pager.setPageNo(page);
				query.setFirstResult((page - 1) * pageSize);
				
				@SuppressWarnings("rawtypes")
				List resultList = query.list();
				Integer totalCount = getTotalCount(sql, parasMaps);

				pager.setRows(resultList);
				pager.setTotal(totalCount);
			}
			else
			{
				pager.setRows(getList(sql, parasMaps));
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		return pager;
	}

	/**
	 * @功能简介：根据查询条件或得查询结果的记录数
	 * @应用页面：
	 * @作者姓名：高洪涛、强当安
	 * @创建时间：2014年10月20日 下午12:06:24
	 * @param sql
	 * @param map
	 * @return
	 * @throws Exception
	 *             ：
	 */
	public Integer getTotalCount(String sql, Map<String, Object> map) throws Exception
	{
		try
		{
			String lowerSql = sql.toLowerCase();
			sql = "select count(1) " + sql.substring(lowerSql.indexOf("from"));
			SQLQuery query = this.getSession().createSQLQuery(sql);
			if (map != null)
			{
				Iterator<String> it = map.keySet().iterator();
				while (it.hasNext())
				{
					String oldkey = it.next();
					if (sql.contains(":" + oldkey))
					{
						query.setParameter(oldkey, map.get(oldkey));
					}
				}
			}
			List list =query.list();//汪旭 2015-02-26 如果没有结果集时List.get(0) 索引越界
			Integer i = DataSwitch.convertObjectToInteger(list.size()>0?list.get(0):0);
			return i;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw e;
		}

	}

	/**
	 * @功能简介：不根据分页查询数据库记录数
	 * @应用页面：
	 * @作者姓名：高洪涛、强当安
	 * @创建时间：2014年10月20日 下午12:06:49
	 * @param sql
	 *            ：查询Sql
	 * @param parasMaps
	 *            ：查询条件
	 * @return
	 * @throws Exception
	 *             ：
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getList(final String sql, Map<String, Object> parasMaps) throws Exception
	{
		try
		{
			final SQLQuery query = this.getSession().createSQLQuery(sql);
			query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			if (parasMaps != null)
			{
				Iterator<String> keySet = parasMaps.keySet().iterator();
				while (keySet.hasNext())
				{
					String key = keySet.next();
					if (sql.contains(":" + key))
					{
						query.setParameter(key, parasMaps.get(key));
					}
				}
			}
			List resultList = query.list();
			return resultList;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * @功能简介：返回指定条数的数据库记录
	 * @应用页面：
	 * @作者姓名：高洪涛、强当安
	 * @创建时间：2014年10月20日 下午12:09:33
	 * @param sql
	 *            ：查询SQL
	 * @param parasMaps
	 *            ：参数
	 * @param size
	 *            ：指定条数
	 * @return
	 * @throws Exception
	 *             ：
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getList(final String sql, Map<String, Object> parasMaps, int size) throws Exception
	{
		try
		{
			SQLQuery query = this.getSession().createSQLQuery(sql);
			query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			if (parasMaps != null)
			{
				Iterator<String> keySet = parasMaps.keySet().iterator();
				while (keySet.hasNext())
				{
					String key = keySet.next();
					if (sql.contains(":" + key))
					{
						query.setParameter(key, parasMaps.get(key));
					}
				}
			}
			int pageSize = size;
			query.setMaxResults(pageSize);
			int page = 0;
			query.setFirstResult(page);
			List resultList = query.list();
			return resultList;
		}
		catch (Exception e)
		{
			throw e;
		}
	}

	/**
	 * @功能简介：当你确定你要检索的数据结果只有一条记录时，用这个方法会提高效率
	 * @应用页面：
	 * @作者姓名：高洪涛、强当安
	 * @创建时间：2014年10月20日 下午12:14:28
	 * @param sql
	 *            ：略
	 * @param parasMaps
	 *            ：略
	 * @return
	 * @throws Exception
	 *             ：
	 */
	public Map<String, Object> getFirstRecord(final String sql, Map<String, Object> parasMaps) throws Exception
	{
		try
		{
			final SQLQuery query = this.getSession().createSQLQuery(sql);
			query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			if (parasMaps != null)
			{
				Iterator<String> keySet = parasMaps.keySet().iterator();
				while (keySet.hasNext())
				{
					String key = keySet.next();
					if (sql.contains(":" + key))
					{
						query.setParameter(key, parasMaps.get(key));
					}
				}
			}
			@SuppressWarnings("unchecked")
			Map<String, Object> resultMap = (Map<String, Object>) query.uniqueResult();
			return resultMap;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * @功能简介：根据查询参数删除数据库记录
	 * @应用页面：
	 * @作者姓名：高洪涛、强当安
	 * @创建时间：2014年10月20日 下午1:14:57
	 * @param sql
	 *            ：删除Sql
	 * @param parasMaps
	 *            ：参数
	 * @return
	 * @throws Exception
	 *             ：
	 */
	public boolean deleteByParas(final String sql, Map<String, Object> parasMaps) throws Exception
	{
		boolean result = false;
		try
		{
			final SQLQuery query = this.getSession().createSQLQuery(sql);
			if (parasMaps != null && parasMaps.size() > 0)
			{
				Iterator<String> keySet = parasMaps.keySet().iterator();
				while (keySet.hasNext())
				{
					String key = keySet.next();
					if (sql.contains(":" + key))
					{
						query.setParameter(key, parasMaps.get(key));
					}
				}
			}
			int flag = query.executeUpdate();
			if (flag >= 0)
			{
				result = true;
			}

		}
		catch (Exception e)
		{
			throw e;
		}
		return result;
	}

	/**
	 * @功能简介：根据Hibernate生成的实体获取表名称，并根据数据库的字段名称、值删除数据库记录
	 * @应用页面：
	 * @作者姓名：高洪涛、强当安
	 * @创建时间：2014年10月20日 下午1:42:42
	 * @param typClass
	 *            ：实体的getClass()
	 * @param fieldName
	 *            ：数据库字段名称
	 * @param fieldValue
	 *            ：字段的值
	 * @return
	 * @throws Exception
	 *             ：
	 */
	public <T> int deleteByParas(Class<T> typClass, String dbFieldName, Object dbFieldValue) throws Exception
	{
		int flag = 0;
		try
		{
			String tableName = typClass.getAnnotation(Table.class).name();
			String sql = "DELETE FROM " + tableName + " WHERE " + dbFieldName + " = '" + dbFieldValue + "'";
			SQLQuery query = this.getSession().createSQLQuery(sql);
			flag = query.executeUpdate();
		}
		catch (Exception e)
		{
			throw e;
		}
		return flag;
	}

	/**
	 * @功能简介：调用存储过程，返回执行结果
	 * @应用页面：
	 * @作者姓名：高洪涛、强当安
	 * @创建时间：2014年10月20日 下午1:34:43
	 * @param callSql
	 *            存储过程sql
	 * @param listParams
	 *            存储过程的调用参数
	 * @param listOutParams
	 *            存储过程的输出参数
	 * @return
	 * @throws Exception
	 *             ：
	 */
	public Object getObjectByCall(final String callSql, List<Object> listParams, List<Object> listOutParams) throws Exception
	{
		try
		{
			CallableStatement cs = (CallableStatement) getSessionConnection().prepareCall(callSql);

			if (listParams != null && listParams.size() > 0)
			{
				for (int i = 0; i < listParams.size(); i++)
				{
					Object param = listParams.get(i);
					cs.setObject(i + 1, param);
				}
			}
			if (listOutParams != null && listOutParams.size() > 0)
			{
				for (int j = 0; j < listOutParams.size(); j++)
				{
					int sqlType = DataSwitch.convertObjectToInteger(listOutParams.get(j));
					cs.registerOutParameter(listParams.size() + j + 1, sqlType);
				}
			}
			cs.execute();
			return cs.getObject(listParams.size() + 1);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * @功能简介：获取数据库链接sessionConnection
	 * @应用页面：
	 * @作者姓名：高洪涛、强当安
	 * @创建时间：2014年10月20日 下午1:33:02
	 * @return：
	 */
	public Connection getSessionConnection()
	{
		try
		{
			Session session = getSession();
			Method connectionMethod = session.getClass().getMethod("connection");
			return (Connection) ReflectionUtils.invokeMethod(connectionMethod, session);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;

	}

}
