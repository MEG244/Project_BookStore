package bsmall.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bookstore.model.BookStore;
import bookstore.model.BookStoreDao;
import bsmall.cart.MyCartList;

@Controller
public class CartAddController {
	
	private static final String command = "/add.bsmall";
	private static final String gotoPage = "redirect:/list.bsmall";
	
	@RequestMapping(value = command)
	public String doAction(BookStore bookstore, HttpSession session,HttpServletResponse response) {
		
		int bnum = bookstore.getBnum();
		int oqty = bookstore.getQuantity(); //detailview quantity 
		
		System.out.println("bo"+bnum+","+oqty);
		if(session.getAttribute("loginfo") == null) {
			
			session.setAttribute("destination","redirect:/detail.bs?pmkey="+bnum);
			/*response.setContentType("text/html; charset=UTF-8");
			PrintWriter out;
			try {
				out = response.getWriter();
				out.println("<script>alert('로그인 해주세요.');</script>");
				out.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			return "redirect:/login.bm";
			
			
		}
		else {
			MyCartList mycart = (MyCartList)session.getAttribute("mycart");
			
			if(mycart == null) {
				mycart = new MyCartList();
			}
			mycart.AddOrder(bnum,oqty);
			session.setAttribute("mycart", mycart);
			
			return gotoPage;
		}
	}
}
