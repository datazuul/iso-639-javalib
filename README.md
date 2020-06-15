# IS0639 Java Library

This product is a Java Library wrapping language codes of format ISO 639
and providing easy access to alternative codes of a language.

## Introduction

Introduction taken from <https://iso639-3.sil.org/about/relationships>:

> "ISO 639 provides three language code sets:
>
> - one is a two-letter code (ISO 639-1) and two others are
> - three-letter codes (ISO 639-2 and ISO 639-3)
>
> for the representation of names of languages.
>
> ISO 639-1 was devised primarily for use in terminology, lexicography and linguistics.
>
> ISO 639-2 was devised primarily for use in terminology and bibliography. It represents all languages contained in ISO 639-1 and in addition other languages and language collections of interest for those primary applications.
>
>ISO 639-3 was devised to provide a comprehensive set of identifiers for all languages for use in a wide range of applications, including linguistics, lexicography and internationalization of information systems. It attempts to represent all known full languages."

## Codes table and implementation details

The wrapped codes table has been downloaded from <https://iso639-3.sil.org/sites/iso639-3/files/downloads/iso-639-3_Code_Tables_20200130.zip>, dated from 01/30/2020.
It is incorporated into this library without changes.

The codes table lists the following columns for each language (see <https://iso639-3.sil.org/code_tables/download_tables#639-3%20Code%20Set>):

- Id (char(3) NOT NULL): The three-letter 639-3 identifier
- Part2B (char(3) NULL): Equivalent 639-2 identifier of the bibliographic applications code set, if there is one
- Part2T (char(3) NULL): Equivalent 639-2 identifier of the terminology applications code set, if there is one
- Part1 (char(2) NULL): Equivalent 639-1 identifier, if there is one
- Scope (char(1) NOT NULL): I(ndividual), M(acrolanguage), S(pecial)
- Language_Type (char(1) NOT NULL): A(ncient), C(onstructed), E(xtinct), H(istorical), L(iving), S(pecial)
- Ref_Name (varchar(150) NOT NULL): Reference language name
- Comment (varchar(150) NULL): Comment relating to one or more of the columns

## Usage

Use static methods from class `ISO639Languages` to lookup a language with a given code.
Result (if any) is of type `ISO639Language` containing all data of the corresponding line in the codes table.

### Examples

- Get Part1 code (as used for Java Locale) for a given Part2B code (as used in MARC XML):

```java
ISO639Language result = ISO639Languages.getByPart2BCode("ger");
Locale locale = new Locale(result.getPart1());
```

## Attribution

SIL International (formerly known as the Summer Institute of Linguistics), <https://www.iso639-3.sil.org>
