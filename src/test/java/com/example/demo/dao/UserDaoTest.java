package com.example.demo.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.UserEntity;

@SpringBootTest
class UserDaoTest {

	@Autowired
	UserDao userDao;

	@Test
	public void save() {
		try {
			UserEntity user = new UserEntity();
			user.setName("username");
			user.setCrDateTime(LocalDateTime.now());
			user.setCrUser("cruser");
			Integer id = userDao.save(user);
			System.out.println("新增成功:id為" + id);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Test
	public void listAuthority() {

		try {
			List<UserEntity> userList = userDao.listUser();
			System.out.println(userList.toString());
		} catch (Exception e) {
			System.out.println("空值或不存在資料");
			System.out.println(e);
		}
	}

	@Test
	public void findByAuthorityId() {
		try {
			int id = 1;
			UserEntity userEntity = userDao.findByUserId(id);
			System.out.println(userEntity.toString());
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Test
	public void updateAuthority() {
		try {
			UserEntity user = new UserEntity();
			user.setId(1);
			user.setName("newname");
			user.setUpDateTime(LocalDateTime.now());
			user.setUpUser("upuser");
			Integer result = userDao.updateUser(user);
			System.out.println("更新成功:id為" + result);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
