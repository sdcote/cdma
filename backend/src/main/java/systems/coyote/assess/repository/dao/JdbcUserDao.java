package systems.coyote.assess.repository.dao;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

/**
 * JDBC implementation for {@link UserDao}
 */
@Repository
public class JdbcUserDao implements UserDao {

  private static final String FIND_USERS_BY_IDS = "SELECT u.id AS id FROM users u WHERE id IN (:users_ids)";

  private final NamedParameterJdbcTemplate parameterJdbcTemplate;

  public JdbcUserDao(NamedParameterJdbcTemplate parameterJdbcTemplate) {
    this.parameterJdbcTemplate = parameterJdbcTemplate;
  }

  /**
   * Returns the list of ids of the not found users using ids
   *
   * @param usersIds ids of the users to check
   * @return a list of the ids of the not found users
   * @throws DaoException             if there is an sql exception
   * @throws IllegalArgumentException if any given argument is invalid
   */
  @Override
  public List<Long> findNonExistingUsersByUsersIds(List<Long> usersIds) {

    Assert.notEmpty(usersIds, "Ids of the users cannot be null or empty");
    usersIds.forEach(userId -> Assert.notNull(userId, "Id of the user cannot be null"));

    MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue("users_ids", usersIds);

    try {
      List<Long> foundUsersId = parameterJdbcTemplate.query(FIND_USERS_BY_IDS, parameters,
          (rs, rowNum) -> rs.getLong(1));

      //@formatter:off
      return usersIds.stream()
                     .filter(id -> !foundUsersId.contains(id))
                     .collect(Collectors.toList());
      //@formatter:on

    } catch (Exception exception) {
      throw new DaoException("Unable to find users by ids", exception);
    }

  }

}
