package xyz.itshark.play.graphqlspringboot.example.service;

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
    @Autowired
    private MahasiswaRepository mahasiswaRepository;

    public List<Mahasiswa> getAllMahasiswa() {
        return mahasiswaRepository.findAll();
    }

    public Mahasiswa getMahasiswaByNpm(Long npm) {
        return mahasiswaRepository.findByNpm(npm);
    }

    public Mahasiswa addMahasiswa(Long npm, String nama) {
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
        Mahasiswa mahasiswa = getMahasiswaByNpm(npm);
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
