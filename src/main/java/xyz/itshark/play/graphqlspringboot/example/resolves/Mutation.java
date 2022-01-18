package xyz.itshark.play.graphqlspringboot.example.resolves;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import xyz.itshark.play.graphqlspringboot.example.pojo.Mahasiswa;
import xyz.itshark.play.graphqlspringboot.example.pojo.Matkul;
import xyz.itshark.play.graphqlspringboot.example.pojo.Tugas;
import xyz.itshark.play.graphqlspringboot.example.repository.MahasiswaRepository;
import xyz.itshark.play.graphqlspringboot.example.repository.MatkulRepository;
import xyz.itshark.play.graphqlspringboot.example.repository.TugasRepository;
import xyz.itshark.play.graphqlspringboot.example.service.MahasiswaService;
import xyz.itshark.play.graphqlspringboot.example.service.MatkulService;
import xyz.itshark.play.graphqlspringboot.example.service.TugasService;

@Component
public class Mutation implements GraphQLMutationResolver {
    private MatkulService matkulService;

    private TugasService tugasService;

    private MahasiswaService mahasiswaService;

//    public Mutation(MatkulService matkulService, TugasService tugasService, MahasiswaService mahasiswaService) {
//        this.matkulService = matkulService;
//        this.tugasService = tugasService;
//        this.mahasiswaService = mahasiswaService;
//    }

    public Matkul addMatkul(String kodeMatkul, String nama, int sks) {
        return matkulService.addMatkul(kodeMatkul, nama, sks);
    }

    public Tugas addTugas(String kodeTugas, String nama, String kodeMatkul, String deadline) {
        return tugasService.addTugas(kodeTugas, nama, matkulService.getMatkulByKodeMatkul(kodeMatkul), deadline);
    }

    public Mahasiswa addMahasiswa(Long npm, String nama) {
        return mahasiswaService.addMahasiswa(npm, nama);
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

    public Tugas updateTugas(String kodeTugas, String nama, String kodeMatkul, String deadline) {
        return tugasService.updateTugas(kodeTugas, nama, matkulService.getMatkulByKodeMatkul(kodeMatkul), deadline);
    }

    public Matkul updateMatkul(String kodeMatkul, String nama, int sks){
        return matkulService.updateMatkul(kodeMatkul, nama, sks);
    }

    public Mahasiswa updateMahasiswa(Long npm, String nama){
        return mahasiswaService.updateMahasiswa(npm, nama);
    }

    public Mahasiswa subscribe(Long npm, String kodeMatkul){
        return mahasiswaService.subscribe(npm, matkulService.getMatkulByKodeMatkul(kodeMatkul));
    }
}
