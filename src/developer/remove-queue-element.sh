#!/bin/bash -x

. http-info.sh

storeId=112358
elementId=85345

bash -c "curl -v -XDELETE '${host}:${port}/queue/${storeId}/${elementId}'"


