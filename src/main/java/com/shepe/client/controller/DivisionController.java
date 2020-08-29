package com.shepe.client.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shepe.admin.biz.chat.BootService;
import com.shepe.admin.biz.chat.BootVO;
import com.shepe.client.biz.division.DivisionService;
import com.shepe.client.common.CommonPaging;
import com.shepe.client.common.PagingVO;
import com.shepe.client.join.JoinDAO;
import com.shepe.client.join.JoinVO;

@Controller
public class DivisionController {
	
	@Autowired
	private DivisionService divisionService;
	@Autowired
	private CommonPaging commonpaging;
	
	@Autowired
	private JoinDAO joindao;
	
	@Autowired
	private BootService bootservice;
	
	
	
	@RequestMapping("/index")
	public String index() {
		return "redirect:/";
	}
	
	@RequestMapping("/join")
	public String join() {
		return "/client/join/join";
	}
	
	@RequestMapping("/clientlogin")
	public String login() {
		return "/client/join/login";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();

		session.invalidate();
		return "redirect:/index";
	}
	
	
	@RequestMapping("/userJoinAction")
	public String userJoin(JoinVO vo) {
		joindao.join(vo);
		return "redirect:/index";
	}
	
	@RequestMapping("/userLoginAction")
	public String userLoginAction(JoinVO vo, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		int check = 0;
		
		check = joindao.login(vo);
		
		if(check == 1) {
			BootVO bo = bootservice.BootContent();
			
			session.setAttribute("BootContent", bo);
			session.setAttribute("member_id", vo.getUserID());
			return "redirect:/index";
			
		} else {
			request.setAttribute("usercheck", "idpwno");
			return "/client/join/login";
		}
	}
	
	
	@RequestMapping("/getDivision_re")
	public String divisionlist_recipe(@RequestParam(value="page", required=false) String page, @RequestParam(value="sum", required=false) String sum, PagingVO po, Model model) {
		
		int pager;
		
		if(page == null & sum == null) { // 맨처음
			pager = 1;
			int listcount = divisionService.getDivisionCount();
			model.addAttribute("paging", commonpaging.paging(pager, listcount, po));
			model.addAttribute("divisionList", divisionService.getDivisionList(pager));
			return "/client/division/division";
			
		} else if(page == null & sum != null) {
			pager = 1;
			int listcount = divisionService.getAjaxCount(sum);
			model.addAttribute("paging", commonpaging.paging(pager, listcount, po));
			model.addAttribute("divisionList", divisionService.getAjaxList(pager,sum));
			return "/client/division/divisionAjax";
		} else if(page != null & sum.equals("")) {
			
			pager = Integer.parseInt(page);
			int listcount = divisionService.getDivisionCount();
			model.addAttribute("paging", commonpaging.paging(pager, listcount, po));
			model.addAttribute("divisionList", divisionService.getDivisionList(pager));
			return "/client/division/divisionAjax";
		} else  {
			
			pager = Integer.parseInt(page);
			int listcount = divisionService.getAjaxCount(sum);
			model.addAttribute("paging", commonpaging.paging(pager, listcount, po));
			model.addAttribute("divisionList", divisionService.getAjaxList(pager,sum));
			return "/client/division/divisionAjax";
		}
	}
	
	@RequestMapping("/getDivision_ingre")
	public String divisionlist_ingre(@RequestParam(value="page", required=false) String page, @RequestParam(value="choice", required=false) String choice, PagingVO po, Model model) {
		
		int pager;
		
		if(page == null & choice == null) { // 맨처음
			pager = 1;
			int listcount = divisionService.getDivisionInCount();
			model.addAttribute("paging", commonpaging.paging(pager, listcount, po));
			model.addAttribute("divisionInList", divisionService.getDivisionInList(pager));
			return "/client/division/division_ingre";
			
		} else if(page == null & choice != null) {
			
			pager = 1;
			int listcount = divisionService.getAjaxinCount(choice);
			model.addAttribute("paging", commonpaging.paging(pager, listcount, po));
			model.addAttribute("ajaxingrelist", divisionService.getAjaxingrelist(pager,choice));
			return "/client/division/divisionAjaxIngreList";
		} else if(page != null & choice.equals("null")) {
			
			pager = Integer.parseInt(page);
			int listcount = divisionService.getDivisionInCount();
			model.addAttribute("paging", commonpaging.paging(pager, listcount, po));
			model.addAttribute("ajaxingrelist", divisionService.getDivisionInList(pager));
			return "/client/division/divisionAjaxIngreList";
		} else  {
			
			pager = Integer.parseInt(page);
			int listcount = divisionService.getAjaxinCount(choice);
			model.addAttribute("paging", commonpaging.paging(pager, listcount, po));
			model.addAttribute("ajaxingrelist", divisionService.getAjaxingrelist(pager,choice));
			return "/client/division/divisionAjaxIngreList";
		}
	}

}
