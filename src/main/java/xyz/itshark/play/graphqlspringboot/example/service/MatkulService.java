package xyz.itshark.play.graphqlspringboot.example.service;

import org.springframework.stereotype.Service;
import xyz.itshark.play.graphqlspringboot.example.pojo.Hello;
import xyz.itshark.play.graphqlspringboot.example.pojo.Matkul;
import xyz.itshark.play.graphqlspringboot.example.pojo.Tugas;

import java.util.ArrayList;
import java.util.List;

@Service
public class MatkulService {

    private List<Matkul> list = new ArrayList();

    public List<Matkul> getAllMatkul() {
        return list;
    }

    public Matkul findByKodeMatkul(String kodeMatkul) {
        for(Matkul matkul : list)
        {
            if(matkul.getKodeMatkul().equals(kodeMatkul))
                return matkul;
        }
        return null;
    }

    public Matkul addMatkul(String kodeMatkul, String nama, int sks) {
        Matkul matkul = new Matkul(kodeMatkul, nama, sks);
        list.add(matkul);

        return matkul;
    }

    public boolean deleteMatkul(String kodeMatkul) {
        Matkul matkul = findByKodeMatkul(kodeMatkul);
        if (matkul == null) {
            return false;
        }
        list.remove(matkul);
        return true;
    }

    public Matkul updateMatkul(String kodeMatkul, String nama, int sks){
        Matkul matkul = findByKodeMatkul(kodeMatkul);
        if(nama != null) {
            matkul.setNama(nama);
        }
        if(sks != 0) {
            matkul.setSks(sks);
        }
        return matkul;
    }

    public Matkul getMatkulByKodeMatkul(String kodeMatkul){
        Matkul matkul = findByKodeMatkul(kodeMatkul);
        return matkul;
    }
}
