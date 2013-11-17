package qianyan.mofi.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import qianyan.mofi.entity.ApplyInfo;

public class ExportToExcel {
		
	public ExportToExcel(List<ApplyInfo> list,String name) throws IOException, RowsExceededException, WriteException{
		if(list!=null){
			Label lab=null;
			Label lab1=null;
			Label lab2 =null;
			Label lab3 =null;
			Label lab4 =null;
			Label lab5 =null;
			Label lab6= null;
			File outFile = new File("D:" + File.separator + name+".xls");
			WritableWorkbook workbook = Workbook.createWorkbook(outFile);
			WritableSheet sheet = workbook.createSheet("name", 0);
			for (int x = 0; x < list.size(); x++) {
				if(x==0){
					int y=0;
					lab = new Label(y++, x, "订单号");
					lab1 =  new Label(y++, x, "货物编号");
					lab2 =  new Label(y++, x, "货物数量");
					lab3 =  new Label(y++, x, "门店编号");
					lab4 =  new Label(y++, x, "订货人");
					lab5 =  new Label(y++, x, "飞信编号");
					lab6 = new Label(y++, x, "订单时间");
					sheet.addCell(lab);
					sheet.addCell(lab1);
					sheet.addCell(lab2);
					sheet.addCell(lab3);
					sheet.addCell(lab4);
					sheet.addCell(lab5);
					sheet.addCell(lab6);
				}
				ApplyInfo applyinfo = list.get(x);
				int y=0;
				lab = new Label(y++, x+1, applyinfo.getId().toString());
				lab1 =  new Label(y++, x+1, applyinfo.getHwbh());
				lab2 =  new Label(y++, x+1, applyinfo.getHwsl().toString());
				lab3 =  new Label(y++, x+1, applyinfo.getMdbh());
				lab4 =  new Label(y++, x+1, applyinfo.getName());
				lab5 =  new Label(y++, x+1, String.valueOf(applyinfo.getUserid()));
				lab6 = new Label(y++, x+1, applyinfo.getTime());
				sheet.addCell(lab);
				sheet.addCell(lab1);
				sheet.addCell(lab2);
				sheet.addCell(lab3);
				sheet.addCell(lab4);
				sheet.addCell(lab5);
				sheet.addCell(lab6);
			}
			workbook.write() ;
			workbook.close() ;
		}
	}
}
