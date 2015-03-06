package reyes.ivan.examen.tapasleon;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MiActivity extends ActionBarActivity {

    //me creo la variable donde recojo los logs y la redireccion al nombre de mi actividad (MiActivity)
    // por si cambiase el nombre nos lo actualizase automaticamente

    final static String TAG = MiActivity.class.getSimpleName();

    //Actividad 7 Crear Array y el adaptador

    ArrayList <Bar> bares;
    ArrayAdapter <Bar> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi);
        Log.d(TAG, "salvar");

        bares = new ArrayList <Bar>();

        //me creo un Listview al que le puse un ID llamado lista
        ListView lista = (ListView) findViewById(R.id.lista) ;

        //inicializo al adpater y le pasao sus parametros
        adapter = new ArrayAdapter <Bar> (this,android.R.layout.simple_list_item_1,bares);
        //se lo pego a mi list
        lista.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mi, menu);
        return true;
    }

    //me creo el evento on click del boton

    public void botonGuardar (View v){
        //llamo a mi variable de logs

        Log.v(TAG,"evento guardar");

        EditText name = (EditText) findViewById(R.id.name);
        EditText address = (EditText) findViewById(R.id.address);
        //para recoger el valor que metemos en el EditString necesitamos pasarlo a una variable string (nombre por ej)

        String nombre = name.getText().toString();
        String direccion = address.getText().toString();

        //me creo un Objeto de la clase BAR para coger nombre y direccion

        Bar objetos = new Bar (nombre,direccion);

        //Le digo a mi adaptador que añada ese objeto
        adapter.add(objetos);

        //para limpiar los textos una vez introducidos
        name.getText().clear();
        address.getText().clear();


        //me creo un objeto de la clase Toast que le llamo informacion

        Toast informacion=Toast.makeText(this, nombre+" "+ direccion, Toast.LENGTH_SHORT);
            informacion.show();

        //otra manera de toast si crear objeto
        //Toast.makeText(this, nombre+" "+ direccion, Toast.LENGTH_SHORT)
        // Toast.show();


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
