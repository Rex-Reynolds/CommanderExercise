/**
 * LightTest.java 1.0 Oct 6, 2014
 *
 * Copyright (c) 2014 Rex A. Reynolds. All Rights Reserved
 */
package headfirst.command.simpleremote;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Start each Class or interface with a summary description line
 *
 * @author RexIII
 * @version 1.0
 *
 */
public class LightTest {
  Light light;
  SimpleRemoteControl remote;
  LightOffCommand lightOff;
  LightOnCommand lightOn;
  PrintStream stream;
  ByteArrayOutputStream baos;
  PrintStream ps;
  PrintStream old;
  String expected;
  String actual;

  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {
    light = new Light();
    lightOn = new LightOnCommand(light);
    lightOff = new LightOffCommand(light);
    remote = new SimpleRemoteControl();
    baos = new ByteArrayOutputStream();
    ps = new PrintStream(baos);
    old = System.out;

  }

  /**
   * @throws java.lang.Exception
   */
  @After
  public void tearDown() throws Exception {
    light = null;
    lightOn = null;
    lightOff = null;
    remote = null;
    baos = null;
    ps = null;
    old = null;
    expected = null;
    actual = null;
  }

  /**
   * Test method for
   * {@link headfirst.command.simpleremote.Light#off()}.
   */
  @Test
  public void testOff() {
    System.setOut(ps);
    lightOff = new LightOffCommand(light);
    remote.setCommand(lightOff);
    remote.buttonWasPressed();
    System.out.flush();
    System.setOut(old);
    expected = "Light is off";
    actual = baos.toString();
    actual = actual.replace("\n", "").replace("\r", "");
    assertEquals(expected, actual);
  }

  /**
   * Test method for {@link headfirst.command.simpleremote.Light#on()}
   * .
   */
  @Test
  public void testOn() {
    System.setOut(ps);
    lightOn = new LightOnCommand(light);
    remote.setCommand(lightOn);
    remote.buttonWasPressed();
    System.out.flush();
    System.setOut(old);
    expected = "Light is on";
    actual = baos.toString();
    actual = actual.replace("\n", "").replace("\r", "");
    assertEquals(expected, actual);
  }

}
