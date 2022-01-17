package xyz.itshark.play.graphqlspringboot.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.itshark.play.graphqlspringboot.example.pojo.Matkul;
import xyz.itshark.play.graphqlspringboot.example.pojo.Tugas;

@Repository
public interface TugasRepository extends JpaRepository<Tugas, String> {
    Tugas findByKodeTugas(String kodeTugas);
}

