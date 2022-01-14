package xyz.itshark.play.graphqlspringboot.example.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
public class Tugas {
    @Id
    private String kodeTugas;

    private String nama;

    @ManyToOne
    @JoinColumn(name = "kodeMatkul",
            nullable = false, updatable = false)
    private Matkul matkul;

    private String deadline;

    public Tugas(String kodeTugas, String nama, Matkul matkul, String deadline) {
        this.kodeTugas = kodeTugas;
        this.nama = nama;
        this.matkul = matkul;
        this.deadline = deadline;
    }
}
