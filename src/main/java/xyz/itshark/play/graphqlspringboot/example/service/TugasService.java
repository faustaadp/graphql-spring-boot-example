package xyz.itshark.play.graphqlspringboot.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.itshark.play.graphqlspringboot.example.pojo.Matkul;
import xyz.itshark.play.graphqlspringboot.example.pojo.Tugas;
import xyz.itshark.play.graphqlspringboot.example.repository.TugasRepository;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class TugasService {
    @Autowired
    private TugasRepository tugasRepository;

    public TugasService() {
    }

    public List<Tugas> getAllTugas() {
        Instant start = Instant.now();
        try {
            return tugasRepository.findAll();
        } finally {
            Instant end = Instant.now();
            Duration timeElapsed = Duration.between(start, end);
            System.out.println("Time taken: " + timeElapsed.toMillis() + " milliseconds");
        }
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

    public int deleteTugasByKodeMatkul(Matkul matkul) {
        if (matkul == null) {
            return 0;
        }
        Iterable<Tugas> listTugas = matkul.getTugas();
        int ret = matkul.getTugas().size();
        tugasRepository.deleteAll(listTugas);
        return ret;
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
            tugas.setMatkul(matkul);
        }
        if (deadline != null) {
            tugas.setDeadline(deadline);
        }
        tugasRepository.save(tugas);
        return tugas;
    }

    public boolean addTugasBulk(String kodeTugas, String nama, Matkul matkul, String deadline, int jumlah) {
        if (matkul == null) {
            return false;
        }
        List<Tugas> listTugas = new ArrayList<Tugas>();
        for (int i = 1; i <= jumlah; i++) {
            Tugas tugas = new Tugas(kodeTugas + "#" + i, nama + " #" + i, matkul, deadline);
            listTugas.add(tugas);
        }
        tugasRepository.saveAll(listTugas);
        return true;
    }
}
