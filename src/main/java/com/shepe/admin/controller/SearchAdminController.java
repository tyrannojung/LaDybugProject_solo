package com.shepe.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.shepe.admin.biz.search.SearchAdminService;
import com.shepe.admin.biz.search.SearchAdminVO;
import com.shepe.admin.faq.FaqService;
import com.shepe.admin.faq.FaqVO;


@Controller
public class SearchAdminController {
	
	@Autowired
	private SearchAdminService searchAdminService;
	
	@Autowired
	private FaqService faqService;
	
	@RequestMapping("/admin/searchChart")
	public String searchChart() {
		
		return "/admin/search/admin_search";
	}
	
	@ResponseBody
	@RequestMapping(value="/admin/search_total", produces = "application/text; charset=utf8")
	public String search_total() {
		Gson searchChartGson = new Gson();
		List<SearchAdminVO> searchChart = searchAdminService.searchChart_total();
		
		return searchChartGson.toJson(searchChart);
	}
	
	@ResponseBody
	@RequestMapping(value="/admin/search_month", produces = "application/text; charset=utf8")
	public String search_month() {
		Gson searchChartGson = new Gson();
		List<SearchAdminVO> searchChart = searchAdminService.searchChart_month();
		
		return searchChartGson.toJson(searchChart);
	}
	
	
	@ResponseBody
	@RequestMapping(value="/admin/search_day", produces = "application/text; charset=utf8")
	public String search_day() {
		Gson searchChartGson = new Gson();
		List<SearchAdminVO> searchChart = searchAdminService.searchChart_day();
		
		return searchChartGson.toJson(searchChart);
	}
	
	@ResponseBody
	@RequestMapping(value="/admin/search_week_searchAmount", produces = "application/text; charset=utf8")
	public String search_week_searchAmount() {
		Gson searchChartGson = new Gson();
		List<SearchAdminVO> searchChart = searchAdminService.search_week_searchAmount();
		
		return searchChartGson.toJson(searchChart);
	}
	
	
	@RequestMapping("/admin/bootChart")
	public String bootChart() {
		
		return "/admin/adminchat/bootchart";
	}
	
	
	@ResponseBody
	@RequestMapping(value="/admin/boot_totalchart", produces = "application/text; charset=utf8")
	public String boot_totalchart() {
		Gson boot_total = new Gson();
		List<FaqVO> boot_totalchart = faqService.boot_totalchart();
		
		return boot_total.toJson(boot_totalchart);
	}
	
	
}
