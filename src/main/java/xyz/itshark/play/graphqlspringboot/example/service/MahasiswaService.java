package xyz.itshark.play.graphqlspringboot.example.service;

import org.springframework.stereotype.Service;
import xyz.itshark.play.graphqlspringboot.example.pojo.Mahasiswa;
import xyz.itshark.play.graphqlspringboot.example.pojo.Matkul;
import xyz.itshark.play.graphqlspringboot.example.pojo.Tugas;

import java.util.ArrayList;
import java.util.List;

@Service
public class MahasiswaService {

    private List<Mahasiswa> list = new ArrayList();

    public List<Mahasiswa> getAllMahasiswa() {
        return list;
    }

    public Mahasiswa getMahasiswaByNpm(Long npm) {
        for(Mahasiswa mahasiswa : list)
        {
            if(mahasiswa.getNpm().equals(npm)) {
                return mahasiswa;
            }
        }
        return null;
    }

    public Mahasiswa addMahasiswa(Long npm, String nama) {
        Mahasiswa mahasiswa = new Mahasiswa(npm, nama);
        list.add(mahasiswa);
        return mahasiswa;
    }

    public boolean deleteMahasiswa(Long npm) {
        Mahasiswa mahasiswa = getMahasiswaByNpm(npm);
        if (mahasiswa == null) {
            return false;
        }
        list.remove(mahasiswa);
        return true;
    }

    public List<Tugas> getTugasByNpm(Long npm){
        Mahasiswa mahasiswa = getMahasiswaByNpm(npm);
        List<Matkul> listMatkul = mahasiswa.getMatkul();
        List<Tugas> listTugas = new ArrayList<Tugas>();
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
