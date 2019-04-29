package com.alibaba.service.impl;
import java.util.List;
import com.alibaba.dao.FileDao;
import com.alibaba.entity.File;
import com.alibaba.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class FileServiceImpl implements FileService{
    @Autowired
    private FileDao fileDao;
    @Override
    public long getFileRowCount(){
        return fileDao.getFileRowCount();
    }
    @Override
    public List<File> selectFile(){
        return fileDao.selectFile();
    }
    @Override
    public File selectFileByObj(File obj){
        return fileDao.selectFileByObj(obj);
    }
    @Override
    public File selectFileById(Long id){
        return fileDao.selectFileById(id);
    }
    @Override
    public int insertFile(File value){
        return fileDao.insertFile(value);
    }
    @Override
    public int insertNonEmptyFile(File value){
        return fileDao.insertNonEmptyFile(value);
    }
    @Override
    public int deleteFileById(Long id){
        return fileDao.deleteFileById(id);
    }
    @Override
    public int updateFileById(File enti){
        return fileDao.updateFileById(enti);
    }
    @Override
    public int updateNonEmptyFileById(File enti){
        return fileDao.updateNonEmptyFileById(enti);
    }

    public FileDao getFileDao() {
        return this.fileDao;
    }

    public void setFileDao(FileDao fileDao) {
        this.fileDao = fileDao;
    }

}