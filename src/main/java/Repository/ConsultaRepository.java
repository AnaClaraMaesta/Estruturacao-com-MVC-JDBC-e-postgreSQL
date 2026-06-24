package Repository;

import Model.Animal;
import Model.Consulta;
import Model.Tutor;
import Util.Conexao;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ConsultaRepository {

    public Consulta salvar(Consulta consulta) throws SQLException {
        String sql = """
            INSERT INTO consulta (tutor_id, animal_id, data_consulta, descricao, valor)
            VALUES (?, ?, ?, ?, ?) RETURNING id
        """;

        Connection conn = Conexao.getConnection();
        try {
            conn.setAutoCommit(false);

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1,consulta.getTutor().getId());
            stmt.setLong(2,consulta.getAnimal().getId());
            stmt.setDate(3, Date.valueOf(consulta.getDataConsulta()));
            stmt.setString(4, consulta.getDescricao());
            stmt.setBigDecimal(5, consulta.getValor());

            ResultSet rs = stmt.executeQuery();
            rs.next();
            long idConsulta = rs.getLong("id");

            conn.commit();

            consulta.setId(idConsulta);

            return new Consulta(idConsulta, consulta.getDataConsulta(), consulta.getAnimal(), consulta.getTutor(), consulta.getValor(), consulta.getDescricao());

        }catch (SQLException e){
            conn.rollback();
            throw e;
        }finally{
            conn.close();
        }
    }

    public List<Consulta> listarPorAnimal(long id_animal) throws SQLException {
        String sql = """
                SELECT * FROM consulta WHERE id_animal = ?
                """;
        List<Consulta> lista = new ArrayList<>();

        try(Connection conn = Conexao.getConnection();){
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, id_animal);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) lista.add(mapear(rs));
        }
        return lista;
    }

    private Consulta mapear(ResultSet rs) throws SQLException {
        long id = rs.getLong("id");
        LocalDate dataConsulta = rs.getDate("data_consulta").toLocalDate();
        BigDecimal valor = rs.getBigDecimal("valor");
        String descricao = rs.getString("descricao");

        // Busca os objetos pelo id armazenado na tabela
        long animalId = rs.getLong("animal_id");
        long tutorId = rs.getLong("tutor_id");

        Animal animal = new AnimalRepository().buscarPorId(animalId).orElse(null);
        Tutor tutor = new TutorRepository().buscarPorId(tutorId).orElse(null);

        return new Consulta(id, dataConsulta, animal, tutor, valor, descricao);
    }
}
