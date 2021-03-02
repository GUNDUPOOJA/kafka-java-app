package edu.nwmissouri.bigdatasec2.group5;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.Scanner;
import java.lang.*;
import java.util.*;


public class ProducerByPooja {
  private static Scanner in;

  public static void main(String[] argv) throws Exception {
    if (argv.length != 1) {
      System.err.println("Please specify 1 parameter (the name of the topic)");
      System.exit(-1);
    }
    String topicName = argv[0];
    in = new Scanner(System.in);
    System.out.println("Thank you for providing the topic " + topicName + "\n");
    System.out.println("Enter message (type exit to quit).\n");

    // Configure the Producer
    Properties configProperties = new Properties();
    configProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
    configProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
        "org.apache.kafka.common.serialization.ByteArraySerializer");
    configProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
        "org.apache.kafka.common.serialization.StringSerializer");


    System.out.println("The configuration properties are: " + configProperties.toString());
    System.out.println("\nWill use this configuration to create a producer.\n");

    org.apache.kafka.clients.producer.Producer producer = new KafkaProducer(configProperties);

    // Make our own messages - create your custom logic here

    Random rand = new Random();

        String input = in.nextLine();

        // we need 5 messages to print
        for (int i = 0; i<5; i++){
            //get a random num to display message
            int  randomno= random.nextInt(5);
            String sent = randomsentence(randomno);
            ProducerRecord<String, String> rec = new ProducerRecord<String, String>(topicName, sent);
            producer.send(rec);
        }

        // Allow the user to type exit to get out.
        String line = in.nextLine();
        while(!line.equals("exit")){
            ProducerRecord<String, String> rec = new ProducerRecord<String, String>(topicName, (line + ", Happy pokemon day!"));
            producer.send(rec);
            line = in.nextLine();
        }

        //User has typed exit

        in.close();
        producer.close();

    }

    private static String randomsentence(int n) {
        if(n==0){
          return "Pablo Picasso";
        }
        else if(n==1){
          return "Leonardo da Vinci";
        }
        else if(n==2){
          return "Henri Matisse";
        }
       else if(n==3){
          return "Jackson Pollock";
        }
       else if(n==4){
          return "Edvard Munch.";
        }
        else {
          return "Andy Warhol";
        }
    }
 }

