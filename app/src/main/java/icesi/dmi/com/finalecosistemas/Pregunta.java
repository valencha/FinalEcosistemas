package icesi.dmi.com.finalecosistemas;

import android.view.View;
import android.widget.Button;

public class Pregunta {


    String name;
    String pregunta;
    String etiqueta;



    public Pregunta(){}


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }
    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }


}
