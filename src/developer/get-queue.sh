#!/bin/bash

. http-info.sh

storeId=112358
size=3

bash -c "curl -v '${host}:${port}/v0/queue/${storeId}?size=${size}'"

