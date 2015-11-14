package com.android.material.androidmaterial;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Refernciamos los elementos visuales de la vista
        ListView contactListView = (ListView) findViewById(R.id.listView);
        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);

        //Obtenemos los datos para la lista


        //Creamos el adapter y se lo asignamos a la lista
        final ContactAdapter contactAdapter = new ContactAdapter<Contact>(
                this,
                getContactList());
        contactListView.setAdapter(contactAdapter);

        //Colocamos el listener en la lista
        contactListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Contact contact = (Contact)contactAdapter.getItem(position);
                callNewActivity(contact);
            }
        });

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               callNewContact();
            }
        });
    }

    //Llamar a la actividad de detalle de contacto
    private void callNewActivity(Contact contact){
        String textToShow = "Contact selected: " + contact.getName();
        Toast toast = Toast.makeText(getApplicationContext(), textToShow,  Toast.LENGTH_SHORT);
        toast.show();
    }

    private void callNewContact(){
        startActivity(new Intent(getApplicationContext(), NewContactActivity.class));
    }


    private List<Contact> getContactList() {
        ArrayList<Contact> list = new ArrayList<Contact>();

        Contact contact1 = new Contact();
        contact1.setName("Juan");
        contact1.setPhoneNumber("12345678");

        Contact contact2 = new Contact();
        contact2.setName("Maria");
        contact2.setPhoneNumber("12345678");

        Contact contact3 = new Contact();
        contact3.setName("Ana");
        contact3.setPhoneNumber("12345678");

        list.add(contact1);
        list.add(contact2);
        list.add(contact3);

        return list;
    }
}
