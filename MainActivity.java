package greg.projetos.com.apptrabalho1;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ArrayList<Disciplina> listaDisciplina = new ArrayList<Disciplina>();
    //private EditText objCod = (EditText)findViewById(R.id.objCod);
    //private EditText objDesc = (EditText)findViewById(R.id.objDesc);
    //private EditText objCh = (EditText)findViewById(R.id.objCh);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnEnviarObjeto = (Button)findViewById(R.id.btnEnviarObjeto);
        btnEnviarObjeto.setOnClickListener(this);
        Button btnEnviarListaObjeto = (Button)findViewById(R.id.btnEnviarListaObjeto);
        btnEnviarListaObjeto.setOnClickListener(this);
        Button btnAdicionar = (Button)findViewById(R.id.adicionaLista);
        btnAdicionar.setOnClickListener(this);

    }

    private void enviarListaObjeto(){
        Intent i = new Intent(this,RecebeListaObjetoDisciplina.class);
        i.putParcelableArrayListExtra("listaDisciplina",listaDisciplina);
        startActivity(i);
    }

    private void adicionarLista(){
        EditText objCod = (EditText)findViewById(R.id.objCod);
        EditText objDesc = (EditText)findViewById(R.id.objDesc);
        EditText objCh = (EditText)findViewById(R.id.objCh);
        Disciplina d1 = new Disciplina();
        String desc = objDesc.getText().toString();
        int auxCod=Integer.parseInt(objCod.getText().toString());
        int auxCh = Integer.parseInt(objCh.getText().toString());
        d1.setCodigo(auxCod);
        d1.setDescricao(desc);
        d1.setCargaHoraria(auxCh);
        listaDisciplina.add(d1);
        Toast.makeText(this,"Objeto adicionado com sucesso!",Toast.LENGTH_LONG).show();
        objCod.setText("");
        objDesc.setText("");
        objCh.setText("");
    }

    private void enviarObjeto(){
        EditText objCod = (EditText)findViewById(R.id.objCod);
        EditText objDesc = (EditText)findViewById(R.id.objDesc);
        EditText objCh = (EditText)findViewById(R.id.objCh);
        Disciplina disciplina = new Disciplina();
        String desc = objDesc.getText().toString();
        int auxCod=Integer.parseInt(objCod.getText().toString());
        int auxCh = Integer.parseInt(objCh.getText().toString());
        disciplina.setCodigo(auxCod);
        disciplina.setDescricao(desc);
        disciplina.setCargaHoraria(auxCh);
        Intent i = new Intent(this,RecebeObjetoDisciplinaActivity.class);
        i.putExtra("DISCIPLINA", (Serializable) disciplina);
        startActivity(i);
        objCod.setText("");
        objDesc.setText("");
        objCh.setText("");
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnEnviarObjeto:
                enviarObjeto();
                break;

            case R.id.btnEnviarListaObjeto:
                enviarListaObjeto();
                break;

            case R.id.adicionaLista:
                adicionarLista();
                break;
        }
    }
}
