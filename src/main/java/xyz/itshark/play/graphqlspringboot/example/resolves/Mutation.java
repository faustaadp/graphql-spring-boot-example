package xyz.itshark.play.graphqlspringboot.example.resolves;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xyz.itshark.play.graphqlspringboot.example.pojo.Mahasiswa;
import xyz.itshark.play.graphqlspringboot.example.pojo.Matkul;
import xyz.itshark.play.graphqlspringboot.example.pojo.Tugas;
import xyz.itshark.play.graphqlspringboot.example.service.MahasiswaService;
import xyz.itshark.play.graphqlspringboot.example.service.MatkulService;
import xyz.itshark.play.graphqlspringboot.example.service.TugasService;

@Component
public class Mutation implements GraphQLMutationResolver {
    @Autowired
    private MatkulService matkulService;

    @Autowired
    private TugasService tugasService;

    @Autowired
    private MahasiswaService mahasiswaService;

    public Matkul addMatkul(String kodeMatkul, String nama, int sks) {
        return matkulService.addMatkul(kodeMatkul, nama, sks);
    }

    public Tugas addTugas(String kodeTugas, String nama, String kodeMatkul, String deadline) {
        return tugasService.addTugas(kodeTugas, nama, kodeMatkul, deadline);
    }

    public Mahasiswa addMahasiswa(Long npm, String nama) {
        return mahasiswaService.addMahasiswa(npm, nama);
    }

    public boolean addTugasBulk(String kodeTugas, String nama, String kodeMatkul, String deadline, int jumlah) {
        return tugasService.addTugasBulk(kodeTugas, nama, kodeMatkul, deadline, jumlah);
    }

    public boolean deleteTugas(String kodeTugas) {
        return tugasService.deleteTugas(kodeTugas);
    }

    public boolean deleteMatkul(String kodeMatkul) {
        return matkulService.deleteMatkul(kodeMatkul);
    }

    public boolean deleteMahasiswa(Long npm) {
        return mahasiswaService.deleteMahasiswa(npm);
    }

    public int deleteTugasByKodeMatkul(String kodeMatkul) {
        return tugasService.deleteTugasByKodeMatkul(kodeMatkul);
    }

    public Tugas updateTugas(String kodeTugas, String nama, String kodeMatkul, String deadline) {
        return tugasService.updateTugas(kodeTugas, nama, kodeMatkul, deadline);
    }

    public Matkul updateMatkul(String kodeMatkul, String nama, int sks) {
        return matkulService.updateMatkul(kodeMatkul, nama, sks);
    }

    public Mahasiswa updateMahasiswa(Long npm, String nama) {
        return mahasiswaService.updateMahasiswa(npm, nama);
    }

    public Mahasiswa subscribe(Long npm, String kodeMatkul) {
        return mahasiswaService.subscribe(npm, kodeMatkul);
    }
}
