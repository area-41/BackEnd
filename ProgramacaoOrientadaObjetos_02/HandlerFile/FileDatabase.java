package br.com.americanas.polotech.ProOri_02.HandlerFile;

import javax.sound.midi.Patch;

public interface FileDatabase {

    void saveFile ();
    void recoveryFile (String directory, String nameFile);
    void removeFile (String nameFile, String directory);
    void listAllFiles (String directory);

    void removeFile();

    void recoveryFile();
    void listAllFiles ();
}
