package org.trabalho.Repository;

import org.trabalho.Model.Alunos;
import org.trabalho.Model.Cursos;
import org.trabalho.Model.Matricula;
import org.trabalho.util.Conexao;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Matricularepository {

    private Alunos aluno;
    private Cursos curso;


    public Matricula cadastrar(Matricula matricula)throws SQLException {
        String sql = """
                INSERT INTO matricula (id_aluno, nome_aluno, id_curso, nome_curso, valor)
                             VALUES (?,?,?,?,?)
                            RETURNING id, data_matricula;
                """;
        try (Connection conn = Conexao.getConnection()){
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setLong(1, matricula.getId_aluno()); ;
            stmt.setString(2, matricula.getNome_aluno());
            stmt.setLong(3, matricula.getId_curso()); ;
            stmt.setString(4, matricula.getNome_curso());
            stmt.setBigDecimal(5, matricula.getValor());

            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                return new Matricula(rs.getLong("id"), matricula.getId_aluno(), matricula.getNome_aluno(), matricula.getId_curso(), matricula.getNome_curso(), rs.getTimestamp("data_matricula"), matricula.getValor());
            }
            throw new SQLException("id ou data não foram gerados");

        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<Matricula> buscarPorCurso(Long id_curso) throws SQLException {
        String sql = "SELECT * FROM matricula WHERE id_curso = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id_curso.intValue());
            ResultSet rs = stmt.executeQuery();
            return rs.next() ? Optional.of(mapear(rs)) : Optional.empty();
        }
    }

    public Optional<Matricula> buscarPorAluno(Long   id_aluno) throws SQLException {
        String sql = "SELECT * FROM matricula WHERE id_aluno = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id_aluno.intValue());
            ResultSet rs = stmt.executeQuery();
            return rs.next() ? Optional.of(mapear(rs)) : Optional.empty();
        }
    }


    public List<Matricula> listarMatricula()throws SQLException{
        String sql = "SELECT * FROM matricula order by id";
        List<Matricula> lista_matricula= new ArrayList<>();
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()){
            while (rs.next()) lista_matricula.add(mapear(rs));
        }
        return lista_matricula;
    }

    public void atualizar(Matricula matricula) throws SQLException {
        String sql = "UPDATE matricula SET valor = ? WHERE id = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setBigDecimal(1, matricula.getValor());
            stmt.setLong(2, matricula.getId().intValue());
            stmt.executeUpdate();
        }
    }

    public void deletar(BigInteger id) throws SQLException {
        String sql = "DELETE FROM matricula WHERE id = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id.intValue());
            stmt.executeUpdate();
        }
    }


    private Matricula mapear(ResultSet rs) throws SQLException {
        return new Matricula(rs.getLong("id"), rs.getLong("id_aluno"), rs.getString("nome_aluno"),  rs.getLong("id_curso"),rs.getString("nome_aluno"), rs.getTimestamp("data_matricula"),  rs.getBigDecimal("valor"));
    }

}
