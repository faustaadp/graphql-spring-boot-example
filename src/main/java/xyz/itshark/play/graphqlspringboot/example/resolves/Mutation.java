package xyz.itshark.play.graphqlspringboot.example.resolves;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xyz.itshark.play.graphqlspringboot.example.pojo.Hello;
import xyz.itshark.play.graphqlspringboot.example.pojo.Mahasiswa;
import xyz.itshark.play.graphqlspringboot.example.pojo.Matkul;
import xyz.itshark.play.graphqlspringboot.example.pojo.Tugas;
import xyz.itshark.play.graphqlspringboot.example.service.HelloService;
import xyz.itshark.play.graphqlspringboot.example.service.MahasiswaService;
import xyz.itshark.play.graphqlspringboot.example.service.MatkulService;
import xyz.itshark.play.graphqlspringboot.example.service.TugasService;

@Component
public class Mutation implements GraphQLMutationResolver {

    @Autowired
    HelloService helloService;

    @Autowired
    MatkulService matkulService;

    @Autowired
    TugasService tugasService;

    @Autowired
    MahasiswaService mahasiswaService;

    public Hello addHello(String message, int nomor) {
        return helloService.addHello(message, nomor);
    }

    public Matkul addMatkul(String kodeMatkul, String nama, int sks) {
        return matkulService.addMatkul(kodeMatkul, nama, sks);
    }

    public Tugas addTugas(String kodeTugas, String nama, String kodeMatkul, String deadline) {
        return tugasService.addTugas(kodeTugas, nama, matkulService.findByKodeMatkul(kodeMatkul), deadline);
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
        return tugasService.updateTugas(kodeTugas, nama, matkulService.findByKodeMatkul(kodeMatkul), deadline);
    }

    public Matkul updateMatkul(String kodeMatkul, String nama, int sks){
        return matkulService.updateMatkul(kodeMatkul, nama, sks);
    }

    public Mahasiswa updateMahasiswa(Long npm, String nama){
        return mahasiswaService.updateMahasiswa(npm, nama);
    }

    public Mahasiswa subscribe(Long npm, String kodeMatkul){
        return mahasiswaService.subscribe(npm, matkulService.findByKodeMatkul(kodeMatkul));
    }
}
