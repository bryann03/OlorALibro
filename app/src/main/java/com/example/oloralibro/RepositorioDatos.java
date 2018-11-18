package com.example.oloralibro;

import com.example.oloralibro.DatosLibreria;
import com.example.oloralibro.R;

import java.util.ArrayList;

public class RepositorioDatos
{
    //METODO PARA RELLENAR Y OBTENER LOS DATOS LAS LIBRERIAS
    public static ArrayList<DatosLibreria> getDatosLibrerias()
    {
        ArrayList<DatosLibreria> librerias = new ArrayList<>();
        librerias.add(new DatosLibreria("Libreria Studio","Barcelona", R.drawable.libreriacomics));
        librerias.add(new DatosLibreria("Libreira Santako", "Santa Coloma de Gramenet", R.drawable.libreriacomics));
        librerias.add(new DatosLibreria("Libreria Badalona", "Badalona", R.drawable.libreriacomics));
        librerias.add(new DatosLibreria("Libreria Vic","VIc", R.drawable.libreriacomics));
        librerias.add(new DatosLibreria("Libreira Betis", "Calle Retis 30", R.drawable.libreriacomics));
        librerias.add(new DatosLibreria("Libreria Ana", "Av Santa Ana 2000", R.drawable.libreriacomics));
        return librerias;
    }

    //METODO PARA RELLENAR Y OBTENER LOS DATOS DE LOS PREMIOS
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
