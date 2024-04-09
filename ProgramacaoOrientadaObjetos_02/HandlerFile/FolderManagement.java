package br.com.americanas.polotech.ProOri_02.HandlerFile;

public interface FolderManagement {
    void createAFolder(String directory);
    void removeAFolder(String Path);
    void listAllFoldersCreated();
}
