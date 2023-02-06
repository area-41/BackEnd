package br.com.americanas.polotech.ProOri_02.HandlerFile;

import java.util.List;

public class MFile {
    String content;
    String nameFile;
    MFileAnnotationTypeEnum type;

    public String path = "C:\\Users\\conta\\IdeaProjects\\CodingTank917\\src\\br\\com\\americanas\\polotech\\ProOri_02\\HandlerFile\\";

    List<String> mFileList;
    List<String> mImageFileList;

    public String getPath() {
        return path;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNameFile() {
        return nameFile;
    }

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }

    public MFileAnnotationTypeEnum getType() {
        return type;
    }

    public void setType(MFileAnnotationTypeEnum type) {
        this.type = type;
    }
}
