package xyz.itshark.play.graphqlspringboot.example.pojo;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

@Data
public class Mahasiswa {
    @Id
    private Long npm;

    private String nama;

    @ManyToMany
    List<Matkul> matkul;

    public Mahasiswa(Long npm, String nama) {
        this.npm = npm;
        this.nama = nama;
        this.matkul = new ArrayList<Matkul>();
    }

    public void subscribe(Matkul matkul) {
        if(this.matkul.contains(matkul)) {
            this.matkul.remove(matkul);
        }
        else {
            this.matkul.add(matkul);
        }
    }
}
