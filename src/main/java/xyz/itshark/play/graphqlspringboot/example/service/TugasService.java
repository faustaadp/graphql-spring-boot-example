package xyz.itshark.play.graphqlspringboot.example.service;

import org.springframework.stereotype.Service;
import xyz.itshark.play.graphqlspringboot.example.pojo.Hello;
import xyz.itshark.play.graphqlspringboot.example.pojo.Matkul;
import xyz.itshark.play.graphqlspringboot.example.pojo.Tugas;

import java.util.ArrayList;
import java.util.List;

@Service
public class TugasService {

    private List<Tugas> list = new ArrayList();

    public List<Tugas> getAllTugas() {
        return list;
    }

    public Tugas getTugasByKodeTugas(String kodeTugas){
        for(Tugas tugas : list)
        {
            if(tugas.getKodeTugas().equals(kodeTugas)) {
                return tugas;
            }
        }
        return null;
    }

    public Tugas addTugas(String kodeTugas, String nama, Matkul matkul, String deadline) {
        Tugas tugas = new Tugas(kodeTugas, nama, matkul, deadline);
        list.add(tugas);
        matkul.addTugas(tugas);

        return tugas;
    }

    public boolean deleteTugas(String kodeTugas) {
        Tugas tugas = getTugasByKodeTugas(kodeTugas);
        if (tugas == null) {
            return false;
        }
        tugas.getMatkul().removeTugas(tugas);
        list.remove(tugas);
        return true;
    }


    public Tugas updateTugas(String kodeTugas, String nama, Matkul matkul, String deadline) {
        Tugas tugas = getTugasByKodeTugas(kodeTugas);
        if(nama != null) {
            tugas.setNama(nama);
        }
        if(matkul != null) {
            tugas.getMatkul().removeTugas(tugas);
            tugas.setMatkul(matkul);
            matkul.addTugas(tugas);
        }
        if(deadline != null) {
            tugas.setDeadline(deadline);
        }
        return tugas;
    }
}
