package greg.projetos.com.apptrabalho1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class RecebeObjetoDisciplinaActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recebe_objeto_disciplina);
        Bundle b = getIntent().getExtras();
        Disciplina disciplina = (Disciplina)b.get("DISCIPLINA");

        TextView txtObjCodigo = (TextView)findViewById(R.id.objCodigo);
        TextView txtDescricao = (TextView)findViewById(R.id.objDescricao);
        TextView txtCargaHoraria = (TextView)findViewById(R.id.objCargaHoraria);
        TextView txtHoraRelogio = (TextView)findViewById(R.id.objHoraRelogio);

        txtObjCodigo.setText("Códgio: " + disciplina.codigo.toString());
        txtDescricao.setText("Descrição: " + disciplina.descricao.toString());
        txtCargaHoraria.setText("Carga Horária: " + disciplina.cargaHoraria.toString());
        txtHoraRelogio.setText("Horas reais: " + disciplina.cargaHorariaToHoraRelogio().toString());

    }
}
