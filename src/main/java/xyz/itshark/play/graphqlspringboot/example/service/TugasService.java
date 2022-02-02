package xyz.itshark.play.graphqlspringboot.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.itshark.play.graphqlspringboot.example.exception.GraphQLException;
import xyz.itshark.play.graphqlspringboot.example.pojo.Matkul;
import xyz.itshark.play.graphqlspringboot.example.pojo.Tugas;
import xyz.itshark.play.graphqlspringboot.example.repository.MatkulRepository;
import xyz.itshark.play.graphqlspringboot.example.repository.TugasRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class TugasService {
    @Autowired
    private TugasRepository tugasRepository;

    @Autowired
    private MatkulRepository matkulRepository;

    public TugasService() {
    }

    public List<Tugas> getAllTugas() {
        return tugasRepository.findAll();
    }

    public Tugas getTugasByKodeTugas(String kodeTugas) {
        Tugas tugas = tugasRepository.findByKodeTugas(kodeTugas);
        if (tugas == null) {
            throw new GraphQLException("Tugas dengan kode tugas kodeTugas tidak ada", "kodeTugas", kodeTugas);
        }
        return tugas;
    }

    public Tugas addTugas(String kodeTugas, String nama, String kodeMatkul, String deadline) {
        if (tugasRepository.findByKodeTugas(kodeTugas) != null) {
            throw new GraphQLException("Tugas dengan kode tugas kodeTugas sudah ada", "kodeTugas", kodeTugas);
        }
        Matkul matkul = matkulRepository.findByKodeMatkul(kodeMatkul);
        if (matkul == null) {
            throw new GraphQLException("Matkul dengan kode matkul kodeMatkul tidak ada", "kodeMatkul", kodeMatkul);
        }
        Tugas tugas = new Tugas(kodeTugas, nama, matkul, deadline);
        tugasRepository.save(tugas);
        return tugas;
    }

    public boolean deleteTugas(String kodeTugas) {
        if (tugasRepository.findByKodeTugas(kodeTugas) == null) {
            throw new GraphQLException("Tugas dengan kode tugas kodeTugas tidak ada", "kodeTugas", kodeTugas);
        }
        tugasRepository.deleteById(kodeTugas);
        return true;
    }

    public int deleteTugasByKodeMatkul(String kodeMatkul) {
        Matkul matkul = matkulRepository.findByKodeMatkul(kodeMatkul);
        if (matkul == null) {
            throw new GraphQLException("Matkul dengan kode matkul kodeMatkul tidak ada", "kodeMatkul", kodeMatkul);
        }
        Iterable<Tugas> listTugas = matkul.getTugas();
        int ret = matkul.getTugas().size();
        tugasRepository.deleteAll(listTugas);
        return ret;
    }


    public Tugas updateTugas(String kodeTugas, String nama, String kodeMatkul, String deadline) {
        Tugas tugas = tugasRepository.findByKodeTugas(kodeTugas);
        if (tugas == null) {
            throw new GraphQLException("Tugas dengan kode tugas kodeTugas tidak ada", "kodeTugas", kodeTugas);
        }
        Matkul matkul = matkulRepository.findByKodeMatkul(kodeMatkul);
        if (matkul == null) {
            throw new GraphQLException("Matkul dengan kode matkul kodeMatkul tidak ada", "kodeMatkul", kodeMatkul);
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

    public boolean addTugasBulk(String kodeTugas, String nama, String kodeMatkul, String deadline, int jumlah) {
        Matkul matkul = matkulRepository.findByKodeMatkul(kodeMatkul);
        if (matkul == null) {
            throw new GraphQLException("Matkul dengan kode matkul kodeMatkul tidak ada", "kodeMatkul", kodeMatkul);
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
