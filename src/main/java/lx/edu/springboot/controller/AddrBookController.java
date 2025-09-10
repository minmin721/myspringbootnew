package lx.edu.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lx.edu.springboot.dao.AddrBookDAO;
import lx.edu.springboot.vo.AddrBookVO;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class AddrBookController {
	@Autowired
	ApplicationContext context;

	@Autowired
	AddrBookDAO dao;

	@RequestMapping("/insert.do")
	public String insert(AddrBookVO vo) throws Exception {
		System.out.println(vo);
		dao.insertDB(vo);
		return "redirect:addrbook_list.do";
	}

	@RequestMapping("/addrbook_form.do") // 기존 코드 안건들임
	public String form() {
		return "addrbook_form"; // jsp file name
	}

	@RequestMapping("addrbook_list.do")
	public String list(HttpSession session, HttpServletRequest req) throws Exception {
//		if(session.getAttribute("userId")==null) {
//			return "login";
//		}
		List<AddrBookVO> list = dao.getDBList();
		req.setAttribute("data", list);
		return "addrbook_list";
	}
	
	
	@RequestMapping("edit.do")
	public ModelAndView edit(@RequestParam("abId") int abId) throws Exception {
		ModelAndView result = new ModelAndView();
		AddrBookVO vo = dao.getDB(abId);
		System.out.println(vo);
		result.addObject("ab", vo);
		result.setViewName("addrbook_edit_form");
		return result;
	}
	
	@RequestMapping("update.do")
	public String update(@RequestParam("abId") int abId) throws Exception {
		dao.updateDB(abId);
		return "redirect:addrbook_edit_form.do";
	}

}
