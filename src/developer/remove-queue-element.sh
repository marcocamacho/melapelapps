#!/bin/bash -x

cd "$(dirname "$0")"
. ./.http-info.sh --source-only

storeId=112358
elementId=85344

curl -v -XDELETE ""${host}:${port}/queue/${storeId}/${elementId}""


