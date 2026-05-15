#!/bin/bash

set -e

###############################################################################
# Handle script parameters
###############################################################################

function usage()
{
    cat <<-END
usage: $(basename -- "${BASH_SOURCE[0]}") [-h]

optional arguments:
  -h    Show this help message and exit.

END
}

while getopts "h v: b:" o; do
  case "${o}" in
    h | *)
      usage
      exit 0
      ;;
  esac
done
shift $((OPTIND-1))

###############################################################################
# Main
###############################################################################

echo
echo "Compile HTML"
echo
if [[ -d ./build ]]; then
  rm -r ./build
fi
mkdir ./build
find src -name "img" -exec cp -r {} ./build \;
docker run -v "$(pwd)":/documents/ asciidoctor/docker-asciidoctor asciidoctor ./src/index.adoc --out-file ./build/architecture-documentation.html -a revdate="$(date +%F)"

TEMP_DIR=$(mktemp -d)
mv ./build/* "${TEMP_DIR}"
mv "${TEMP_DIR}" ./build/html

echo
echo "Compile PDF"
echo
find src -name "img" -exec cp -r {} ./src \; > /dev/null
mkdir ./build/pdf
docker run -v "$(pwd)":/documents/ -v ./build/pdf:/target asciidoctor/docker-asciidoctor asciidoctor-pdf ./src/index.adoc -a lang=en --out-file /target/architecture-documentation.pdf -a revdate="$(date +%F)"

# Cleanup of temporarily copied files
rm -r ./src/img
