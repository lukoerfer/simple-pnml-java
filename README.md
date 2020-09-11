# SimplePNML for JVM
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](https://github.com/lukoerfer/simple-pnml-jvm/blob/master/LICENSE)
[![Build](https://github.com/lukoerfer/simple-pnml-jvm/workflows/build/badge.svg)](https://github.com/lukoerfer/simple-pnml-jvm/actions)
[![Coverage](https://img.shields.io/coveralls/github/lukoerfer/simple-pnml-jvm)](https://coveralls.io/github/lukoerfer/simple-pnml-jvm?branch=master)

Simple JVM implementation of the Petri Net Markup Language (PNML), limited to Place-Transition-(PT)-Nets

> Check out [SimplePNML for .NET](https://github.com/lukoerfer/simple-pnml-dotnet) to handle PNML files from .NET languages like C# and VB.NET!

## Motivation
The [Petri Net Markup Language (PNML)](http://www.pnml.org/) was developed as an interchange format for petri nets.
It can describe logical relations between petri net elements as well as visualization information.
Its high expandability and conceptual support for a variety of different petri net types comes with the price of high complexity.
Since most use cases and applications are focused on Place-Transition-(PT)-Nets, this library provides a simple way to access and modify this kind of petri nets programmatically.

## Installation


## Usage

``` java
// Create a place, a transition and an arc
Place place = Place.builder()
	.id("my-place")
	.initialMarking(new Label("1"))
	.build();
Transition transition = Transition.builder()
	.id("my-transition")
	.build();
Arc arc = Arc.builder()
	// no explicit identifier
	.inscription(new Label("1"))
	.build();

// Let the arc connect the place and the transition
arc.connect(place, transition);

// Add all the elements to a new page
Page page = new Page();
page.getPlaces().add(page);
page.getTransitions().add(transition);
page.getArcs().add(arc);
```


## Differences to .NET version

* The element relations can be accessed via getters and setters.
* Naming conventions from the Java world are applied. This includes:
  * Methods are named using `camelCase`.
  * Enum members are named using `UPPER_CASE`.
* The `Builder` pattern can be used to construct objects.

## License
The software is licensed under the [MIT license](https://github.com/lukoerfer/simple-pnml-dotnet/blob/master/LICENSE).
