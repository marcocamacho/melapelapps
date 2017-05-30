#!/bin/bash

cd "$(dirname "$0")"

storeId=112358
size=2
page=1

pretty="false"

# Usage info
show_help() {
cat << EOF
  Usage: ${0##*/} [-hp]
      -h          display this help and exit
      -p          pretty printing.
      -s          size of results.
      -g          page of results.
EOF
}

while getopts s:g:hp opt; do
  case $opt in
    h)
      show_help
      exit 0
      ;;
    p)
      pretty="true"
      ;;
    s)
      size=$OPTARG
      ;;
    g)
      page=$OPTARG
      ;;
  esac
done

. ./.http-info.sh --source-only

output=`bash -c "curl -v '${host}:${port}/queue/${storeId}?size=${size}&page=${page}'"`

if [ "$pretty" == "true" ]; then
  echo "$output" | python -m json.tool
else
  echo "$output"
fi