package bookstore.controller;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bsmall.cart.ShoppingInfo;

@Component("myCompositeDao")
public class CompositeDao {

	private final String namespace="product.model.Composite"; // composite.xml
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	public List<ShoppingInfo> showDetail(int pmkey) {
		
		List<ShoppingInfo> lists = sqlSessionTemplate.selectList(namespace+".showDetail",pmkey);
		return lists;
	}
	
}
