package br.com.americanas.polotech.ProOri_02.HandlerFile;

public enum ActionsEnum {
    SAVETXT(1), SAVEIMAGE(2), DELETETXT(3), DELETEIMAGE(4), CREATEFOLDER(5), LIST(6), RECOVERY(7);


    private final int actionsCode;
    ActionsEnum(int code) {
        actionsCode = code;
    }

    public int getActionsCode() {
        return actionsCode;
    }

}
