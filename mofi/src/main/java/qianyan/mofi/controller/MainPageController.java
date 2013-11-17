package qianyan.mofi.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.management.timer.Timer;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import net.solosky.litefetion.bean.Buddy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import qianyan.mofi.bean.PageBean;
import qianyan.mofi.entity.ApplyInfo;
import qianyan.mofi.service.ApplyInfoService;
import qianyan.mofi.service.MessageService;
import qianyan.mofi.utils.ExportToExcel;




@Controller
public class MainPageController extends BaseController {
	
	@Autowired
	ApplyInfoService applyInfoService;
	
	@Autowired
	MessageService messageService;
	
	@RequestMapping(value = "/ShowInfo", method = RequestMethod.GET)  
    public String ShowInfo() {  
		return "/ShowInfo";
    }
	
	@RequestMapping(value = "/ListenConfig", method = RequestMethod.GET)  
    public String ListenConfig() {  
		return "/ListenConfig";
    }
	
	@RequestMapping(value = "/ListenInfo", method = RequestMethod.GET)  
    public String ListenInfo(ModelMap modelMap) throws UnsupportedEncodingException {
		if(state==0){			//第一次开启线程 0表示第一次 1表示开启  2表示暂停
			listen.thread.start();
			listen.setApplyInfoService(applyInfoService);
			listen.setMessageService(messageService);
			state=1;
			isListen = true;
		}else if(state==2){
			listen.thread.resume();
			state=1;
	
		}
		modelMap.put("isListen", isListen);
		return "/ListenConfig";
    }
	
	@RequestMapping(value = "/StopListen", method = RequestMethod.GET)  
    public String StopListen(ModelMap modelMap) throws UnsupportedEncodingException {
		if(state==1){
			listen.thread.suspend();
			state=2;
			isListen = false;
		}
		modelMap.put("isListen", isListen);
		return "/ListenConfig";
    }
	

	@RequestMapping(value = "/listUnApplyInfo", method = RequestMethod.GET)  
    public String Listapplyinfo(@RequestParam("page") int page, ModelMap modelMap) {
		PageBean pagebean = applyInfoService.queryForPage(10, page,"等待审核","desc");
		modelMap.put("pagebean", pagebean);
		return "/ListUnApplyInfo";
    }
	
	@RequestMapping(value = "/listPassApplyInfo", method = RequestMethod.GET)  
    public String ListPassapplyinfo(@RequestParam("page") int page,HttpServletRequest request, ModelMap modelMap) {
		PageBean pagebean = applyInfoService.queryForPage(10, page,"通过审核","desc");
		modelMap.put("pagebean", pagebean);
		return "/ListPassApplyInfo";
    }
	
	@RequestMapping(value = "/listOverApplyInfo", method = RequestMethod.GET)  
    public String ListOverapplyinfo(@RequestParam("page") int page,HttpServletRequest request, ModelMap modelMap) {
		PageBean pagebean = applyInfoService.queryForPage(10, page,"完成交易","desc");
		modelMap.put("pagebean", pagebean);
		return "/ListOverApplyInfo";
    }
	
