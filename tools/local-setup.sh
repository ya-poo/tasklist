#!/usr/bin/env sh
set -eu

docker-compose down -v
docker-compose up -d postgres
