package qianyan.mofi.thread;

import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import net.solosky.litefetion.bean.ClientState;
import net.solosky.litefetion.bean.VerifyImage;
import net.solosky.litefetion.notify.BuddyApplicationNotify;
import net.solosky.litefetion.notify.BuddyMessageNotify;
import net.solosky.litefetion.notify.BuddyStateNotify;
import net.solosky.litefetion.notify.ClientStateNotify;
import net.solosky.litefetion.notify.Notify;
import qianyan.mofi.controller.BaseController;
import qianyan.mofi.entity.ApplyInfo;
import qianyan.mofi.entity.Message;
import qianyan.mofi.service.ApplyInfoService;
import qianyan.mofi.service.MessageService;
import qianyan.mofi.utils.DateTime;

public class Listen extends BaseController implements Runnable {

	ApplyInfoService applyInfoService;
	MessageService messageService;
	public MessageService getMessageService() {
		return messageService;
	}

	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

	public ApplyInfoService getApplyInfoService() {
		return applyInfoService;
	}

	public void setApplyInfoService(ApplyInfoService applyInfoService) {
		this.applyInfoService = applyInfoService;
	}

	public Thread thread;

	public Listen() {
		thread = new Thread(this);
	}

	public void run() {
		VerifyImage vc = null;
		boolean isLogout = false;
		while (!isLogout) {
			List<Notify> list = client.pollNotify(); // 总是返回一个size>=0的通知列表
														// ，所以直接迭代，不用判断null
			Iterator<Notify> nit = list.iterator();
			while (nit.hasNext()) {
				Notify notify = nit.next();
				
				switch (notify.getType()) {
				case BUDDY_MESSAGE: // 好友消息消息
					String mdbh = null; // 门店编号
					String hwbh = null;
					String hwsl = null;
					StringBuffer sb=null;
					ApplyInfo applyinfo;
					String message = "发送格式不符合要求，请按照以下格式发送    门店编号:货物1编号,货物1数量;货物2编号,货物2数量;";
					boolean istrue = false;
					int i = 0;
					BuddyMessageNotify bn = (BuddyMessageNotify) notify;
					System.out.println("[收到消息]"
							+ bn.getBuddy().getDisplayName() + ":"
							+ bn.getMessage());
					Message messageinfo = new Message();
					messageinfo.setMessage(bn.getMessage());
					messageinfo.setName(bn.getBuddy().getDisplayName());
					messageinfo.setTime(DateTime.getDateTime());
					messageinfo.setUserid(bn.getBuddy().getUserId());
					messageService.save(messageinfo);
					String[] infos = bn.getMessage().split(":");
					if (infos.length >= 2) {
						mdbh = infos[0];
						sb = new StringBuffer("订货信息已收到,请等候处理.订货信息如下：" + "门店编号【" + mdbh+"】");
						StringTokenizer st = new StringTokenizer(
								infos[1], ";；", false);
						while (st.hasMoreElements()) {
							String str = st.nextToken();
								String[] goods =str.split(",");
								
								if(goods.length<2){
									goods=str.split("，");
									if(goods.length<2)
										break;
								}
								hwbh=goods[0];
								hwsl=goods[1];
							
								System.out.println("门店编号：" + mdbh + " 货物编号："
										+ hwbh + " 货物数量：" + hwsl);
								applyinfo = new ApplyInfo();
								applyinfo.setMdbh(mdbh);
								applyinfo.setHwbh(hwbh);
								applyinfo.setHwsl(Long.parseLong(hwsl));
								applyinfo.setName(bn.getBuddy().getLocalName());
								applyinfo.setPhone(String.valueOf(bn.getBuddy()
										.getMobile()));
								applyinfo.setState("等待审核");
								applyinfo.setTime(DateTime.getDateTime());
								applyinfo.setUserid(bn.getBuddy().getUserId());
								// ApplyInfoService ais = new
								// ApplyInfoService();
								applyInfoService.save(applyinfo);
								sb.append(" 货物编号："	+ hwbh + " 货物数量：" + hwsl+";");
								istrue=true;
							}
							
							
						}
						if(istrue){
							message = sb.toString();
								
						}
				
					client.sendMessage(bn.getBuddy(), message, false);

					break;

				case CLIENT_STATE: // 客户端状态
					ClientStateNotify cn = (ClientStateNotify) notify;
					System.out.println("客户端状态改变了:" + cn.getClientState());
					if (cn.getClientState() == ClientState.NET_ERROR
							|| cn.getClientState() == ClientState.OTHER_LOGIN) {
						isLogout = true;
						client.logout();
					}
					break;

				case BUDDY_STATE: // 好友状态改变
					BuddyStateNotify sn = (BuddyStateNotify) notify;
					System.out.println("好友状态改变了:buddy="
							+ sn.getBuddy().getDisplayName() + ", current="
							+ sn.getCurrentState() + ", before="
							+ sn.getBeforeState());
					break;

				case BUDDY_APPLICATION:
					BuddyApplicationNotify an = (BuddyApplicationNotify) notify;
					System.out.println("收到了好友请求:buddy="
							+ an.getBuddy().getDisplayName() + ", 说明:"
							+ an.getDesc());
					System.out.println("自动同意添加好友请求:"
							+ client.handleBuddyApplication(an.getBuddy(),
									true, null, null));
					break;

				/*
				 * case APPLICATION_CONFIRMED: ApplicationConfirmedNotify fn =
				 * (ApplicationConfirmedNotify) notify;
				 * System.out.println("收到添加好友的回复："
				 * +fn.getBuddy().getDisplayName()
				 * +" "+(fn.isAgreed()?"同意":"拒绝")+"了你添加好友的请求。");
				 * 
				 * if(!fn.isAgreed()) { vc =
				 * client.retireVerifyImage(VerifyImage.TYPE_ADD_BUDDY); dialog
				 * = new VerifyDialog(vc, client); dialog.setVisible(true); vc =
				 * dialog.waitOK();
				 * System.out.println("未同意添加好友请求，重新发起添加好友请求："+client
				 * .addBuddy(""+fn.getBuddy().getMobile(), "xxx", null, null,
				 * vc)); } break;
				 */

				}
			}

		}
		if (isLogout) {
			state=0;
			isListen = false;
		}
	}

}
