package xyz.itshark.play.graphqlspringboot.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.itshark.play.graphqlspringboot.example.exception.GraphQLException;
import xyz.itshark.play.graphqlspringboot.example.pojo.Mahasiswa;
import xyz.itshark.play.graphqlspringboot.example.pojo.Matkul;
import xyz.itshark.play.graphqlspringboot.example.pojo.Tugas;
import xyz.itshark.play.graphqlspringboot.example.repository.MahasiswaRepository;
import xyz.itshark.play.graphqlspringboot.example.repository.MatkulRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class MahasiswaService {
    @Autowired
    private MahasiswaRepository mahasiswaRepository;

    @Autowired
    private MatkulRepository matkulRepository;

    public MahasiswaService() {
    }

    public List<Mahasiswa> getAllMahasiswa() {
        return mahasiswaRepository.findAll();
    }

    public Mahasiswa getMahasiswaByNpm(Long npm) {
        if (!mahasiswaRepository.existsById(npm)) {
            throw new GraphQLException("Mahasiswa dengan npm npm tidak ada", "npm", npm);
        }
        return mahasiswaRepository.findByNpm(npm);
    }

    public Mahasiswa addMahasiswa(Long npm, String nama) {
        if (mahasiswaRepository.existsById(npm)) {
            throw new GraphQLException("Mahasiswa dengan npm npm sudah ada", "npm", npm);
        }
        Mahasiswa mahasiswa = new Mahasiswa(npm, nama);
        mahasiswaRepository.save(mahasiswa);
        return mahasiswa;
    }

    public boolean deleteMahasiswa(Long npm) {
        if (!mahasiswaRepository.existsById(npm)) {
            throw new GraphQLException("Mahasiswa dengan npm npm tidak ada", "npm", npm);
        }
        mahasiswaRepository.deleteById(npm);
        return true;
    }

    public Mahasiswa updateMahasiswa(Long npm, String nama) {
        if (!mahasiswaRepository.existsById(npm)) {
            throw new GraphQLException("Mahasiswa dengan npm npm tidak ada", "npm", npm);
        }
        Mahasiswa mahasiswa = mahasiswaRepository.findByNpm(npm);
        if (nama != null) {
            mahasiswa.setNama(nama);
        }
        mahasiswaRepository.save(mahasiswa);
        return mahasiswa;
    }

    public Mahasiswa subscribe(Long npm, String kodeMatkul) {
        if (!mahasiswaRepository.existsById(npm)) {
            throw new GraphQLException("Mahasiswa dengan npm npm tidak ada", "npm", npm);
        }
        if (!matkulRepository.existsById(kodeMatkul)) {
            throw new GraphQLException("Matkul dengan kode matkul kodeMatkul tidak ada", "kodeMatkul", kodeMatkul);
        }
        Mahasiswa mahasiswa = mahasiswaRepository.findByNpm(npm);
        Matkul matkul = matkulRepository.findByKodeMatkul(kodeMatkul);
        mahasiswa.subscribe(matkul);
        mahasiswaRepository.save(mahasiswa);
        return mahasiswa;
    }
}
