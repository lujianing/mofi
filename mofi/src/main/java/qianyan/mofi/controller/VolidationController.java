package qianyan.mofi.controller;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.solosky.litefetion.LiteFetion;
import net.solosky.litefetion.bean.VerifyImage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 生成飞信验证码
 * */
@Controller
@RequestMapping("/volidate")
public class VolidationController extends BaseController{
	
	
	public VolidationController(){
		super();
	}
	
	public void destroy() {
		super.destroy();
	}

	public void init() throws ServletException {
		super.init();
	}
	
	@RequestMapping("service.do")
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("image")!=null){
			session.removeAttribute("image");
		}
		
		
		VerifyImage image = client.retireVerifyImage(VerifyImage.TYPE_LOGIN);
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "No-cache");
		response.setDateHeader("Expires", 0);
		// 指定生成的响应是图片
		response.setContentType("image/png");
		System.out.println(image.getSessionId());
		session.setAttribute("image",image);
		response.getOutputStream().write(image.getImageData());
	}
}
