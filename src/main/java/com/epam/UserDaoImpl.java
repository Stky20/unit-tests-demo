package com.epam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserDaoImpl implements UserDao {

  private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

  @Override
  public void deleteUser(Long id) {
    logger.info("deleting user by id {}", id);
  }
}
