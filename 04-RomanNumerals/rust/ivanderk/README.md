# Rust Implementation

## Usage as executable

```bash
romannumerals
Copyright (c) MMXVIII (2018)


    -r(oman)    <roman numeral>   ->  prints decimal value
    -d(decimal) <decimal number>  ->  prints roman representation
```
## Usage as library

```rust
extern crate romannumerals;
use romannumerals::{RomanNumberPresentation, RomanNumberValue};

println!("{}", 2018.as_roman_number().unwrap());
println!("{}", "MMXVIII".roman_number_value().unwrap());

```

## Details of the implementation of Kata: Roman Numerals

The rust solution is provided in the _romannumerals_ module. Main characteristics of this implementation are:

- Central to the implementation is the NUMERALS array which is used as a lookup buffer for both the _number_value_ function ("Roman Numerals to integer") and the _number_presentation_ function ("integer to Roman Numeral").

- Both functions come with basic error handling. The functions "_number_presentation_" and "_number_value_" return Option type data. They return None in case of invalid data. Parsing of Roman Numbers is strict.

- Number range of supported Roman Numerals is [1 .. 3999].

- The _number_value_ function can read latin character numerals, unicode code points equal to the ASCII char byte order, as well as the code points reserved in Unicode especially for Roman Numerals; code point 2160-216F. In both cases only upper case characters are supported.

- the "_number_presentation_" function only renders latin character numerals as that is recommended by the Unicode standard itself

- RomanNumberValue and RomanNumberPresentation Traits showcase how existing types can be extended with the functionality implemented by "_number_presentation_" and "_number_value_" respectively. String types gain a "_roman_number_value_" method and u32 integers an "_as_roman_number_" method.

- Shown in the tests but not used in the Traits, the modules contains the function "_number_value2_", an alternative recursive, immutable implementation. This to compare with the compact but mutable iterative default function "_number_value_".

## TODO
Optional conversion of special Unicode code points denoting Latin Numerals to ("normal") latin uppercase characters. This only has to be done for the _number_value_ (i.e. parsing) as the Unicode standard itself recommends against using these special code points.

## Why Rust

Rust is a systems programming language sponsored by Mozilla Research (makers of the Firefox browser) that runs blazingly fast, prevents segfaults, and guarantees thread safety. It features:

- zero-cost abstractions
- move semantics
- guaranteed memory safety
- threads without data races
- trait-based generics
- pattern matching
- type inference
- minimal runtime
- efficient C bindings

Mozilla describes Rust as a "safe, concurrent, practical language,"supporting functional and imperative-procedural paradigms. Rust is syntactically similar to C++, but its designers intend it to provide better memory safety while maintaining performance.

Rust is an open source programming language. Rust won first place for "most loved programming language" in the Stack Overflow Developer Survey in 2016 and 2017.

## Install Rust

See: https://www.rust-lang.org/en-US/install.html

## Run code

In the _src/_ directory run:

```bash
$ cargo test
```

to run the unit tests or run:

```bash
$ cargo run
```
to run the _main_ entry point. Although in this demo this is hardly useful; the unit tests are preferable.

## Documentation 

The command 

```bash
$ cargo doc --no-deps --open
```

creates HTML documentation for the application. The --no-deps option tells Cargo to generate documentation only for the app itself, and not for any crates it depends on (it doesn´t in this version). The --open option tells Cargo to open the documentation in your browser afterward. Cargo saves the new documentation files in target/ doc.

## license

Copyright (c) 2017 by Iwan van der Kleijn. All rights reserved.

This program is MIT licensed. See the file LICENSE.
