#!/bin/bash

cd "$(dirname "$0")"
. ./http-info.sh --source-only

storeId=112358

bash -c "curl -v -XPOST --data-binary '{\"id\":\"112358\",\"name\":\"Arturo\",\"lastName\":\"Coen\"}' -H 'Content-Type: application/json' '${host}:${port}/queue/${storeId}'"


