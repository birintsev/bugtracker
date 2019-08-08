package dbparsers.impl.projects;

import org.springframework.stereotype.Service;
import entities.bt.Project;
import entities.impl.ProjectImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

@Service
public class AllProjectsDBParser implements ProjectDBParser {
    /**
     *  Parses the {@code ResultSet} extracting {@code Project}s from it
     *
     * @param           resultSet the result of executing the query {@code SELECT * FROM BT_PROJECTS}
     *
     * */
    @Override
    public Collection<Project> parse(ResultSet resultSet) throws SQLException {
        Collection<Project> result = new LinkedList<>();
        while (resultSet.next()) {
            ProjectImpl project = new ProjectImpl(resultSet.getLong("PROJECT_ID")
                    , resultSet.getString("NAME")
                    , resultSet.getLong("ADMIN_ID"));
        }
        return result;
    }
}