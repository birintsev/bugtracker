package ua.edu.sumdu.nc.parsers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

public interface Parser<T> {
    Collection<T> parse(ResultSet resultSet) throws SQLException;
}