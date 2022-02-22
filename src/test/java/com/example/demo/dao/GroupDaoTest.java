package com.example.demo.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.GroupEntity;

@SpringBootTest
class GroupDaoTest {

	@Autowired
	GroupDao groupDao;

	@Test
	public void insert() {
		try {
			GroupEntity groupEntity = new GroupEntity();
			groupEntity.setName("groupname");
			groupEntity.setCrDateTime(LocalDateTime.now());
			groupEntity.setCrUser("cruser");
			
			Integer id = groupDao.insert(groupEntity);

			System.out.println("新增成功:id為"+id);
		} catch (Exception e) {
			System.out.println("新增失敗");
			System.out.println(e);
		}

	}

	@Test
	public void listGroup() {
		try {
			List<GroupEntity> groupList = groupDao.listGroup();
			System.out.println(groupList.toString());
		} catch (Exception e) {
			System.out.println("空值或不存在資料");
		}

	}

	@Test
	public void findByGroupId() {
		try {
			int id = 1;
			GroupEntity groupEntity = groupDao.findByGroupId(id);

			System.out.println(groupEntity.toString());
		} catch (Exception e) {
			System.out.println("空值或不存在資料");
		}
	}

	@Test
	public void updateGroup() {
		try {
			
			GroupEntity group = new GroupEntity();
			group.setId(1);
			group.setName("newname");
			group.setUpDateTime(LocalDateTime.now());
			group.setUpUser("upuser");
			Integer result = groupDao.updateGroup(group);
			System.out.println("更新成功:id為" + result);
		} catch (Exception e) {
			System.out.println("更新失敗");
			System.out.println(e);
		}
	}
	
	
}
