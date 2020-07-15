# SpringBoot-Kafka-Mongo



## Steps


### 1. Clone and build the project


Run the command below to clone the project:
```
git clone https://github.com/SaWLeaDeR/SpringBoot-Kafka-Mongo.git
```

After the process is finished, access the project folder and execute docker-compose 

```
cd SpringBoot-Kafka-Mongo
docker-compose up
```

or as a deamon

```
docker-compose up -d
```

You can either open a separate terminal and follow the logs while systems are initializing:

```
docker-compose logs -f
```

check the starting status:
```
docker-compose ps
```

#### Mongo

it is database server in docker 

If you have a database client, you can access with this port

```
localhost:27017

user:root
password:example
```

If you don't have any client

you can access this database with this in browser

##### Mongo-Express

```
localhost:8081
```

##### Nosqlclient

```
localhost:3000
```


#### Kafka

This compose file has also includes kafka


##### Zookeeper

zookeeper port is : 2181

you can access this with 

```
localhost:2181
```


##### Kafka

kafka port is :29092

```
localhost:29092
```

if you have kafka you can listen topics with this command
```
bin/kafka-console-consumer.sh --bootstrap-server localhost:29092 --topic deviceData --from-beginning
```


##### Kafka-Topics-UI

kafka-topics-ui port is :8085

```
localhost:8085
```

you can watch kafka toics from here


### 2. Run the first projects (Device-Api & Device-Data-Consumer)

Device-Api -> there are Rest endpoints you can send data

Device-Data-Consumer -> there is a kafka listener that reads data from topic



### 3. Clean up
Go to the root folder where is *docker-compose.yml*.

To stop all containers execute:
```
docker-compose down
```


















