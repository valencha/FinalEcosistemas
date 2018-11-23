package icesi.dmi.com.finalecosistemas;

public class Usuario {
     String uid;
     String name;
     String pass;

public Usuario(){

}

    public Usuario(String name, String pass) {
        this.name = name;
        this.pass = pass;



    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String nombre) {
        this.name = name;
    }


    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}
