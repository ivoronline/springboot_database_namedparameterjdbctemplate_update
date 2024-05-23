package com.ivoronline.springboot_database_namedparameterjdbctemplate_update.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

@Service
public class MyService {

  //PROPERTIES
  @Autowired private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  //=========================================================================================================
  // UPDATE
  //=========================================================================================================
  public int update(String newName, String oldName, Integer age) {

    String sql = "UPDATE PERSON SET NAME = :newName WHERE name = :oldName AND age = :age";

    SqlParameterSource parameters = new MapSqlParameterSource()
      .addValue("newName", newName)
      .addValue("oldName", oldName)
      .addValue("age"    , age    );

    return namedParameterJdbcTemplate.update(sql, parameters);

  }

}
