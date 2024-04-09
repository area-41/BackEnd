package br.com.americanas.polotech.ProOri_02.HandlerFile;

 interface ImageFileDatabase {
  void saveImageFile(String directory, String content, String nameFile) ;
  void recoveryImageFile(String directory) ;
  void removeImageFile(String directory, String nameFile) ;
  void listAllImageFiles (String directory) ;
}
