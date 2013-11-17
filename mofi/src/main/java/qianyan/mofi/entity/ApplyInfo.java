package qianyan.mofi.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="applyinfo")
public class ApplyInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	private String mdbh;
	private String hwbh;
	private Long hwsl;
	private String name;	//联系人名
	private String phone;	//手机号
	private String time;
	private String state;  //等待审核 通过审核 完成交易
	private int userid;   
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "mdbh",length=30)
	public String getMdbh() {
		return mdbh;
	}
	public void setMdbh(String mdbh) {
		this.mdbh = mdbh;
	}
	
	@Column(name = "hwbh",length=30)
	public String getHwbh() {
		return hwbh;
	}
	public void setHwbh(String hwbh) {
		this.hwbh = hwbh;
	}
	
	@Column(name = "hwsl",length=8)
	public Long getHwsl() {
		return hwsl;
	}
	public void setHwsl(Long hwsl) {
		this.hwsl = hwsl;
	}
	
	@Column(name = "name",length=30)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "phone",length=15)
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Column(name = "tiem",length=30)
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	@Column(name = "state",length=10)
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	@Column(name = "userid")
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	@Override
	public String toString() {
		return "ApplyInfo [id=" + id + ", mdbh=" + mdbh + ", hwbh=" + hwbh
				+ ", hwsl=" + hwsl + ", name=" + name + ", phone=" + phone
				+ ", time=" + time + ", state=" + state + "]";
	}
	

}
