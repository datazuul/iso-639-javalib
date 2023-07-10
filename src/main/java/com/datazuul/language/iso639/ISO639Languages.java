package com.datazuul.language.iso639;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ISO639Languages {

  private final static List<ISO639Language> LANGUAGES;

  static {
    LANGUAGES = new ArrayList<>();
    Scanner sc = null;
    try (InputStream inputStream = ISO639Languages.class.getClassLoader().getResourceAsStream("iso-639-3_20220120.tab")) {
      sc = new Scanner(inputStream);

      if (sc.hasNext()) {
        // skip first line containing headings
        sc.nextLine();
      }
      // Check if there is another line of input
      while (sc.hasNextLine()) {
        String str = sc.nextLine();
        // parse each line using delimiter
        ISO639Language language = parseData(str);
        LANGUAGES.add(language);
      }
    } catch (IOException exp) {
      throw new ExceptionInInitializerError("initialisation failed because of IOException");
    } finally {
      if (sc != null) {
        sc.close();
      }
    }
  }

  private static ISO639Language parseData(String str) {
    String[] fullResult = str.split("\\t");
    ISO639Language language = new ISO639Language();

    String id = fullResult[0];
    language.setId(id);

    String part2B = fullResult[1];
    language.setPart2B(part2B);

    String part2T = fullResult[2];
    language.setPart2T(part2T);

    String part1 = fullResult[3];
    language.setPart1(part1);

    String scope = fullResult[4];
    if (scope != null && !scope.trim().isEmpty()) {
      language.setScope(scope.charAt(0));
    }

    String languageType = fullResult[5];
    if (languageType != null && !languageType.trim().isEmpty()) {
      language.setLanguageType(languageType.charAt(0));
    }

    String referenceName = fullResult[6];
    language.setReferenceName(referenceName);

    if (fullResult.length == 8) {
      String comment = fullResult[7];
      language.setComment(comment);
    }

    return language;
  }

  public static ISO639Language getByCode(String code) {
    if (code == null || code.isEmpty() || code.length() == 1) {
      return null;
    }
    if (code.length() == 2) {
      return getByPart1Code(code);
    }
    for (ISO639Language iSO639Language : LANGUAGES) {
      if (code.equals(iSO639Language.getId())) {
        return iSO639Language;
      }
      if (code.equals(iSO639Language.getPart2B())) {
        return iSO639Language;
      }
      if (code.equals(iSO639Language.getPart2T())) {
        return iSO639Language;
      }
    }
    return null;
  }

  public static ISO639Language getByPart3Code(String part3) {
    if (part3 == null || part3.isEmpty()) {
      return null;
    }
    for (ISO639Language iSO639Language : LANGUAGES) {
      if (part3.equals(iSO639Language.getId())) {
        return iSO639Language;
      }
    }
    return null;
  }

  public static ISO639Language getByLocale(Locale locale) {
      if (locale == null) {
        return null;
      }
      String part1 = locale.getLanguage();
      return getByPart1Code(part1);
    }
  
  public static ISO639Language getByPart1Code(String part1) {
    if (part1 == null || part1.isEmpty()) {
      return null;
    }
    for (ISO639Language iSO639Language : LANGUAGES) {
      if (part1.equals(iSO639Language.getPart1())) {
        return iSO639Language;
      }
    }
    return null;
  }

  public static ISO639Language getByPart2BCode(String part2B) {
    if (part2B == null || part2B.isEmpty()) {
      return null;
    }
    for (ISO639Language iSO639Language : LANGUAGES) {
      if (part2B.equals(iSO639Language.getPart2B())) {
        return iSO639Language;
      }
    }
    return null;
  }

  public static ISO639Language getByPart2TCode(String part2T) {
    if (part2T == null || part2T.isEmpty()) {
      return null;
    }
    for (ISO639Language iSO639Language : LANGUAGES) {
      if (part2T.equals(iSO639Language.getPart2T())) {
        return iSO639Language;
      }
    }
    return null;
  }
}
