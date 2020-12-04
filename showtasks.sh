#!/usr/bin/env bash

if ./runcrud.sh; then
  echo "all good!"
  open -a "Google Chrome" http://localhost:8080/crud/v1/task/getTasks
else
  echo "oops! Something went terribly wrong!"
fi