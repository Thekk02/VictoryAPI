package com.Victory.VictoryApplicationAPI.utils;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileInputStream;

/**
 * @author kk
 * @description 文件输入输出工具类
 * @date 2024-9-3 09:26:14
 */
public class FileUtil {

    /**
    * @Description:文件上传方法
    * @Params: multipartFiles 上传的文件数组
     *         filePath文件保存路径
    * @Return:
    */
    public static String uploadFile(MultipartFile[] multipartFiles,String filePath){
        try{
            File sourceFile = new File(filePath);
            if(!sourceFile.exists()){
                sourceFile.mkdirs();
            }
            if(multipartFiles.length > 0){
                for(MultipartFile multipartFile : multipartFiles){
                    if(multipartFile.isEmpty()){
                        return "上传文件为空！";
                    }
                    String fileName = multipartFile.getOriginalFilename();
                    String path = filePath + File.pathSeparator + fileName;
                    String absolutepath = new File(path).getAbsolutePath();
                    File file = new File(absolutepath);
                    if(!file.getParentFile().exists()){
                        file.getParentFile().mkdirs();
                    }
                    multipartFile.transferTo(file);
                }
                return "上传成功";
            }
            return "上传失败";
        }catch (IOException e){
            e.printStackTrace();
        }
        return "成功！";
    }

    /**
    * @Description: 文件下载方法
    * @Params:
    * @Return:
    */
    public static void download(String fileUrl, String fileName, HttpServletResponse res) throws IOException{
        File file = new File(fileUrl + fileName);
        boolean flag = FileUtil.fileIsExist(fileUrl,fileName);
        if(flag){
            InputStream inputStream = null;
            OutputStream os = null;
            try{
                inputStream = new FileInputStream(file);
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int len = 0;
                while((len = inputStream.read(buffer)) != -1){
                    outputStream.write(buffer,0,len);
                }
                inputStream.close();
                byte[] data = outputStream.toByteArray();
                res.reset();
                res.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
                res.setContentType("applicaiton/octet-stream");
                os = res.getOutputStream();
                os.write(data);
                os.flush();
                os.close();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                if(inputStream != null){
                    inputStream.close();
                }
                if(os != null){
                    os.close();
                }
            }
        }
    }

    /**
    * @Description: 判断文件是否存在
    * @Params: filePath 文件路径
     *         fileName 文件名称
    * @Return:
    */
    public static boolean fileIsExist(String filePath,String fileName){
        File fileSource = new File(filePath + File.separator + fileName);
        if(fileSource.exists()){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 文件复制
     *
     * @param sourcePath 源文件夹目录
     * @param newPath    目标文件夹目录
     */
    public static void copyFile(String sourcePath, String newPath) {
        try {
            BufferedInputStream bufferedInputStream = null;
            BufferedOutputStream bufferedOutputStream = null;
            InputStream input = null;
            OutputStream output = null;
            File fileSource = new File(sourcePath); //源文件对象
            File fileDest = new File(newPath); //目的文件对象
            if (fileSource.exists() && fileSource.list() != null) {
                if (!fileDest.exists()) {
                    fileDest.mkdirs(); //目的文件不存在则先创建目的文件
                }
                String[] list = fileSource.list();
                for (String fileName : list) {
                    input = new FileInputStream(fileSource + File.separator + fileName);
                    bufferedInputStream = new BufferedInputStream(input);
                    output = new FileOutputStream(fileDest + File.separator + fileName);
                    bufferedOutputStream = new BufferedOutputStream(output);
                    byte[] bytes = new byte[2048];
                    int length;
                    while ((length = bufferedInputStream.read(bytes)) > 0) {
                        bufferedOutputStream.write(bytes, 0, length);
                    }
                    bufferedInputStream.close();
                    bufferedOutputStream.close();
                    input.close();
                    output.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
    * @Description:从局域网内共享文件夹下载文件
    * @Params:
    * @Return:
    */
    public static void downloadBySharedFolder(String remoteUrl,HttpServletResponse res) throws IOException{
        InputStream inputStream = null;
        OutputStream os = null;
        try{
            SmbFile remoteFile = new SmbFile(remoteUrl);
            remoteFile.connect();
            if(remoteFile.exists()){
                inputStream = new BufferedInputStream(new SmbFileInputStream(remoteFile));
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int len = 0;
                while((len = inputStream.read(buffer)) != -1){
                    outputStream.write(buffer,0,len);
                }
                inputStream.close();
                byte[] data = outputStream.toByteArray();
                res.reset();
                res.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(remoteFile.getName(), "UTF-8"));
                res.setContentType("applicaiton/pdf");
                os = res.getOutputStream();
                os.write(data);
                os.flush();
                os.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(inputStream != null){
                inputStream.close();
            }
            if(os != null){
                os.close();
            }
        }
    }




































}
