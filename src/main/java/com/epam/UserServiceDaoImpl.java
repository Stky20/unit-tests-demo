package com.epam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserServiceDaoImpl implements UserService {

  private static final Logger logger = LoggerFactory.getLogger(UserServiceDaoImpl.class);

  private UserDao userDao;

  public UserServiceDaoImpl(UserDao userDao) {
    this.userDao = userDao;
  }

  @Override
  public void deleteUserById( final Long id) {
    logger.info( "trying to delete by id {}", id);
    if ( id == 0L) {
      logger.info( "invalid id {}", id);
      return;
    }
    try {
      userDao.deleteUser(id);
    } catch ( final Exception e ) {
      logger.info( "can not delete by id {}", id);
      throw new IllegalArgumentException(e.getMessage());
    }
    logger.info( "successfully deleted by id {}", id);
  }
}
