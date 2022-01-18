package xyz.itshark.play.graphqlspringboot.example.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.itshark.play.graphqlspringboot.example.pojo.Matkul;
import xyz.itshark.play.graphqlspringboot.example.pojo.Tugas;
import xyz.itshark.play.graphqlspringboot.example.repository.MatkulRepository;
import xyz.itshark.play.graphqlspringboot.example.repository.TugasRepository;

import java.util.List;

@Service
public class TugasService {
    private TugasRepository tugasRepository;

    public TugasService() {
        System.out.println("Hei");
    }

    public TugasService(TugasRepository tugasRepository) {
        this.tugasRepository = tugasRepository;
    }

    public List<Tugas> getAllTugas() {
        return tugasRepository.findAll();
    }

    public Tugas getTugasByKodeTugas(String kodeTugas) {
        return tugasRepository.findByKodeTugas(kodeTugas);
    }

    public Tugas addTugas(String kodeTugas, String nama, Matkul matkul, String deadline) {
        if (tugasRepository.findByKodeTugas(kodeTugas) != null) {
            return null;
        }
        Tugas tugas = new Tugas(kodeTugas, nama, matkul, deadline);
        tugasRepository.save(tugas);
        return tugas;
    }

    public boolean deleteTugas(String kodeTugas) {
        if (tugasRepository.findByKodeTugas(kodeTugas) == null) {
            return false;
        }
        tugasRepository.deleteById(kodeTugas);
        return true;
    }


    public Tugas updateTugas(String kodeTugas, String nama, Matkul matkul, String deadline) {
        Tugas tugas = tugasRepository.findByKodeTugas(kodeTugas);
        if (tugas == null) {
            return null;
        }
        if (nama != null) {
            tugas.setNama(nama);
        }
        if (matkul != null) {
            tugas.getMatkul().removeTugas(tugas);
            tugas.setMatkul(matkul);
            matkul.addTugas(tugas);
        }
        if (deadline != null) {
            tugas.setDeadline(deadline);
        }
        return tugas;
    }
}
