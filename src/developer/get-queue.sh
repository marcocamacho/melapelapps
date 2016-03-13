#!/bin/bash

. http-info.sh

storeId=112358
size=10

bash -c "curl -v '${host}:${port}/queue/${storeId}?size=${size}'"

