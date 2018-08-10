package com.epam;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class UserServiceImplTest {

  private static UserService userService;
  private static UserDao userDao;

  @BeforeAll
  public static void setup() {
    userDao = Mockito.mock(UserDao.class);
    userService = new UserServiceImpl(userDao);
  }

  @AfterEach
  public void reset() {
    Mockito.reset(userDao);
  }

  @Test
  public void exceptionFlow() {
    final String errorMessage = "unknown error";
    Mockito.doThrow(new RuntimeException(errorMessage)).when(userDao).deleteUser(1L);
    try {
      userService.deleteUserById(1L);
      Assertions.fail("expected exception");
    } catch ( IllegalArgumentException e ) {
      Assertions.assertEquals(errorMessage, e.getMessage());
    }
  }

  @Test
  public void successfulFlow() {
    userService.deleteUserById(1L);
    Mockito.verify(userDao).deleteUser(1L);
  }

  @Test
  public void invalidFlow() {
    userService.deleteUserById(0L);
    Mockito.verifyZeroInteractions(userDao);
  }
}
