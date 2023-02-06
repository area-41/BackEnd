package br.com.americanas.polotech.ProOri_02.HandlerFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FileOrchestrator implements ImageFileDatabase, FileDatabase {
    void saveAllListOfFiles(List<MFile> mFileList) {

    }

    void saveAllListOfImageFiles(List<MFile> mImageFileList) {

    }

    @Override
    public void saveImageFile(String directory, String content, String nameFile) {
        // URL do Github
        BufferedImage image;
        try {
            URL url = new URL("https://raw.githubusercontent.com/gabiandrade/programacao-orientada-objetos-java/main/src/com/ada/example/segunda/aula/exercicio/File_.jpeg");
            image = ImageIO.read(url);
            ImageIO.write(image, "jpg", new File("C:\\Users\\conta\\IdeaProjects\\CodingTank917\\src\\br\\com\\americanas\\polotech\\ProOri_02\\HandlerFile\\teste\\"+nameFile));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void recoveryImageFile(String directory) {

    }

    @Override
    public void removeImageFile(String directory, String nameFile) {
        File file = new File("C:\\Users\\conta\\IdeaProjects\\CodingTank917\\src\\br\\com\\americanas\\polotech\\ProOri_02\\HandlerFile\\" +directory+"\\"+ nameFile);
        file.delete();
    }

    @Override
    public void listAllImageFiles(String directory) {

    }

    @Override
    public void saveFile(){
//        String directory, String content, MFileAnnotationTypeEnum type, String nameFile
        MFile mFile = new MFile();

        System.out.println("Insira um nome para o arquivo TXT que deseja salvar:");
        Application.sc = new Scanner(System.in);
        mFile.nameFile = Application.sc.nextLine();

        System.out.println("Em qual pasta deseja salvar o arquivo?");
        Application.sc = new Scanner(System.in);
        String directory = Application.sc.nextLine();
        if (!Files.exists(Path.of(mFile.getPath()+directory))) {
            try {
                Files.createDirectory(Path.of(mFile.getPath().toString()+directory));
                FileWriter file = new FileWriter("C:\\Users\\conta\\IdeaProjects\\CodingTank917\\src\\br\\com\\americanas\\polotech\\ProOri_02\\HandlerFile\\" +directory+"\\"+ mFile.nameFile+".txt");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if (Files.exists(Path.of(mFile.getPath()+directory))) {
            System.out.printf("A pasta já existe, o arquivo %s.txt será salvo dentro dela.\n", mFile.nameFile);
            try {
                FileWriter file = new FileWriter("C:\\Users\\conta\\IdeaProjects\\CodingTank917\\src\\br\\com\\americanas\\polotech\\ProOri_02\\HandlerFile\\" +directory+"\\"+ mFile.nameFile+".txt");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }  catch (RuntimeException e) {
                System.out.println("Precisa criar a pasta antes.");
            }
//            File file = new File("C:\\Users\\conta\\IdeaProjects\\CodingTank917\\src\\br\\com\\americanas\\polotech\\ProOri_02\\HandlerFile\\" +directory+"\\"+ mFile.nameFile + ".txt");
//            File file = new File(mFile.path +"\\"+directory+"\\"+ mFile.nameFile + ".txt");

        } else {
            System.out.println("Precisa criar a pasta antes.");
        }
    }


//        try {
//            FileWriter file = new FileWriter(mFile.path+mFile.nameFile+".txt");
//            System.out.println(mFile.content.toString());
////            file.write(mFile.content.toString());
////            file.write(mFile.getContent());
////            file.append(mFile.content);
////            System.out.println(mFile.getContent());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } catch (RuntimeException e) {
//            System.out.println("Precisa criar a pasta antes.");
//
//        }


    @Override
    public void recoveryFile (String directory, String nameFile) {
        try {
            MFile mFile = new MFile();
            if (Files.exists(Path.of(mFile.getPath() +"\\" + directory +"\\"+ nameFile))) {
                System.out.println(Files.getFileStore(Path.of(mFile.getPath() +"\\" + directory +"\\" + nameFile)));
                System.out.printf("O arquivo %s foi encontrado na pasta '%s'", nameFile, directory);
            } else {
                System.out.println("Arquivo ou Pasta não encontrada.");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void recoveryFile() {
        Application.sc = new Scanner(System.in);
        System.out.println("Qual o nome do arquivo que deseja procurar? (ex.: arquivo.txt)");
        String nameFile = Application.sc.nextLine();
        System.out.println("Em qual pasta deseja procurar?");
        String directory = Application.sc.nextLine();
        recoveryFile(directory, nameFile);

    }

    public void removeFile (String nameFile, String directory){
        System.out.println("C:\\Users\\conta\\IdeaProjects\\CodingTank917\\src\\br\\com\\americanas\\polotech\\ProOri_02\\HandlerFile\\" +directory+"\\"+ nameFile+".txt");
        File file = new File("C:\\Users\\conta\\IdeaProjects\\CodingTank917\\src\\br\\com\\americanas\\polotech\\ProOri_02\\HandlerFile\\" +directory+"\\"+ nameFile+".txt");
        file.delete();
    }

    public void removeFile () {
        System.out.println("Qual o nome do arquivo que deseja remover?");
        Application.sc = new Scanner(System.in);
        String nameFile = Application.sc.nextLine();
        System.out.println("Em qual pasta?");
        String directory = Application.sc.nextLine();
        File file = new File("C:\\Users\\conta\\IdeaProjects\\CodingTank917\\src\\br\\com\\americanas\\polotech\\ProOri_02\\HandlerFile\\" +directory+"\\"+ nameFile+".txt");
        file.delete();
    }

    public void listAllFiles (String directory) {

    }

    public void listAllFiles () {
        Application.sc = new Scanner(System.in);
        System.out.println("Em qual pasta?");
        String directory = Application.sc.nextLine();
        File file = new File("C:\\Users\\conta\\IdeaProjects\\CodingTank917\\src\\br\\com\\americanas\\polotech\\ProOri_02\\HandlerFile\\" +directory);
        System.out.println(Arrays.stream(file.list()).toList());
    }
}
