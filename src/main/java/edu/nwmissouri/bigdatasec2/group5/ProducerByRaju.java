package edu.nwmissouri.bigdatasec2.group5;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.Random;
import java.util.Scanner;


public class ProducerByRaju {
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

    String str = reverseString();
      ProducerRecord<String, String> rec = new ProducerRecord<String, String>(topicName, message);
      producer.send(rec);
    

    // still allow input from keyboard

    String line = in.nextLine();

    while (!line.equals("exit")) {
      ProducerRecord<String, String> recs = new ProducerRecord<String, String>(topicName, line);
      producer.send(recs);
      line = in.nextLine();
    }

    in.close();
    producer.close();

  

}
  public static String reversestring(){

  String line = "Northwest Missouri State University";
 
  // getBytes() method to convert string
  // into bytes[].
  byte[] strAsByteArray = input.getBytes();

  byte[] result = new byte[strAsByteArray.length];

  // Store result in reverse order into the
  // result byte[]
  for (int i = 0; i < strAsByteArray.length; i++){
      result[i] = strAsByteArray[strAsByteArray.length - i - 1];
  }

    return result;
}
 
}
  
 
