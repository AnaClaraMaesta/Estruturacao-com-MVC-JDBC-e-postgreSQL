package org.trabalho.Repository;

import org.trabalho.Model.Alunos;
import org.trabalho.util.Conexao;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Alunorepository {

    public Alunos cadastrar(Alunos aluno)throws SQLException{
        String sql = """
                INSERT INTO alunos (nome, email, telefone)
                VALUES (?,?,?)
                RETURNING id
                """;
        try (Connection conn = Conexao.getConnection()){
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getEmail());
            stmt.setString(3, aluno.getTelefone());

            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                return new Alunos(rs.getLong("id"), aluno.getNome(), aluno.getEmail(), aluno.getTelefone());
            }
            throw new SQLException("ID não gerado");
        }
    }

    public Optional<Alunos> buscarPorNome(String nome) throws SQLException {
        String sql = "SELECT * FROM alunos WHERE nome = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            return rs.next() ? Optional.of(mapear(rs)) : Optional.empty();
        }
    }

    public List<Alunos> listarAlunos()throws SQLException{
        String sql = "SELECT * FROM alunos order by id";
        List<Alunos> lista_alunos= new ArrayList<>();
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()){
            while (rs.next()) lista_alunos.add(mapear(rs));
        }
        return lista_alunos;
    }

    public void atualizar(Alunos aluno) throws SQLException {
        String sql = "UPDATE alunos SET nome = ?,email = ?, telefone = ? WHERE id = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getEmail());
            stmt.setString(3, aluno.getTelefone());
            stmt.setLong(4, aluno.getId().intValue());
            stmt.executeUpdate();
        }
    }

    public void deletar(BigInteger id) throws SQLException {
        String sql = "DELETE FROM alunos WHERE id = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id.intValue());
            stmt.executeUpdate();
        }
    }


    private Alunos mapear(ResultSet rs) throws SQLException {
        return new Alunos(rs.getLong("id"), rs.getString("nome"),  rs.getString("email"),  rs.getString("telefone"));
    }

}




