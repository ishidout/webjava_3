  package jp.co.systena.tigerscave.shoppingdb.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;

@Controller
  public class ListController {

@Autowired
JdbcTemplate jdbcTemplate;

}