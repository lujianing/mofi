import static org.junit.Assert.fail;

import org.junit.Test;

import qianyan.mofi.entity.ApplyInfo;
import qianyan.mofi.service.ApplyInfoService;


public class test {

	@Test
	public void testSave() {
		ApplyInfo a  = new ApplyInfo();
		a.setHwbh("aa");
		a.setHwsl(Long.parseLong("1000"));
		a.setMdbh("111");
		a.setName("a");
		a.setPhone("111");
		a.setState("a");
		a.setTime("a");
		ApplyInfoService ais = new ApplyInfoService();
		ais.save(a);
	//	fail("Not yet implemented");
	}

}
