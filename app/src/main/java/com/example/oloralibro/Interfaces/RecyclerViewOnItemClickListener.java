package com.example.oloralibro.Interfaces;

import android.view.View;

//INTERFACE PARA PODER OBTENER LA POSICION DEL ITEM SELECCIONADO EN EL RECYRCLE VIEW
public interface RecyclerViewOnItemClickListener {
    void onItemClick(View v, int position);
}
