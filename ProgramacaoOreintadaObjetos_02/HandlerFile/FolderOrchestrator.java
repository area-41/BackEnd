package br.com.americanas.polotech.ProOri_02.HandlerFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class FolderOrchestrator extends FileOrchestrator implements FolderManagement {
    List<MFile> files = new ArrayList<MFile>();
    public void createFolders (List<String> mListPaths) {

    }
    public void removeFolders (List<String> mListPaths) {

    }

    @Override
    public void createAFolder(String directory) {
        try {
            MFile mFile = new MFile();
            if (!Files.exists(Path.of(mFile.getPath().toString()+directory))) {
                Files.createDirectory(Path.of(mFile.getPath().toString()+directory));
                System.out.printf("Nova pasta '%s' criada", directory);
            } else {
                System.out.println("Directory already exists");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void removeAFolder(String Path) {

    }

    @Override
    public void listAllFoldersCreated() {
//        Files.getFileStore();

    }
}