package com.datazuul.language.iso639;

import com.datazuul.language.iso639.ISO639Language;
import com.datazuul.language.iso639.ISO639Languages;
import java.util.Locale;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ISO639LanguagesTest {

  @Test
  public void testGetByPart2BCode() {
    ISO639Language result = ISO639Languages.getByPart2BCode("ger");
    assertEquals("de", result.getPart1());

    Locale locale = new Locale(result.getPart1());
    assertEquals(Locale.GERMAN, locale);
  }
  
  @Test
  public void testGetByCode1() {
    ISO639Language result = ISO639Languages.getByCode("ger");
    assertEquals("de", result.getPart1());

    Locale locale = new Locale(result.getPart1());
    assertEquals(Locale.GERMAN, locale);
  }
  
  @Test
  public void testGetByCode3() {
    ISO639Language result = ISO639Languages.getByCode("deu");
    assertEquals("de", result.getPart1());

    Locale locale = new Locale(result.getPart1());
    assertEquals(Locale.GERMAN, locale);
  }
  
  @Test
  public void testGetByCode2() {
    ISO639Language result = ISO639Languages.getByCode("aa");
    assertEquals("aar", result.getId());
  }
}
