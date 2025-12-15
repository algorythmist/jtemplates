# jtemplates

Implementation-agnostic templating library for Java

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

## Overview

If you frequently work with different Java templating engines (Freemarker, Velocity, Mustache, etc.) but find yourself constantly googling the boilerplate setup code, this library is for you.

**jtemplates** provides a single, unified interface for accessing multiple templating engines. It eliminates implementation-specific boilerplate and makes it easy to switch between templating engines without changing your application code.

## Features

- **Unified API**: One consistent interface for all supported templating engines
- **Zero boilerplate**: No need to remember engine-specific setup code
- **Easy switching**: Change templating engines with minimal code changes
- **Lightweight**: Minimal dependencies, templating engines are optional (provided scope)

## Supported Templates

- **Velocity** 2.4.1
- **Freemarker** 2.3.x
- **Mustache** 0.9.14
- **Rythm** 1.4.1

## Requirements

- Java 19 or higher
- Maven 3.x (for building from source)

## Installation

Add the following dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>com.tecacet</groupId>
    <artifactId>jtemplates</artifactId>
    <version>1.0.1-SNAPSHOT</version>
</dependency>
```

Then add the specific templating engine you want to use:

```xml
<!-- For Velocity -->
<dependency>
    <groupId>org.apache.velocity</groupId>
    <artifactId>velocity-engine-core</artifactId>
    <version>2.4.1</version>
</dependency>

<!-- For Freemarker -->
<dependency>
    <groupId>org.freemarker</groupId>
    <artifactId>freemarker</artifactId>
    <version>2.3.34</version>
</dependency>

<!-- For Mustache -->
<dependency>
    <groupId>com.github.spullara.mustache.java</groupId>
    <artifactId>compiler</artifactId>
    <version>0.9.14</version>
</dependency>

<!-- For Rythm -->
<dependency>
    <groupId>org.rythmengine</groupId>
    <artifactId>rythm-engine</artifactId>
    <version>1.4.1</version>
</dependency>
```

## Usage

All templating engines implement the `TemplateRenderer` interface:

```java
public interface TemplateRenderer {
    void put(String name, Object value);
    String render(String templateFile);
    String render(String templateFile, Object... args);
    void clear();
}
```

### Velocity Example

```java
TemplateRenderer renderer = new VelocityRenderer();
renderer.put("name", "World");
String result = renderer.render("template.vm");
// Or use the varargs method:
String result = renderer.render("template.vm", "name", "World");
```

Template file (`template.vm`):
```velocity
Hello $name!
```

### Freemarker Example

```java
// From filesystem
TemplateRenderer renderer = FreemarkerRenderer.fromFilesystem("templates");
renderer.put("name", "World");
String result = renderer.render("template.ftl");

// From classpath
TemplateRenderer renderer = FreemarkerRenderer.fromClasspath("templates");
String result = renderer.render("template.ftl", "name", "World");
```

Template file (`template.ftl`):
```freemarker
Hello ${name}!
```

### Mustache Example

```java
TemplateRenderer renderer = new MustacheRenderer();
String result = renderer.render("template.mustache", "name", "World");
```

Template file (`template.mustache`):
```mustache
Hello {{name}}!
```

### Rythm Example

```java
TemplateRenderer renderer = new RythmTemplateRenderer();
String result = renderer.render("template.rm", "name", "World");
```

Template file (`template.rm`):
```rythm
Hello @name!
```

## Building from Source

```bash
git clone https://github.com/algorythmist/jtemplates.git
cd jtemplates
mvn clean install
```

## Running Tests

```bash
mvn test
```

## License

This project is licensed under the Apache License 2.0 - see the [LICENSE](LICENSE) file for details.

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## Author

**Dimitri Papaioannou**
- Organization: [TecAceT](http://www.tecacet.com)
- GitHub: [@algorythmist](https://github.com/algorythmist)

## Links

- [GitHub Repository](https://github.com/algorythmist/jtemplates)
- [Issue Tracker](https://github.com/algorythmist/jtemplates/issues)
