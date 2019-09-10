package bsmall.controller;

import java.lang.reflect.Member;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import order.model.Order;
import order.model.OrderDao;


@Controller
public class OrderMallController {
	private static final String command = "/order.bsmall";
	private static final String getPage = "ShopList";
	
	@Autowired
	@Qualifier("myOrderDao")
	private OrderDao orderDao;
	
	@RequestMapping(value=command)
	public String doAction(HttpSession session, Model model) {
		
		Member loginfo = (Member)session.getAttribute("loginfo");
		if(loginfo == null) {
			session.setAttribute("destination", "redirect:/order.bsmall" );
			return "redirect:/login.bm" ;
		}
		else {
			List<Order> lists = orderDao.OrderMall(loginfo.getName());
			model.addAttribute("lists",lists);
			
			return getPage;
		}
	}
}
