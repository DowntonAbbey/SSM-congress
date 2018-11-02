package com.qf.meeting.utils;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

public class CommonUtils {

	public static String fileUpload(HttpServletRequest request) {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		String photo = null;
		// 检查form中是否有enctype="multipart/form-data"
		if (multipartResolver.isMultipart(request)) {
			// 将request变成多部分request
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			// 获取multiRequest 中所有的文件名
			Iterator<?> iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				// 一次遍历所有文件
				MultipartFile file = multiRequest.getFile(iter.next().toString());
				@SuppressWarnings("deprecation")
				File fileDir = new File(request.getRealPath("/upload/"));
				if(!fileDir.exists()) {
					fileDir.mkdirs();
				}
				if (file != null) {
					@SuppressWarnings("deprecation")
					String path = request.getRealPath("/upload/" + file.getOriginalFilename());
					
					//获取文件名
					photo = file.getOriginalFilename();
					// 上传
					try {
						file.transferTo(new File(path));
					} catch (IllegalStateException | IOException e) {
						e.printStackTrace();
					}
				}

			}

		}
		return photo;
	}
}
