package com.example.listacontactosconcustonadapter

import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import androidx.activity.ComponentActivity


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.listView)

        val contactoList = getContactos()

        val itemsAdapter = ContactAdapter(context = this, contactoList)

        listView.adapter =itemsAdapter

        listView.onItemClickListener =

            AdapterView.OnItemClickListener{ parent, view,  position, id ->
                val nombContacto = contactoList[position].nombreCont
                val telefContacto = contactoList[position].telefCont
                Toast.makeText(
                    applicationContext,
                    "El número de $nombContacto es $telefContacto", Toast.LENGTH_SHORT
                )
                    .show()

            }
}

    private fun getContactos():ArrayList<ContactoModel>{

        val contactosModel = arrayListOf(
            ContactoModel("Alejandro Uroza", "2281577028", "alejandrociduroza@gmail.com", R.drawable.contacto1),
            ContactoModel("Fernanda Solis", "5550123456", "fer_17solis@outlook.com", R.drawable.contacto2),
            ContactoModel("Olivia Cid", "2281223367", "Toca para registrar un correo", R.drawable.contacto3),
            ContactoModel("Armando Anell", "2281098765", "armAnell_18@gmail.com", R.drawable.contacto4)
        )

        return contactosModel
