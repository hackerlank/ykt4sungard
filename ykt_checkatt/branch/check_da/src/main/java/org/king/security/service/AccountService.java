/* ============================================================
 * 版权：    king 版权所有 (c) 2006
 * 文件：    org.king.framework.service.AccountService.java
 * 创建日期： 2006-4-18 14:06:10
 * 功能：    {具体要实现的功能}
 * 所含类:   {包含的类}
 * 修改记录：
 * 日期                    作者         内容
 * =============================================================
 * 2006-4-18 14:06:10      ljf        创建文件，实现基本功能
 * ============================================================
 */

/**
 * 
 */
package org.king.security.service;

import java.io.Serializable;
import java.util.List;

import org.king.security.domain.Account;
import org.king.security.exception.AccountAlreadyExistException;
import org.king.check.domain.Toperlimit;
import org.king.framework.exception.BusinessException;
import org.king.framework.service.Service;

/**
 * <p> AccountService.java </p>
 * <p> {功能说明} </p>
 *
 * <p><a href="AccountService.java.html"><i>查看源代码</i></a></p>  
 *
 * @author <a href="mailto:m_ljf@msn.com">ljf</a>
 * @version 0.1
 * @since 2006-4-18
 * 
 *
 */
public interface AccountService extends Service{

	/**
	 * 通过id查找帐户
	 * @param id
	 * @return
	 */
	public Account findAccountById(Serializable id);
	
	/**
	 * 通过帐户名得到帐户
	 * @param name
	 * @return
	 * @throws BusinessException
	 */
	public Account findAccountByName(String name) throws BusinessException;
	
	/**
	 * 得到所有帐户
	 * @return
	 * @throws BusinessException
	 */
	public List findAllAccount() throws BusinessException;
	
	/**
	 * 不同查询条件查询帐户
	 * @param args
	 * @return
	 * @throws BusinessException
	 */
	public List findAccount(String[] args) throws BusinessException;
	
	/**
	 * 保存帐户
	 * @param account
	 * @throws BusinessException
	 * @throws AccountAlreadyExistException
	 */
	public void saveAccount(Account account) throws BusinessException,AccountAlreadyExistException;
	
	/**
	 * 更新帐户
	 * @param account
	 * @throws BusinessException
	 */
	public void updateAccount(Account account) throws BusinessException;

	/**
	 * 删除帐户
	 * @param id
	 * @throws BusinessException
	 */
	public void deleteAccount(Serializable id) throws BusinessException;
	
	/**
	 * 批量删除帐户
	 * @param ids
	 * @throws BusinessException
	 */
	public void deleteAccount(Serializable[] ids) throws BusinessException;
	
    /**
     * 得到帐户数
     * @param args
     * @return
     */
	public Integer getAccountCount(final String[] args);
	
	/**
	 * 保存用户权限信息
	 * @param operlimit
	 * @throws BusinessException
	 */
	public void saveAccountLimit(Toperlimit operlimit)throws BusinessException;
	
	
	/**
	 * 更新用户权限信息
	 * @param operlimit
	 * @throws BusinessException
	 */
	public void updateAccountLimit(Toperlimit operlimit)throws BusinessException;
	
	
	/**
	 * 根据部门编号和操作员编号取得权限信息
	 * @param deptId
	 * @param operId
	 * @return
	 */
	public List getAccountLimit(String deptId,String operId); 
	
	
	/**
	 * 删除权限信息
	 * @param accountId
	 */
	public void deleteAccountLimit(String accountId);
	
	/**
	 * 批量删除权限信息
	 * @param ids
	 */
	public void deleteAccountLimitIds(String[] ids);
	
	/**
	 * 删除用户角色
	 * @param ids
	 */
	public void deleteAccountRole(String[] ids);
	
	/**
	 * 保存用户角色信息
	 * @param accrole
	 */
	//public void saveAccountRole(AccRole accrole);
	
	/**
	 * 更新用户角色信息
	 */
	//public void updateAccountRole(AccRole accrole);
	
	/**
	 * 查找用户角色信息
	 * @param accId
	 * @param roleId
	 * @return
	 */
	public List findAccountRole(String accId,String roleId);

    public boolean isTeacher(Account account);
}
