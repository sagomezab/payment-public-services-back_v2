package edu.escuelaing.arem.ASE.app.service;

import edu.escuelaing.arem.ASE.app.model.ServicioModel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.mysql.cj.x.protobuf.MysqlxCrud.Limit;

@Service
public class ServicioService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public ServicioService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createService(ServicioModel servicioModel) {
        String sql = "INSERT INTO servicio (id,nombre) VALUES (?, ?)";

        jdbcTemplate.update(sql, preparedStatement -> {
            preparedStatement.setString(1, servicioModel.getId());
            preparedStatement.setString(2, servicioModel.getNombre());
        });
    }

    public void updateService(String serviceId, ServicioModel servicioModel) {
        String sql = "UPDATE servicio SET nombre = (?) WHERE id=(?)";

        jdbcTemplate.update(sql, preparedStatement -> {
            preparedStatement.setString(1, servicioModel.getNombre());
            preparedStatement.setString(2, serviceId);
        });
    }

    public String getService(String serviceId) {
        String sql = "SELECT nombre FROM servicio WHERE id=?";
        try {
            return jdbcTemplate.queryForObject(sql, String.class, serviceId);
        } catch (Exception e) {
            System.err.println("Error al obtener el servicio '" + serviceId + "': " + e.getMessage());
            return null;
        }
    }

    public boolean deleteService(String serviceId) {
        String sql = "DELETE FROM servicio WHERE id = ?";
        int filasAfectadas = jdbcTemplate.update(sql, serviceId);

        return filasAfectadas > 0;
    }

    public List<Object> getAllServices() {
        String sql = "SELECT id,nombre FROM servicio";
        
        try {
            return jdbcTemplate.query(sql, (rs, rowNum) -> {
                ServicioModel servicioModel = new ServicioModel();
                servicioModel.setId(rs.getString("id"));
                servicioModel.setNombre(rs.getString("nombre"));
                return servicioModel;
            });
            //return jdbcTemplate.query(sql, (rs, rowNum) -> rs.getString("nombre"));
        } catch (Exception e) {
            System.err.println("Error al obtener todos los servicios: " + e.getMessage());
            return null;
        }
    }

}
