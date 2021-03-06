package tests;

import dao.EmployeeDAO;
import dao.PositionDAO;
import dao.ProjectDAO;
import dao.WorkingHistoryDAO;
import helper.GenerateContentOfTables;
import org.junit.Test;
import utils.MySQLDatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class Texture extends GenerateContentOfTables {

    @Test
    public void createContentOfTables() {
        GenerateContentOfTables.generatePositionTable();
        GenerateContentOfTables.generateProjectTable();
        GenerateContentOfTables.generateEmployeeTable();
        GenerateContentOfTables.generateWorkingHistoryTable();
    }

    @Test
    public void cleanTables() {
        try (Connection connection = MySQLDatabaseConnection.getConnection(URL, USER, PASSWORD, DATABASE_NAME)) {
            EmployeeDAO employeeDAO = new EmployeeDAO(connection);
            employeeDAO.removeAll();
            ProjectDAO projectDAO = new ProjectDAO(connection);
            projectDAO.removeAll();
            PositionDAO positionDAO = new PositionDAO(connection);
            positionDAO.removeAll();
            WorkingHistoryDAO whDAO = new WorkingHistoryDAO(connection);
            whDAO.removeAll();
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
