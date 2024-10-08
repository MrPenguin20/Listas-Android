package mx.edu.itl.c85360673.u3listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListaSencillaActivity extends AppCompatActivity {

    private final String [] estados   = { "Issac Newton", "Wilhelm", "Huygens", "Denis Papin", "Cartwright",
                                          "Senefelder" };
    private final String [] capitales = { "Telescopio", "Calculadora", "Reloj de Bolsillo", "Olla a presion", "Telar mecánico",
                                          "Litografía"
                                        };

    private TextView txtvResultado;
    private ListView lstvEstados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_sencilla);

        txtvResultado = findViewById ( R.id.txtvResultado );
        lstvEstados   = findViewById ( R.id.lstvEstados );

        // Se crea un ArrayAdapter: El 2o argumento debe ser el id de un recurso TEXTVIEW
        //                          El 3er argumento es la lista de Strings con los que se va a llenar
        ArrayAdapter adaptador = new ArrayAdapter( this, R.layout.list_fila_sencilla, estados );
        lstvEstados.setAdapter ( adaptador );

        // Establecemos el listener para el evento OnItemClick  del ListView
        lstvEstados.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick ( AdapterView<?> parent, View view, int i, long l ) {
                txtvResultado.setText ( "Esta persona " + lstvEstados.getItemIdAtPosition( i ) +
                        " invento:  " + capitales [ i ] );

                String estado = ( (TextView) view ).getText().toString();
                Toast.makeText( ListaSencillaActivity.this, estado, Toast.LENGTH_SHORT )
                        .show();
            }
        });

    }


}
