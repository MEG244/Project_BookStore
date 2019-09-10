package bsmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bookstore.controller.CompositeDao;
import bookstore.model.BookStoreDao;
import bsmall.cart.ShoppingInfo;

@Controller
public class DetailViewController {
	
	private static final String command = "/detailview.bsmall";
	private static final String getPage = "ShopResult";
	
	@Autowired
	private BookStoreDao bookStoreDao;
	
	@Autowired
	private CompositeDao compositeDao;
	
	
	@RequestMapping(value=command)
	public String doAction(@RequestParam(value="pmkey",required=true) int pmkey,Model model) {
		
		List<ShoppingInfo> lists = compositeDao.showDetail(pmkey);
		model.addAttribute("lists", lists);
		model.addAttribute("pmkey", pmkey);
		
		return getPage;
	}


}
