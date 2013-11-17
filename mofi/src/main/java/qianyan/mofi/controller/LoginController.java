package qianyan.mofi.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.solosky.litefetion.LiteFetion;
import net.solosky.litefetion.bean.ActionResult;
import net.solosky.litefetion.bean.Buddy;
import net.solosky.litefetion.bean.Cord;
import net.solosky.litefetion.bean.Presence;
import net.solosky.litefetion.bean.VerifyImage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * 登录验证
 * 
 * */
@Controller
public class LoginController extends BaseController {
	 
	@RequestMapping(value = "/login", method = RequestMethod.GET)  
     public String Login() {  
      return "/Login";
     } 
	
	@RequestMapping(value = "/logintest", method = RequestMethod.POST)  
    public void Logintest(HttpServletRequest request, HttpServletResponse response) { 
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username+"  " + password);
    } 
	
	@RequestMapping(value = "/loginvolidate", method = RequestMethod.POST)  
    public String LoginVolidate(HttpServletRequest request, HttpServletResponse response) throws Exception {  
		
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		VerifyImage image = (VerifyImage)request.getSession().getAttribute("image");
		String volidate = request.getParameter("volidate").trim();
		System.out.println(volidate);
		System.out.println("进入验证");
		image.setVerifyCode(volidate);
		ActionResult r = client.login(username,password,Presence.AWAY,image);  //登录验证
		System.out.println("LoginReulst:"+r.toString());
		System.out.println(image.getVerifyCode());
		if(r==ActionResult.SUCCESS) {
			HttpSession session = request.getSession();
			session.setAttribute("client", client);
			return "/Main";
		}
		
		return "/Fail";
    }
}
