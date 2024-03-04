# Spring Boot 3.0.4
https://docs.spring.io/spring-boot/docs/3.0.4/reference/htmlsingle/

## Pre-requisites
Depending on how you would like to build and run you will need either:
- GraalVM (https://bell-sw.com/pages/downloads/native-image-kit/#/nik-22-17)
- Docker (https://rancherdesktop.io/)

## How to build and run (GraalVM)
 `./gradlew nativeRun`  
or`./gradlew nativeCompile` and then run the executable `./build/native/nativeCompile/demo`   

## How to build and run (Docker)
`./gradlew bootBuildImage`  
`docker run --rm -p 8080:8080 -p 8081:8081 docker.io/library/demo:0.0.1-SNAPSHOT `

## Compatibility

| Library   	            | Version   	| Compatible  	| Notes   	
|---	                    |---	        |---	        |---		
| Spring Webflux   	        |6.0.6  	    | ✅	        |
| ECS Logging               |1.5.0          | ✅            |
| Spring Docs               |2.0.4          | ✅            | 
| Micrometer - Prometheus   |1.10.4         | ✅            |
| Micrometer - Tracing      |               | ❓            |
| Spring Data               |               | ❓            |
| Spring Kafka              |               | ❓            |

