package xyz.itshark.play.graphqlspringboot.example.pojo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "mahasiswa")
public class Mahasiswa {
    @Id
    @Column(name = "npm", updatable = false, nullable = false)
    private Long npm;

    @Column(name = "nama", updatable = true, nullable = true)
    private String nama;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "listMatkul",
            joinColumns = @JoinColumn(name = "npm"),
            inverseJoinColumns = @JoinColumn(name = "kodeMatkul")
    )
    private List<Matkul> matkul;

    public Mahasiswa(Long npm, String nama) {
        this.npm = npm;
        this.nama = nama;
        this.matkul = new ArrayList<>();
    }

    public Mahasiswa() {

    }

    public void subscribe(Matkul matkul) {
        if(this.matkul.contains(matkul)) {
            this.matkul.remove(matkul);
        }
        else {
            this.matkul.add(matkul);
        }
    }

    public List<Matkul> getMatkul() {
        return matkul;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
