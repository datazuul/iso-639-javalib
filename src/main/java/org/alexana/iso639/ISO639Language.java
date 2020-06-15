package org.alexana.iso639;

/**
 * Introduction taken from <a href="https://iso639-3.sil.org/about/relationships">SIL homepage</a>:
 *
 * <p>"ISO 639 provides three language code sets:</p>
 *
 * <ul>
 * <li>one is a two-letter code (ISO 639-1) and two others are
 * <li>three-letter codes (ISO 639-2 and ISO 639-3)
 * </ul>
 *
 * for the representation of names of languages.
 *
 * <p>ISO 639-1 was devised primarily for use in terminology, lexicography and linguistics
 * <p>ISO 639-2 was devised primarily for use in terminology and bibliography. It represents all languages contained in ISO 639-1 and in addition other languages and language collections of interest for those primary applications.
 * <p>ISO 639-3 was devised to provide a comprehensive set of identifiers for all languages for use in a wide range of applications, including linguistics, lexicography and internationalization of information systems. It attempts to represent all known full languages.
 */
public class ISO639Language {

  String comment;
  String id;
  char languageType;
  String part1;
  String part2B;
  String part2T;
  String referenceName;
  char scope;

  /** @return Comment relating to one or more of the columns */
  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  /** @return The three-letter 639-3 identifier */
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  /** @return A(ncient), C(onstructed), E(xtinct), H(istorical), L(iving), S(pecial) */
  public char getLanguageType() {
    return languageType;
  }

  public void setLanguageType(char languageType) {
    this.languageType = languageType;
  }

  /** @return Equivalent 639-1 (2-letter) identifier, if there is one */
  public String getPart1() {
    return part1;
  }

  public void setPart1(String part1) {
    this.part1 = part1;
  }

  /** @return Equivalent 639-2 (3-letter) identifier of the bibliographic applications code set, if there is one */
  public String getPart2B() {
    return part2B;
  }

  public void setPart2B(String part2B) {
    this.part2B = part2B;
  }

  /** @return Equivalent 639-2 (3-letter) identifier of the terminology applications code set, if there is one */
  public String getPart2T() {
    return part2T;
  }

  public void setPart2T(String part2T) {
    this.part2T = part2T;
  }

  /** @return Reference language name */
  public String getReferenceName() {
    return referenceName;
  }

  public void setReferenceName(String referenceName) {
    this.referenceName = referenceName;
  }

  /** @return I(ndividual), M(acrolanguage), S(pecial) */
  public char getScope() {
    return scope;
  }

  public void setScope(char scope) {
    this.scope = scope;
  }
}
