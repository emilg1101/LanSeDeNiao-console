package com.github.emilg1101.lansedeniao.data.base;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public interface RowMapper<T> {
    Optional<T> rowMap(ResultSet resultSet) throws SQLException;
}
