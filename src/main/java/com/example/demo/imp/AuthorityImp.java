package com.example.demo.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.AuthorityDao;
import com.example.demo.entity.AuthorityEntity;


@Repository
public class AuthorityImp implements AuthorityDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private NamedParameterJdbcTemplate jdbcNameTemplate;

	@Override
	public Integer insert(AuthorityEntity authority) {
		
		String sql = " INSERT deploy_authority ( NAME, CREATE_TIME, CREATE_USER)VALUES( :name, :crDateTime, :crUser) ";
		
	SqlParameterSource paramSource = new BeanPropertySqlParameterSource(authority);
	return jdbcNameTemplate.update(sql, paramSource);
}

	@Override
	public List<AuthorityEntity> listAuthority() {
		String sql = " SELECT "
					+ " 	NAME "
					+ " FROM "
					+ "		deploy_authority"
					+ " ORDER BY "
					+ " 	ID ";

		List<AuthorityEntity> result = jdbcTemplate.query(sql,
				new BeanPropertyRowMapper<AuthorityEntity>(AuthorityEntity.class));
		if (result != null && result.size() > 0)
			return result;

		return null;
	}

	@Override
	public AuthorityEntity findByAuthorityId(int id) {
		String sql = " SELECT NAME FROM deploy_authority WHERE ID = ? ";
		List<AuthorityEntity> result = jdbcTemplate.query(sql,
				new BeanPropertyRowMapper<AuthorityEntity>(AuthorityEntity.class), new Object[] { id });
		if (result != null && result.size() > 0) {
			return result.get(0);
		}
		return null;
	}

	@Override
	public int updateAuthority(AuthorityEntity authority) {
		String sql = " UPDATE deploy_authority "
					+ " SET NAME = :name, UPDATE_TIME = :upDateTime ,UPDATE_USER = :upUser"
					+ " WHERE ID = :id ";

		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(authority);
		
		return jdbcNameTemplate.update(sql, paramSource);
	}

	@Override
	public void deleteAuthority(int id) {

		String sql = " DELETE "
				+ "			deploy_authority "
				+ " 	WHERE "
				+ "			ID = :id ";

		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(id);
		jdbcNameTemplate.update(sql, paramSource);
	}


}
