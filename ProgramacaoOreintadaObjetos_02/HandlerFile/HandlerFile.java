package br.com.americanas.polotech.ProOri_02.HandlerFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

public class HandlerFile extends FileOrchestrator{


    ImageFileDatabase imageFileOrchestrator;
    FileDatabase fileOrchestrator;

    FolderManagement folderOrchestrator;
//    FolderOrchestrator folderManagement;



    public HandlerFile() {
        imageFileOrchestrator = new FileOrchestrator();
        fileOrchestrator = new FileOrchestrator();
        folderOrchestrator = new FolderOrchestrator();


//        folderOrchestrator.createAFolder("String path");


//        folderManagement.saveImageFile("String directory", "String content", "String nameFile" );
//        folderManagement.saveImageFile("fwe","ewwgre", "ewf");
//        folderManagement.createAFolder("String path");



    }

    public void createImageDirectory(MFile mFile) {
//        folderManagement.createFolder(mFile.getPath(), MFile.getType());
//        ImageIO.write(image, "jpge", new File("C:\\Users\\conta\\IdeaProjects\\CodingTank917\\src\\br\\com\\americanas\\polotech\\ProOri_02\\HandlerFile"));

    }

    public void saveImageFileWithDirectory(MFile mFile) {

    }



    public static void main(String[] args) {
        BufferedImage image;
        try {
            // URL do Github
            URL url = new URL("");
            image = ImageIO.read(url);

            // maquina local
            ImageIO.write(image, "jpge", new File("C:\\Users\\conta\\IdeaProjects\\CodingTank917\\src\\br\\com\\americanas\\polotech\\ProOri_02\\HandlerFile"));



        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
