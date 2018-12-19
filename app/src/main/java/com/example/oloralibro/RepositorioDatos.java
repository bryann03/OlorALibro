package com.example.oloralibro;

import android.content.Context;
import org.json.JSONException;
import android.content.res.AssetManager;

import com.example.oloralibro.DatosLibreria;
import com.example.oloralibro.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class RepositorioDatos
{
    //METODO PARA RELLENAR Y OBTENER LOS DATOS LAS LIBRERIAS EN LAS CARDVIEW'S
    public static ArrayList<DatosLibreria> getDatosLibrerias()
    {
        ArrayList<DatosLibreria> librerias = new ArrayList<>();
        librerias.add(new DatosLibreria("Libreria Studio","Calle Aribau, 93", R.drawable.libstudio));
        librerias.add(new DatosLibreria("Libreria Santaco", "Calle Benidorm, 23", R.drawable.libsantaco));
        librerias.add(new DatosLibreria("Libreria Badalona", "Calle Guifré, 11", R.drawable.libadalona));
        librerias.add(new DatosLibreria("Libreria Vic","Calle Pellaires, 32", R.drawable.libvic));
        librerias.add(new DatosLibreria("Libreria Betis", "Avenida de Les Corts, 34", R.drawable.libetis));
        librerias.add(new DatosLibreria("Libreria Ana", "Calle Santa Ana, 21", R.drawable.libana));
        librerias.add(new DatosLibreria("Libreria Paquito", "Calle el valle, 50", R.drawable.libpaquito));
        return librerias;
    }

    //METODO PARA RELLENAR Y OBTENER LOS DATOS DE LOS PREMIOS EN LAS CARDVIEW'S
    public static ArrayList<DatosPremios> getDatosPremios()
    {
        ArrayList<DatosPremios> premios = new ArrayList<>();
        premios.add(new DatosPremios("10€ Descuento",
                "Aprovecha este descuento inmediato de 10€ sobre tu proxima compra en todas nuestras tiendas adheridas." ,
                200, R.drawable.casalibro));

        premios.add(new DatosPremios("¡Entrada 2X1!",
                "Al comprar tu entrada general para el Museo obtén otra totalmente gratuita con todas sus ventajas" ,
                200, R.drawable.museolibro));

        premios.add(new DatosPremios("50% descuento", "Con tu proxima compra superior a 4000€ obtén un 50% de descuento inmediato" ,
                600, R.drawable.abacuspremio));

        premios.add(new DatosPremios("10€ Descuento",
                "Aprovecha este descuento inmediato de 10€ sobre tu proxima compra en todas nuestras tiendas adheridas." ,
                200, R.drawable.casalibro));

        premios.add(new DatosPremios("¡Entrada 2X1!",
                "Al comprar tu entrada general para el Museo obtén otra totalmente gratuita con todas sus ventajas" ,
                200, R.drawable.museolibro));

        premios.add(new DatosPremios("50% descuento", "Con tu proxima compra superior a 4000€ obtén un 50% de descuento inmediato" ,
                600, R.drawable.abacuspremio));

        return premios;
    }
}
