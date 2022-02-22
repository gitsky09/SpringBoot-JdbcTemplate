package com.example.demo.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.AuthorityEntity;

@SpringBootTest
class AuthorityDaoTest {

	@Autowired
	AuthorityDao authorityDao;

	@Test
	public void insert() {
		try {
			AuthorityEntity authority = new AuthorityEntity();
			authority.setId(1);
			authority.setName("authority");
			authority.setCrDateTime(LocalDateTime.now());
			authority.setCrUser("cruser");
			Integer id = authorityDao.insert(authority);
			System.out.println("新增成功:id為" + id);
		} catch (Exception e) {
			System.out.println("新增失敗");
			System.out.println(e);
		}
	}

	@Test
	public void listAuthority() {
		List<AuthorityEntity> authList = authorityDao.listAuthority();

		if (authList != null)
			System.out.println(authList.toString());
		else
			System.out.println("空值或不存在資料");

	}

	@Test
	public void findByAuthorityId() {
		int id = 1;
		AuthorityEntity authority = authorityDao.findByAuthorityId(id);

		if (authority != null)
			System.out.println(authority.toString());
		else
			System.out.println("空值或不存在資料");

	}

	@Test
	public void updateAuthority() {
		try {

			AuthorityEntity authority = new AuthorityEntity();
			authority.setId(1);
			authority.setName("newname");
			authority.setUpDateTime(LocalDateTime.now());
			authority.setUpUser("upuser");
			Integer result = authorityDao.updateAuthority(authority);
			System.out.println("更新成功:id為" + result);
		} catch (Exception e) {
			System.out.println("更新失敗");
			System.out.println(e);
		}
	}

}
