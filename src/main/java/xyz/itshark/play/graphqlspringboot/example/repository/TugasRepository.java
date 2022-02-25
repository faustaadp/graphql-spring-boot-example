package xyz.itshark.play.graphqlspringboot.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import xyz.itshark.play.graphqlspringboot.example.pojo.Tugas;

import java.util.List;

@Repository
public interface TugasRepository extends JpaRepository<Tugas, String> {
    Tugas findByKodeTugas(String kodeTugas);

    @Query(value = "select tugas.kode_tugas, tugas.deadline, tugas.nama, tugas.kode_matkul from tugas join matkul on tugas.kode_matkul=matkul.kode_matkul join list_matkul on matkul.kode_matkul=list_matkul.kode_matkul where npm=?1", nativeQuery = true)
    List<Tugas> findTugasByNpmBatching(Long npm);

    @Override
    @Query(value = "select tugas.kode_tugas, tugas.deadline, tugas.nama, tugas.kode_matkul from tugas join matkul on tugas.kode_matkul=matkul.kode_matkul", nativeQuery = true)
    List<Tugas> findAll();
}

