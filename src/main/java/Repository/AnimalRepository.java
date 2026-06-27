package Repository;

import Model.Animal;
import Util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AnimalRepository {
    public Animal salvar(Animal animal) throws SQLException {
        String sql = """
        INSERT INTO animal (nome, raca, especie)
        VALUES (?, ?, ?)
        RETURNING id
    """;

        try (Connection conn = Conexao.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, animal.getNome());
            stmt.setString(2, animal.getRaca());
            stmt.setString(3, animal.getEspecie());

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                long idGerado = rs.getLong("id");
                return new Animal(idGerado, animal.getNome(), animal.getEspecie(), animal.getRaca());
            }

            throw new SQLException("Erro ao salvar animal: ID não gerado.");
        }
    }

    public Optional<Animal> buscarPorId(Long id) throws SQLException {
        String sql = "SELECT * FROM animal WHERE id = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            return rs.next() ? Optional.of(mapear(rs)) : Optional.empty();
        }
    }

    public List<Animal> listarTodos() throws SQLException {
        String sql = "SELECT * FROM animal ORDER BY nome";
        List<Animal> lista = new ArrayList<>();
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) lista.add(mapear(rs));
        }
        return lista;
    }

    public void atualizar(long id, String nome, String especie, String raca) throws SQLException {
        String sql = "UPDATE animal SET nome = ?, raca = ?, especie = ? WHERE id = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1,nome);
            stmt.setString(2, raca);
            stmt.setString(3, especie );
            stmt.setLong(4, id);
            stmt.executeUpdate();
        }
    }

    public void deletar(Long id) throws SQLException {
        String sql = "DELETE FROM animal WHERE id = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }

    public List<Animal> listarPorTutor(long tutor_id) throws SQLException {
        String sql = "SELECT * FROM animal WHERE tutor_id = ?";
        List<Animal> lista = new ArrayList<>();

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, tutor_id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                lista.add(mapear(rs));
            }

            return lista;
        }
    }

    private Animal mapear(ResultSet rs) throws SQLException {
        return new Animal(rs.getLong("id"), rs.getString("nome"), rs.getString("raca"), rs.getString("especie"));
    }

}
