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

import com.example.demo.dao.GroupDao;
import com.example.demo.entity.GroupEntity;

@Repository
public class GroupImp implements GroupDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private NamedParameterJdbcTemplate jdbcNameTemplate;

	@Override
	public Integer insert(GroupEntity group) {
		String sql = " INSERT INTO deploy_groups ( " 
				+ "		NAME, "
				+ "		CREATE_TIME, CREATE_USER " + " ) "
				+ " VALUES ( "
				+ "		:name, "
				+ "		:crDateTime, :crUser " + " ) ";

		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(group);
		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcNameTemplate.update(sql, paramSource, keyHolder);
		return keyHolder.getKey().intValue();
	}

	@Override
	public List<GroupEntity> listGroup() {
		String sql = " SELECT " + " 	NAME " + " FROM " + " 	deploy_groups" + " ORDER BY " + " 	ID ";

		List<GroupEntity> result = jdbcTemplate.query(sql, new BeanPropertyRowMapper<GroupEntity>(GroupEntity.class));
		if (result != null && result.size() > 0)
			return result;

		return null;
	}

	@Override
	public GroupEntity findByGroupId(int id) {
		String sql = "SELECT NAME FROM deploy_groups WHERE ID=?";
		List<GroupEntity> result = jdbcTemplate.query(sql, new BeanPropertyRowMapper<GroupEntity>(GroupEntity.class),
				new Object[] { id });
		if (result != null && result.size() > 0) {
			return result.get(0);
		}
		return null;
	}

	@Override
	public int updateGroup(GroupEntity group) {
		String sql = " UPDATE deploy_groups " + " SET NAME = :name, UPDATE_USER = :upUser, UPDATE_TIME = :upDateTime "
				+ " WHERE ID = :id ";

		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(group);

		return jdbcNameTemplate.update(sql, paramSource);
	}

	@Override
	public void deleteGroup(int id) {
		String sql = " DELETE " + "		deploy_groups " + " WHERE " + "		ID = :id ";

		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(id);
		jdbcNameTemplate.update(sql, paramSource);
	}
}
