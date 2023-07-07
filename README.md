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

The wrapped codes table has been downloaded from <https://iso639-3.sil.org/sites/iso639-3/files/downloads/iso-639-3.tab>, dated from 01/20/2022.
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

## Download

See GitHub Packages: <https://github.com/datazuul/iso-639-javalib/packages/1267001>

### Apache Maven

Add as dependency to your Maven `pom.xml`:

```
<dependency>
  <groupId>com.datazuul.language</groupId>
  <artifactId>iso-639</artifactId>
  <version>1.0.2</version>
</dependency>
```

Add GitHub Packages repository to repositories section in `pom.xml`:

```
<repositories>
  <repository>
    <id>github</id>
    <url>https://maven.pkg.github.com/datazuul/iso-639</url>
    <snapshots>
      <enabled>true</enabled>
    </snapshots>
  </repository>
</repositories>
```

Until today, you need to add your authentication credentials (Personal Access Token) to your `settings.xml` to be able to read/download the GitHub packages.

* Login to GitHub and navigate to <https://github.com/settings/tokens>
* Create a new Personal Access Token (classic), e.g. named "GitHub Packages Read (public_repo, read:packages) "
* Select scopes "public_repo" and "read:packages"
* Save/Create token and copy token value

Put your GitHub username and the created personal access token into `~/.m2/settings.xml`:

```
<servers>
  <server>
    <id>github</id>
    <username>USERNAME</username>
    <password>TOKEN</password>
  </server>
</servers>
```
See [Apache Maven: Authenticating with a personal access token](https://docs.github.com/en/packages/working-with-a-github-packages-registry/working-with-the-apache-maven-registry#authenticating-with-a-personal-access-token)

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

## License

```
Copyright 2020 Ralf Eichinger

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
```
