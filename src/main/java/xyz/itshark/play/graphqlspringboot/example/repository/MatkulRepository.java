package xyz.itshark.play.graphqlspringboot.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import xyz.itshark.play.graphqlspringboot.example.pojo.Matkul;

@Repository
public interface MatkulRepository extends JpaRepository<Matkul, String> {
    Matkul findByKodeMatkul(String kodeMatkul);
}

