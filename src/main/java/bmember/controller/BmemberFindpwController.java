package bmember.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import bmember.model.BmemberBean;
import bmember.model.BmemberDao;

@Controller
public class BmemberFindpwController {
	
	private static final String command = "/findpw.bm";
	private static final String getPage = "findpw";
	private static final String gotoPage = "redirect:/main.bm";
	
	@Autowired
	private BmemberDao bmemberDao;
	
	@RequestMapping(value=command,method=RequestMethod.GET) 
	public String doAction() {
		return getPage;
	}
	
	@RequestMapping(value=command,method=RequestMethod.POST) 
	public ModelAndView doAction( BmemberBean Bmember, HttpServletResponse response, HttpSession session) throws IOException{
		System.out.println(this.getClass() + " POST ��� ����");
		
		System.out.println(Bmember.getId());
		System.out.println(Bmember.getPw());
		
		BmemberBean login = bmemberDao.findpw(Bmember); 
		System.out.println("login:"+login);
		
		PrintWriter writer;
		writer = response.getWriter();
		ModelAndView mav = new ModelAndView();
		if(login == null) {
			System.out.println("�������� �ʴ� ���̵�");
			writer.print("<script type='text/javascript'>");
			writer.print("alert('�Է��� ������ ��ġ�ϴ� ȸ�� ������ �����ϴ�.');");
			writer.print("</script>");
			writer.flush();
			
			return new ModelAndView(getPage);
			
		}
		else {
			System.out.println("�����ϴ� ���̵�");
			
			session.setAttribute("loginfo", login);
			mav.setViewName((String)session.getAttribute("destination"));
			
		}
		return mav;
	}
	
}