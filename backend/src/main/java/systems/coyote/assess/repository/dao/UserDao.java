package systems.coyote.assess.repository.dao;

import java.util.List;

/**
 * User Dao
 */
public interface UserDao {

  /**
   * Returns the list of ids of the not found users using ids
   *
   * @param usersIds ids of the users to check
   * @return a list of the ids of the not found users
   * @throws DaoException             if there is an sql exception
   * @throws IllegalArgumentException if any given argument is invalid
   */
  List<Long> findNonExistingUsersByUsersIds(List<Long> usersIds);
}
