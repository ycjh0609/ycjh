package com.ycjh.file.model;

public class FileModel implements Comparable<FileModel> {
    String fileName;
    String filePath;
    String type;


    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public String getType() {
        return type;
    }

    @Override
    public int compareTo(FileModel fileModel) {
        return fileName.compareTo(fileModel.getFileName());
    }


}
