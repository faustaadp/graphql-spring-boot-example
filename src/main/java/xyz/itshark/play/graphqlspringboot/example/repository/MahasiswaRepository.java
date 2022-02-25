package xyz.itshark.play.graphqlspringboot.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import xyz.itshark.play.graphqlspringboot.example.pojo.Mahasiswa;
import xyz.itshark.play.graphqlspringboot.example.pojo.Tugas;

import java.util.List;

@Repository
public interface MahasiswaRepository extends JpaRepository<Mahasiswa, Long> {
    Mahasiswa findByNpm(Long npm);
}

