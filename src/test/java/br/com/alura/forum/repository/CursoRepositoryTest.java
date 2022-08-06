package br.com.alura.forum.repository;


import br.com.alura.forum.modelo.Curso;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CursoRepositoryTest {

    @Autowired
    private CursoRepository repository;

    @Test
    void shouldLoadCurso_whenNameOfCursoExists() {
        String nomeCurso = "HTML 5";

        Curso curso = repository.findByNome(nomeCurso);

        assertNotNull(curso);
        assertEquals(nomeCurso, curso.getNome());
    }

    @Test
    void shouldReturnNull_whenNameOfCursoNotExists() {
        String nomeCurso = "JPA";

        Curso curso = repository.findByNome(nomeCurso);

        assertNull(curso);
    }
}
