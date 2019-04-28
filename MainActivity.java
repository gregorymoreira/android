package greg.projetos.com.apptrabalho2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //cria a lista de objetos do tipo disciplina
    private ArrayList<Disciplina> listaDisciplina = new ArrayList<Disciplina>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnAdicionar = (Button) findViewById(R.id.btnAdicionarObjetoLista);
        btnAdicionar.setOnClickListener(this);
        Button btnExibeListView = (Button)findViewById(R.id.btnExibeListView);
        btnExibeListView.setOnClickListener(this);
        Button btnExibeGridView = (Button) findViewById(R.id.btnExibeGridView);
        btnExibeGridView.setOnClickListener(this);
    }

    public void adicionaObjetoLista(){
        EditText edtCodigo = (EditText)findViewById(R.id.edtCodigo);
        EditText edtDescr =  (EditText)findViewById(R.id.edtDescricao);
        EditText edtCargaHorara = (EditText)findViewById(R.id.edtCargaHoraria);
        Disciplina d = new Disciplina();
        int cod = Integer.parseInt(edtCodigo.getText().toString());
        int cargaHoraria = Integer.parseInt(edtCargaHorara.getText().toString());
        //seta os valores do objeto
        d.setCodigo(cod);
        d.setDescricao(edtDescr.getText().toString());
        d.setCargaHoraria(cargaHoraria);
        //adiciona o objeto a lista
        listaDisciplina.add(d);
        Toast.makeText(this,"Objeto adicionado à lista com sucesso",Toast.LENGTH_LONG).show();
        edtCodigo.setText("");
        edtDescr.setText("");
        edtCargaHorara.setText("");

    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btnAdicionarObjetoLista:
                adicionaObjetoLista();
                break;
            case R.id.btnExibeListView:
                chamaExibeListView();
                break;
            case R.id.btnExibeGridView:
                chamaExibeGridView();
                break;
        }
    }

    private void chamaExibeGridView() {
        //primeiro antes de exibir envia a lista de objetos pra outra activity
        Intent i = new Intent(this,RecebeListaObjExibeGrid.class);
        i.putParcelableArrayListExtra("listaDisciplina",listaDisciplina);
        startActivity(i);

    }

    private void chamaExibeListView() {
        //primeiro antes de exibir envia a lista de objetos pra outra activity
        Intent i = new Intent(this,RecebeListaObjExibeList.class);
        i.putParcelableArrayListExtra("listaDisciplina",listaDisciplina);
        startActivity(i);
    }
}
