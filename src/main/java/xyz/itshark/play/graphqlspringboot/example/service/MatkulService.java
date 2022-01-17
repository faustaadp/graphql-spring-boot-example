package xyz.itshark.play.graphqlspringboot.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.itshark.play.graphqlspringboot.example.pojo.Matkul;
import xyz.itshark.play.graphqlspringboot.example.repository.MatkulRepository;

import java.util.List;

@Service
public class MatkulService {
    @Autowired
    private MatkulRepository matkulRepository;

    public List<Matkul> getAllMatkul() {
        return matkulRepository.findAll();
    }

    public Matkul getMatkulByKodeMatkul(String kodeMatkul) {
        return matkulRepository.findByKodeMatkul(kodeMatkul);
    }

    public Matkul addMatkul(String kodeMatkul, String nama, int sks) {
        Matkul matkul = new Matkul(kodeMatkul, nama, sks);
        matkulRepository.save(matkul);
        return matkul;
    }

    public boolean deleteMatkul(String kodeMatkul) {
        if (matkulRepository.findByKodeMatkul(kodeMatkul) == null) {
            return false;
        }
        matkulRepository.deleteById(kodeMatkul);
        return true;
    }

    public Matkul updateMatkul(String kodeMatkul, String nama, int sks){
        Matkul matkul = matkulRepository.findByKodeMatkul(kodeMatkul);
        if(nama != null) {
            matkul.setNama(nama);
        }
        if(sks != 0) {
            matkul.setSks(sks);
        }
        return matkul;
    }
}