	@RequestMapping(value = "/deleteApplyInfo")
	public void del(@RequestParam("id") String id, HttpServletResponse response){
		try{
			ApplyInfo applyinfo = new ApplyInfo();
			applyinfo.setId(Long.parseLong(id));
			System.out.println(applyinfo.getId());
			applyInfoService.delete(applyinfo);
			response.getWriter().print("{\"del\":\"true\"}");
		}
		catch(Exception e){
			
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/updateStateAll")  
    public String UpdateStateALL(@RequestParam("state") String state,HttpServletRequest request, ModelMap modelMap) {
		String[] lists = request.getParameterValues("list");		
		if(lists==null){
			modelMap.put("error", "没有选中项");
			return "Error";
		}
		if(state.equals("over"))
			state="完成交易";
		if(state.equals("pass"))
			state="通过审核";
		int i =applyInfoService.updateState(lists,state);
		System.out.println("更新了"+i+"条记录");
		modelMap.put("success", "更新了"+i+"条记录");
		return "/Success";
    }
	
	
	@RequestMapping(value = "/updateInput", method = RequestMethod.GET)  
    public String updateInput(@RequestParam("id") String id, ModelMap modelMap) throws UnsupportedEncodingException {
		System.out.println(id);
		long idnum=Long.parseLong(id);
		ApplyInfo applyinfo =applyInfoService.findById(ApplyInfo.class, idnum);
		modelMap.put("applyinfo", applyinfo);
		System.out.println(applyinfo.toString());
		return "/UpdateInput";
    }
	
	@RequestMapping(value = "/sendInfo")  
    public String SendInfo(@RequestParam("userid") String userid,HttpServletRequest request,HttpServletResponse response ,ModelMap modelMap) throws IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		Buddy buddy =client.getBuddyByUserId(Integer.parseInt(userid));
		String message = request.getParameter("message"+userid);
		System.out.println(message);
		System.out.println("message"+userid+"向"+buddy.getDisplayName()+"发送消息"+message);
		client.sendMessage(buddy, message, false);
		modelMap.put("success", "成功发送信息给"+buddy.getDisplayName()+":"+message);
		return "Success";
		
    }
	
	
	@RequestMapping(value = "/sendInfos")  
    public String SendInfos(HttpServletRequest request,HttpServletResponse response ,ModelMap modelMap) throws IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String[] lists = request.getParameterValues("list");
		String message=request.getParameter("messages");
		int i=0;
		for(;i<lists.length;i++){
			Buddy buddy =client.getBuddyByUserId(Integer.parseInt(lists[i]));
			client.sendMessage(buddy, message, false);
		}
//		System.out.println(lists[0]);
		modelMap.put("success", "成功发送了"+i+"条信息"+message);
		return "Success";
		
    }
	
	@RequestMapping(value = "/UpdateApplyInfo")  
    public String UpdateApplyInfo(HttpServletRequest request,HttpServletResponse response, ModelMap modelMap) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		long id=Long.parseLong(request.getParameter("id"));
		String hwbh=request.getParameter("hwbh");
		long hwsl =Long.parseLong(request.getParameter("hwsl"));
		String mdbh=request.getParameter("mdbh");
		String name =request.getParameter("name");
		
		ApplyInfo applyinfo =applyInfoService.findById(ApplyInfo.class, id);
		
		applyinfo.setHwbh(hwbh);
		applyinfo.setHwsl(hwsl);
		applyinfo.setId(id);
		applyinfo.setMdbh(mdbh);
		applyinfo.setName(name);
		applyInfoService.update(applyinfo);
		modelMap.put("success", "更新信息成功");
		return "/Success";
    }
	
	@RequestMapping(value = "/ExportToExcelU", method = RequestMethod.GET)  
    public String ExportToExcelU(@RequestParam("type") String type,HttpServletRequest request, ModelMap modelMap) throws RowsExceededException, WriteException, IOException {
		ArrayList<ApplyInfo> applyinfos =null;
		ExportToExcel ete= null;
		if(type.equals("un")){
			applyinfos =(ArrayList<ApplyInfo>) applyInfoService.listUnExamine();
			ete =new ExportToExcel(applyinfos, "审核信息");
			modelMap.put("success", "导出成功！请在D盘下查找 【等待审核信息.xsl】");
		}else if(type.equals("pass")){
			applyinfos =(ArrayList<ApplyInfo>) applyInfoService.listPassApplyInfo();
			ete =new ExportToExcel(applyinfos, "通过审核信息");
			modelMap.put("success", "导出成功！请在D盘下查找 【通过审核信息.xsl】");
		}else if(type.equals("over")){
			applyinfos =(ArrayList<ApplyInfo>) applyInfoService.listOverApplyInfo();
			ete =new ExportToExcel(applyinfos, "完成交易信息");
			modelMap.put("success", "导出成功！请在D盘下查找 【完成交易信息.xsl】");
		}
		return "/Success";
    }

