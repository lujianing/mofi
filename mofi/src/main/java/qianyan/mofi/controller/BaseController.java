package qianyan.mofi.controller;

import javax.servlet.http.HttpServlet;

import net.solosky.litefetion.LiteFetion;

import org.slf4j.LoggerFactory;

import qianyan.mofi.factory.FetionFactory;
import qianyan.mofi.thread.Listen;


public class BaseController extends HttpServlet{
	//日志记录器，个子类通过继承该属性即可直接在需要的地方输出日志信息
	 protected org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
	 protected static final LiteFetion client = new LiteFetion();  //单例 飞信客户端
	 protected static final Listen listen =new Listen();	//监听线程
	 protected static int state =0;	//信号量
	 protected static boolean isListen =false;
}
