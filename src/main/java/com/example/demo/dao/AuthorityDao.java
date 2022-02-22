package com.example.demo.dao;

import java.util.List;
import com.example.demo.entity.AuthorityEntity;

public interface AuthorityDao {

	//新增
	public Integer insert(AuthorityEntity authority);
	
	//查詢列表
	public List<AuthorityEntity> listAuthority();
	
	//查詢單一
	public AuthorityEntity findByAuthorityId(int id);
	
	//更新
	public int updateAuthority(AuthorityEntity authority);
	
	//刪除
	public void deleteAuthority(int id);
}

