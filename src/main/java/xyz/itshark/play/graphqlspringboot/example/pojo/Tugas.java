package xyz.itshark.play.graphqlspringboot.example.pojo;

import javax.persistence.*;

@Entity
@Table(name = "tugas")
public class Tugas {
    @Id
    @Column(name = "kodeTugas", updatable = false, nullable = false)
    private String kodeTugas;

    @Column(name = "nama", updatable = true, nullable = true)
    private String nama;

    @ManyToOne
    @JoinColumn(name = "kodeMatkul")
    private Matkul matkul;

    @Column(name = "deadline", updatable = true, nullable = true)
    private String deadline;

    public String getKodeTugas() {
        return kodeTugas;
    }

    public Tugas(String kodeTugas, String nama, Matkul matkul, String deadline) {
        this.kodeTugas = kodeTugas;
        this.nama = nama;
        this.matkul = matkul;
        this.deadline = deadline;
    }

    public Tugas() {

    }

    public Matkul getMatkul() {
        return this.matkul;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setMatkul(Matkul matkul) {
        this.matkul = matkul;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
}
