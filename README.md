# SimplePNML for JVM
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](https://github.com/lukoerfer/simple-pnml-jvm/blob/master/LICENSE)
[![Build](https://github.com/lukoerfer/simple-pnml-jvm/workflows/build/badge.svg)](https://github.com/lukoerfer/simple-pnml-jvm/actions)
[![Coverage](https://img.shields.io/coveralls/github/lukoerfer/simple-pnml-jvm)](https://coveralls.io/github/lukoerfer/simple-pnml-jvm?branch=master)

Simple JVM implementation of the Petri Net Markup Language (PNML), limited to Place-Transition-(PT)-Nets

> Check out [SimplePNML for .NET](https://github.com/lukoerfer/simple-pnml-dotnet) to handle PNML files from .NET languages like C# and VB.NET!

## Motivation
The [Petri Net Markup Language (PNML)](http://www.pnml.org/) was developed as an interchange format for petri nets and can describe the logical relations between the components as well as information required for visualization. It is highly extendable and provides support for a variety of different petri net types, which comes with the price of high complexity. Since most use cases and applications are focused on Place-Transition-(PT)-Nets, this library provides a simple way to access and modify this kind of petri nets programmatically.

## Installation

## Usage

## Differences between .NET and JVM version

* The element relations are implemented via (auto-)properties in .NET and via fields with getters and optional setters in the JVM (with some help of Lombok).
* Some names are changed to follow language-specific naming conventions:
  * Methods are named using `PascalCase` in the .NET version, but using `camelCase` in the JVM version.
  * Enum members are named using `PascalCase` in the .NET version, but using `UPPER_CASE` in the JVM version.
* A lot more constructors and fluent methods are provided in the JVM version, because initialization blocks and optional or named parameters are not supported.
* `Label` instances for element names, inscriptions and initial markings must be constructed manually when using the JVM version, because implicit type conversion is not supported.
* The points of an `Edge` or the content of a `ToolData` element cannot be defined via tuples when using the JVM version.

## License
The software is licensed under the [MIT license](https://github.com/lukoerfer/simple-pnml-dotnet/blob/master/LICENSE).
