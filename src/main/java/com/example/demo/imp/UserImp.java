package com.example.demo.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.UserEntity;


@Repository
public class UserImp implements UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private NamedParameterJdbcTemplate jdbcNameTemplate;

	@Override
	public Integer save(UserEntity user) {

		String sql = " INSERT INTO deploy_users ( "
					+ "		NAME, ACCOUNT, PASSWORD, "
					+ "		CREATE_TIME, CREATE_USER "
					+ " ) "
					+ " VALUES ( "
					+ "		:name, :account, :password, "
					+ "		:crDateTime, :crUser "
					+ " ) ";

		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(user);
		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcNameTemplate.update(sql, paramSource, keyHolder);
		return keyHolder.getKey().intValue();
	}

	@Override
	public List<UserEntity> listUser() {
		String sql = " SELECT "
					+ 		" NAME, ACCOUNT , PASSWORD "
					+ " FROM "
					+ 		" deploy_users "
					+ " ORDER BY "
					+ " 	ID ";
		
		List<UserEntity> result = jdbcTemplate.query(sql, new BeanPropertyRowMapper<UserEntity>(UserEntity.class));
		if (result != null && result.size() > 0)
			return result;

		return null;
	}

	@Override
	public UserEntity findByUserId(int id) {

		String sql = " SELECT "
					+ "		NAME, ACCOUNT, PASSWORD "
					+ " FROM "
					+ "		deploy_users "
					+ " WHERE "
					+ "		ID = ? ";

		List<UserEntity> result = jdbcTemplate.query(sql, new BeanPropertyRowMapper<UserEntity>(UserEntity.class),
				new Object[] { id });
		if (result != null && result.size() > 0) {
			return result.get(0);
		}
		return null;
	}

	@Override
	public Integer updateUser(UserEntity user) {
		
		String sql = "UPDATE deploy_Users "
				+ " SET NAME = :name, ACCOUNT = :account, PASSWORD = :password ,"
				+ " UPDATE_TIME = :upDateTime , UPDATE_USER = :upUser "
				+ " WHERE ID = :id ";
		
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(user);
		
		return jdbcNameTemplate.update(sql, paramSource);
	}


}
