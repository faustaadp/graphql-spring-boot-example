package xyz.itshark.play.graphqlspringboot.example.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.itshark.play.graphqlspringboot.example.pojo.Mahasiswa;
import xyz.itshark.play.graphqlspringboot.example.pojo.Matkul;
import xyz.itshark.play.graphqlspringboot.example.pojo.Tugas;
import xyz.itshark.play.graphqlspringboot.example.repository.MahasiswaRepository;


import java.util.ArrayList;
import java.util.List;

@Service
public class MahasiswaService {
    private MahasiswaRepository mahasiswaRepository;

    public MahasiswaService(){
    }

    public MahasiswaService(MahasiswaRepository mahasiswaRepository){
        this.mahasiswaRepository = mahasiswaRepository;
    }

    public List<Mahasiswa> getAllMahasiswa() {
        return mahasiswaRepository.findAll();
    }

    public Mahasiswa getMahasiswaByNpm(Long npm) {
        return mahasiswaRepository.findByNpm(npm);
    }

    public Mahasiswa addMahasiswa(Long npm, String nama) {
        if(mahasiswaRepository.findByNpm(npm) != null){
            return null;
        }
        Mahasiswa mahasiswa = new Mahasiswa(npm, nama);
        mahasiswaRepository.save(mahasiswa);
        return mahasiswa;
    }

    public boolean deleteMahasiswa(Long npm) {
        if (getMahasiswaByNpm(npm) == null) {
            return false;
        }
        mahasiswaRepository.deleteById(npm);
        return true;
    }

    public List<Tugas> getTugasByNpm(Long npm){
        Mahasiswa mahasiswa = mahasiswaRepository.findByNpm(npm);
        if(mahasiswa == null) {
            return null;
        }
        List<Matkul> listMatkul = mahasiswa.getMatkul();
        List<Tugas> listTugas = new ArrayList<>();
        for(Matkul matkul : listMatkul)
        {
            listTugas.addAll(matkul.getTugas());
        }
        return listTugas;
    }

    public Mahasiswa updateMahasiswa(Long npm, String nama) {
        Mahasiswa mahasiswa = getMahasiswaByNpm(npm);
        if(mahasiswa == null) {
            return null;
        }
        if(nama != null) {
            mahasiswa.setNama(nama);
        }
        return mahasiswa;
    }

    public Mahasiswa subscribe(Long npm, Matkul matkul) {
        Mahasiswa mahasiswa = getMahasiswaByNpm(npm);
        if(matkul != null) {
            mahasiswa.subscribe(matkul);
        }
        return mahasiswa;
    }
}
