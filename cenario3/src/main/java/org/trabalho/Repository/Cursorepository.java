package org.trabalho.Repository;

import org.trabalho.Model.Alunos;
import org.trabalho.Model.Cursos;
import org.trabalho.util.Conexao;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Cursorepository {

    public Cursos cadastrar(Cursos curso)throws SQLException {
        String sql = """
                INSERT INTO cursos (nome, descricao, carga_horaria, vagas_totais, vagas_disponiveis )
                VALUES (?,?,?,?,?)
                RETURNING id
                """;
        try (Connection conn = Conexao.getConnection()){
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, curso.getNome());
            stmt.setString(2, curso.getDescricao());
            stmt.setLong(3, curso.getCarga_horaria());
            stmt.setInt(4, curso.getVagas_totais());
            stmt.setInt(5, curso.getVagas_disponiveis());

            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                return new Cursos(rs.getLong("id"), curso.getNome(), curso.getDescricao(), curso.getCarga_horaria(), curso.getVagas_totais(), curso.getVagas_disponiveis());
            }
            throw new SQLException("ID não gerado");
        }




    }

    public Optional<Cursos> buscarPorNome(String nome) throws SQLException {
        String sql = "SELECT * FROM cursos WHERE nome = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            return rs.next() ? Optional.of(mapear(rs)) : Optional.empty();
        }
    }

    public List<Cursos> listarCursos()throws SQLException{
        String sql = "SELECT * FROM cursos order by id";
        List<Cursos> lista_cursos= new ArrayList<>();
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()){
            while (rs.next()) lista_cursos.add(mapear(rs));
        }
        return lista_cursos;
    }

    public void atualizar(Cursos curso) throws SQLException {
        String sql = "UPDATE cursos SET nome = ?,descricao = ?, carga_horaria = ?, vagas_totais = ?, vagas_disponiveis = ? WHERE id = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, curso.getNome());
            stmt.setString(2, curso.getDescricao());
            stmt.setLong(3, curso.getCarga_horaria());
            stmt.setInt(4, curso.getVagas_totais());
            stmt.setInt(5, curso.getVagas_disponiveis());
            stmt.setLong(6, curso.getId().intValue());
            stmt.executeUpdate();
        }
    }

    public void deletar(BigInteger id) throws SQLException {
        String sql = "DELETE FROM cursos WHERE id = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id.intValue());
            stmt.executeUpdate();
        }
    }

    private Cursos mapear(ResultSet rs) throws SQLException {
        return new Cursos(rs.getLong("id"), rs.getString("nome"),  rs.getString("descricao"),  rs.getLong("carga_horaria"), rs.getInt("vagas_totais"), rs.getInt("vagas_disponiveis"));
    }

    public void atualizarQuantidade(Long id, int vagas_disponoveis) throws SQLException {
        String sql = "UPDATE cursos SET vagas_disponiveis = ? WHERE id = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, vagas_disponoveis);
            stmt.setLong(2, id.intValue());
            stmt.executeUpdate();
        }
    }

}
