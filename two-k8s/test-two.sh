#!/bin/bash

while true; do
  curl -H "Content-Type: application/json" \
    -X GET http://localhost:8080/
done