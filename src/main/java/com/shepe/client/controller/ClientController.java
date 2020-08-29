package com.shepe.client.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shepe.admin.biz.chat.BootService;
import com.shepe.admin.biz.chat.BootVO;
import com.shepe.client.join.JoinDAO;
import com.shepe.client.join.JoinVO;

@Controller
public class ClientController {
	
    
    @Autowired
    private JoinDAO joindao;
    
    @Autowired
    private BootService bootservice;
    
    @RequestMapping("/")
    public String index() {
        return "/client/index";
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
        return "redirect:/";
    }
    
    
    @RequestMapping("/userJoinAction")
    public String userJoin(JoinVO vo) {
        joindao.join(vo);
        return "redirect:/";
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
            return "redirect:/";
            
        } else {
            request.setAttribute("usercheck", "idpwno");
            return "/client/join/login";
        }
    }
    

}
