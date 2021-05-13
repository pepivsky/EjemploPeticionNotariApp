package com.pepivsky.ejemplopeticionnotariapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pepivsky.ejemplopeticionnotariapp.R
import com.pepivsky.ejemplopeticionnotariapp.response.gettramites.GetTramitesResponse
import com.pepivsky.ejemplopeticionnotariapp.response.gettramites.GetTramitesResponseItem
import com.pepivsky.ejemplopeticionnotariapp.response.tramites.TramitesResponse
import com.squareup.picasso.Picasso

class TramiteAdapter(val listTramite: List<GetTramitesResponseItem>): RecyclerView.Adapter<TramiteAdapter.TramiteHolder>() {

    class TramiteHolder(val view: View): RecyclerView.ViewHolder(view) {
        lateinit var tvNombreTramite: TextView
        lateinit var ivTramite: ImageView

        fun bind(getTramitesResponseItem: GetTramitesResponseItem) {
            //val tvNombreTramite =
            tvNombreTramite = view.findViewById(R.id.tvNombreTramite)
            ivTramite = view.findViewById(R.id.imgTramite)

            tvNombreTramite.text = getTramitesResponseItem.transact
            //cargando la imagen
            getTramitesResponseItem.image?.let { Picasso.get().load(it).into(ivTramite) }


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TramiteHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return TramiteHolder(layoutInflater.inflate(R.layout.item_tramite, parent, false))
    }

    override fun onBindViewHolder(holder: TramiteHolder, position: Int) {
        val item = listTramite[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = listTramite.size
}