package jp.co.systena.tigerscave.shoppingdb.application.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import jp.co.systena.tigerscave.shoppingdb.application.model.Cart;
import jp.co.systena.tigerscave.shoppingdb.application.model.Item;


@Controller
public class ItemListController {

  @Autowired
  JdbcTemplate jdbcTemplate;

  @RequestMapping(value = "/itemlist", method = RequestMethod.GET)
  public String index(Model model) {

    model.addAttribute("items", getItemList());

    return "itemlist";
  }
  private List<Item> getItemList() {
    List<Item> list = jdbcTemplate.query("SELECT item_name,price FROM items ORDER BY item_id", new BeanPropertyRowMapper<Item>(Item.class));

    return list;


  }

  private List<Cart> getCart(){
    List<Cart> list = jdbcTemplate.query("SELECT * FROM cart WHERE customer_id='1' ORDER BY cart_number", new BeanPropertyRowMapper<Cart>(Cart.class));

    return list;
  }
}

