package xyz.itshark.play.graphqlspringboot.example.config;

import org.springframework.context.annotation.Bean;
import xyz.itshark.play.graphqlspringboot.example.pojo.Mahasiswa;
import xyz.itshark.play.graphqlspringboot.example.pojo.Matkul;
import xyz.itshark.play.graphqlspringboot.example.repository.MahasiswaRepository;
import xyz.itshark.play.graphqlspringboot.example.repository.MatkulRepository;
import xyz.itshark.play.graphqlspringboot.example.repository.TugasRepository;
import xyz.itshark.play.graphqlspringboot.example.resolves.Mutation;
import xyz.itshark.play.graphqlspringboot.example.service.MahasiswaService;
import xyz.itshark.play.graphqlspringboot.example.service.MatkulService;
import xyz.itshark.play.graphqlspringboot.example.service.TugasService;

public class GraphqlConfiguration {
//    @Bean
//    public Mutation mutationResolves(MatkulService matkulService, TugasService tugasService, MahasiswaService mahasiswaService) {
//        return new Mutation(matkulService, tugasService, mahasiswaService);
//    }

    @Bean
    public MahasiswaService mahasiswaService(MahasiswaRepository mahasiswaRepository) {
        return new MahasiswaService(mahasiswaRepository);
    }

    @Bean
    public MatkulService matkulService(MatkulRepository matkulRepository) {
        System.out.println("Tes");
        return new MatkulService(matkulRepository);
    }

    @Bean
    TugasService tugasService(TugasRepository tugasRepository) {
        return new TugasService(tugasRepository);
    }

}
