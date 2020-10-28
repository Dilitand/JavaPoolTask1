FROM postgres:12-alpine
COPY *.sql /docker-entrypoint-initdb.d/

#docker build -f dockerfile_postgres -t testdoc .
#docker run --name postgres-0 -e POSTGRES_PASSWORD=password -d -p 5432:5432 testdoc
#docker run --name some-postgres --volume db-data:/var/lib/postgresql/data -e POSTGRES_PASSWORD=qqq -e POSTGRES_DB=vv -p 5434:5432 postgres:12-alpine