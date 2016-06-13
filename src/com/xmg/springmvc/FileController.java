package com.xmg.springmvc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {
	@RequestMapping("/upload")
	public String upload(MultipartFile file){
		System.out.println(file.getContentType());//文件类型
		System.out.println(file.getOriginalFilename());//文件元素名
		System.out.println(file.getSize());//文件大小
		//System.out.println(file.getInputStream());//文件的输入流
		OutputStream os = null;
		try{
			InputStream is = file.getInputStream();
			os = new FileOutputStream(new File("D:/a.xls"));
			IOUtils.copyLarge(is, os);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "redirect:UploadFile.jsp";
	}
	@RequestMapping("/download")
	@ResponseBody//表示请求全部交给response去处理
	public void downLoad(HttpServletResponse response){
		OutputStream os = null;
		InputStream is = null;
		try {
			os = response.getOutputStream();
			is = new FileInputStream(new File("D:/a.jpg"));
			response.setHeader("Content-Disposition", "attachment;filename=a.jpg");
			IOUtils.copyLarge(is, os);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
