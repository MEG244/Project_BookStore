package order.model;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("myOrderDao")
public class OrderDao {

	private final String namespace = "order.model.Order"; // order.xml

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public void insertData(String id) {
		
		sqlSessionTemplate.insert(namespace+".InsertData",id);
	}

	public int getMaxOrderId() {
		int maxoid = sqlSessionTemplate.selectOne(namespace+".getMaxOrderId");
		return maxoid;
	}
	
	public List<Order> OrderMall(String id){
		List<Order> lists = new ArrayList<Order>();
		lists = sqlSessionTemplate.selectList(namespace+".OrderMall",id);
		return lists;
	}
	
}
