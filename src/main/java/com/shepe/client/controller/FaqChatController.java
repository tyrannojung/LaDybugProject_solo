package com.shepe.client.controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shepe.admin.biz.chat.BootService;
import com.shepe.admin.biz.chat.BootVO;
import com.shepe.client.biz.chat.ChatEncoding;
import com.shepe.client.biz.chat.ChatService;
import com.shepe.client.biz.chat.CommonChatDTO;
import com.shepe.client.join.JoinDAO;
import com.shepe.client.join.JoinVO;


@Controller
public class FaqChatController {
	
	@Autowired
	private ChatService chatService;
	
	@Autowired
	private ChatEncoding chatencoding;
	
	
	@ResponseBody
	@RequestMapping("/faqChatCompleteCheck")
	public int chatCompleteCheck(@RequestParam String userID) {
		System.out.println("FaqCht Con /chatCompleteCheck");
		return chatService.chatCompleteCheck(userID);
		
	}

	@ResponseBody
	@RequestMapping("/faqChatAllComplete")
	public void chatAllComplete(@RequestParam String userID) {
		System.out.println("FaqCht Con /chatAllComplete");
		chatService.chatAllComplete(userID);
	}
	
	
	@ResponseBody
	@RequestMapping("/faqSelectChatroomnum")
	public int selectChatroomnum(@RequestParam String userID, HttpServletRequest request) {
		HttpSession session = request.getSession();
		int a = chatService.selectChatroomnum(userID);
		System.out.println("FaqCht Con /selectChatroomnum");
			session.setAttribute("consultRoomNum", a);

		return a;
	}
		
		
	@RequestMapping("/faqChat") 
	public String chat(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		String userID = (String) session.getAttribute("member_id");
		int a = chatService.chatListNum(userID);
		session.setAttribute("consultNum", a);
		System.out.println("FaqCht Con /chat");
		return "/client/division/chat/faqChatModule_chat";
	}
	

	
	@RequestMapping("/faqChatindex")
	public String chatindex() {
		System.out.println("FaqCht Con /chatindex");
		return "/client/division/chat/chatModule_index";
	}
	
	@RequestMapping("/faqChatlist")
	public String chatlist(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		String userID = (String) session.getAttribute("member_id");
		session.setAttribute("ChatRoomList", chatService.chatroomlist(userID));
		System.out.println("FaqCht Con /chatlist");
		return "/client/division/chat/chatModule_chatbox";
	}
	
	@RequestMapping("/faqChatroomlistpage")
	public String chatroomlistpage() {
		System.out.println("FaqCht Con /chatroomlistpage");
		return "/client/division/chat/chatModule_chatroom";
	}
	
	
	@RequestMapping(value="/faqChatRoomSetting", produces = "application/text; charset=utf8", method=RequestMethod.POST)
	@ResponseBody
	public void chatRoomSetting(@RequestParam String fromID, @RequestParam int chatRoomNum, @RequestParam String chatRoomSubject, @RequestParam(value="admincall", required=false) String admincall) throws IOException {
		System.out.println("FaqCht Con /chatRoomSetting");
		if(admincall != null) {
			
			chatRoomSubject = URLDecoder.decode(chatRoomSubject, "UTF-8");
			fromID = URLDecoder.decode(fromID, "UTF-8");
			chatService.chatRoomSetting(fromID,chatRoomNum,chatRoomSubject,1);
			
		} else {
			chatRoomSubject = URLDecoder.decode(chatRoomSubject, "UTF-8");
			fromID = URLDecoder.decode(fromID, "UTF-8");
			chatService.chatRoomSetting(fromID,chatRoomNum,chatRoomSubject,0);
		}
	}
	
	@RequestMapping(value="/faqChatList",produces = "application/text; charset=utf8", method=RequestMethod.POST)
	@ResponseBody
	public String chatList(@RequestParam String fromID, @RequestParam String toID, @RequestParam String listType, @RequestParam int chatroomnum)  throws IOException {
		System.out.println("FaqCht Con /chatList");
		return getTen(URLDecoder.decode(fromID,"UTF-8"), URLDecoder.decode(toID, "UTF-8"), chatroomnum); //from id, to id  는 한글로 작성되어있을수도 있기때문에 디코더를 사용해야한다.
	
	}
	
	@ResponseBody
	@RequestMapping(value="/faqChatSubmit",produces = "application/text; charset=utf8", method=RequestMethod.POST)
	public void chatSubmit(@RequestParam String fromID, @RequestParam String toID, @RequestParam String chatContent, @RequestParam int chatRoomNum, @RequestParam(value="chatread", required=false) String chatread) throws IOException {
		
		int chatreaddata = 0 ;
		System.out.println("FaqCht Con /chatSubmit");
		if(chatread != null) { // 맨처음
			chatreaddata = Integer.parseInt(chatread);
		} 
		
		fromID = URLDecoder.decode(fromID, "UTF-8");
		toID = URLDecoder.decode(toID, "UTF-8");
		chatContent = URLDecoder.decode(chatContent, "UTF-8");
		chatService.submit(fromID, toID, chatContent,chatRoomNum, chatreaddata);	

	}
	
	@ResponseBody
	@RequestMapping(value="/faqChatBootSubmit",produces = "application/text; charset=utf8", method=RequestMethod.POST)
	public void chatBootSubmit(@RequestParam String fromID, @RequestParam String toID, @RequestParam String chatContent, @RequestParam int chatRoomNum) throws IOException {
		System.out.println("FaqCht Con /chatBootSubmit");
		fromID = URLDecoder.decode(fromID, "UTF-8");
		toID = URLDecoder.decode(toID, "UTF-8");
		chatContent = URLDecoder.decode(chatContent, "UTF-8");
		chatService.chatBootSubmit(fromID, toID, chatContent,chatRoomNum);	

	}
	
	@RequestMapping(value="/faqChatUnread",produces = "application/text; charset=utf8", method=RequestMethod.POST)
	@ResponseBody
	public String chatUnread(@RequestParam String userID) throws IOException {
		if(userID == null || userID.equals("")) {
			return "0";
		} else {
			userID = URLDecoder.decode(userID, "UTF-8");
			return chatService.getAllUnreadChat(userID) + "";
		}
	}
	
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	@ResponseBody
	public String getTen(String fromID, String toID, int chatroomnum) {// 최근 메세지 10개까지인데 아래 숫자고침으로써 100개로 변경
		StringBuffer result = new StringBuffer("");
		System.out.println("FaqCht Con getTen");
		result.append("{\"result\":[");
		List<CommonChatDTO> chatList = chatService.getChatListByRecent(fromID, toID, 100, chatroomnum);
		if(chatList.size() == 0) return "";
		for(int i = 0; i <chatList.size(); i++) {
			result.append("[{\"value\": \"" + chatencoding.encoding(chatList.get(i).getFromID()) + "\"},");
			result.append("{\"value\": \"" + chatencoding.encoding(chatList.get(i).getToID()) + "\"},");
			result.append("{\"value\": \"" + chatList.get(i).getChatContent() + "\"},");
			result.append("{\"value\": \"" + chatencoding.encoding(chatList.get(i).getChatTime()) + "\"},");
			result.append("{\"value\": \"" + chatList.get(i).getChatRead() + "\"}]");
			if(i != chatList.size() -1) result.append(",");
		}
		result.append("], \"last\":\"" + chatList.get(chatList.size() - 1).getChatSQ() + "\"}");
		chatService.readChat(fromID, toID); // 반환직전에 모든 채팅을 다 읽었다고 알려준다. 
		return result.toString();
		
	}
}
