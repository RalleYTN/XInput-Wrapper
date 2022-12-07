[![RalleYTN](https://circleci.com/gh/RalleYTN/XInput-Wrapper.svg?style=svg)](https://app.circleci.com/pipelines/github/RalleYTN/XInput-Wrapper)
[![CodeFactor](https://www.codefactor.io/repository/github/ralleytn/xinput-wrapper/badge)](https://www.codefactor.io/repository/github/ralleytn/xinput-wrapper)

# Description

This library is a full wrapper (state 03/30/2018) of the XInput API from Microsoft for Java 11+.
The XInput API was wrapped 1:1 with JNA. All function and member names are still the same, with the only difference being that the structure names are now in upper camel case
like any other normal Java class to prevent confusion with the constants.

An example of an implementation can be found in the unit tests.

## Maven

In order to use XInput-Wrapper as a Maven dependency in your own projects you first have to include Jitpack as a repository to your POM.

```xml
<project>
	...
	<repositories>
		...
		<repository>
			<id>jitpack.io</id>
			<url>https://jitpack.io</url>
		</repository>
		...
	</repositories>
	...
</project>
```

Then add the following as dependency:

```xml
<dependency>
	<groupId>com.github.RalleYTN</groupId>
	<artifactId>XInput-Wrapper</artifactId>
	<!-- NOTE: You can also use the commit ID as version number -->
	<version>1.2.0</version>
</dependency>
```

## Changelog

### Version 1.2.1

- Added jitpack.yml to fix an issue with Jitpack IO not using JDK 11

### Version 1.2.0

- Made the library Java 11 compatible.
- Updated JNA dependency to 5.12.1
- Simplified Jupiter dependency

### Version 1.1.0

- Added a `module-info.java`.
- Added the `Info` class. Its purpose is to give information about which DLL was loaded and which functions are available. There is only a single instance of this class and it can be retrieved by the new `INFO` constant in the `XInput` interface.

### Version 1.0.0

- Release

## License

```
MIT License

Copyright (c) 2018 Ralph Niemitz

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```

## Links

- [Online Documentation](https://ralleytn.github.io/XInput-Wrapper/)
- [Download](https://github.com/RalleYTN/XInput-Wrapper/releases)
- [Microsoft Documentation](https://msdn.microsoft.com/de-de/library/windows/desktop/hh405053(v=vs.85))