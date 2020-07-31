package com.shepe.client.division;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shepe.admin.division.DivisionService;
import com.shepe.client.common.CommonPaging;
import com.shepe.client.common.PagingVO;

@Controller
public class DivisionController {
	
	@Autowired
	private DivisionService divisionService;
	@Autowired
	private CommonPaging commonpaging;
	
	@RequestMapping("/index")
	public String index() {
		return "redirect:/";
	}
	
	
	@RequestMapping("/getDivision_re")
	public String divisionlist_recipe(@RequestParam(value="page", required=false) String page,@RequestParam(value="sum", required=false) String sum, PagingVO po, Model model) {
		
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
	public String divisionlist_ingre(@RequestParam(value="page", required=false) String page,@RequestParam(value="choice", required=false) String choice, PagingVO po, Model model) {
		
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
	
//	@RequestMapping("/getDivision")
//	public String divisionlist(@RequestParam(value="page", required=false) String page, PagingVO po, Model model) {
//		
//		int pager;
//		
//		if(page == null) {
//			pager = 1;
//		} else {
//			pager = Integer.parseInt(page);
//		}
//		
//	    int listcount = divisionService.getDivisionCount();
//
//		model.addAttribute("paging", commonpaging.paging(pager, listcount, po));
//		model.addAttribute("divisionList", divisionService.getDivisionList(pager));
//		return "/client/division/division";
//	}
//	
//	@RequestMapping("/ajaxtest/{sum}")
//	public String ajax(@PathVariable("sum") String sum, @RequestParam(value="page", required=false) String page, PagingVO po, Model model) {
//		int pager;
//		if(page == null) {
//			pager = 1;
//		} else {
//			pager = Integer.parseInt(page);
//		}
//		model.addAttribute("divisionList", divisionService.getAjaxList(pager,sum));
//		int listcount = divisionService.getAjaxCount(sum);
//		System.out.println("식재료카운트 :" + listcount);
//		model.addAttribute("paging", commonpaging.paging(pager, listcount, po));
//		model.addAttribute("sum", sum);
//		return "/client/division/divisionAjax";
//	}
//	
//	@RequestMapping("/choicePaging")
//	public String choicepaging(@RequestParam(value="page", required=false) String page, @RequestParam String sum, PagingVO po, Model model) {
//		int pager;
//		if(page == null) {
//			pager = 1;
//		} else {
//			pager = Integer.parseInt(page);
//		}
//		
//		model.addAttribute("divisionList", divisionService.getAjaxList(pager,sum));
//		int listcount = divisionService.getAjaxCount(sum);
//		model.addAttribute("paging", commonpaging.paging(pager, listcount, po));
//		model.addAttribute("sum", sum);
//		return "/client/division/divisionPaging";
//	}
//	
	
//	@RequestMapping("/ajaxingrelist/{choice}")
//	public String ajaxingrelist(@PathVariable("choice") String choice, @RequestParam(value="page", required=false) String page, PagingVO po, Model model) {
//		int pager;
//		if(page == null) {
//			pager = 1;
//		} else {
//			pager = Integer.parseInt(page);
//		}
//		model.addAttribute("ajaxingrelist", divisionService.getAjaxingrelist(pager,choice));
//		int listcount = divisionService.getAjaxinCount(choice);
//		model.addAttribute("paging", commonpaging.paging(pager, listcount, po));
//		model.addAttribute("choice", choice);
//		return "/client/division/divisionAjaxIngreList";
//	}
	
}
