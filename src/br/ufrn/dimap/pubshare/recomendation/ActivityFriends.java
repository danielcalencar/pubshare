package br.ufrn.dimap.pubshare.recomendation;

import br.ufrn.dimap.pubshare.activity.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class ActivityFriends extends Activity implements OnItemClickListener{

	private final static String[] amigos = new String[] {
		"Friend 1", "Friend 2", "Friend 3"
		};
	
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
		setContentView(R.layout.tela_amigos);
		
		ArrayAdapter<String> lista_amigos = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, amigos);

		ListView list = (ListView) findViewById(R.id.listViewAmigos);
		list.setAdapter(lista_amigos);

		list.setTextFilterEnabled(true);
		list.setOnItemClickListener(this);
	}
	
	public void onItemClick(AdapterView<?> a, View v, int position,	long id) {
		AlertDialog show = new AlertDialog.Builder(this)
        .setMessage("Article shared with "+amigos[position]+"\nOBS: falta enviar de fato ao servidor")
        .setCancelable(false)
        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            	//salvar estatísticas no servidor
            	finish();
            }
        })
        .show();

	}

}