/*	@RequestMapping(value = "/testPage", method = RequestMethod.GET)  
    public String testPage(HttpServletRequest request, ModelMap modelMap) {
		ArrayList<ApplyInfo> applyinfos=null;
		Page page = new Page<ApplyInfo>();
		page.setOrder("asc");
		page.setOrder("time");
		page.setResult(applyinfos);
//		page.setTotalCount(100L);
		page.setLimit(10L);
		PageBean pagebean =applyInfoService.findPage(ApplyInfo.class, page);
		modelMap.put("pagebean", pagebean);
		return "/testPage";
    }
	*/
	
	@RequestMapping(value = "/testPage", method = RequestMethod.GET)  
    public String testPage(@RequestParam("page") int page,HttpServletRequest request, ModelMap modelMap) {
		PageBean pagebean = applyInfoService.queryForPage(2, page,"等待审核","asc");
		modelMap.put("pagebean", pagebean);
		return "/testPage";
    }
	
	
	
	@RequestMapping(value = "/listAllInfo")  
    public String listAllInfo(@RequestParam("page") int page,HttpServletRequest request,HttpServletResponse response, ModelMap modelMap) throws UnsupportedEncodingException {
		PageBean pagebean = messageService.queryForPage(10, page, "desc");
		modelMap.put("pagebean", pagebean);
		return "/ListAllInfo";
    }
	
		
	@RequestMapping(value = "/timingToAll", method = RequestMethod.GET)  
    public String timingToAll() throws UnsupportedEncodingException {
		
		return "/TimingToAll";
    }
	
	@RequestMapping(value = "/timingToMyself", method = RequestMethod.GET)  
    public String timingToMyself() throws UnsupportedEncodingException {
		
		return "/TimingToMyself";
    }
	
//	sendtomyself
	
	
	@RequestMapping(value = "/sendtomyself")  
    public String Sendtomyself(HttpServletRequest request,HttpServletResponse response ,ModelMap modelMap) throws IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String message = request.getParameter("message");
//		String datetime = "1970-01-01 00:00:00";
		String datetime =request.getParameter("time");
	
		
		
		client.sendSelfSMS(message);
		modelMap.put("success", "定时短信将于"+datetime+ "发送到您的手机："+message);
		return "Success";
		
    }
	
	
	
	@RequestMapping(value = "/TimingsendInfos")  
    public String TimingsendInfos(HttpServletRequest request,HttpServletResponse response ,ModelMap modelMap) throws IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String[] lists = request.getParameterValues("list");
		String message=request.getParameter("messages");
		List<Buddy> buddys = new ArrayList<Buddy>();
		int i=0;
		for(;i<lists.length;i++){
			Buddy buddy =client.getBuddyByUserId(Integer.parseInt(lists[i]));
			buddys.add(buddy);
		}
		Date date = new Date();
		date.setTime(date.getMinutes()+11);
		client.sendScheduleSMS(buddys, message, date);
		
		modelMap.put("success", "定时信息将于 xxx发送给用户"+message);
		return "Success";
		
    }
	
	
	@RequestMapping(value = "/save")  
    public void Save(HttpServletRequest request,HttpServletResponse response ,ModelMap modelMap) throws IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String hwbh = request.getParameter("hwbh");
		String hwsl = request.getParameter("hwsl");
		String mdbh = request.getParameter("mdbh");
		String phone = request.getParameter("phone");
		String time = request.getParameter("time");
		ApplyInfo applyinfo = new ApplyInfo();
		applyinfo.setHwbh(hwbh);
		applyinfo.setHwsl(Long.valueOf(hwsl));
		applyinfo.setMdbh(mdbh);
		applyinfo.setName(time);
		applyinfo.setState("等待审核");
		applyInfoService.save(applyinfo);
		
		
    }
	
	
	
	@RequestMapping(value = "/Left", method = RequestMethod.GET)  
    public String Left() throws UnsupportedEncodingException {
		
		return "/Left";
    }
	
	@RequestMapping(value = "/Top", method = RequestMethod.GET)  
    public String Top() throws UnsupportedEncodingException {
		
		return "/Top";
    }
	
	@RequestMapping(value = "/Right", method = RequestMethod.GET)  
    public String Right() throws UnsupportedEncodingException {
		
		return "/Right";
    }
	
	@RequestMapping(value = "/Test", method = RequestMethod.GET)  
    public String Test() throws UnsupportedEncodingException {
		
		return "/Main";
    }
}
