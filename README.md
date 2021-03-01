# kafka-java-app
Preparing for kafka apps(group)

## Team Lead
Pooja Gundu [![](https://img.shields.io/badge/Github-GUNDUPOOJA)](https://github.com/GUNDUPOOJA)

## Team Members
-----------------------------------------------------
- Raju Nooka [![](https://img.shields.io/badge/Github-nrajubn)](https://github.com/nrajubn)
- Sai Rohith Gorla [![](https://img.shields.io/badge/Github-SaiGorla)](https://github.com/SaiGorla)
- Rajeshwari Rudravaram [![](https://img.shields.io/badge/Github-Rajeshwari-Rudra)](https://github.com/Rajeshwari-Rudra)
- Sri Sudheera Chitipolu [![](https://img.shields.io/badge/Github-Sudheera96-orange)](https://github.com/sudheera96)
- Ravichander Reddy Goli [![](https://img.shields.io/badge/Github-Ravichanderreddy-goli)](https://github.com/Ravichanderreddy-goli)

## Command to Start a Zookeeper
- To start a zookeeper, open Powershell in your kafka directory and run this command

```Powershell
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
```
- Note:- Leave this window open or minimize it.
----------------------------------------
## Command to start a Kafka Server
* Now open a new window and run Powershell as Administrator in your Kafka directory


```Powershell
.\bin\windows\kafka-server-start.bat .\config\server.properties
```
- Leave this window open or minimize it.
---------------------------------------------------------------
## Command to create a topic


```PowerShell
 .\bin\windows\kafka-topics.bat --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --create --topic bank
```

## Compile and Build the Fat Jar File

Open PowerShell as Administrator in the root project folder, compile the code using Maven and create an executable jar file. Generated artificacts can be found in the new 'target' folder.

```PowerShell
mvn clean compile assembly:single
```

## To start a Consumer

Open PowerShell as Administrator in the root project folder, start the original consumer app using topic test and group1 with:

```PowerShell
 
 
```
- Leave this window open or minimize it.

## To Start a Producer

Open a new PowerShell as Administrator in the root project folder, start the Producer app using topic test:

```PowerShell
 
```
- Leave this window open or minimize it.





## References

- [Reference Repo](https://github.com/denisecase/kafka-api)
- [Kafa Tutorial](http://cloudurable.com/blog/kafka-tutorial-kafka-producer/index.html)


