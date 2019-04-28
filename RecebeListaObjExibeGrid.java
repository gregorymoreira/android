package greg.projetos.com.apptrabalho2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.util.ArrayList;

public class RecebeListaObjExibeGrid extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recebe_lista_obj_exibe_grid);
        //cria a lista para receber os dados da outra activity
        ArrayList<Disciplina> listaDisciplina = getIntent().getParcelableArrayListExtra("listaDisciplina");
        //cria o adpter para a lista
        ArrayAdapter<Disciplina> adapterDisciplina;
        adapterDisciplina = new ArrayAdapter<Disciplina>(this,android.R.layout.simple_list_item_1,listaDisciplina);
        GridView gridViewDisciplina = (GridView)findViewById(R.id.gridViewDisciplina);
        gridViewDisciplina.setAdapter(adapterDisciplina);
    }
}
