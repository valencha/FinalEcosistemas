package icesi.dmi.com.finalecosistemas;

public class Curso {
    String cursoId;
    String cursoTitulo;

    public Curso(){

    }


    public Curso(String cursoId, String cursoTitulo) {
        this.cursoId = cursoId;
        this.cursoTitulo = cursoTitulo;

    }

    public String getCursoId() {
        return cursoId;
    }

    public String getCursoTitulo() {
        return cursoTitulo;
    }
}
