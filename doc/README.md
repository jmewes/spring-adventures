# Architecture Documentation

This directory contains the architecture documentation for the **Spring Adventures** application, using the [arc42](https://arc42.org/overview) template.

## Overview

The source code of the docs consists of Asciidoctor files that are split into directories according to the chapters of the arc42 template.
By convention, images are placed in a subdirectory called `img`.

```
aw2_arc42/
├── build/
├── compile.sh
└── src
    ├── 01_introduction_and_goals
    │   └── index.adoc
    ├── 02_architecture_constraints
    ├── 03_system_scope_and_context
    │   └── index.adoc
    ├── 04_solution_strategy
    ├── 05_building_block_view
    ├── 06_runtime_view
    ├── 07_deployment_view
    ├── 08_concepts
    ├── 09_architecture_decisions
    ├── 10_quality_requirements
    ├── 11_technical_risks
    ├── 12_glossary
    └── index.adoc
```

## Development

To compile the documentation, the [GNU Core Utilities](https://en.wikipedia.org/wiki/GNU_Core_Utilities), [Docker](https://www.docker.com) and [git](https://git-scm.com/) must be installed. The docs can then be compiled by running the `compile.sh` script, as shown below.

```sh
./compile.sh
```

The result will be PDF and HTML files in the `build` directory.

| ✏️ Supported OS                                                                     |
|:------------------------------------------------------------------------------------|
| The script has been tested on **macOS** and will probabably also work on **Linux**. |

[Draw.io](https://app.diagrams.net) is recommended for creating images. However, any other diagramming tool can be used instead.

## References

- [arc42 Documentation](https://docs.arc42.org)
- [DokChess as an example for arc42 | dokchess.de](https://www.dokchess.de/en/)
- [Asciidoctor PDF Documentation | docs.asciidoctor.org](https://docs.asciidoctor.org/pdf-converter/latest/)
