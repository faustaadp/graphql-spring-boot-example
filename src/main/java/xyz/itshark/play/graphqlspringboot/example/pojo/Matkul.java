package xyz.itshark.play.graphqlspringboot.example.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "matkul")
public class Matkul {
    @Id
    @Column(name = "kodeMatkul", updatable = false, nullable = false)
    private String kodeMatkul;

    @Column(name = "nama", updatable = true, nullable = true)
    private String nama;

    @Column(name = "sks", updatable = true, nullable = true)
    private int sks;

    @OneToMany(mappedBy = "matkul", fetch = FetchType.LAZY)
    private List<Tugas> tugas;

    @JsonIgnore
    @ManyToMany(mappedBy = "matkul")
    private List<Mahasiswa> mahasiswa;

    public Matkul(String kodeMatkul, String nama, int sks) {
        this.kodeMatkul = kodeMatkul;
        this.nama = nama;
        this.sks = sks;
        this.tugas = new ArrayList<Tugas>();
    }

    public Matkul() {

    }

    public String getKodeMatkul() {
        return this.kodeMatkul;
    }

    public String getNama() {
        return this.nama;
    }

    public int sks() {
        return this.sks;
    }

    public List<Tugas> getTugas() {
        return this.tugas;
    }

    public void addTugas(Tugas tugas) {
        this.tugas.add(tugas);
    }

    public void removeTugas(Tugas tugas) {
        this.tugas.remove(tugas);
    }

    public void setKodeMatkul(String kodeMatkul) {
        this.kodeMatkul = kodeMatkul;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setSks(int sks) {
        this.sks = sks;
    }

    public void setTugas(List<Tugas> tugas) {
        this.tugas = tugas;
    }


}
