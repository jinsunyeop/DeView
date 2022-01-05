//package user.controller;
//
//import java.io.IOException;
//import java.util.HashMap;
//
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//import user.service.KakaoLoginService;
//
//@Controller
//public class KakaoLoginController {
//
//	@Autowired
//	private KakaoLoginService kakao;
//	
//	@RequestMapping(value="/")
//    public String index() {
//        
//        return "index";
//    }
//    
//    @RequestMapping(value="/login")
//    public String login(@RequestParam("code") String code,HttpSession session) {
//    	String access_Token = kakao.getAccessToken(code);
//        HashMap<String, Object> userInfo = kakao.getUserInfo(access_Token);
//        System.out.println("login Controller : " + userInfo);
//
//        //    클라이언트의 이메일이 존재할 때 세션에 해당 이메일과 토큰 등록
//        if (userInfo.get("email") != null) {
//            session.setAttribute("userId", userInfo.get("email"));
//            session.setAttribute("access_Token", access_Token);
//        }
//        
//        return "index";
//    }
//	
//    @RequestMapping(value="/logout")
//    public String logout(HttpSession session) {
//        kakao.kakaoLogout((String)session.getAttribute("access_Token"));
//        session.removeAttribute("access_Token");
//        session.removeAttribute("userId");
//        return "index";
//    }
//	
//	
//}