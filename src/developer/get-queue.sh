#!/bin/bash

cd "$(dirname "$0")"
. ./http-info.sh --source-only

storeId=112358
size=10

bash -c "curl -v '${host}:${port}/queue/${storeId}?size=${size}'"

