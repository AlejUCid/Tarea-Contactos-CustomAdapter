package com.example.listacontactosconcustonadapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class  ContactAdapter(private val context: Context,
                      private val datos: ArrayList<ContactoModel>
    ): BaseAdapter(){

    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        //Inflamos la vista list_item_contact para cada elemento de la lista
        val rowView = inflater.inflate(R.layout.list_item_contact, parent, false)

        val nombre = rowView.findViewById<View>(R.id.nombre) as TextView
        val telefono = rowView.findViewById<View>(R.id.telefono) as TextView
        val correoElec = rowView.findViewById<View>(R.id.email) as TextView
        val fotoCont = rowView.findViewById<View>(R.id.fotocontacto) as ImageView

        val contactos = getItem(position) as ContactoModel

        nombre.text = contactos.nombreCont
        telefono.text = contactos.telefCont
        correoElec.text = contactos.emailCont
        fotoCont.setImageResource(contactos.imagCont)

        return rowView

    }

    //Regresa un item para ser colocado en la posición position del Listview
    override fun getItem(position: Int): Any {
        return datos[position]
    }

    //Este método define un id para cada item, decidimos usar el index en el array de data
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    //Método le dice al ListView cuantos items mostrar
    override fun getCount(): Int {
        return datos.size
    }

    }
