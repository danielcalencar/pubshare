package br.ufrn.dimap.pubshare.recomendation;

import br.ufrn.dimap.pubshare.activity.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ActivityRecommendation extends Activity {

	Context tela;
	
	Button botao;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		tela = this;
		
		Button botao = (Button) findViewById(R.id.buttonEnviar);
		botao.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				
				AlertDialog show = new AlertDialog.Builder(tela)
		           .setMessage("Recommend to friends or by another application?")
		           .setCancelable(false)
		           .setPositiveButton("Friends", new DialogInterface.OnClickListener() {
		               public void onClick(DialogInterface dialog, int id) {
		            	   	Intent intent = new Intent();
		            	   	intent.setClass(ActivityRecommendation.this, ActivityFriends.class);
		            	   	startActivity(intent);
		               }
		           })
		           .setNeutralButton("Other applications", new DialogInterface.OnClickListener() {
		               public void onClick(DialogInterface dialog, int id) {				   
						   Intent sendIntent = new Intent();
						   sendIntent.setAction(Intent.ACTION_SEND);
						   sendIntent.putExtra(Intent.EXTRA_TEXT, "Exemplo de artigo a compartilhar. http://www.google.com.br");
						   sendIntent.setType("text/plain");
						   startActivity(sendIntent);
		               }
		           })
		           .show();
				}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu, menu);
		return true;
	}

}
