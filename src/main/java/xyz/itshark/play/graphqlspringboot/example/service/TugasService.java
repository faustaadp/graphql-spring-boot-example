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
        if (!tugasRepository.existsById(kodeTugas)) {
            throw new GraphQLException("Tugas dengan kode tugas kodeTugas tidak ada", "kodeTugas", kodeTugas);
        }
        return tugasRepository.findByKodeTugas(kodeTugas);
    }

    public Tugas addTugas(String kodeTugas, String nama, String kodeMatkul, String deadline) {
        if (!tugasRepository.existsById(kodeTugas)) {
            throw new GraphQLException("Tugas dengan kode tugas kodeTugas tidak ada", "kodeTugas", kodeTugas);
        }
        if (!matkulRepository.existsById(kodeMatkul)) {
            throw new GraphQLException("Matkul dengan kode matkul kodeMatkul tidak ada", "kodeMatkul", kodeMatkul);
        }
        Matkul matkul = matkulRepository.findByKodeMatkul(kodeMatkul);
        Tugas tugas = new Tugas(kodeTugas, nama, matkul, deadline);
        tugasRepository.save(tugas);
        return tugas;
    }

    public boolean deleteTugas(String kodeTugas) {
        if (!tugasRepository.existsById(kodeTugas)) {
            throw new GraphQLException("Tugas dengan kode tugas kodeTugas tidak ada", "kodeTugas", kodeTugas);
        }
        tugasRepository.deleteById(kodeTugas);
        return true;
    }

    public int deleteTugasByKodeMatkul(String kodeMatkul) {
        if (!matkulRepository.existsById(kodeMatkul)) {
            throw new GraphQLException("Matkul dengan kode matkul kodeMatkul tidak ada", "kodeMatkul", kodeMatkul);
        }
        Matkul matkul = matkulRepository.findByKodeMatkul(kodeMatkul);
        Iterable<Tugas> listTugas = matkul.getTugas();
        int size = matkul.getTugas().size();
        tugasRepository.deleteAll(listTugas);
        return size;
    }


    public Tugas updateTugas(String kodeTugas, String nama, String kodeMatkul, String deadline) {
        if (!tugasRepository.existsById(kodeTugas)) {
            throw new GraphQLException("Tugas dengan kode tugas kodeTugas tidak ada", "kodeTugas", kodeTugas);
        }
        if (!matkulRepository.existsById(kodeMatkul) && kodeMatkul != null) {
            throw new GraphQLException("Matkul dengan kode matkul kodeMatkul tidak ada", "kodeMatkul", kodeMatkul);
        }
        Tugas tugas = tugasRepository.findByKodeTugas(kodeTugas);
        Matkul matkul = matkulRepository.findByKodeMatkul(kodeMatkul);
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
        if (!matkulRepository.existsById(kodeMatkul)) {
            throw new GraphQLException("Matkul dengan kode matkul kodeMatkul tidak ada", "kodeMatkul", kodeMatkul);
        }
        Matkul matkul = matkulRepository.findByKodeMatkul(kodeMatkul);
        List<Tugas> listTugas = new ArrayList<Tugas>();
        for (int i = 1; i <= jumlah; i++) {
            Tugas tugas = new Tugas(kodeTugas + "#" + i, nama + " #" + i, matkul, deadline);
            listTugas.add(tugas);
        }
        tugasRepository.saveAll(listTugas);
        return true;
    }
}
