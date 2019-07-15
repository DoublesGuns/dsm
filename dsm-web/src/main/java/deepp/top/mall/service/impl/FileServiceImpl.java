package deepp.top.mall.service.impl;

import com.google.common.collect.Lists;

import deepp.top.login.util.FTPUtil;
import deepp.top.mall.service.IFileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service("iFileService")
public class FileServiceImpl  implements IFileService {

    private static Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);
    public String upload(MultipartFile file,String path){
        String fileName = file.getOriginalFilename();
        //扩展名 .jpg .txt
        String fileExtensionName = fileName.substring(fileName.lastIndexOf(".")+1);
        String uploadFileName = UUID.randomUUID().toString()+"."+fileExtensionName;
        logger.info("开始上传文件，上传文件的文件名:{},上传路径:{}，新文件名:{}",fileName,path,uploadFileName);
        File filDir = new File(path);
        if (!filDir.exists()){
            filDir.setWritable(true);
            filDir.mkdirs();
        }
        File targetFile = new File(path,uploadFileName);

        try {
            file.transferTo(targetFile);
            //文件已经上传成功
            //todo 将targetFile 上传到ftp服务器
            FTPUtil.uploadFile(Lists.newArrayList(targetFile));
            //todo 上传完之后，删除upload下面的文件
            targetFile.delete();
        } catch (IOException e) {
            logger.error("上传文件异常",e);
            return null;
        }
        return targetFile.getName();
    }
}
