# Rust Implementation

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

Copyright (c) 2018 by Iwan van der Kleijn. All rights reserved.

This program is MIT licensed. See the file LICENSE.