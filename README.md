## Spring boot application with Apache Kafka 

Demo spring boot application for implementing apache kafka where I have used [wikimedia stream](https://stream.wikimedia.org/v2/stream/recentchange) data as a source of event.

## Technology stacks
* Java 17
* Spring Boot 3.1.0
* Apache Kafka 3.4.1

## Project Details
This project has a parent project called **springboot-kafka-demo**, which consists of two modules: **kafka-producer-wikimedia** and **kafka-consumer-database**.

### kafka-producer-wikimedia
This Spring Boot application is designed to consume event data from Wikimedia, process it, and publish the events to a specific topic in a Kafka broker.

### kafka-consumer-database
This application is responsible for listening to any events published in the Kafka broker, consuming them, and subsequently storing the data into a MySQL database.


## Topics I've Covered
* Installing and running Kafka and Zookeeper service in Windows machine
* Configuring Kafka broker with spring boot application
* Creating a topic in kafka broker and some theory about partitioning
* Publishing events into a topic and consuming those events on that topic, finally performing some action
* Changing default port of kafka service 

## Some Kafka Commands I've Used

| Command                                                                                                                   | Description                           |
|---------------------------------------------------------------------------------------------------------------------------|---------------------------------------|
| D:\kafka>.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties                                           | To start the ZooKeeper service        |
| D:\kafka>.\bin\windows\kafka-server-start.bat .\config\server.properties                                                  | To start the Kafka broker service     |
| D:\kafka>.\bin\windows\kafka-topics.bat --create --topic <topic-name> --bootstrap-server localhost:9092                   | To create a topic to store the events |
| D:\kafka>.\bin\windows\kafka-console-producer.bat --topic <topic-name> --bootstrap-server localhost:9092                  | To write some events into the topic   |
| D:\kafka>.\bin\windows\kafka-console-consumer.bat --topic <topic-name> --from-beginning --bootstrap-server localhost:9092 | To read the events                    |
