package com.example.demo.dao;

import java.util.List;
import com.example.demo.entity.GroupEntity;

public interface GroupDao {

	// 新增
	public Integer insert(GroupEntity group);

	// 查詢列表
	public List<GroupEntity> listGroup();

	// 查詢單一
	public GroupEntity findByGroupId(int id);

	// 更新
	public int updateGroup(GroupEntity user);

	// 刪除
	public void deleteGroup(int id);
}
