package xyz.itshark.play.graphqlspringboot.example.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
public class Matkul {
    @Id
    private String kodeMatkul;

    private String nama;

    private int sks;

    @OneToMany(mappedBy = "matkul")
    private List<Tugas> tugas;

    public Matkul(String kodeMatkul, String nama, int sks) {
        this.kodeMatkul = kodeMatkul;
        this.nama = nama;
        this.sks = sks;
        this.tugas = new ArrayList<Tugas>();
    }

    public void addTugas(Tugas tugas) {
        this.tugas.add(tugas);
    }

    public void removeTugas(Tugas tugas) {
        this.tugas.remove(tugas);
    }
}
