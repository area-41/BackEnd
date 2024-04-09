package br.com.americanas.polotech.ProOri_02.HandlerFile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Application {
    static Scanner sc = new Scanner(System.in);
        static HandlerFile handlerFile = new HandlerFile();

    public static void main(String[] args) {
        intro();
        questionOne();

//        MFile mFile = new MFile();
//        mFile.setContent("Bla bla");
//        mFile.setNameFile("outro3.txt");
//        handlerFile.createFile(mFile);
    }

    public static void questionOne() {
        Boolean key = Boolean.TRUE;
        while (key){
//            System.out.println(Arrays.stream(ActionsEnum.values()).map(ActionsEnum::getActionsCode).collect(Collectors.toList()));
            System.out.println("\n\tSAIR (0)");
            for (ActionsEnum actionsEnum : ActionsEnum.values()){
                System.out.println("\t\t"+actionsEnum+" ("+actionsEnum.getActionsCode()+")");}
            System.out.println("Olá, o quê você deseja fazer?\t");
//        ActionsEnum actionsEnum = ActionsEnum.valueOf(sc.nextLine().toUpperCase());
            int actionsEnum = sc.nextInt();
            try {
                switch (actionsEnum) {
                    case 0 -> {
                        System.out.println("Sair\nOk, saindo...!!!\n\n::System OFF::");
                        key = Boolean.FALSE;
                    }
                    case 1 -> {
                        System.out.println("Save txt");
                        handlerFile.saveFile();
                        questionTwo();
                    }
                    case 2 -> {
                        System.out.println("Save Image");
                        handlerFile.imageFileOrchestrator.saveImageFile("teste", "Qualquer coisa", "arquivoPicture.jpg");

                    }
                    case 3 -> {
                        System.out.println("Delete txt");
//                        handlerFile.fileOrchestrator.removeFile("arquivo55", "teste");
                        handlerFile.fileOrchestrator.removeFile();
                    }
                    case 4 -> {
                        System.out.println("Delete Image");
                        handlerFile.imageFileOrchestrator.removeImageFile("teste", "arquivoPicture.jpg");
                    }
                    case 5 -> {
                        System.out.println("Create Folder\nDigite o nome da pasta que deseja criar:");
                        Scanner sc = new Scanner(System.in);
                        String directory = sc.nextLine();
                        handlerFile.folderOrchestrator.createAFolder(directory);
                    }
                    case 6 -> {
                        System.out.println("Listar");
                        handlerFile.fileOrchestrator.listAllFiles();
                    }
                    case 7 -> {
                        System.out.println("Recovery arquivo");
//                        handlerFile.fileOrchestrator.recoveryFile("teste2", "arquivo.txt");
                        handlerFile.fileOrchestrator.recoveryFile();
                    }
                    default -> {
                        System.out.println("Opção inválida. Tente novamente");
                    }
                }
            } catch (IllegalArgumentException e){
                System.out.println("Valor invalido.");
            }
        }
//
    }




    public static void questionThree(){
        System.out.println("O que deseja criar? >>> FILE, IMAGE, FOLDER");
        TypeActionEnum typeActionEnum = TypeActionEnum.valueOf(String.valueOf(sc.nextLine().toUpperCase()));

        switch (typeActionEnum) {
            case IMAGE -> {
                System.out.println("Qual o diretorio?");
                String directory = sc.nextLine();
                System.out.println("Qual a extensao?");
                String content = sc.nextLine();
                System.out.println("Qual o nome do arquivo?");
                String nameFile = sc.nextLine();
                handlerFile.imageFileOrchestrator.saveImageFile(directory, content, nameFile);

            }
            case FILE -> {

            }
            case FOLDER -> {

            }

        }
    }

    public static void questionTwo(){
        System.out.println("Em qual tipo de categoria quer salvar? >>> REMINDER, IMPORTANT, SIMPLE, IMAGE");
        MFileAnnotationTypeEnum mFileAnnotationTypeEnum = MFileAnnotationTypeEnum.valueOf(sc.nextLine().toUpperCase());
        switch (mFileAnnotationTypeEnum) {
            case IMAGE -> {
                handlerFile.folderOrchestrator.createAFolder("images");
                System.out.println("Pasta images -> criada");
            }
            case REMINDER -> {
                handlerFile.folderOrchestrator.createAFolder("reminders");
                System.out.println("Pasta reminders -> criada");
//                handlerFile.fileOrchestrator.saveFile();
//                try {
//                    FileWriter file = new FileWriter("C:\\Users\\conta\\IdeaProjects\\CodingTank917\\src\\br\\com\\americanas\\polotech\\ProOri_02\\HandlerFile\\reminders\\");
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }

            }
            case IMPORTANT -> {
                handlerFile.folderOrchestrator.createAFolder("importants");
                System.out.println("Pasta importants -> criada");

            }
            case SIMPLE -> {
                handlerFile.folderOrchestrator.createAFolder("simples");
                System.out.println("Pasta simples -> criada");
            }
        }
    }
    public static void intro(){
        System.out.println("::System ON::");
    }
}
