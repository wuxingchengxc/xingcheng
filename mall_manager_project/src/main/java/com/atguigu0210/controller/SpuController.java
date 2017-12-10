package com.atguigu0210.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.atguigu0210.bean.T_MALL_PRODUCT;
import com.atguigu0210.service.SpuServiceImpl;
import com.atguigu0210.util.MyUpLoadFile;

@Controller
public class SpuController {

	@Autowired
	private SpuServiceImpl spuServiceImpl;
	
	@RequestMapping("goto_spu_publish")
	public String goto_spu_publish() {

		return "manager_spu_publish";
	}

	@RequestMapping("save_spu")
	public String save_spu(T_MALL_PRODUCT spu,@RequestParam("files")MultipartFile[] files ) throws IOException{
		//上传文件到服务器
		List<String>  list_images =MyUpLoadFile.image_upload(files);
		//保存SPU基本信息及地址到数据库
		spuServiceImpl.save_spu(spu,list_images);
		return "manager_spu_publish";
	}
	
	
}
