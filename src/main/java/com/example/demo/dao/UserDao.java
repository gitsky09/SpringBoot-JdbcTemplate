package com.example.demo.dao;

import java.util.List;
import com.example.demo.entity.UserEntity;


public interface UserDao {

	// 新增
	public Integer save(UserEntity user);

	// 查詢列表
	public List<UserEntity> listUser();

	// 查詢單一
	public UserEntity findByUserId(int id);

	// 更新
	public Integer updateUser(UserEntity user);

}