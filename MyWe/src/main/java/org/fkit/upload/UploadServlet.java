package org.fkit.upload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse resp)throws
	ServletException,IOException{
		doPost(req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws
	ServletException,IOException{
		request.setCharacterEncoding("UTF-8");
		DiskFileItemFactory factory=new DiskFileItemFactory();
		String str=request.getSession().getServletContext().getRealPath("");
		System.out.println(str);
		String path=request.getSession().getServletContext().getRealPath("/upload");
		String pathStr=null;
		System.err.println("上传的图片路径："+path);
		factory.setRepository(new File(path));
		factory.setSizeThreshold(1024*1024);
		ServletFileUpload upload=new ServletFileUpload(factory);
		try{
			List<FileItem> list=(List<FileItem>)upload.parseRequest(request);
			for(FileItem item:list){
				String name=item.getFieldName();
				if(item.isFormField()){
					String value=item.getString();
					request.setAttribute(name, value);
					System.out.println(name);
					
					
				}else{
					String value=item.getName();
					int start=value.lastIndexOf("\\");
					String filename=value.substring(start+1);
					request.setAttribute(name, filename);
					str+="upload\\"+filename;
					pathStr="upload\\"+filename;
					System.err.println("文件存储路径："+str);
					File file=new File(str);
					OutputStream out=new FileOutputStream(file);
					InputStream in=item.getInputStream();
					int length=0;
					byte[] buf=new byte[1024];
					System.out.println("获取上传文件的总共容量："+item.getSize());
					while((length=in.read(buf))!=-1){
						out.write(buf, 0, length);
						
					}
					in.close();
					out.close();
				}
			}
		}catch(FileUploadException e){
			e.printStackTrace();
		}
		catch(Exception e){
			PrintWriter printWriter=response.getWriter();
			printWriter.println(pathStr);
			printWriter.flush();
			printWriter.close();
			
		}
	}

}
