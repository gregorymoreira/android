package greg.projetos.com.apptrabalho2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class RecebeListaObjExibeList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recebe_lista_obj_exibe_list);
        //cria a lista para receber os dados da outra activity
        ArrayList<Disciplina> listaDisciplina = getIntent().getParcelableArrayListExtra("listaDisciplina");
        //cria o adpter para a lista
        ArrayAdapter<Disciplina> adapterDisciplina;
        adapterDisciplina = new ArrayAdapter<Disciplina>(this,android.R.layout.simple_list_item_1,listaDisciplina);
        ListView listViewDisciplina = (ListView) findViewById(R.id.listViewDisciplina);
        listViewDisciplina.setAdapter(adapterDisciplina);

    }
}
