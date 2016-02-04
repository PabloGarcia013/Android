package ediciones.b.h.mitiempo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by V on 4/2/16.
 */


public class PronosticoHoraViewHolder extends RecyclerView.ViewHolder {

    TextView textViewTexto, textViewTemperatura, textViewFecha,textViewHora;
    ImageView imageView;

    public PronosticoHoraViewHolder(View itemView) {
        super(itemView);

        textViewTexto = (TextView) itemView.findViewById(R.id.text_view_texto);
        imageView = (ImageView) itemView.findViewById(R.id.image_view_icono);
        textViewTemperatura = (TextView) itemView.findViewById(R.id.text_view_temperatura);
        textViewFecha = (TextView) itemView.findViewById(R.id.text_view_fecha);
        textViewHora = (TextView) itemView.findViewById(R.id.text_view_hora);
    }

    public void bind(PronosticoHora pronosticoHora){
        textViewTexto.setText(pronosticoHora.getTexto());
        textViewTemperatura.setText(pronosticoHora.getTemperatura());
        textViewFecha.setText(pronosticoHora.getFecha());
        textViewHora.setText(pronosticoHora.getHoradatos());
    }
}
