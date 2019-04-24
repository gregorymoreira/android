package greg.projetos.com.apptrabalho1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class RecebeListaObjetoDisciplina extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recebe_lista_objeto_disciplina);

        TextView listaObjCodigo = (TextView)findViewById(R.id.listaObjCodigo);
        TextView listaObjDescricao = (TextView)findViewById(R.id.listaObjDescricao);
        TextView listaObjCargaHoraria = (TextView)findViewById(R.id.listaObjCargaHoraria);
        TextView listaObjHoraRelogio = (TextView)findViewById(R.id.listaObjHoraRelogio);

        ArrayList<Disciplina> listaDisciplina = getIntent().getParcelableArrayListExtra("listaDisciplina");
        if(listaDisciplina != null){
            listaObjCodigo.setText("Código: "+ listaDisciplina.get(1).getCodigo().toString());
            listaObjDescricao.setText("Descrição: " + listaDisciplina.get(1).getDescricao().toString());
            listaObjCargaHoraria.setText("Carga Horária: " + listaDisciplina.get(1).getCargaHoraria().toString());
            listaObjHoraRelogio.setText("Hora real: " + listaDisciplina.get(1).cargaHorariaToHoraRelogio().toString());
        }
    }
}
