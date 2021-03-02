package edu.nwmissouri.bigdatasec2.group5;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.Scanner;
import java.lang.*;

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

    for (int i = 1; i <= 2; i++) {
        String message = "pooja is good girl" + i +"ofcourse,";
        ProducerRecord<String, String> rec = new ProducerRecord<String, String>(topicName, message);
        producer.send(rec);
      }
    // still allow input from keyboard

    String line = in.nextLine();
    while (!line.equals("exit")) {
      ProducerRecord<String, String> rec = new ProducerRecord<String, String>(topicName, line);
      producer.send(rec);
      line = in.nextLine();
    }

    in.close();
    producer.close();
  }
}

//     // still allow input from keyboard

//     String line = in.nextLine();
//     while (!line.equals("exit")) {
//       ProducerRecord<String, String> rec = new ProducerRecord<String, String>(topicName, line);
//       producer.send(rec);
//       line = in.nextLine();
//     }

//     in.close();
//     producer.close();
//   }
//   private static String randomSentence(int n) {
//     if(n==0){
//         return "The Wrong Family  is the perfect book for readers when one shocking plot twist is not nearly enough.";
//     }
//     else if(n==1){
//         return "Paul Cadden";
//     }
//     else if(n==2){
//         return " Adonna Khare";
//     }
//     else if(n==3){
//         return "CJ Hendry";
//     }
//     else if(n==4){
//         return " Diego Fazzio";
//     }
//     else if(n==5){
//         return "Dirk Dzimirsky";
//     }
//     else if(n==6){
//         return "Monica Lee";
//     }
//     else if(n==7){
//         return "Monica Lee";
//     }
//    else if(n==8){
//         return "Monica Lee";
//     }
//     else if(n==9){
//         return "Monica Lee";
//     }
//     else
//     {
//         return "picaso";
//     }
   
// }

// }
