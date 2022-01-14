package xyz.itshark.play.graphqlspringboot.example.resolves;


import com.coxautodev.graphql.tools.GraphQLQueryResolver;
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

import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {

    @Autowired
    HelloService helloService;

    @Autowired
    MatkulService matkulService;

    @Autowired
    TugasService tugasService;

    @Autowired
    MahasiswaService mahasiswaService;

    public Hello hello() {

        Hello h = new Hello();
        h.setMessage("hello");
        h.setNomor(12);

        return h;
    }

    public List<Hello> allDataHello() {
        return helloService.getAllHello();
    }
    public List<Matkul> allDataMatkul() {
        return matkulService.getAllMatkul();
    }
    public List<Tugas> allDataTugas() {
        return tugasService.getAllTugas();
    }
    public List<Mahasiswa> allDataMahasiswa() {
        return mahasiswaService.getAllMahasiswa();
    }
    public Matkul getMatkulByKodeMatkul(String kodeMatkul){
        return matkulService.getMatkulByKodeMatkul(kodeMatkul);
    }
    public Tugas getTugasByKodeTugas(String kodeTugas){
        return tugasService.getTugasByKodeTugas(kodeTugas);
    }
    public Mahasiswa getMahasiswaByNpm(Long npm){
        return mahasiswaService.getMahasiswaByNpm(npm);
    }
    public List<Tugas> getTugasByNpm(Long npm){
        return mahasiswaService.getTugasByNpm(npm);
    }
}
