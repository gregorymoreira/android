package greg.projetos.com.apptrabalho1;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Disciplina implements Serializable, Parcelable {

    Integer codigo;
    String descricao;
    Integer cargaHoraria;

    public Disciplina() {
    }

    public Disciplina(Parcel in){
        codigo = in.readInt();
        descricao = in.readString();
        cargaHoraria = in.readInt();
    }

    public static final Parcelable.Creator<Disciplina> CREATOR = new Parcelable.Creator<Disciplina>(){
        public Disciplina createFromParcel(Parcel in){
            return new Disciplina(in);
        }
        public Disciplina[] newArray(int size){
            return new Disciplina[size];
        }
    };

    public Double cargaHorariaToHoraRelogio(){

        return this.cargaHoraria /60.0;
    }

    public Integer getCodigo() {
        return codigo;
    }


    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(codigo);
        dest.writeString(descricao);
        dest.writeInt(cargaHoraria);
    }
}
