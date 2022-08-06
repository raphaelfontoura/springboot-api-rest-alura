package br.com.alura.forum.repository;

import br.com.alura.forum.modelo.Curso;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.modelo.Usuario;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")

/*
A partir da versão 2.5.1 do Spring Boot a propriedade spring.datasource.initialization-mode foi removida
e deve-se utilizar a nova propriedade spring.sql.init.mode em seu lugar.

Essa nova propriedade aceita dois possíveis valores:

always -> sempre inicializa o banco de dados
never -> nunca inicializa o banco de dados
 */
class TopicoRepositoryTest {

    @Autowired
    private TopicoRepository repository;

    @Autowired
    private TestEntityManager em;

    @Test
    void shouldReturnCurso_whenNameOfCursoExists() {
        String nomeCurso = "HTML 5";
        Pageable page = PageRequest.of(0, 5);
        Curso curso = new Curso();
        curso.setCategoria("Programacao");
        curso.setNome("HTML 5");
        Topico topico = new Topico();
        topico.setCurso(curso);
        topico.setMensagem("Mensagem do topico");
        em.persist(curso);
        em.persist(topico);

        Page<Topico> topicos = repository.findByCursoNome(nomeCurso, page);

        assertNotNull(topicos);
        assertEquals(1, topicos.getTotalElements());
    }
}