package ediciones.b.h.mitiempo;

import android.graphics.Bitmap;

/**
 * Created by V on 4/2/16.
 */
public class PronosticoHora {

    private String fecha;
    private String horadatos;
    private String temperatura;
    private String texto;
    private String humedad;
    private String presion;
    private String icono;
    private String viento;
    private String dirViento;
    private String icoViento;

    public PronosticoHora(String fecha, String horadatos, String temperatura, String texto, String humedad, String presion, String icono, String viento, String dirViento, String icoViento) {
        this.fecha = fecha;
        this.horadatos = horadatos;
        this.temperatura = temperatura;
        this.texto = texto;
        this.humedad = humedad;
        this.presion = presion;
        this.icono = icono;
        this.viento = viento;
        this.dirViento = dirViento;
        this.icoViento = icoViento;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHoradatos() {
        return horadatos;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public String getTexto() {
        return texto;
    }

    public String getHumedad() {
        return humedad;
    }

    public String getPresion() {
        return presion;
    }

    public String getIcono() {
        return icono;
    }

    public String getViento() {
        return viento;
    }

    public String getDirViento() {
        return dirViento;
    }

    public String getIcoViento() {
        return icoViento;
    }
}
