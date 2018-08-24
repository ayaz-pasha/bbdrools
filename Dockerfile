FROM java:8

ADD target/bbdrools-1.0-SNAPSHOT.jar /data/bbdrools-1.0-SNAPSHOT.jar

ADD example.yml /data/example.yml

CMD java -jar /data/bbdrools-1.0-SNAPSHOT.jar server /data/example.yml

EXPOSE 8080