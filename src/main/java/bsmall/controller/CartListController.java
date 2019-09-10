package bsmall.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import bookstore.model.BookStore;
import bookstore.model.BookStoreDao;
import bsmall.cart.MyCartList;
import bsmall.cart.ShoppingInfo;

@Controller
public class CartListController {
	private static final String command = "/list.bsmall";
	private static final String getPage = "MallList";
	
	@Autowired
	private BookStoreDao bookStoreDao;
	
	@RequestMapping(value=command)
	public String doAction(HttpSession session) {
		
		MyCartList mycart = (MyCartList)session.getAttribute("mycart");
		if(mycart!=null) {
		Map<Integer, Integer> orderlists = mycart.getAllOrder();
		
		Set<Integer> keylist = orderlists.keySet(); ////keySet()��  Map���� ���ǵ�(this.params) �� �߿� key ���� �����ͼ� �����Ѵ�.
		
		List<ShoppingInfo> shopLists = new ArrayList<ShoppingInfo>();
		
		int totalAmount = 0;
		
		for(Integer bnum : keylist) {
			Integer qty = orderlists.get(bnum);
			
			
			
			BookStore bean = bookStoreDao.GetData(bnum);
			
			ShoppingInfo shopInfo = new ShoppingInfo();
			shopInfo.setBnum(bnum);
			shopInfo.setPname(bean.getTitle());
			shopInfo.setQty(qty);
			shopInfo.setPrice(bean.getPrice());
			
			System.out.println("qty" + shopInfo.getQty());
			int amount = (bean.getPrice() * qty);
			
			System.out.println("amount1:"+amount);
			
			System.out.println("amount2:"+amount);
			System.out.println("price" + bean.getPrice());
			
			shopInfo.setAmount(amount);
			totalAmount += amount;
			
			shopLists.add(shopInfo);
			System.out.println(shopInfo.getBnum()+","+shopInfo.getPname()+","+shopInfo.getPrice()+","+shopInfo.getAmount()+","+shopInfo.getQty());
		}
		
		session.setAttribute("shopLists", shopLists);
		session.setAttribute("totalAmount", totalAmount);
		
		return getPage;
		}
		
		else {
			return getPage;
		}
	}
	
}
