package com.rakeshv.springcloudtask;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableTask
@Slf4j
public class SpringCloudTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudTaskApplication.class, args);
    }

    @Bean
    public CommandLineRunner tollProcessingTask() {
        return new TollProcessingTask();
    }

    public class TollProcessingTask implements CommandLineRunner {
        @Override
        public void run(String... args) throws Exception {
            if (null != args) {
                log.info("Parameters length is {}", args.length);

                if (args.length >= 3) {
                    String stationId = args[0];
                    String licensePlate = args[1];
                    String timeStamp = args[2];
                    log.info("Station ID is {}, License Plate is {}, Timestamp is {}",
                            stationId, licensePlate, timeStamp);
                }
            }
        }
    }
}
