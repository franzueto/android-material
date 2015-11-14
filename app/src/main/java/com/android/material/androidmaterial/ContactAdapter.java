package com.android.material.androidmaterial;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Byron on 11/13/2015.
 */
public class ContactAdapter<Contact> extends ArrayAdapter<Contact>{

    private Context context;
    private List<Contact> contactList;

    public ContactAdapter(Context context, List<Contact> contactList) {
        super(context, 0, contactList);
        this.context = context;
        this.contactList = contactList;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       com.android.material.androidmaterial.Contact contact = (com.android.material.androidmaterial.Contact) contactList.get(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_contact, parent, false);
        }

        ImageView imageThumbnailContact = (ImageView) convertView.findViewById(R.id.imageThumbnailContact);
        String imageUrl = contact.getImageUrl();

        if(imageUrl !=null){
            Picasso.with(this.context)
                    .load(imageUrl)
                    .into(imageThumbnailContact);
        }else{
            Picasso.with(context).
                    load(R.drawable.contact_no_pic).
                    into(imageThumbnailContact);
        }

        TextView textViewNameArtist = (TextView) convertView.findViewById(R.id.textViewNameContact);
        textViewNameArtist.setText(contact.getName());

        TextView textViewNameAlbum = (TextView) convertView.findViewById(R.id.textViewContactNumber);
        textViewNameAlbum.setText(contact.getPhoneNumber());

        return convertView;
    }
}
