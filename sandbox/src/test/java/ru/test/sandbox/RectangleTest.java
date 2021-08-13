package ru.test.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RectangleTest {

  @Test
  public void testRectangle() {

    Rectangle r = new Rectangle(4, 6);
    Assert.assertEquals(r.area(), 24);
  }
}
