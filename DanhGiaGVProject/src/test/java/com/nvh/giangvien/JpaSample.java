package com.nvh.giangvien;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nvh.giangvien.model.MonHoc;
import com.nvh.giangvien.model.ThoiKhoaBieu;
import com.nvh.giangvien.model.User;
import com.nvh.giangvien.service.MonHocService;
import com.nvh.giangvien.service.ThoiKhoaBieuService;
import com.nvh.giangvien.service.UserService;

public class JpaSample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext mContext = new ClassPathXmlApplicationContext(
				"root-context.xml");
		ThoiKhoaBieuService tkbService = mContext.getBean("JpaThoikhoabieuService",
				ThoiKhoaBieuService.class);
		UserService gvService = mContext.getBean("JpaUserService",
				UserService.class);
		MonHocService mhService = mContext.getBean("JpaMonHocService",
				MonHocService.class);
		ThoiKhoaBieu tkb = new ThoiKhoaBieu();
		tkb.setSv(gvService.findById("10110200")); //add nguyen van hoa
		tkb.setGv(gvService.findById("2150")); // add thay dao
		tkb.setMonhoc(mhService.findById("LTC"));
		
		tkbService.save(tkb);
	}

}
